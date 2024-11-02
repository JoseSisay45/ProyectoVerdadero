/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal1;

/**
 *
 * @author JOSE
 */


import javax.swing.table.DefaultTableModel; // Importa el modelo de tabla por defecto para manejar datos en la tabla
import java.awt.event.ActionEvent; // Importa la clase para manejar eventos de acción
import javafx.embed.swing.JFXPanel; // Necesario para inicializar JavaFX
import javax.swing.JFileChooser; // Importa el selector de archivos para elegir archivos o directorios
import java.io.File; // Importa la clase para manejar archivos
import javax.swing.*; // Importa todas las clases de la biblioteca Swing para interfaces gráficas



public class musicaventana extends javax.swing.JFrame {
private MusicPlayer musicPlayer; // Clase que controla la música


   
    public musicaventana() {
       initComponents();
        
        
      JFXPanel fxPanel = new JFXPanel(); // Necesario para inicializar JavaFX


        // Configura el modelo de la tabla y las listas
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"Nombre", "Artista", "Álbum", "Duración", "Peso", "Año"}, 0); // Define las columnas de la tabla
        jTable1.setModel(tableModel); // Asigna el modelo a la tabla

        musicPlayer = new MusicPlayer(tableModel, jList1, jList2); // Inicializa el reproductor de música con la tabla y listas
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rutaincial = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        anterior = new javax.swing.JButton();
        reproducir = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        pausa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        dublicados = new javax.swing.JButton();
        karaoke = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        rutaincial.setBackground(new java.awt.Color(255, 255, 153));
        rutaincial.setText("Ruta Inicial");
        rutaincial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutaincialActionPerformed(evt);
            }
        });
        getContentPane().add(rutaincial);
        rutaincial.setBounds(40, 40, 110, 20);

        jTextField1.setBackground(new java.awt.Color(153, 255, 153));
        jTextField1.setText("____________________________________");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(170, 40, 190, 22);

        anterior.setBackground(new java.awt.Color(153, 204, 0));
        anterior.setText("Anterior");
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        getContentPane().add(anterior);
        anterior.setBounds(50, 120, 73, 23);

        reproducir.setBackground(new java.awt.Color(255, 153, 51));
        reproducir.setText("Reproducir");
        reproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reproducirActionPerformed(evt);
            }
        });
        getContentPane().add(reproducir);
        reproducir.setBounds(140, 120, 100, 23);

        siguiente.setBackground(new java.awt.Color(102, 255, 102));
        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        getContentPane().add(siguiente);
        siguiente.setBounds(250, 120, 100, 23);

        pausa.setBackground(new java.awt.Color(153, 255, 255));
        pausa.setText("Pausa");
        pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausaActionPerformed(evt);
            }
        });
        getContentPane().add(pausa);
        pausa.setBounds(160, 160, 72, 23);

        jTable1.setBackground(new java.awt.Color(255, 255, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Artista", "Album", "Duracion", "Peso D Music", "Año Public"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 200, 500, 120);

        agregar.setBackground(new java.awt.Color(153, 0, 102));
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        getContentPane().add(agregar);
        agregar.setBounds(30, 370, 72, 23);

        eliminar.setBackground(new java.awt.Color(204, 153, 0));
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar);
        eliminar.setBounds(130, 370, 73, 23);

        dublicados.setBackground(new java.awt.Color(102, 204, 0));
        dublicados.setText("Duplicados");
        dublicados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dublicadosActionPerformed(evt);
            }
        });
        getContentPane().add(dublicados);
        dublicados.setBounds(220, 370, 90, 23);

        karaoke.setBackground(new java.awt.Color(153, 0, 51));
        karaoke.setText("Karaoke");
        karaoke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karaokeActionPerformed(evt);
            }
        });
        getContentPane().add(karaoke);
        karaoke.setBounds(320, 370, 72, 23);

        jLabel2.setText("Lista de musica");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(560, 30, 90, 20);

        jList1.setBackground(new java.awt.Color(255, 0, 51));
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(520, 70, 190, 200);

        jList2.setBackground(new java.awt.Color(153, 0, 153));
        jScrollPane3.setViewportView(jList2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(530, 300, 170, 150);

        jLabel1.setText("Musica Duplicados");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(410, 350, 110, 30);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 720, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rutaincialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutaincialActionPerformed
  
        JFileChooser chooser = new JFileChooser(); // Crea un selector de archivos
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Configura para seleccionar solo directorios
        int returnValue = chooser.showOpenDialog(this); // Muestra el selector de archivos
        if (returnValue == JFileChooser.APPROVE_OPTION) { // Si se selecciona un archivo
            File selectedFile = chooser.getSelectedFile(); // Obtiene el archivo seleccionado
            jTextField1.setText(selectedFile.getAbsolutePath()); // Muestra la ruta del archivo en el campo de texto
        }
              
    }//GEN-LAST:event_rutaincialActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
              musicPlayer.playPrevious();// Llama al método para reproducir la canción anterior
 
    }//GEN-LAST:event_anteriorActionPerformed

    private void reproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reproducirActionPerformed
         
        int selectedRow = jTable1.getSelectedRow();// Obtiene la fila seleccionada en la tabla
    if (selectedRow != -1) { // Si hay una fila seleccionada
        // Reproducir la canción seleccionada
        musicPlayer.playSong(selectedRow);
        reproducir.setText("Reproducir"); // Cambia el texto del botón a "Reproducir"
    } else {
        JOptionPane.showMessageDialog(this, "Selecciona una canción para reproducir.");
    }
    }//GEN-LAST:event_reproducirActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
              musicPlayer.playNext();// Llama al método para reproducir la canción anterior

        
    }//GEN-LAST:event_siguienteActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
         
        JFileChooser chooser = new JFileChooser(); // Crea un selector de archivos
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Configura para seleccionar solo archivos
        int returnValue = chooser.showOpenDialog(this); // Muestra el selector de archivos
        if (returnValue == JFileChooser.APPROVE_OPTION) { // Si se selecciona un archivo
            File selectedFile = chooser.getSelectedFile(); // Obtiene el archivo seleccionado
            musicPlayer.addSong(selectedFile); // Agrega la canción seleccionada al reproductor
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
       
        int selectedRow = jTable1.getSelectedRow(); // Obtiene la fila seleccionada en la tabla
        if (selectedRow != -1) { // Si hay una fila seleccionada
            musicPlayer.removeSong(selectedRow); // Llama al método para eliminar la canción
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void dublicadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dublicadosActionPerformed
        musicPlayer.findDuplicates(); // Llama al método para buscar canciones duplicadas
    }//GEN-LAST:event_dublicadosActionPerformed

    private void karaokeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karaokeActionPerformed
       JOptionPane.showMessageDialog(this, "Lo siento Valimos Madres.. :(.");
        
    }//GEN-LAST:event_karaokeActionPerformed

    private void pausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausaActionPerformed
              
    if (musicPlayer.isPlaying()) {// Si el reproductor está reproduciendo
        musicPlayer.pause(); // Pausa la reproducción
        pausa.setText("Reanudar");// Cambia el texto del botón a "Reanudar"
    } else {// Si el reproductor está pausado
        musicPlayer.resume(); // Reanuda la reproducción
        pausa.setText("Pausa");// Cambia el texto del botón a "Pausa"
    }
    
    }//GEN-LAST:event_pausaActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new musicaventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton anterior;
    private javax.swing.JButton dublicados;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton karaoke;
    private javax.swing.JButton pausa;
    private javax.swing.JButton reproducir;
    private javax.swing.JButton rutaincial;
    private javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables

   

   
}
