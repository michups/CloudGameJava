package cloud_game;

/**
 *
 * @author Mich
 */
public class GameData {

    /**
     * counted clicks after 0.5s
     */
    int countedClicks = 0;
    /**
     * Current clicks, resetting after every 0.5s
     */
    int currentClickingTime = 0;
    int level = 1;
    int points = 0;
    int destroyedClouds = 0;
    int fallingCloudLevel = 0;
    /**
     * set the time by the clicks will be counted
     */
    long nextHalfSecond = System.currentTimeMillis() + 500;
    /**
     * Clicking time while halfsecond period before
     */
    long lastClickingTime = 0;
    /**
     * counted last play time
     */
    long lastPlayTime = System.currentTimeMillis();
    long playTime = 0;
    long clickingTime = 0;
    long currentTime;

    boolean pause = false;
    boolean endGame = false;
    boolean saveScore = false;
    boolean exit = false;

    boolean rightSpeed;
    boolean toFast;
    boolean toSlow;

    public boolean whilePlay() {
        return (pause == false && endGame == false);
    }

    public void fallingPanalty() {
        if (fallingCloudLevel >= 10) {
            fallingCloudLevel = 0;
            points--;
        }
    }

    public void addPointsForDestroyedCloud() {
        switch (this.level) {
            case 1:
                points = points + 10;
                break;
            case 2:
                points = points + 15;
                break;
            case 3:
                points = points + 20;
                break;

        }
    }

    private void SetToFastSpeed() {

        rightSpeed = false;
        toFast = true;
        toSlow = false;
    }

    private void SetToSlowSpeed() {

        rightSpeed = false;
        toFast = false;
        toSlow = true;
    }

    private void SetRightSpeed() {

        rightSpeed = true;
        toFast = false;
        toSlow = false;
    }

    public void changeLevel() {
        if (destroyedClouds > 2) {
            level = 1;
        }

        if (destroyedClouds > 5) {
            level = 2;
        }

        if (destroyedClouds > 7) {
            level = 3;
        }

    }

    public boolean checkRightClickingSpeed(int cloudPositionY, int cloudType) {
        if (cloudType == 1) {
            if (countedClicks <= 1 & countedClicks > 0) {
                SetRightSpeed();
                return false;
            }
            if ((countedClicks > 1 || countedClicks <= 0) & cloudPositionY < 700) {

                if (countedClicks > 1) {
                    SetToFastSpeed();
                } else {
                    SetToSlowSpeed();
                }

                if (points > 0) {
                    fallingCloudLevel++;
                }
                return true;
            }
        }

        if (cloudType == 2) {
            if (countedClicks <= 3 & countedClicks > 1) {
                SetRightSpeed();
                return false;
            }
            if ((countedClicks > 3 || countedClicks <= 1) & cloudPositionY < 700) {
                if (points > 0) {
                    fallingCloudLevel++;
                }
                if (countedClicks > 3) {
                    SetToFastSpeed();
                } else {
                    SetToSlowSpeed();
                }
                return true;
            }
        }
        if (cloudType == 3) {

            if (countedClicks <= 5 & countedClicks > 3) {
                SetRightSpeed();
                return false;
            }

            if ((countedClicks > 5 || countedClicks <= 3) & cloudPositionY < 700) {
                if (points > 0) {
                    fallingCloudLevel++;
                }
                if (countedClicks > 5) {
                    SetToFastSpeed();
                } else {
                    SetToSlowSpeed();
                }
                return true;
            }
        }
        return true;
    }

    public void checkGameOver(int cloudPosY) {
        if (cloudPosY > 550) {
            endGame = true;
            pause = true;
        }
    }

    public void checkIfWinGame() {
        if (destroyedClouds >= 9 && level == 3) {
            endGame = true;
            pause = true;
        }
    }

    public GameData() {

    }
}
