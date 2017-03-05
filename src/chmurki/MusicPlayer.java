package chmurki;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * class which load and play sounds
 *
 * @author Michal
 */
public class MusicPlayer {

    File sound1;
    File sound2;
    File choosenSound;

    public MusicPlayer() {
        try {
            sound1 = new File(CloudGame.class.getResource("/materialy/stuk.wav").getPath());
            sound2 = new File(CloudGame.class.getResource("/materialy/balon_z_woda.wav").getPath());
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
