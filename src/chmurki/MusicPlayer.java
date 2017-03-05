package chmurki;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *klasa sluzaca do wczytania i odtwarzania dzwiekow
 * @author Michal
 */
public class Odtwarzacz {
    File dzwiek1= new File("materialy/stuk.wav");
    File dzwiek2= new File("materialy/balon_z_woda.wav");
    File plik_dzwiekowy ;
    
    /**
     *Metoda odtwarzania plików dźwiękowych
     * @param numer_pliku numer odtworzonego pliku (1-stukniecie, 2-pekniecie balona)
     */
    public void odtworz(int numer_pliku){
        if (numer_pliku==1)
            plik_dzwiekowy=dzwiek1;
        if (numer_pliku==2)
            plik_dzwiekowy=dzwiek2;
            try {                       
                Clip klip = AudioSystem.getClip();
                AudioInputStream strumien_wejsciowy = 
                        AudioSystem.getAudioInputStream(plik_dzwiekowy);
                klip.open(strumien_wejsciowy);
                klip.start(); 
            } 
            catch (Exception ex){
                System.err.println(ex.getMessage());
            }
    }
}//koniec klasy Odtwarzacz