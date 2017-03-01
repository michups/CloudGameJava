package chmurki;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *klasa zawierajaca wszystkie obrazki
 * @author Michal
 */
public class Obrazki {
    public Image       tlo1;
    public Image       tlo2;
    public Image       tlo3;
    public Image       tlo_uzyte;
    public Image       pauza_chmura;
    public Image       chmurka1;
    public Image       chmurka2;
    public Image       chmurka3;
    public Image       chmurka_uzyta;
    public Image       wiatrak;
    public Image       prog;
    public Image       pasek;
    public Image       menu;
/**
 * konstruktor wczytujacy obrazki
 */
    public  Obrazki(){
        tlo1            = new ImageIcon("materialy/tlo1.png").getImage();
        menu            = new ImageIcon("materialy/menu.png").getImage();
        tlo2            = new ImageIcon("materialy/tlo2.png").getImage();
        tlo3            = new ImageIcon("materialy/tlo3.png").getImage();
        wiatrak         = new ImageIcon("materialy/wiatrak.png").getImage();
        prog            = new ImageIcon("materialy/prog.png").getImage();
        pasek           = new ImageIcon("materialy/pasek.png").getImage();
        chmurka1        = new ImageIcon("materialy/chmurka1.png").getImage();
        chmurka2        = new ImageIcon("materialy/chmurka2.png").getImage();
        chmurka3        = new ImageIcon("materialy/chmurka3.png").getImage();
        pauza_chmura    = new ImageIcon("materialy/pauza.png").getImage();
    }
    public void setBackgroundForLevel(int level)
    {
        switch (level)
        {
            case 1: tlo_uzyte = tlo1;
            case 2: tlo_uzyte = tlo2;
            case 3: tlo_uzyte = tlo3;
                default: tlo_uzyte = tlo1 ;
        } 
    }
}//koniec klasy Obrazki
