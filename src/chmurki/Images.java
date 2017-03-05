package chmurki;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * class containing all images
 *
 * @author Michal
 */
public class Images {

    public Image background1;
    public Image backgroud2;
    public Image background3;
    public Image usedBackgroundImage;
    public Image cloudOnPause;
    public Image cloud1;
    public Image cloud2;
    public Image cloud3;
    public Image usedCloud;
    public Image windmill;
    public Image spinePipe;
    public Image label;
    public Image menu;

    /**
     * konstruktor wczytujacy obrazki
     */
    public Images() {
        try {
            background1 = ImageIO.read(Images.class.getResource("/materialy/tlo1.png"));
            menu = ImageIO.read(Images.class.getResource("/materialy/menu.png"));
            backgroud2 = ImageIO.read(Images.class.getResource("/materialy/tlo2.png"));
            background3 = ImageIO.read(Images.class.getResource("/materialy/tlo3.png"));
            windmill = ImageIO.read(Images.class.getResource("/materialy/wiatrak.png"));
            spinePipe = ImageIO.read(Images.class.getResource("/materialy/prog.png"));
            label = ImageIO.read(Images.class.getResource("/materialy/pasek.png"));
            cloud1 = ImageIO.read(Images.class.getResource("/materialy/chmurka1.png"));
            cloud2 = ImageIO.read(Images.class.getResource("/materialy/chmurka2.png"));
            cloud3 = ImageIO.read(Images.class.getResource("/materialy/chmurka3.png"));
            cloudOnPause = ImageIO.read(Images.class.getResource("/materialy/pauza.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBackgroundForLevel(int level) {
        switch (level) {
            case 1:
                usedBackgroundImage = background1;
            case 2:
                usedBackgroundImage = backgroud2;
            case 3:
                usedBackgroundImage = background3;
            default:
                usedBackgroundImage = background1;
        }
    }
}
