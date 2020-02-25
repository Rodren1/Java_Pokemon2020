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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.UIDefaults;
import javax.swing.plaf.ColorUIResource;

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

    //estructura para guardar todo el contenido de la base de datos de golpe
    HashMap<String, Pokemon> listaPokemones = new HashMap();

    @Override
    public void paint(Graphics g) {
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
        Color bgColor = jPanel1.getBackground();
        UIDefaults defaults = new UIDefaults();
        defaults.put("TextPane.background", new ColorUIResource(bgColor));
        defaults.put("TextPane[Enabled].backgroundPainter", bgColor);
        descripcion.putClientProperty("Nimbus.Overrides", defaults);
        descripcion.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
        descripcion.setBackground(bgColor);

        try {
            imagen1 = ImageIO.read(getClass()
                    .getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
        }

        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        Graphics2D g2 = buffer1.createGraphics();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager
                    .getConnection("jdbc:mysql://127.0.0.1/test",
                            "user",
                            "");
            estado = conexion.createStatement();
            resultadoConsulta = estado.executeQuery("select * from pokemon");
            //recorremos el array del resultado uno a uno para ir cargandolo en el hashmap
            while (resultadoConsulta.next()) {
                Pokemon p = new Pokemon();
                p.nombre = resultadoConsulta.getString("nombre");
                p.especie = resultadoConsulta.getString("especie");
                p.movimiento1 = resultadoConsulta.getString("movimiento1");
                p.peso = resultadoConsulta.getString("peso");
                p.altura = resultadoConsulta.getString("altura");
                p.tipo1 = resultadoConsulta.getString("tipo1");
                p.tipo2 = resultadoConsulta.getString("tipo2");
                p.movimiento1 = resultadoConsulta.getString("movimiento1");
                p.movimiento2 = resultadoConsulta.getString("movimiento2");
                p.movimiento3 = resultadoConsulta.getString("movimiento3");
                p.movimiento4 = resultadoConsulta.getString("movimiento4");
                p.habitat = resultadoConsulta.getString("habitat");
                p.id = resultadoConsulta.getString("id");
                p.descripcion = resultadoConsulta.getString("descripcion");

                listaPokemones.put(resultadoConsulta.getString("id"), p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("hay un error");
        }
    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion) {
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        g2.drawImage(imagen1,
                0, //posicion X inicial dentro del jpanel 
                0, // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna * 96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila * 96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna * 96 + 96, //posicion final X
                fila * 96 + 96, //posicion final Y
                null //si no lo pones no va
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
        id = new javax.swing.JLabel();
        peso = new javax.swing.JLabel();
        altura = new javax.swing.JLabel();
        movimiento1 = new javax.swing.JLabel();
        movimiento2 = new javax.swing.JLabel();
        movimiento3 = new javax.swing.JLabel();
        movimiento4 = new javax.swing.JLabel();
        nombrePokemon = new javax.swing.JLabel();
        especie = new javax.swing.JLabel();
        habitat = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextPane();
        tipo1 = new javax.swing.JLabel();
        tipo2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pokedex = new javax.swing.JLabel();
        arriba = new javax.swing.JButton();
        abajo = new javax.swing.JButton();
        dcha = new javax.swing.JButton();
        izq = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenPokemon.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(imagenPokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 250, 170));

        id.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 120, 30));

        peso.setBackground(new java.awt.Color(0, 0, 0));
        peso.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        peso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 120, 20));

        altura.setBackground(new java.awt.Color(0, 0, 0));
        altura.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        altura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(altura, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 20));

        movimiento1.setBackground(new java.awt.Color(0, 0, 0));
        movimiento1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        movimiento1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(movimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 120, 20));

        movimiento2.setBackground(new java.awt.Color(0, 0, 0));
        movimiento2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        movimiento2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(movimiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 120, 20));

        movimiento3.setBackground(new java.awt.Color(0, 0, 0));
        movimiento3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        movimiento3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(movimiento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 120, 20));

        movimiento4.setBackground(new java.awt.Color(0, 0, 0));
        movimiento4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        movimiento4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(movimiento4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 120, 20));

        nombrePokemon.setBackground(new java.awt.Color(0, 0, 0));
        nombrePokemon.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        nombrePokemon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(nombrePokemon, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 240, 30));

        especie.setBackground(new java.awt.Color(0, 0, 0));
        especie.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        especie.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(especie, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 240, 30));

        habitat.setBackground(new java.awt.Color(0, 0, 0));
        habitat.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        habitat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(habitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 240, 30));

        descripcion.setEditable(false);
        descripcion.setBackground(new java.awt.Color(0, 102, 0));
        descripcion.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        getContentPane().add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 240, 80));

        tipo1.setBackground(new java.awt.Color(0, 0, 0));
        tipo1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tipo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(tipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 130, 30));

        tipo2.setBackground(new java.awt.Color(0, 0, 0));
        tipo2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tipo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(tipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 110, 30));

        jPanel2.setBackground(new java.awt.Color(51, 102, 0));
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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 140, 70));

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
            .addGap(0, 324, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 260, 330));

        pokedex.setBackground(new java.awt.Color(0, 0, 0));
        pokedex.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        pokedex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pokedex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pkedex.png"))); // NOI18N
        getContentPane().add(pokedex, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 750, 550));

        arriba.setBackground(new java.awt.Color(0, 0, 0));
        arriba.setForeground(new java.awt.Color(255, 255, 255));
        arriba.setBorder(null);
        arriba.setBorderPainted(false);
        arriba.setFocusPainted(false);
        arriba.setOpaque(false);
        arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arribaActionPerformed(evt);
            }
        });
        getContentPane().add(arriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 30, 20));

        abajo.setBackground(new java.awt.Color(0, 0, 0));
        abajo.setForeground(new java.awt.Color(255, 255, 255));
        abajo.setBorder(null);
        abajo.setBorderPainted(false);
        abajo.setFocusPainted(false);
        abajo.setOpaque(false);
        abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abajoActionPerformed(evt);
            }
        });
        getContentPane().add(abajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 30, 20));

        dcha.setBackground(new java.awt.Color(0, 0, 0));
        dcha.setForeground(new java.awt.Color(255, 255, 255));
        dcha.setBorder(null);
        dcha.setBorderPainted(false);
        dcha.setFocusPainted(false);
        dcha.setOpaque(false);
        dcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dchaActionPerformed(evt);
            }
        });
        getContentPane().add(dcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 30, 20));

        izq.setBackground(new java.awt.Color(0, 0, 0));
        izq.setForeground(new java.awt.Color(255, 255, 255));
        izq.setBorder(null);
        izq.setBorderPainted(false);
        izq.setFocusPainted(false);
        izq.setOpaque(false);
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });
        getContentPane().add(izq, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 30, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        dibujaElPokemonQueEstaEnLaPosicion(contador - 1);
        Pokemon p = listaPokemones.get(String.valueOf(contador));
        if (p != null) {
            nombrePokemon.setText("Nombre: " + p.nombre);
            altura.setText("Altura: " + p.altura + " m");
            peso.setText("Peso: " + p.peso + " kg");
            movimiento1.setText("1º " + p.movimiento1);
            movimiento2.setText("2º " + p.movimiento2);
            movimiento3.setText("3º " + p.movimiento3);
            movimiento4.setText("4º " + p.movimiento4);
            tipo1.setText("Tipos: " + p.tipo1 + "     / ");
            tipo2.setText(p.tipo2);
            habitat.setText("Habitat del pokemon: " + p.habitat);
            especie.setText("Especie: " + p.especie);
            id.setText("Nº en la pokedex: " + p.id);
            descripcion.setText(p.descripcion);
        } else {
            nombrePokemon.setText("Nombre: " + "No hay datos");
            altura.setText("Altura: " + "No hay datos");
            peso.setText("Peso: " + "No hay datos");
            movimiento1.setText("1º " + "No hay datos");
            movimiento2.setText("2º " + "No hay datos");
            movimiento3.setText("3º " + "No hay datos");
            movimiento4.setText("4º " + "No hay datos");
            tipo1.setText("Tipos: " + "No hay datos");
            tipo2.setText("");
            habitat.setText("Habitat del pokemon: " + "No hay datos");
            especie.setText("Especie: " + "No hay datos");
            id.setText("Nº en la pokedex: " + "XX");
            descripcion.setText("No hay datos");
        }
        contador--;
        if (contador <= 0) {
            contador = 0;
        }
    }//GEN-LAST:event_izqActionPerformed

    private void dchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dchaActionPerformed
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        Pokemon p = listaPokemones.get(String.valueOf(contador + 1));
        if (p != null) {
            nombrePokemon.setText("Nombre: " + p.nombre);
            altura.setText("Altura: " + p.altura + " m");
            peso.setText("Peso: " + p.peso + " kg");
            movimiento1.setText("1º " + p.movimiento1);
            movimiento2.setText("2º " + p.movimiento2);
            movimiento3.setText("3º " + p.movimiento3);
            movimiento4.setText("4º " + p.movimiento4);
            tipo1.setText("Tipos: " + p.tipo1 + "     / ");
            tipo2.setText(p.tipo2);
            habitat.setText("Habitat del pokemon: " + p.habitat);
            especie.setText("Especie: " + p.especie);
            id.setText("Nº en la pokedex: " + p.id);
            descripcion.setText(p.descripcion);
        } else {
            nombrePokemon.setText("Nombre: " + "No hay datos");
            altura.setText("Altura: " + "No hay datos");
            peso.setText("Peso: " + "No hay datos");
            movimiento1.setText("1º " + "No hay datos");
            movimiento2.setText("2º " + "No hay datos");
            movimiento3.setText("3º " + "No hay datos");
            movimiento4.setText("4º " + "No hay datos");
            tipo1.setText("Tipos: " + "No hay datos");
            tipo2.setText("");
            habitat.setText("Habitat del pokemon: " + "No hay datos");
            especie.setText("Especie: " + "No hay datos");
            id.setText("Nº en la pokedex: " + "XX");
            descripcion.setText("No hay datos");
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
        Pokemon p = listaPokemones.get(String.valueOf(contador));
        if (p != null) {
            nombrePokemon.setText("Nombre: " + p.nombre);
            altura.setText("Altura: " + p.altura + " m");
            peso.setText("Peso: " + p.peso + " kg");
            movimiento1.setText("1º " + p.movimiento1);
            movimiento2.setText("2º " + p.movimiento2);
            movimiento3.setText("3º " + p.movimiento3);
            movimiento4.setText("4º " + p.movimiento4);
            tipo1.setText("Tipos: " + p.tipo1 + "     / ");
            tipo2.setText(p.tipo2);
            habitat.setText("Habitat del pokemon: " + p.habitat);
            especie.setText("Especie: " + p.especie);
            id.setText("Nº en la pokedex: " + p.id);
            descripcion.setText(p.descripcion);
        } else {
            nombrePokemon.setText("Nombre: " + "No hay datos");
            altura.setText("Altura: " + "No hay datos");
            peso.setText("Peso: " + "No hay datos");
            movimiento1.setText("1º " + "No hay datos");
            movimiento2.setText("2º " + "No hay datos");
            movimiento3.setText("3º " + "No hay datos");
            movimiento4.setText("4º " + "No hay datos");
            tipo1.setText("Tipos: " + "No hay datos");
            tipo2.setText("");
            habitat.setText("Habitat del pokemon: " + "No hay datos");
            especie.setText("Especie: " + "No hay datos");
            id.setText("Nº en la pokedex: " + "XX");
            descripcion.setText("No hay datos");
        }
        
    }//GEN-LAST:event_abajoActionPerformed

    private void arribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arribaActionPerformed
        contador += 10;
        if (contador >= 151) {
            contador = 151;

        }
        dibujaElPokemonQueEstaEnLaPosicion(contador-1);
        Pokemon p = listaPokemones.get(String.valueOf(contador));
        if (p != null) {
            nombrePokemon.setText("Nombre: " + p.nombre);
            altura.setText("Altura: " + p.altura + " m");
            peso.setText("Peso: " + p.peso + " kg");
            movimiento1.setText("1º " + p.movimiento1);
            movimiento2.setText("2º " + p.movimiento2);
            movimiento3.setText("3º " + p.movimiento3);
            movimiento4.setText("4º " + p.movimiento4);
            tipo1.setText("Tipos: " + p.tipo1 + "     / ");
            tipo2.setText(p.tipo2);
            habitat.setText("Habitat del pokemon: " + p.habitat);
            especie.setText("Especie: " + p.especie);
            id.setText("Nº en la pokedex: " + p.id);
            descripcion.setText(p.descripcion);
        } else {
            nombrePokemon.setText("Nombre: " + "No hay datos");
            altura.setText("Altura: " + "No hay datos");
            peso.setText("Peso: " + "No hay datos");
            movimiento1.setText("1º " + "No hay datos");
            movimiento2.setText("2º " + "No hay datos");
            movimiento3.setText("3º " + "No hay datos");
            movimiento4.setText("4º " + "No hay datos");
            tipo1.setText("Tipos: " + "No hay datos");
            tipo2.setText("");
            habitat.setText("Habitat del pokemon: " + "No hay datos");
            especie.setText("Especie: " + "No hay datos");
            id.setText("Nº en la pokedex: " + "XX");
            descripcion.setText("No hay datos");
        }
        
    }//GEN-LAST:event_arribaActionPerformed

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
    private javax.swing.JTextPane descripcion;
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
