package cloud_game;

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
    public Image instructions;
    public Image OkCloud;
    public Image menu;
    public Image toFastToSlowCloud;

    /**
     * the constructor is loading images
     */
    public Images() {
        try {
            instructions = ImageIO.read(Images.class.getResource("/materials/chmurka_instrukcja.png"));
            OkCloud = ImageIO.read(Images.class.getResource("/materials/chmurka_ok.png"));
            toFastToSlowCloud = ImageIO.read(Images.class.getResource("/materials/chmurka_zle.png"));
            background1 = ImageIO.read(Images.class.getResource("/materials/tlo1.png"));
            menu = ImageIO.read(Images.class.getResource("/materials/menu.png"));
            backgroud2 = ImageIO.read(Images.class.getResource("/materials/tlo2.png"));
            background3 = ImageIO.read(Images.class.getResource("/materials/tlo3.png"));
            windmill = ImageIO.read(Images.class.getResource("/materials/wiatrak.png"));
            spinePipe = ImageIO.read(Images.class.getResource("/materials/prog.png"));
            label = ImageIO.read(Images.class.getResource("/materials/pasek.png"));
            cloud1 = ImageIO.read(Images.class.getResource("/materials/chmurka1.png"));
            cloud2 = ImageIO.read(Images.class.getResource("/materials/chmurka2.png"));
            cloud3 = ImageIO.read(Images.class.getResource("/materials/chmurka3.png"));
            cloudOnPause = ImageIO.read(Images.class.getResource("/materials/pauza.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCloudImage(int typeOfCloud) {
        switch (typeOfCloud) {
            case 1:
                usedCloud = cloud1;
                break;
            case 2:
                usedCloud = cloud2;
                break;
            case 3:
                usedCloud = cloud3;
                break;
            default:
                usedCloud = cloud1;
        }

    }

    public void setBackgroundForLevel(int level) {
        switch (level) {
            case 1:
                usedBackgroundImage = background1;
                break;
            case 2:
                usedBackgroundImage = backgroud2;
                break;
            case 3:
                usedBackgroundImage = background3;
                break;
            default:
                usedBackgroundImage = background1;
                break;
        }
    }
}
