/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfazgrafica;

import herencias.Idiomas;
import interfacespropias.Sonidos;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author ShibaXpath
 */
public final class MensajesRecibidos extends Idiomas implements Sonidos {

    private String nombreUsuario;

    /**
     * Creates new form InicioApp
     */
    public MensajesRecibidos() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Kizuna App");
        setResizable(false);
        setIconImage(getIconImage());
        nombreUsuario = "";
    }

    public void setNombreUsuario(String nombreUsuario) {
        // Establece el nombre de usuario en el objeto actual
        this.nombreUsuario = nombreUsuario;
    }

    public void setCampoUser1(String mensaje) {
        // Establece el texto del campoUser1 en la interfaz de usuario
        this.campoUser1.setText(mensaje);
    }

    public void setFoto1(String sexo) {
        try
        {
            // Establece la imagen del foto1 según el sexo proporcionado
            switch (sexo)
            {
                case "Hombre":
                    this.foto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hombreMini.png")));
                    break;
                case "男":
                    this.foto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hombreJapoMini.png")));
                    break;
                case "Mujer":
                    this.foto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mujerMini.png")));
                    break;
                case "女性":
                    this.foto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mujerJapoMini.png")));
                    break;
            }
        } catch (NullPointerException e)
        {
            // Si se produce una excepción de puntero nulo, establece una imagen de desconocido en foto1
            this.foto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/desconocido.png")));
        }
    }

    public void setUser1(String user) {
        // Establece el texto del user1 en la interfaz de usuario
        this.user1.setText(user);
    }

    public void setCampoUser2(String mensaje) {
        // Establece el texto del campoUser2 en la interfaz de usuario
        this.campoUser2.setText(mensaje);
    }

    public void setFoto2(String sexo) {
        try
        {
            // Establece la imagen del foto2 según el sexo proporcionado
            switch (sexo)
            {
                case "Hombre":
                    this.foto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hombreMini.png")));
                    break;
                case "男":
                    this.foto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hombreJapoMini.png")));
                    break;
                case "Mujer":
                    this.foto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mujerMini.png")));
                    break;
                case "女性":
                    this.foto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mujerJapoMini.png")));
                    break;
            }
        } catch (NullPointerException e)
        {
            // Si se produce una excepción de puntero nulo, establece una imagen de desconocido en foto2
            this.foto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/desconocido.png")));
        }
    }

    public void setUser2(String user) {
        // Establece el texto del user2 en la interfaz de usuario
        this.user2.setText(user);
    }

    public void setCampoUser3(String mensaje) {
        // Establece el texto del campoUser3 en la interfaz de usuario
        this.campoUser3.setText(mensaje);
    }

    public void setFoto3(String sexo) {
        try
        {
            // Establece la imagen del foto3 según el sexo proporcionado
            switch (sexo)
            {
                case "Hombre":
                    this.foto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hombreMini.png")));
                    break;
                case "男":
                    this.foto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hombreJapoMini.png")));
                    break;
                case "Mujer":
                    this.foto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mujerJapoMini.png")));
                    break;
                case "女性":
                    this.foto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mujerJapo.png")));
                    break;
            }
        } catch (NullPointerException e)
        {
            // Si se produce una excepción de puntero nulo, establece una imagen de desconocido en foto3
            this.foto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/desconocido.png")));
        }
    }

    public void setUser3(String user) {
        // Establece el texto del user3 en la interfaz de usuario
        this.user3.setText(user);
    }

    @Override
    public Image getIconImage() {
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/miicono.jpg"));

        return icono;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imagen = new javax.swing.JLabel();
        fondo = new javax.swing.JPanel();
        volver = new javax.swing.JButton();
        separador5 = new javax.swing.JSeparator();
        scroll3 = new javax.swing.JScrollPane();
        campoUser3 = new javax.swing.JTextField();
        separador6 = new javax.swing.JSeparator();
        foto3 = new javax.swing.JLabel();
        user3 = new javax.swing.JLabel();
        foto2 = new javax.swing.JLabel();
        separador3 = new javax.swing.JSeparator();
        user2 = new javax.swing.JLabel();
        separador4 = new javax.swing.JSeparator();
        scroll2 = new javax.swing.JScrollPane();
        campoUser2 = new javax.swing.JTextField();
        foto1 = new javax.swing.JLabel();
        user1 = new javax.swing.JLabel();
        separador1 = new javax.swing.JSeparator();
        scroll1 = new javax.swing.JScrollPane();
        campoUser1 = new javax.swing.JTextField();
        separador2 = new javax.swing.JSeparator();
        titulo = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        menuSesion = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        salida = new javax.swing.JMenuItem();
        idiomas = new javax.swing.JMenu();
        español = new javax.swing.JMenuItem();
        japones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1030, 730));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 690));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 530, 680));

        fondo.setBackground(new java.awt.Color(204, 204, 204));
        fondo.setPreferredSize(new java.awt.Dimension(510, 680));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        volver.setBackground(new java.awt.Color(255, 0, 51));
        volver.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        volver.setForeground(new java.awt.Color(255, 255, 255));
        volver.setText("VOLVER");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        fondo.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 140, 60));
        fondo.add(separador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 510, 20));

        campoUser3.setEditable(false);
        campoUser3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        campoUser3.setFocusable(false);
        scroll3.setViewportView(campoUser3);

        fondo.add(scroll3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 320, 80));
        fondo.add(separador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 510, 20));
        fondo.add(foto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 150, 80));

        user3.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(user3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 160, 30));
        fondo.add(foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 150, 80));
        fondo.add(separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 510, 20));

        user2.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(user2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 160, 30));
        fondo.add(separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 510, 20));

        campoUser2.setEditable(false);
        campoUser2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        campoUser2.setFocusable(false);
        scroll2.setViewportView(campoUser2);

        fondo.add(scroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 320, 80));
        fondo.add(foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 150, 80));

        user1.setForeground(new java.awt.Color(0, 0, 0));
        fondo.add(user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 160, 30));
        fondo.add(separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 510, 20));

        campoUser1.setEditable(false);
        campoUser1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        campoUser1.setFocusable(false);
        scroll1.setViewportView(campoUser1);

        fondo.add(scroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 320, 80));
        fondo.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 510, 20));

        titulo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("ÚLTIMOS 3 MENSAJES RECIBIDOS:");
        fondo.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 30, 680));

        archivo.setText("Archivo");

        salida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        salida.setText("Salir");
        salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidaActionPerformed(evt);
            }
        });
        archivo.add(salida);

        menuSesion.add(archivo);

        idiomas.setText("Idiomas");

        español.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK));
        español.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/espaicon.png"))); // NOI18N
        español.setText("Español");
        español.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                españolActionPerformed(evt);
            }
        });
        idiomas.add(español);

        japones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.ALT_DOWN_MASK));
        japones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/japoicon.png"))); // NOI18N
        japones.setText("日本語");
        japones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                japonesActionPerformed(evt);
            }
        });
        idiomas.add(japones);

        menuSesion.add(idiomas);

        setJMenuBar(menuSesion);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void japonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_japonesActionPerformed
        cambiarIdioma(false);
        super.setBandera(false);
    }//GEN-LAST:event_japonesActionPerformed

    private void españolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_españolActionPerformed
        cambiarIdioma(true);
        super.setBandera(true);
    }//GEN-LAST:event_españolActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Plataforma plata = new Plataforma();
        reproducirSonidoBoton();
        plata.setBandera(super.isBandera());
        plata.cambiarIdioma(super.isBandera());
        plata.setNombreUsuario(nombreUsuario);
        this.dispose();
        plata.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed

    private void salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu archivo;
    private javax.swing.JTextField campoUser1;
    private javax.swing.JTextField campoUser2;
    private javax.swing.JTextField campoUser3;
    private javax.swing.JMenuItem español;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel foto1;
    private javax.swing.JLabel foto2;
    private javax.swing.JLabel foto3;
    private javax.swing.JMenu idiomas;
    private javax.swing.JLabel imagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JMenuItem japones;
    private javax.swing.JMenuBar menuSesion;
    private javax.swing.JMenuItem salida;
    private javax.swing.JScrollPane scroll1;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JScrollPane scroll3;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador2;
    private javax.swing.JSeparator separador3;
    private javax.swing.JSeparator separador4;
    private javax.swing.JSeparator separador5;
    private javax.swing.JSeparator separador6;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel user1;
    private javax.swing.JLabel user2;
    private javax.swing.JLabel user3;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cambiarIdioma(boolean idioma) {
        if (idioma)
        {
            // Si el idioma es verdadero (español)
            archivo.setText("Archivo");
            idiomas.setText("Idiomas");
            salida.setText("Desconectar");
            volver.setFont(new java.awt.Font("Roboto", 0, 18));
            volver.setText("VOLVER");
            titulo.setText("ÚLTIMOS 3 MENSAJES RECIBIDOS:");
            titulo.setFont(new java.awt.Font("Roboto", 0, 24));
            imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3Mensajes.jpg")));
        } else
        {
            // Si el idioma es falso (japonés)
            archivo.setText("アーカイブ");
            idiomas.setText("語");
            salida.setText("ディスコネクト");
            volver.setFont(new java.awt.Font("Dialog", 0, 18));
            titulo.setText("直近の受信メッセージ3件");
            titulo.setFont(new java.awt.Font("Dialog", 0, 24));
            volver.setText("戻る");
            imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo3MensajesJP.jpg")));
        }
    }

    @Override
    public AudioClip obtenerSonido() {
        // Obtiene el archivo de sonido del botón
        AudioClip sonidoBoton;
        URL url = getClass().getResource("/sonidos/raton.wav");
        sonidoBoton = java.applet.Applet.newAudioClip(url);
        return sonidoBoton;
    }

    @Override
    public void reproducirSonidoBoton() {
        // Reproduce el sonido del botón
        obtenerSonido().play();
    }

}
