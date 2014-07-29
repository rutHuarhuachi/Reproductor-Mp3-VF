/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 *
 * @author Rut
 */
public class Controles {
    private MiMP3 MP3 = new MiMP3();  //Variable de tipo myMP3
    private Vector<String> urlCompleto = new Vector<String>(10, 2);//Vector para guardar los url's de los archivos  
    private Vector<String> namemp3 = new Vector<String>(10, 2);//Vector para guardar los nombres de los archivos
    private static FileNameExtensionFilter filter = new FileNameExtensionFilter("Mp3 File", "mp3");
    /*Filtro: util para filtrar los archivos seleccionados. Solo permite achivos mp3*/ 
    private DefaultListModel modelo = new DefaultListModel();  //modelo para la lista de reproduccion
    private int mp3seleccionado = -1;
    private boolean reproduciendo = false;  //Para saber si se esta reproduciendo un archivo
    private JFileChooser fileChooser;
    public DefaultListModel getModelo() {
        return this.modelo;
    }
    
    //Obtener el nombre de un archivo
    public String getNamemp3() {
        String name = "";
        if (this.mp3seleccionado != -1) {
            name = namemp3.get(this.mp3seleccionado).toString();
        }
        return name;
    }

    //Abrir archivo mp3 
    public void abrir_mp3() {
        fileChooser = new JFileChooser();         //Inicializar el JFileChooser
        fileChooser.setDialogTitle("Abrir mp3"); //Titulo a la ventana de dialogo
        fileChooser.setFileFilter(filter);      //le agregamos el filtro
        int result = fileChooser.showOpenDialog(null); //Guarda si se aprueba abrir un archivo o se cancela el dialogo

        if (result == JFileChooser.APPROVE_OPTION) {// si se abre un archivo mp3 entonces
            try {
                //Se agrega la URL del archivo al vector de url's
                this.urlCompleto.addElement(fileChooser.getSelectedFile().toURL().toString());
                //Se agrega el nombre del archivo al vector de nombres
                this.namemp3.addElement(fileChooser.getSelectedFile().getName());
                //Se agrega el nombre del archivo al modelo de la lista de reproduccion
                this.modelo.addElement(fileChooser.getSelectedFile().getName());
            } catch (MalformedURLException ex) {
                Logger.getLogger(Controles.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
    
    //...........................................................codigo rut
    
    public void abrir_mp3_carpeta()  {
    File carpeta = new File("");
    String[] carpetadir = carpeta.list();
    
   if (carpetadir==null)
       System.out.println("no hay carpeta");
   else{
    for(int x=0; x<carpetadir.length; x++)
      System.out.println(carpetadir[x]);
   }
   
    }
    
    //..............
    
    //int i es el valor del archivo seleccionado
    //JSilder para el progreso de la reproduccion
    //JLabel para indicar el estado si esta reproduciendo o esta activo
    public void play(int i,JSlider b, JLabel lbl) {
         if (i >= 0) {   //Si i es mayor o igual a cero entonces
            try {
                if (this.reproduciendo) {  //Si un archivo se esta reproduciendo entonces
                    detener();//Se detiene caso contrario 
                }
                this.reproduciendo = true;    //reproduciendo en true, ya que al detener esta en false
                this.mp3seleccionado = i;      //Guardamos el valor del archivo seleccionado
                //Play le mandamos el URL del archivo seleccionado y el slider
                MP3.play(new URL(urlCompleto.get(i).toString()), b);
                lbl.setText("Reproduciendo");   //Indicamos en el Jlabel que actualmente se esta reproduciendo
            } catch (MalformedURLException ex) {
                Logger.getLogger(Controles.class.getName()).log(Level.SEVERE, null, ex);
                lbl.setText(" fallo en la reproduccion ");
            }
        }
    }
    
    // metodo detener
    
     public void detener() {
        if (this.reproduciendo) {//Si se esta reproduciendo algun archivo entonces
            MP3.stop();//Se detiene
            this.reproduciendo = false;//reproduciendo en false: para indicar que ya nada se esta reproduciendo
        }
    }
     
   //siguiente
    //JSlider para indicar el progreso de reproduccion
    //Jlabel para indicar el estado si esta activo
    public void siguiente(JSlider b, JLabel lbl) {
        int tamanio_total_vector = namemp3.size() - 1;    //Obtenemos el tamaño del vector de nombres menos uno
        //Si el index del archivo seleccionado mas uno es menor o igual que el tamaño del vector 
        //(esto significa que hay un archivo siguiente para reproducir)... entonces...
        if ((this.mp3seleccionado + 1) <= tamanio_total_vector) {
            this.mp3seleccionado = this.mp3seleccionado + 1;   //Actualiza el archivo seleccionado
            detener();                 //Detiene el que actualmente se reproduce
            play((this.mp3seleccionado), b, lbl);    //reproduce el nuevo archivo seleccionado
        }
    }
    
    //Anterior
    //JSlider para indicar el progreso de reproduccion
    //Jlabel para indicar el estado
    public void anterior(JSlider b, JLabel lbl) {
        //Si el index del archivo seleecionado menos 1 es mayor o igual a cero
        //esto significa que todavia hay un archivo anterior entonces
        if ((this.mp3seleccionado - 1) >= 0) {
            this.mp3seleccionado = this.mp3seleccionado - 1;   //Actualiza el archivo seleccionado
            detener();    //Detiene el que actualmente se reproduce
            play((this.mp3seleccionado), b, lbl);   //reproduce el nuevo archivo seleccionado
        }
    }
    
//    //pausa codigo rut
//    public void pausar(JSlider b,JLabel lbl){
//      if (this.reproduciendo) {//Si se esta reproduciendo algun archivo entonces
//            MP3.pausa();//Se detiene
//            this.reproduciendo = false;//reproduciendo en false: para indicar que ya nada se esta reproduciendo
//        }
//    }
    
    //Volumen
    //float: para indicar el nivel del volumen
    public void Volumen(float vol) {
        MP3.setVolumen(vol);
    }
     
    //Mute
    public void Mute() {
        MP3.setMute();
    } 
}
