import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;
class Music{
    // this plays music files
   
    Boolean stopPlayback = false;
    SourceDataLine sourceDataLine;
    AudioFormat audioFormat;
    
    AudioInputStream audioInputStream;

   
    public void music(String newt) throws UnsupportedAudioFileException,IOException, LineUnavailableException {
      try{
        File in = new File(newt);
        audioInputStream = AudioSystem.getAudioInputStream(in);
        audioFormat = audioInputStream.getFormat();
        DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
        sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
        new Thread(new PlayThread()).start();
    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
    }
    
  }
    

    public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    
}
  class PlayThread implements Runnable {
        byte soundBuffer[] = new byte[10000];

        @Override
        public void run() {
            try {
                sourceDataLine.open(audioFormat);
                sourceDataLine.start();
                int cnt;
                while ((cnt = audioInputStream.read(soundBuffer, 0,
                        soundBuffer.length)) != -1 && stopPlayback == false) {
                    if (cnt > 1) {
                        sourceDataLine.write(soundBuffer, 0, cnt);
                    }
                }
                sourceDataLine.drain();
                sourceDataLine.close();
                stopPlayback = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}