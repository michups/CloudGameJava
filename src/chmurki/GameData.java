package chmurki;

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

    public boolean whilePlay() {
        return (pause == false && endGame == false);
    }

    public void fallingPanalty() {
        if (fallingCloudLevel >= 10) {
            fallingCloudLevel = 0;
            points--;
        }
    }

    public boolean checkRightClickingSpeed(int cloudPositionY, int cloudType) {
        if (cloudType == 1) {

            if (countedClicks <= 1 & countedClicks > 0) {
                return false;
            }

            if ((countedClicks > 1 || countedClicks <= 0) & cloudPositionY < 700) {

                if (points > 0) {
                    fallingCloudLevel++;
                }
                return true;
            }
        }

        if (cloudType == 2) {
            if (countedClicks <= 3 & countedClicks > 1) {
                return false;
            }
            if ((countedClicks > 3 || countedClicks <= 1) & cloudPositionY < 700) {
                if (points > 0) {
                    fallingCloudLevel++;
                }
                return true;
            }
        }
        if (cloudType == 3) {
            if (countedClicks <= 5 & countedClicks > 3) {
                return false;
            }

            if ((countedClicks > 5 || countedClicks <= 3) & cloudPositionY < 700) {
                if (points > 0) {
                    fallingCloudLevel++;
                }
                return true;
            }
        }
        return true;
    }

    public void gameOver(int cloudPosY) {
        if (cloudPosY > 550) {
            endGame = true;
            pause = true;
        }
    }

    public void checkIfWinGame() {
        if (destroyedClouds >= 60) {
            endGame = true;
            pause = true;
        }
    }

    public GameData() {

    }
}
