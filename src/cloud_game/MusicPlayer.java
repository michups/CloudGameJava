package cloud_game;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * class which load and play sounds
 *
 * @author Michal
 */
public class MusicPlayer {

    URL sound1;
    URL sound2;
    URL choosenSound;

    public MusicPlayer() {
        try {
            sound1 = getClass().getResource("/materials/stuk.wav");
            sound2 = getClass().getResource("/materials/balon_z_woda.wav");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    /**
     * Method which play choosen sound
     *
     * @param numberOfChoosenSound number of choosen sound (1-knock, 2-exploding
     * baloon)
     */
    public void playSound(int numberOfChoosenSound) {
        if (numberOfChoosenSound == 1) {
            choosenSound = sound1;
        }
        if (numberOfChoosenSound == 2) {
            choosenSound = sound2;
        }
        try {
            Clip klip = AudioSystem.getClip();
            AudioInputStream strumien_wejsciowy
                    = AudioSystem.getAudioInputStream(choosenSound);
            klip.open(strumien_wejsciowy);
            klip.start();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
