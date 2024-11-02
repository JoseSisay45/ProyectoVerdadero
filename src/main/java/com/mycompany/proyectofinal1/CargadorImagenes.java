/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal1;

/**
 *
 * @author JOSE
 */
import javax.swing.*; // A - Importar librerías de Swing para interfaz gráfica
import java.awt.*; // B - Importar librería para el diseño de la interfaz
import java.awt.event.*; // C - Importar eventos para la interfaz
import java.io.File; // D - Importar manejo de archivos
import java.util.ArrayList; // E - Importar manejo de listas
import javax.swing.filechooser.FileNameExtensionFilter; // F - Importar filtro para seleccionar archivos


public class CargadorImagenes {
    
   private ArrayList<String> imagenes; // H - Lista de rutas de imágenes
    private int indiceActual; // I - Índice actual de la imagen mostrada
    private JLabel etiquetaImagen; // J - Etiqueta para mostrar la imagen
    private JList<String> listaImagenes; // K - Lista visual de imágenes

    // L - Constructor para inicializar componentes y eventos
    public CargadorImagenes(JList<String> listaImagenes, JPanel panel) {
        this.listaImagenes = listaImagenes; // M - Asigna el JList de imágenes
        this.etiquetaImagen = new JLabel(); // N - Inicializa la etiqueta de imagen
        this.imagenes = new ArrayList<>(); // O - Crea la lista de rutas de imágenes
        this.indiceActual = 0; // P - Establece el índice inicial

        // Q - Configuración del panel para mostrar imágenes
        panel.setLayout(new BorderLayout()); // R - Establece diseño de panel
        panel.add(etiquetaImagen, BorderLayout.CENTER); // S - Añade la etiqueta de imagen al centro del panel

        // T - Evento de doble clic en lista para mostrar imagen
        listaImagenes.addMouseListener(new MouseAdapter() { // U - Añade mouse listener
            public void mouseClicked(MouseEvent evt) { // V - Evento de clic en la lista
                if (evt.getClickCount() == 2) { // W - Detecta doble clic
                    indiceActual = listaImagenes.getSelectedIndex(); // X - Obtiene el índice seleccionado
                    mostrarImagen(); // Y - Llama al método para mostrar imagen
                }
            }
        });
    }

    // Z - Método para cargar imágenes desde una carpeta
    public void cargarImagenesDesdeRuta() {
        JFileChooser selector = new JFileChooser(); // AA - Selector de archivos
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // AB - Selección de directorios
        int opcion = selector.showOpenDialog(null); // AC - Abre selector de carpeta

        if (opcion == JFileChooser.APPROVE_OPTION) { // AD - Verifica si se seleccionó una carpeta
            File carpeta = selector.getSelectedFile(); // AE - Obtiene la carpeta seleccionada
            File[] archivos = carpeta.listFiles((dir, name) -> // AF - Filtra solo archivos JPG y JPEG
                name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".jpeg")); // AG - Filtro de archivos

            if (archivos != null) { // AH - Verifica si hay archivos en la carpeta
                for (File archivo : archivos) { // AI - Recorre cada archivo
                    imagenes.add(archivo.getAbsolutePath()); // AJ - Añade ruta de cada imagen a la lista
                }
                actualizarLista(); // AK - Actualiza la lista en el JList
                indiceActual = 0; // AL - Resetea el índice
                mostrarImagen(); // AM - Muestra la primera imagen
            }
        }
    }

    // AN - Método para mostrar la imagen actual en el JLabel
    private void mostrarImagen() {
        if (!imagenes.isEmpty() && indiceActual >= 0 && indiceActual < imagenes.size()) { // AO - Verifica límites
            ImageIcon icono = new ImageIcon(imagenes.get(indiceActual)); // AP - Carga imagen actual
            Image imagen = icono.getImage().getScaledInstance( // AQ - Escala imagen
                etiquetaImagen.getWidth(), etiquetaImagen.getHeight(), Image.SCALE_SMOOTH); // AR - Tamaño ajustado
            etiquetaImagen.setIcon(new ImageIcon(imagen)); // AS - Asigna imagen escalada a la etiqueta
        }
    }

    // AT - Método para avanzar a la siguiente imagen
    public void siguienteImagen() {
        if (!imagenes.isEmpty() && indiceActual < imagenes.size() - 1) { // AU - Verifica que hay imágenes y límite
            indiceActual++; // AV - Avanza índice
            mostrarImagen(); // AW - Muestra imagen actualizada
        }
    }

    // AX - Método para retroceder a la imagen anterior
    public void anteriorImagen() {
        if (!imagenes.isEmpty() && indiceActual > 0) { // AY - Verifica que hay imágenes y límite
            indiceActual--; // AZ - Retrocede índice
            mostrarImagen(); // BA - Muestra imagen actualizada
        }
    }

    // BB - Método para eliminar la imagen seleccionada de la lista
    public void eliminarImagenSeleccionada() {
        int indiceSeleccionado = listaImagenes.getSelectedIndex(); // BC - Obtiene índice de imagen seleccionada
        if (indiceSeleccionado != -1) { // BD - Verifica que hay selección
            imagenes.remove(indiceSeleccionado); // BE - Elimina la imagen de la lista
            actualizarLista(); // BF - Actualiza JList
            if (indiceActual >= imagenes.size()) { // BG - Ajusta índice si es necesario
                indiceActual = imagenes.size() - 1; // BH - Reajusta índice
            }
            mostrarImagen(); // BI - Muestra imagen actualizada
        }
    }

    // BJ - Actualizar la lista de imágenes en el JList
    private void actualizarLista() {
        DefaultListModel<String> modelo = new DefaultListModel<>(); // BK - Modelo de lista
        for (String ruta : imagenes) { // BL - Recorre cada ruta de imagen
            modelo.addElement(new File(ruta).getName()); // BM - Añade el nombre del archivo al modelo
        }
        listaImagenes.setModel(modelo); // BN - Establece el modelo en el JList
    }
}