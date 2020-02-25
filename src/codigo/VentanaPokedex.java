
package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    Image imagen1 = null;
    int contador = 0;
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    
    
    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
        g2.drawImage(buffer1, 0, 0,
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight(), null);
    }
    
    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        try {
            imagen1 = ImageIO.read(getClass()
                    .getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
        }
        
        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        Graphics2D g2 = buffer1.createGraphics();
       
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/test",
                            "user",
                            "");
            estado = conexion.createStatement();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("hay un error");
        }
    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight()); 
        g2.drawImage(imagen1,
                0,  //posicion X inicial dentro del jpanel 
                0,  // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null  //si no lo pones no va
                );
        repaint();
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenPokemon = new javax.swing.JLabel();
        nombrePokemon = new javax.swing.JLabel();
        altura = new javax.swing.JLabel();
        peso = new javax.swing.JLabel();
        movimiento1 = new javax.swing.JLabel();
        movimiento2 = new javax.swing.JLabel();
        movimiento3 = new javax.swing.JLabel();
        movimiento4 = new javax.swing.JLabel();
        tipo1 = new javax.swing.JLabel();
        tipo2 = new javax.swing.JLabel();
        especie = new javax.swing.JLabel();
        habitat = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pokedex = new javax.swing.JLabel();
        izq = new javax.swing.JButton();
        arriba = new javax.swing.JButton();
        dcha = new javax.swing.JButton();
        abajo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(imagenPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 250, 170));

        nombrePokemon.setBackground(new java.awt.Color(0, 0, 0));
        nombrePokemon.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(nombrePokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 240, 30));

        altura.setBackground(new java.awt.Color(0, 0, 0));
        altura.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(altura, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 120, 30));

        peso.setBackground(new java.awt.Color(0, 0, 0));
        peso.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 120, 30));

        movimiento1.setBackground(new java.awt.Color(0, 0, 0));
        movimiento1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(movimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 120, 20));

        movimiento2.setBackground(new java.awt.Color(0, 0, 0));
        movimiento2.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(movimiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 120, 20));

        movimiento3.setBackground(new java.awt.Color(0, 0, 0));
        movimiento3.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(movimiento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 120, 20));

        movimiento4.setBackground(new java.awt.Color(0, 0, 0));
        movimiento4.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(movimiento4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 120, 20));

        tipo1.setBackground(new java.awt.Color(0, 0, 0));
        tipo1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(tipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 130, 30));

        tipo2.setBackground(new java.awt.Color(0, 0, 0));
        tipo2.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(tipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 110, 30));

        especie.setBackground(new java.awt.Color(0, 0, 0));
        especie.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(especie, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 240, 40));

        habitat.setBackground(new java.awt.Color(0, 0, 0));
        habitat.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(habitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 240, 40));

        id.setBackground(new java.awt.Color(0, 0, 0));
        id.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 80, 40));

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 134, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 140, 70));

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 260, 340));

        pokedex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pkedex.png"))); // NOI18N
        getContentPane().add(pokedex, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 536));

        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });
        getContentPane().add(izq, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 420, 30, 30));

        arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arribaActionPerformed(evt);
            }
        });
        getContentPane().add(arriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 30, 30));

        dcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dchaActionPerformed(evt);
            }
        });
        getContentPane().add(dcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 30, 30));

        abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abajoActionPerformed(evt);
            }
        });
        getContentPane().add(abajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        dibujaElPokemonQueEstaEnLaPosicion(contador - 1);
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador));
            if (resultadoConsulta.next()){
                id.setText("Nº :  " + resultadoConsulta.getString(1));
                nombrePokemon.setText("Nombre: " + resultadoConsulta.getString(2));
                altura.setText("Altura: " + resultadoConsulta.getString(3) + "m");
                peso.setText("Peso: " + resultadoConsulta.getString(4) + "kg");
                movimiento1.setText("1º: " + resultadoConsulta.getString(10));
                movimiento2.setText("2º: " + resultadoConsulta.getString(11));
                movimiento3.setText("3º: " + resultadoConsulta.getString(12));
                movimiento4.setText("4º: " + resultadoConsulta.getString(13));
                tipo1.setText("Tipos: " + resultadoConsulta.getString(7) + "    /");
                tipo2.setText(resultadoConsulta.getString(8));
                especie.setText("Especie: " + resultadoConsulta.getString(5));
                habitat.setText("Habitat: " + resultadoConsulta.getString(6));
            }
            else{
                id.setText("Sin datos");
                nombrePokemon.setText("Sin datos");
                altura.setText("Sin datos");
                peso.setText("Sin datos");
                movimiento1.setText("Sin datos");
                movimiento2.setText("Sin datos");
                movimiento3.setText("Sin datos");
                movimiento4.setText("Sin datos");
                tipo1.setText("Sin datos");
                tipo2.setText("Sin datos");
                especie.setText("Sin datos");
                habitat.setText("Sin datos");
            }
        } catch (SQLException ex) {
        }
        contador--;
        if (contador <= 0) {
            contador = 0;
        }
    }//GEN-LAST:event_izqActionPerformed

    private void arribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arribaActionPerformed
        contador += 10;
        if (contador >= 151) {
            contador = 151;

        }
        dibujaElPokemonQueEstaEnLaPosicion(contador-1);
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador));
            if (resultadoConsulta.next()){
                id.setText("Nº :  " + resultadoConsulta.getString(1));
                nombrePokemon.setText("Nombre: " + resultadoConsulta.getString(2));
                altura.setText("Altura: " + resultadoConsulta.getString(3) + "m");
                peso.setText("Peso: " + resultadoConsulta.getString(4) + "kg");
                movimiento1.setText("1º: " + resultadoConsulta.getString(10));
                movimiento2.setText("2º: " + resultadoConsulta.getString(11));
                movimiento3.setText("3º: " + resultadoConsulta.getString(12));
                movimiento4.setText("4º: " + resultadoConsulta.getString(13));
                tipo1.setText("Tipos: " + resultadoConsulta.getString(7) + "    /");
                tipo2.setText(resultadoConsulta.getString(8));
                especie.setText("Especie: " + resultadoConsulta.getString(5));
                habitat.setText("Habitat: " + resultadoConsulta.getString(6));
            }
            else{
                id.setText("Sin datos");
                nombrePokemon.setText("Sin datos");
                altura.setText("Sin datos");
                peso.setText("Sin datos");
                movimiento1.setText("Sin datos");
                movimiento2.setText("Sin datos");
                movimiento3.setText("Sin datos");
                movimiento4.setText("Sin datos");
                tipo1.setText("Sin datos");
                tipo2.setText("Sin datos");
                especie.setText("Sin datos");
                habitat.setText("Sin datos");
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_arribaActionPerformed

    private void dchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dchaActionPerformed
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador+1));
            if (resultadoConsulta.next()){
                id.setText("Nº :  " + resultadoConsulta.getString(1));
                nombrePokemon.setText("Nombre: " + resultadoConsulta.getString(2));
                altura.setText("Altura: " + resultadoConsulta.getString(3) + "m");
                peso.setText("Peso: " + resultadoConsulta.getString(4) + "kg");
                movimiento1.setText("1º: " + resultadoConsulta.getString(10));
                movimiento2.setText("2º: " + resultadoConsulta.getString(11));
                movimiento3.setText("3º: " + resultadoConsulta.getString(12));
                movimiento4.setText("4º: " + resultadoConsulta.getString(13));
                tipo1.setText("Tipos: " + resultadoConsulta.getString(7) + "    /");
                tipo2.setText(resultadoConsulta.getString(8));
                especie.setText("Especie: " + resultadoConsulta.getString(5));
                habitat.setText("Habitat: " + resultadoConsulta.getString(6));
            }
            else{
                id.setText("Sin datos");
                nombrePokemon.setText("Sin datos");
                altura.setText("Sin datos");
                peso.setText("Sin datos");
                movimiento1.setText("Sin datos");
                movimiento2.setText("Sin datos");
                movimiento3.setText("Sin datos");
                movimiento4.setText("Sin datos");
                tipo1.setText("Sin datos");
                tipo2.setText("Sin datos");
                especie.setText("Sin datos");
                habitat.setText("Sin datos");
            }
        } catch (SQLException ex) {
        }
        contador++;
        if (contador >= 150) {
            contador = 150;

        }
    }//GEN-LAST:event_dchaActionPerformed

    private void abajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abajoActionPerformed
        contador -= 10;
        if (contador <= 0) {
            contador = 0;
        }
        dibujaElPokemonQueEstaEnLaPosicion(contador - 1);
        try {
            resultadoConsulta = estado.executeQuery("select * from pokemon where id=" + (contador));
            if (resultadoConsulta.next()){
                id.setText("Nº :  " + resultadoConsulta.getString(1));
                nombrePokemon.setText("Nombre: " + resultadoConsulta.getString(2));
                altura.setText("Altura: " + resultadoConsulta.getString(3) + "m");
                peso.setText("Peso: " + resultadoConsulta.getString(4) + "kg");
                movimiento1.setText("1º: " + resultadoConsulta.getString(10));
                movimiento2.setText("2º: " + resultadoConsulta.getString(11));
                movimiento3.setText("3º: " + resultadoConsulta.getString(12));
                movimiento4.setText("4º: " + resultadoConsulta.getString(13));
                tipo1.setText("Tipos: " + resultadoConsulta.getString(7) + "    /");
                tipo2.setText(resultadoConsulta.getString(8));
                especie.setText("Especie: " + resultadoConsulta.getString(5));
                habitat.setText("Habitat: " + resultadoConsulta.getString(6));
            }
            else{
                id.setText("Sin datos");
                nombrePokemon.setText("Sin datos");
                altura.setText("Sin datos");
                peso.setText("Sin datos");
                movimiento1.setText("Sin datos");
                movimiento2.setText("Sin datos");
                movimiento3.setText("Sin datos");
                movimiento4.setText("Sin datos");
                tipo1.setText("Sin datos");
                tipo2.setText("Sin datos");
                especie.setText("Sin datos");
                habitat.setText("Sin datos");
            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_abajoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abajo;
    private javax.swing.JLabel altura;
    private javax.swing.JButton arriba;
    private javax.swing.JButton dcha;
    private javax.swing.JLabel especie;
    private javax.swing.JLabel habitat;
    private javax.swing.JLabel id;
    private javax.swing.JLabel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel movimiento1;
    private javax.swing.JLabel movimiento2;
    private javax.swing.JLabel movimiento3;
    private javax.swing.JLabel movimiento4;
    private javax.swing.JLabel nombrePokemon;
    private javax.swing.JLabel peso;
    private javax.swing.JLabel pokedex;
    private javax.swing.JLabel tipo1;
    private javax.swing.JLabel tipo2;
    // End of variables declaration//GEN-END:variables
}
