import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

class muse{
    //music will be available to main method
    static Thread music ;
    // this plays music files

    Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
    public void uncaughtException(Thread music, Throwable ex) {
        System.out.println("Uncaught exception: " + ex);
    }
    };
    
    static int dialogButton;
     static void mate(String dian) throws InterruptedException{
    music = new Thread(dian){
        
    //removed argument so it can run when you call start(); 
    @Override
    public void run(){
        
      try{
          /*
        JFrame frame = new JFrame("Muse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.getContentPane().add("hello",.CENTER);
        frame.pack();
        frame.setVisible(true);
        */
        
        Clip clip= null;
        File in = new File(dian);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(in);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        dialogButton = JOptionPane.showConfirmDialog(null, "Click Yes to stop music", 
       ("Muse: "+dian), JOptionPane.YES_OPTION);
        if(dialogButton == JOptionPane.YES_OPTION)
         {
          System.out.println("exiting");
          clip.stop();       
         } 
        if (Client.sl.equalsIgnoreCase("stop")){
            clip.stop();
        }
    
        clip.drain();
        
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();   
    }
    
    }
    }; 
    music.start();
    
};

     
    }
