/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal1;

/**
 *
 * @author JOSE
 */
import javax.swing.*; // Importa las bibliotecas para crear la interfaz
import java.awt.event.*; // Importa bibliotecas para manejar eventos de botón
import java.io.File; // Importa para manipular archivos
import java.util.ArrayList; // Importa para manejar listas
import java.util.List;

public class videoventana extends javax.swing.JFrame {
    
 private VideoPlayer videoPlayer; // Objeto para reproducir videos
    private List<File> videoFiles; // Lista de archivos de video
    private int currentIndex = -1; // Guarda el índice del video actual
    
    public videoventana() {
            initComponents(); // Inicializa la interfaz gráfica
        videoPlayer = new VideoPlayer(jPanel1); // Asocia el reproductor con el panel de video
        videoFiles = new ArrayList<>(); // Crea la lista de videos
        jList1.setModel(new DefaultListModel<>()); // Modelo de la lista de videos

        // Añade el evento de doble clic en la lista de videos
        jList1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Si es doble clic
                    currentIndex = jList1.getSelectedIndex(); // Toma el índice seleccionado
                    if (currentIndex != -1) { // Si hay un video seleccionado
                        playVideoFromList(); // Llama al método para reproducir
                    }
                }
            }
        });
    }

    // Reproduce el video seleccionado de la lista
    private void playVideoFromList() {
        File selectedFile = videoFiles.get(currentIndex); // Toma el archivo seleccionado
        videoPlayer.loadVideo(selectedFile); // Carga el video en el reproductor
        videoPlayer.play(); // Inicia la reproducción
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Anterior = new javax.swing.JButton();
        Play = new javax.swing.JButton();
        Siguiente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Ruta = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        Eliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 204));
        getContentPane().setLayout(null);

        Anterior.setBackground(new java.awt.Color(255, 51, 51));
        Anterior.setText("Anterior");
        Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(Anterior);
        Anterior.setBounds(50, 440, 73, 23);

        Play.setBackground(new java.awt.Color(153, 0, 153));
        Play.setText("Play");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });
        getContentPane().add(Play);
        Play.setBounds(160, 440, 72, 23);

        Siguiente.setBackground(new java.awt.Color(0, 204, 204));
        Siguiente.setText("Siguiente");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(Siguiente);
        Siguiente.setBounds(250, 440, 79, 23);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setForeground(new java.awt.Color(51, 255, 51));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 110, 430, 300);

        jList1.setBackground(new java.awt.Color(204, 255, 255));
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(460, 50, 240, 240);

        Ruta.setBackground(new java.awt.Color(255, 153, 51));
        Ruta.setText("Ruta");
        Ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutaActionPerformed(evt);
            }
        });
        getContentPane().add(Ruta);
        Ruta.setBounds(40, 30, 72, 23);

        jTextField1.setBackground(new java.awt.Color(255, 255, 153));
        jTextField1.setText("_________________________________");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(140, 30, 190, 22);

        Eliminar.setBackground(new java.awt.Color(153, 153, 0));
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar);
        Eliminar.setBounds(550, 310, 75, 23);

        jPanel2.setBackground(new java.awt.Color(102, 255, 102));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 710, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
       if (videoPlayer.isPlaying()) { // Verifica si el video está reproduciéndose
        videoPlayer.pause(); // Si está reproduciendo, pausa el video
    } else {
        videoPlayer.play(); // Si no está reproduciendo, inicia la reproducción
    }
    }//GEN-LAST:event_PlayActionPerformed

    private void AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnteriorActionPerformed
        
      if (currentIndex > 0) { // Verifica si hay un video anterior en la lista
        currentIndex--; // Retrocede al índice del video anterior
        playVideoFromList(); // Llama al método para reproducir el video actual
    }
    }//GEN-LAST:event_AnteriorActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
    if (currentIndex < videoFiles.size() - 1) { // Verifica si hay un siguiente video
        currentIndex++; // Avanza al índice del siguiente video
        playVideoFromList(); // Llama al método para reproducir el video actual
    }
    }//GEN-LAST:event_SiguienteActionPerformed

    private void RutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutaActionPerformed
      JFileChooser fileChooser = new JFileChooser(); // Crea un selector de archivos
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("MP4 Videos", "mp4")); // Filtro para solo archivos MP4
    int result = fileChooser.showOpenDialog(this); // Muestra el diálogo para elegir un archivo

    if (result == JFileChooser.APPROVE_OPTION) { // Verifica si el usuario seleccionó un archivo
        File selectedFile = fileChooser.getSelectedFile(); // Toma el archivo seleccionado
        videoFiles.add(selectedFile); // Lo agrega a la lista de archivos de video
        ((DefaultListModel<String>) jList1.getModel()).addElement(selectedFile.getName()); // Muestra el nombre en la lista
        jTextField1.setText(selectedFile.getAbsolutePath()); // Muestra la ruta del archivo en el campo de texto
    }
    }//GEN-LAST:event_RutaActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int index = jList1.getSelectedIndex(); // Obtiene el índice del video seleccionado
    if (index != -1) { // Verifica si hay un video seleccionado en la lista
        videoFiles.remove(index); // Remueve el archivo de la lista de videos
        ((DefaultListModel<String>) jList1.getModel()).remove(index); // Lo quita de la interfaz

        // Si el video eliminado es el que estaba en reproducción, detiene la reproducción
        if (index == currentIndex) { // Verifica si el video eliminado era el actual
            videoPlayer.stop(); // Detiene el reproductor
            currentIndex = -1; // Restablece el índice actual
        }
    }
    }//GEN-LAST:event_EliminarActionPerformed

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new videoventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Anterior;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Play;
    private javax.swing.JButton Ruta;
    private javax.swing.JButton Siguiente;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
