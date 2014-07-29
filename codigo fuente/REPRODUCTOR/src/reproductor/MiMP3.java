package reproductor;

import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JSlider;

/**
 *
 * @author Rut
 */
public class MiMP3 {
    
    //mis variables privados
    private Player mediaPlayer;
    private Timer tiempo;
    private TimerTask task;
    private int speed = 1000;
    private int frame = 0;

  
    //Url la direccion del archivo a reproducir
    //JSlider slider que llevara el progreso de la reproduccion
    public void play(URL url, JSlider b) {
        try {
            mediaPlayer = Manager.createRealizedPlayer(url);
            mediaPlayer.start();
            this.startAnimation(b);
        } catch (IOException ex) {
            Logger.getLogger(MiMP3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoPlayerException ex) {
            Logger.getLogger(MiMP3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(MiMP3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodo para animar el JSlider
    public void startAnimation(final JSlider b) {
        tiempo = new Timer();
        task = new TimerTask() {

            public void run() {
                frame = (int) Math.round((mediaPlayer.getMediaTime().getSeconds() * 100) / mediaPlayer.getDuration().getSeconds());
                if (mediaPlayer.getMediaTime().getSeconds() == mediaPlayer.getDuration().getSeconds()) {
                    frame = 100;
                    stop();
                } else {
                    b.setValue(frame);
                }
            }
        };
        tiempo.schedule(task, 0, speed);
    }
    
     //Metodo Stop
    public void stop() {
    mediaPlayer.stop();
    }
    
      
    //obtener volumen
     public float getVolumen() {
        return mediaPlayer.getGainControl().getLevel();
    }
     
     //Poner volumen
    public void setVolumen(float volumen) {
        mediaPlayer.getGainControl().setLevel(volumen);
    }
    
    //mute
      public void setMute(){
        if(mediaPlayer.getGainControl().getMute()==true){//Si esta mute
            mediaPlayer.getGainControl().setMute(false);//quita el mute
        } else{//Si no esta mute
            mediaPlayer.getGainControl().setMute(true);//pone mute
        }
    }
     

}
