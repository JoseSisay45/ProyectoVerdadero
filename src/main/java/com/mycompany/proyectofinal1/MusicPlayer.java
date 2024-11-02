/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1;

/**
 *
 * @author JOSE
 */import javafx.util.Duration; // Importa Duration para representar el tiempo de pausa en la reproducción de audio
import java.util.HashSet; // Importa HashSet para manejar elementos únicos en la búsqueda de duplicados
import javafx.scene.media.Media; // Importa Media para cargar archivos de música o medios
import javafx.scene.media.MediaPlayer; // Importa MediaPlayer para controlar la reproducción de archivos Media
import javax.swing.*; // Importa componentes de Swing para la interfaz gráfica, como JOptionPane y JList
import java.io.File; // Importa File para gestionar archivos del sistema
import java.util.ArrayList; // Importa ArrayList para manejar una lista dinámica de canciones
import java.util.List; // Importa List como interfaz para manejar la colección de canciones
import javax.swing.table.DefaultTableModel; // Importa DefaultTableModel para manejar los datos de la tabla


public class MusicPlayer {
    private DefaultTableModel tableModel; // Modelo de tabla para almacenar información de canciones
    private JList<String> duplicateList; // Lista para mostrar canciones duplicadas
    private JList<String> songList; // Lista para mostrar canciones agregadas
    private List<Media> songs = new ArrayList<>(); // Lista para almacenar las canciones
    private MediaPlayer mediaPlayer; // Controlador de reproducción de medios
    private int currentIndex = -1; // Índice de la canción actual
    private Duration pausePosition = Duration.ZERO; // Guarda la posición cuando la canción está en pausa
    private boolean isPaused = false; // Indica si la reproducción está en pausa

    // Constructor
    
    public MusicPlayer(DefaultTableModel tableModel, JList<String> songList, JList<String> duplicateList) {
        this.tableModel = tableModel; // Modelo de la tabla donde se muestran las canciones
        this.songList = songList; // Lista de canciones para mostrar en la interfaz
        this.duplicateList = duplicateList; // Lista de canciones duplicadas para mostrar en la interfaz
    }

    // Método para agregar una canción a la lista y la tabla
    
    public void addSong(File file) {
        Media song = new Media(file.toURI().toString()); // Convierte el archivo en un objeto Media
        songs.add(song); // Agrega la canción a la lista de canciones

        // Agrega una fila a la tabla con la información de la canción
        tableModel.addRow(new Object[]{
            file.getName(), // Nombre del archivo
            "Artista Desconocido", // Nombre del artista (predeterminado)
            "Álbum Desconocido", // Álbum de la canción (predeterminado)
            "Duración desconocida", // Duración de la canción (predeterminado)
            file.length() / 1024 + " KB", // Tamaño del archivo en KB
            "Año desconocido" // Año de la canción (predeterminado)
        });
    }

    // Método para eliminar una canción de la lista y la tabla
    public void removeSong(int index) {
        if (index >= 0 && index < songs.size()) { // Verifica que el índice sea válido
            songs.remove(index); // Elimina la canción de la lista
            tableModel.removeRow(index); // Elimina la fila correspondiente de la tabla
        }
    }

    // Método para buscar y mostrar canciones duplicadas
    public void findDuplicates() {
        HashSet<String> uniqueSongs = new HashSet<>(); // Conjunto para almacenar canciones únicas
        DefaultListModel<String> duplicatesModel = new DefaultListModel<>(); // Modelo de lista para duplicados

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String songName = (String) tableModel.getValueAt(i, 0); // Obtiene el nombre de la canción
            if (!uniqueSongs.add(songName)) { // Si ya existe en el conjunto, es un duplicado
                duplicatesModel.addElement(songName); // Agrega el duplicado al modelo de lista
            }
        }

        duplicateList.setModel(duplicatesModel); // Asigna el modelo de duplicados a la lista en la interfaz
        if (duplicatesModel.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay canciones duplicadas."); // Muestra mensaje si no hay duplicados
        } else {
            JOptionPane.showMessageDialog(null, "Se encontraron canciones duplicadas."); // Muestra mensaje si hay duplicados
        }
    }

    // Método para reproducir una canción en un índice específico
    public void playSong(int index) {
        if (index < 0 || index >= songs.size()) { // Verifica que el índice sea válido
            return;
        }

        if (mediaPlayer != null) { // Si hay un reproductor activo, lo detiene
            mediaPlayer.stop();
        }

        Media song = songs.get(index); // Obtiene la canción en el índice especificado
        mediaPlayer = new MediaPlayer(song); // Crea un nuevo reproductor para la canción
        mediaPlayer.play(); // Inicia la reproducción

        currentIndex = index; // Actualiza el índice de la canción actual
        pausePosition = Duration.ZERO; // Restablece la posición de pausa al inicio
        isPaused = false; // Indica que no está en pausa
    }

    // Método para pausar la reproducción
    public void pause() {
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) { // Verifica si está reproduciendo
            pausePosition = mediaPlayer.getCurrentTime(); // Guarda la posición actual de la canción
            mediaPlayer.pause(); // Pausa la reproducción
            isPaused = true; // Indica que está en pausa
        }
    }

    // Método para reanudar la reproducción desde la posición de pausa
    public void resume() {
        if (mediaPlayer != null && isPaused) { // Verifica si está en pausa
            mediaPlayer.seek(pausePosition); // Configura la posición de la canción
            mediaPlayer.play(); // Reanuda la reproducción
            isPaused = false; // Indica que ya no está en pausa
        }
    }

    // Método para reproducir la siguiente canción en la lista
    public void playNext() {
        if (currentIndex + 1 < songs.size()) { // Verifica que haya una siguiente canción
            playSong(currentIndex + 1); // Reproduce la siguiente canción
        }
    }

    // Método para reproducir la canción anterior en la lista
    public void playPrevious() {
        if (currentIndex > 0) { // Verifica que haya una canción anterior
            playSong(currentIndex - 1); // Reproduce la canción anterior
        }
    }

    // Método para verificar si se está reproduciendo música
    public boolean isPlaying() {
        return mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING; // Devuelve true si está reproduciendo
    }
}