/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Rut
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    
    ImageIcon Max_Vol = new ImageIcon("src\\Imagenes\\MaxVolum.png");
    ImageIcon Med_Vol = new ImageIcon("src\\Imagenes\\MedioVolum.png");
    ImageIcon Min_Vol = new ImageIcon("src\\Imagenes\\MinVolum.png");
    ImageIcon Silence = new ImageIcon("src\\Imagenes\\Silence.png");
    ImageIcon ecualizador1 = new ImageIcon("src\\Imagenes\\ecualizador.gif");
    ImageIcon ecualizador2 = new ImageIcon("src\\Imagenes\\ecualizador.jpg");
    
    MiMP3 mp3 = new MiMP3();
    int contador = 1;  //Variable para saber cuantas veces se ha presionado el mute
    private Controles CONTROL = new Controles();
     
    public Interfaz() {
        initComponents();
        this.setVisible(true);
        this.setLocation(400, 50);
        this.setLocationRelativeTo(null);
        Lista.setModel(CONTROL.getModelo());
    }
    
    
    
       //metodo play

    public void Play() {
        jalarecualizador.setIcon(ecualizador1);
        int seleccionado = Lista.getSelectedIndex();
        if (Lista.getFirstVisibleIndex() == -1) { //si el 1er elemento visible es -1
            lblProgreso.setText("La lista esta vacia");//la lista esta vacia
        } else {//Si no esta vacia entonces
            if (Lista.isSelectionEmpty() == true) { //Si la seleccion esta limpia
                lblProgreso.setText("Seleccione una canción para Reproducir");//No hay ningun elemento seleccionado para reproducir
            } else {//Si la seleccion no esta limpia entonces
                CONTROL.play(seleccionado, sldprogreso, lblProgreso);  //Reproduce el elemento seleccionado
                this.setTitle("MP3 - " + CONTROL.getNamemp3()); //Pone de titulo al frame el nombre de la cancion que se reproduce 
            }
        }
        try {//Cada vez que se presiona "Play" se verifica el volumen,
            //para saber en que volumen se debe reproducir la cancion
            float volumen = (float) (sldVolumen.getValue() / 100.0);
            CONTROL.Volumen(volumen);
        } catch (Exception e) {
        }
    }
    
    //metodo siguiente
    public void Siguiente() {
         jalarecualizador.setIcon(ecualizador1);
        if (Lista.getFirstVisibleIndex() == -1) {//si el 1er elemento visible es -1
            lblProgreso.setText("La lista esta vacia");//la lista esta vacia
        } else {//Si no esta vacia... entonces...
            if (Lista.isSelectionEmpty() == true) {//Si la seleccion esta limpia
                lblProgreso.setText("Seleccione una canción para Reproducir");//No hay ningun elemento seleccionado para reproducir
            } else {  //Si la seleccion no esta limpia entonces
                CONTROL.siguiente(sldprogreso, lblProgreso);      //Se reproduce el siguiente elemento del que actualmente se reproduce
                this.setTitle("MP3 - " + CONTROL.getNamemp3());  //Pone el titulo al frame
                Lista.setSelectedIndex(Lista.getSelectedIndex() + 1);  //Selecciona el elemento siguiente
            }
        }
        try {//Cada vez que se presiona "siguiente" se verifica el volumen,
            //para saber en que volumen se debe reproducir la cancion
            float volumen = (float) (sldVolumen.getValue() / 100.0);
            CONTROL.Volumen(volumen);
        } catch (Exception e) {
        }
    }
    
    // metodo anterior
    public void Anterior() {
         jalarecualizador.setIcon(ecualizador1);
        if (Lista.getFirstVisibleIndex() == -1) {//si el 1er elemento visible es -1
            lblProgreso.setText("La lista esta vacia");//la lista esta vacia
        } else {//Si no esta vacia entonces
            if (Lista.isSelectionEmpty() == true) {//Si la seleccion esta limpia
                lblProgreso.setText("Seleccione una canción para Reproducir");//No hay ningun elemento seleccionado para reproducir
            } else {//Si la seleccion no esta limpia entonces
                CONTROL.anterior(sldprogreso, lblProgreso);//Se reproduce el anterior elemento del que actualmente se reproduce
                this.setTitle("MP3 - " + CONTROL.getNamemp3());//Pone el titulo al frame
                Lista.setSelectedIndex(Lista.getSelectedIndex() - 1);//Selecciona el elemento siguiente
            }
        }
        try {//Cada vez que se presiona "Previous" se verifica el volumen,
            //para saber en que volumen se debe reproducir la cancion
            float volumen = (float) (sldVolumen.getValue() / 100.0);
            CONTROL.Volumen(volumen);
        } catch (Exception e) {
        }
    }
    
     //metodo stop o detener la cancion
   public void Stop() {
        jalarecualizador.setIcon(ecualizador2);
        if (Lista.getFirstVisibleIndex() == -1) {//si el 1er elemento visible es -1
            lblProgreso.setText("La lista esta vacia");//la lista esta vacia
        } else {//Si no esta vacia entonces
            if (Lista.isSelectionEmpty() == true) {//Si la seleccion esta limpia
                lblProgreso.setText("No hay ninguna cancion");//Ningun elemento se esta reproduciendo
            } else {//Si la seleccion no esta limpia entonces
                CONTROL.detener();//Se detiene la reproduccion
                this.setTitle("MP3");//Pone el titulo al frame
                lblProgreso.setText("active cancion ");
                sldprogreso.setValue(0);//Pone el progreso en cero
            }
        }
    }
   
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        cambiarfondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        anterior = new javax.swing.JButton();
        play = new javax.swing.JButton();
        pausa = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        sldVolumen = new javax.swing.JSlider();
        lblVolum = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        sldprogreso = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JList();
        lblProgreso = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jalarecualizador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        abrirmp3 = new javax.swing.JMenuItem();
        abrircarpetamp3 = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        tema2 = new javax.swing.JMenu();
        tem1 = new javax.swing.JMenuItem();
        tem2 = new javax.swing.JMenuItem();
        tem3 = new javax.swing.JMenuItem();
        tem4 = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cambiarfondo.setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setToolTipText("");

        anterior.setBackground(new java.awt.Color(0, 0, 0));
        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anterior2.png"))); // NOI18N
        anterior.setToolTipText("Anterior");
        anterior.setBorder(null);
        anterior.setBorderPainted(false);
        anterior.setContentAreaFilled(false);
        anterior.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        anterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        anterior.setIconTextGap(-3);
        anterior.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anterior3.png"))); // NOI18N
        anterior.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/anterior.png"))); // NOI18N
        anterior.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        anterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });

        play.setBackground(new java.awt.Color(0, 0, 0));
        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play2.png"))); // NOI18N
        play.setToolTipText("Play");
        play.setBorder(null);
        play.setBorderPainted(false);
        play.setContentAreaFilled(false);
        play.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        play.setIconTextGap(-3);
        play.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play3.png"))); // NOI18N
        play.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/play.png"))); // NOI18N
        play.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        play.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });

        pausa.setBackground(new java.awt.Color(0, 0, 0));
        pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pausa2.png"))); // NOI18N
        pausa.setToolTipText("Pausa");
        pausa.setBorder(null);
        pausa.setBorderPainted(false);
        pausa.setContentAreaFilled(false);
        pausa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pausa.setIconTextGap(-3);
        pausa.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pausa3.png"))); // NOI18N
        pausa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pausa.png"))); // NOI18N
        pausa.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        pausa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausaActionPerformed(evt);
            }
        });

        stop.setBackground(new java.awt.Color(0, 0, 0));
        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/stop2.png"))); // NOI18N
        stop.setToolTipText("Stop");
        stop.setBorder(null);
        stop.setBorderPainted(false);
        stop.setContentAreaFilled(false);
        stop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stop.setIconTextGap(-3);
        stop.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/stop3.png"))); // NOI18N
        stop.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/stop.png"))); // NOI18N
        stop.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        stop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        siguiente.setBackground(new java.awt.Color(0, 0, 0));
        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siguiente2.png"))); // NOI18N
        siguiente.setToolTipText("Siguiente");
        siguiente.setBorder(null);
        siguiente.setBorderPainted(false);
        siguiente.setContentAreaFilled(false);
        siguiente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        siguiente.setIconTextGap(-3);
        siguiente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siguiente3.png"))); // NOI18N
        siguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siguiente.png"))); // NOI18N
        siguiente.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        siguiente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(play)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pausa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(siguiente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(anterior)
            .addComponent(play)
            .addComponent(stop)
            .addComponent(siguiente)
            .addComponent(pausa)
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        sldVolumen.setBackground(new java.awt.Color(255, 255, 255));
        sldVolumen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sldVolumen.setForeground(new java.awt.Color(0, 51, 51));
        sldVolumen.setToolTipText("Volumen");
        sldVolumen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sldVolumen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldVolumenStateChanged(evt);
            }
        });

        lblVolum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MedioVolum_1.png"))); // NOI18N
        lblVolum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVolumMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sldVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVolum, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVolum)
                    .addComponent(sldVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        sldprogreso.setBackground(new java.awt.Color(255, 255, 255));
        sldprogreso.setToolTipText("Progreso ");
        sldprogreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sldprogreso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldprogresoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sldprogreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sldprogreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Lista.setBackground(new java.awt.Color(0, 51, 51));
        Lista.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Lista.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        Lista.setForeground(new java.awt.Color(255, 255, 255));
        Lista.setToolTipText("Lista de reproduccion");
        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMouseClicked(evt);
            }
        });
        Lista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ListaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(Lista);

        lblProgreso.setBackground(new java.awt.Color(255, 0, 204));
        lblProgreso.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblProgreso.setForeground(new java.awt.Color(255, 255, 255));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("LISTA DE REPRODUCCION");
        jTextField1.setBorder(null);

        jalarecualizador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ecualizador.JPG"))); // NOI18N
        jalarecualizador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jalarecualizador.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout cambiarfondoLayout = new javax.swing.GroupLayout(cambiarfondo);
        cambiarfondo.setLayout(cambiarfondoLayout);
        cambiarfondoLayout.setHorizontalGroup(
            cambiarfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cambiarfondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cambiarfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jalarecualizador, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        cambiarfondoLayout.setVerticalGroup(
            cambiarfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cambiarfondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jalarecualizador, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(cambiarfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cambiarfondoLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        archivo.setBackground(new java.awt.Color(0, 0, 0));
        archivo.setBorder(null);
        archivo.setForeground(new java.awt.Color(255, 255, 255));
        archivo.setText("ARCHIVO");
        archivo.setToolTipText("Abrir archivo MP3");
        archivo.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N

        abrirmp3.setBackground(new java.awt.Color(0, 0, 0));
        abrirmp3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        abrirmp3.setForeground(new java.awt.Color(255, 255, 255));
        abrirmp3.setText("Abrir MP3");
        abrirmp3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        abrirmp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirmp3ActionPerformed(evt);
            }
        });
        archivo.add(abrirmp3);

        abrircarpetamp3.setBackground(new java.awt.Color(0, 0, 0));
        abrircarpetamp3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        abrircarpetamp3.setForeground(new java.awt.Color(255, 255, 255));
        abrircarpetamp3.setText("Abrir carpeta MP3");
        abrircarpetamp3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        abrircarpetamp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrircarpetamp3ActionPerformed(evt);
            }
        });
        archivo.add(abrircarpetamp3);

        salir.setBackground(new java.awt.Color(0, 0, 0));
        salir.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        archivo.add(salir);

        jMenuBar1.add(archivo);

        tema2.setForeground(new java.awt.Color(255, 255, 255));
        tema2.setText("TEMAS");
        tema2.setToolTipText("Cambiar fondo");
        tema2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tema2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tema2ActionPerformed(evt);
            }
        });

        tem1.setBackground(new java.awt.Color(0, 0, 0));
        tem1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tem1.setForeground(new java.awt.Color(255, 255, 255));
        tem1.setText("Rojo");
        tem1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tem1ActionPerformed(evt);
            }
        });
        tema2.add(tem1);

        tem2.setBackground(new java.awt.Color(0, 0, 0));
        tem2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tem2.setForeground(new java.awt.Color(255, 255, 255));
        tem2.setText("Verde Limon");
        tem2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tem2ActionPerformed(evt);
            }
        });
        tema2.add(tem2);

        tem3.setBackground(new java.awt.Color(0, 0, 0));
        tem3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tem3.setForeground(new java.awt.Color(255, 255, 255));
        tem3.setText("Café");
        tem3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tem3ActionPerformed(evt);
            }
        });
        tema2.add(tem3);

        tem4.setBackground(new java.awt.Color(0, 0, 0));
        tem4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        tem4.setForeground(new java.awt.Color(255, 255, 255));
        tem4.setText("Morado");
        tem4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tem4ActionPerformed(evt);
            }
        });
        tema2.add(tem4);

        jMenuBar1.add(tema2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cambiarfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 272, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cambiarfondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirmp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirmp3ActionPerformed
        // TODO add your handling code here:
        CONTROL.abrir_mp3();
        
    }//GEN-LAST:event_abrirmp3ActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        // TODO add your handling code here:
         Anterior();
    }//GEN-LAST:event_anteriorActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        // TODO add your handling code here:
        Play();
    }//GEN-LAST:event_playActionPerformed

    private void pausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausaActionPerformed
        // TODO add your handling code here:
       
      
    }//GEN-LAST:event_pausaActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:
           Stop();
    }//GEN-LAST:event_stopActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        // TODO add your handling code here:
           Siguiente();
    }//GEN-LAST:event_siguienteActionPerformed

    private void ListaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListaKeyTyped
        // TODO add your handling code here:
         if (evt.getKeyChar() == '\n') {
            Play();
        }
    }//GEN-LAST:event_ListaKeyTyped

    private void ListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMouseClicked
        // TODO add your handling code here:
        
          if (evt.getClickCount() == 2) {
            CONTROL.play(Lista.getSelectedIndex(), sldprogreso, lblProgreso);
            this.setTitle("MP3 Player -" + CONTROL.getNamemp3());
        }
        try {
            float volumen = (float) (sldVolumen.getValue() / 100.0);
            CONTROL.Volumen(volumen);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_ListaMouseClicked

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        System.exit(0);        
    }//GEN-LAST:event_salirActionPerformed

    private void sldVolumenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldVolumenStateChanged
        // TODO add your handling code here:
        
        try {//Pone el volumen segun la variacion que ocurre en el JSlider
            float volumen = (float) (sldVolumen.getValue() / 100.0);
            CONTROL.Volumen(volumen);

        } catch (Exception ex) {
        }
        //Cambiar el icono de volumen
        //Si el volumen es mayor o igual a 90
        if (sldVolumen.getValue() >= 90) {
            lblVolum.setIcon(Max_Vol);//Pone el icono de volumen maximo
        } //Si el volumen es mayor o igual a 40 y menor a 90
        else if (sldVolumen.getValue() >= 40 && sldVolumen.getValue() < 90) {
            lblVolum.setIcon(Med_Vol);//Pone el icono de volumen medio
        } //Si el volumen es mayor o igual a 1 y menor a 40
        else if (sldVolumen.getValue() >= 1 && sldVolumen.getValue() < 40) {
            lblVolum.setIcon(Min_Vol);//Pone el icono de volumen minimo
        } else {//Si no es ninguno de los anteriores, es decir, que el volumen es cero
            lblVolum.setIcon(Silence);//Pone el icono de Mute
        }
    }//GEN-LAST:event_sldVolumenStateChanged

    private void lblVolumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVolumMouseClicked
        // TODO add your handling code here:
       int v = sldVolumen.getValue();//Obteniene el valor del volumen
        if (lblProgreso.getText().equals("Play ")) {//Si se esta reproduciendo algun elemento
            //Siempre la primera vez contador es 1
            if (contador % 2 != 0) {//Si al dividir contador entre 2 el residuo es diferent de 0... entonces...
                CONTROL.Mute();//Pone Mute: si el mute no esta puesto lo pone
                lblVolum.setIcon(Silence);//Pone el icono de silencio
                sldVolumen.setEnabled(false);//Deshabilita el JSlider de volumen
            } else {//Si el residuo si es 0... entonces...
                sldVolumen.setEnabled(true);//Habilita el JSlider de volumen
                CONTROL.Mute();//Pone Mute: si el mute ya esta puesto entonces lo quita
                //Pone el icono segun el valor que tenia el volumen antes de ponerse en mute
                if (v >= 90) {
                    lblVolum.setIcon(Max_Vol);
                } else if (v >= 40 && v < 90) {
                    lblVolum.setIcon(Med_Vol);
                } else if (v >= 1 && v < 40) {
                    lblVolum.setIcon(Min_Vol);
                } else {
                    lblVolum.setIcon(Silence);
                }
            }
        } else {//Si no se esta reproduciendo ningun elemento entonces
            lblProgreso.setText("no hay ninguna cancion"); //avisa que ningun elemento se esta reproduciendo
        }
        contador++;//Aumenta el contador
        /*Lo que sucede es que cada vez que contador sea impar se pondrá en mute y cada vez que
        contador sea par se quitará el mute. Por eso la primera vez contador es 1(numero impar), para que se ponga en mute.
       */
    }//GEN-LAST:event_lblVolumMouseClicked

    private void sldprogresoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldprogresoStateChanged
        // TODO add your handling code here:
        //Este codigo hace que al terminar la reproduccion de un elemento,
       // reproduzca automaticamente el siguiente elemento
       // Si el progreso de la reproduccion es 100, es decir, que ya concluyó entonces
        if (sldprogreso.getValue() == 100) {
            lblProgreso.setText("active cancion");
            this.setTitle("MP3");//Pone titulo al frame
            Siguiente();//Reproduce el siguiente elemento
        }
    }//GEN-LAST:event_sldprogresoStateChanged

    private void tem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tem1ActionPerformed
        // TODO add your handling code here:
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MagmaSkin");
        Color color = new Color(153, 204, 255);
        cambiarfondo.setBackground(color);
    }//GEN-LAST:event_tem1ActionPerformed

    private void tema2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tema2ActionPerformed
        // TODO add your handling code here:  
        
    }//GEN-LAST:event_tema2ActionPerformed

    private void tem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tem3ActionPerformed
        // TODO add your handling code here:
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
        Color color = new Color(204, 204, 204);
        cambiarfondo.setBackground(color);
    }//GEN-LAST:event_tem3ActionPerformed

    private void tem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tem4ActionPerformed
        // TODO add your handling code here:
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.ChallengerDeepSkin");
        Color color = new Color(102, 102, 102);
        cambiarfondo.setBackground(color);
    }//GEN-LAST:event_tem4ActionPerformed

    private void tem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tem2ActionPerformed
        // TODO add your handling code here:
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.EmeraldDuskSkin");
        Color color = new Color(204, 204, 204);
        cambiarfondo.setBackground(color);
    }//GEN-LAST:event_tem2ActionPerformed

    private void abrircarpetamp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrircarpetamp3ActionPerformed
        // TODO add your handling code here:
        CONTROL.abrir_mp3_carpeta();
    }//GEN-LAST:event_abrircarpetamp3ActionPerformed

    /*
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList Lista;
    private javax.swing.JMenuItem abrircarpetamp3;
    private javax.swing.JMenuItem abrirmp3;
    private javax.swing.JButton anterior;
    private javax.swing.JMenu archivo;
    private javax.swing.JPanel cambiarfondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jalarecualizador;
    private javax.swing.JLabel lblProgreso;
    private javax.swing.JLabel lblVolum;
    private javax.swing.JButton pausa;
    private javax.swing.JButton play;
    private javax.swing.JMenuItem salir;
    private javax.swing.JButton siguiente;
    private javax.swing.JSlider sldVolumen;
    private javax.swing.JSlider sldprogreso;
    private javax.swing.JButton stop;
    private javax.swing.JMenuItem tem1;
    private javax.swing.JMenuItem tem2;
    private javax.swing.JMenuItem tem3;
    private javax.swing.JMenuItem tem4;
    private javax.swing.JMenu tema2;
    // End of variables declaration//GEN-END:variables
}
