/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1;



/**
 *
 * @author JOSE
 */
import javafx.embed.swing.JFXPanel; // Importa JFXPanel para integrar JavaFX en un entorno Swing
import javafx.scene.media.Media; // Importa la clase Media para representar archivos de audio o video
import javafx.scene.media.MediaPlayer; // Importa MediaPlayer para reproducir archivos de Media
import javafx.scene.media.MediaView; // Importa MediaView para visualizar contenido de video
import javax.swing.JPanel; // Importa JPanel de Swing para el contenedor de componentes gráficos
import java.io.File; // Importa la clase File para gestionar archivos del sistema

class VideoPlayer {
    
    private MediaPlayer mediaPlayer; // Objeto para controlar la reproducción del video
    private MediaView mediaView;     // Objeto para mostrar el video en el JFXPanel
    private JFXPanel videoPanel;     // Panel para integrar JavaFX en Swing

    // Constructor de la clase VideoPlayer
    // Recibe un JPanel como parámetro y configura el videoPanel (JFXPanel) dentro del JPanel
    public VideoPlayer(JPanel jPanel) {
        videoPanel = new JFXPanel(); // Crear el panel JFXPanel que mostrará el video
        jPanel.setLayout(new java.awt.BorderLayout()); // Usar un layout BorderLayout
        jPanel.add(videoPanel, java.awt.BorderLayout.CENTER); // Agregar el videoPanel al JPanel recibido
    }

    // Método para cargar un video desde un archivo
    public void loadVideo(File file) {
        // Si mediaPlayer ya contiene un video, liberamos los recursos
        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }

        // Cargar el archivo de video en un objeto Media
        Media media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media); // Crear el MediaPlayer con el objeto Media
        mediaView = new MediaView(mediaPlayer); // Crear MediaView para mostrar el video

        // Mostrar el video en el JFXPanel
        videoPanel.setScene(new javafx.scene.Scene(new javafx.scene.Group(mediaView)));
    }

    // Método para iniciar la reproducción del video
    public void play() {
        if (mediaPlayer != null) { // Comprobar que mediaPlayer tiene un video cargado
            mediaPlayer.play(); // Iniciar la reproducción
        }
    }

    // Método para pausar el video
    public void pause() {
        if (mediaPlayer != null) { // Comprobar que mediaPlayer tiene un video cargado
            mediaPlayer.pause(); // Pausar la reproducción
        }
    }

    // Método para detener el video
    public void stop() {
        if (mediaPlayer != null) { // Comprobar que mediaPlayer tiene un video cargado
            mediaPlayer.stop(); // Detener la reproducción
        }
    }

    // Método para verificar si el video está en reproducción
    public boolean isPlaying() {
        return mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING;
        // Retorna true si el video está en estado de reproducción
    }

}