package chmurki;

/**
 * class which return the position of cloud
 *
 * @author Michal
 */
public class Cloud {

    private int positionX = 380;
    private int positionY = 230;
    private int cloudType = 1;

    /**
     * method set the position of clodu and type dependenc on level
     *
     * @param level number from 1 to 3
     */
    public void setNewHighForLevel(int level) {

        if (cloudType == 3 & level == 3) {
            positionY = (int) (100 * Math.random()) + 200;
        }

        if (cloudType == 2 & level == 3) {
            positionY = (int) (150 * Math.random()) + 200;
        }

        if (cloudType == 1 & level == 3) {
            positionY = (int) (200 * Math.random()) + 200;
        }

        if (cloudType == 2 & level == 2) {
            positionY = (int) (100 * Math.random()) + 200;
        }

        if (cloudType == 1 & level == 2) {
            positionY = (int) (150 * Math.random()) + 200;
        }

        if (cloudType == 1 & level == 1) {
            positionY = (int) (50 * Math.random()) + 200;
        }

    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void decreasePosY() {
        this.positionY--;
    }

    public void increasePosY() {
        this.positionY++;
    }

    public int getCloudType() {
        return cloudType;
    }

    /**
     * Method setting type of cloud
     *
     * @param level number from 1 to 3
     */
    public void setTypeOfCloud(int level) {

        if (level == 3) {
            cloudType = (int) (2 * Math.random() + 1);
        } else if (level == 2) {
            cloudType = (int) (2 * Math.random() + 1);
        } else {
            cloudType = 1;
        }
    }
}
