package cloud_game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for saving scores
 *
 * @author Michal
 */
public class Saver {

    public int points;
    public long gameTime;
    public long clickingTime;
    String name = "Adam";

    /**
     * Setter of game data
     *
     * @param pointsInput gained points
     * @param gameTimeInput play time
     * @param clickingTimeInput clicking time
     */
    public void setGameData(int pointsInput, long gameTimeInput, long clickingTimeInput) {
        points = pointsInput;
        gameTime = gameTimeInput;
        clickingTime = clickingTimeInput;

    }

    /**
     * method saving the score to the text file scores.txt save in order: play
     * time, clicking time, name, date, points
     *
     */
    public void saveScore() {

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scores.txt", true)))) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd;HH:mm:ss");
            Date date = new Date();
            out.println(gameTime / 1000 + ";" + clickingTime / 1000 + ";" + name + ";" + dateFormat.format(date) + ";" + points + ";");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * method which resets name, game time and clicking time
     */
    public void setDefoultGameData() {
        name = "Adam";
        gameTime = 0;
        clickingTime = 0;
    }
}
