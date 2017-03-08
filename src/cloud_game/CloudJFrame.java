package cloud_game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

/**
 * Main class
 *
 * @author Michal
 * @version 1.00
 */
public class CloudJFrame extends JFrame {

    Images images = new Images();
    private Timer timer;
    GameData gameData = new GameData();
    Saver saver = new Saver();
    MusicPlayer musicPlayer = new MusicPlayer();
    Cloud cloud = new Cloud(1);

    
    
    CloudJFrame() {
        super("CHMURKI");
        setBounds(50, 50, 1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        createBufferStrategy(2);

        timer = new Timer();
        timer.scheduleAtFixedRate(new Task(), 0, 20);

        /**
         * Keylistener only active on saving score page
         */
        this.addKeyListener(new KeyListener() {

            public void keyPressed(KeyEvent e) {
                if (gameData.endGame == true & gameData.saveScore == true) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_Q:
                            saver.name = saver.name + "Q";
                            break;
                        case KeyEvent.VK_W:
                            saver.name = saver.name + "W";
                            break;
                        case KeyEvent.VK_E:
                            saver.name = saver.name + "E";
                            break;
                        case KeyEvent.VK_R:
                            saver.name = saver.name + "R";
                            break;
                        case KeyEvent.VK_T:
                            saver.name = saver.name + "T";
                            break;
                        case KeyEvent.VK_Y:
                            saver.name = saver.name + "Y";
                            break;
                        case KeyEvent.VK_U:
                            saver.name = saver.name + "U";
                            break;
                        case KeyEvent.VK_I:
                            saver.name = saver.name + "I";
                            break;
                        case KeyEvent.VK_O:
                            saver.name = saver.name + "O";
                            break;
                        case KeyEvent.VK_P:
                            saver.name = saver.name + "P";
                            break;
                        case KeyEvent.VK_A:
                            saver.name = saver.name + "A";
                            break;
                        case KeyEvent.VK_S:
                            saver.name = saver.name + "S";
                            break;
                        case KeyEvent.VK_D:
                            saver.name = saver.name + "D";
                            break;
                        case KeyEvent.VK_F:
                            saver.name = saver.name + "F";
                            break;
                        case KeyEvent.VK_G:
                            saver.name = saver.name + "G";
                            break;
                        case KeyEvent.VK_H:
                            saver.name = saver.name + "H";
                            break;
                        case KeyEvent.VK_J:
                            saver.name = saver.name + "J";
                            break;
                        case KeyEvent.VK_K:
                            saver.name = saver.name + "K";
                            break;
                        case KeyEvent.VK_L:
                            saver.name = saver.name + "L";
                            break;
                        case KeyEvent.VK_Z:
                            saver.name = saver.name + "Z";
                            break;
                        case KeyEvent.VK_X:
                            saver.name = saver.name + "X";
                            break;
                        case KeyEvent.VK_C:
                            saver.name = saver.name + "C";
                            break;
                        case KeyEvent.VK_V:
                            saver.name = saver.name + "V";
                            break;
                        case KeyEvent.VK_B:
                            saver.name = saver.name + "B";
                            break;
                        case KeyEvent.VK_N:
                            saver.name = saver.name + "N";
                            break;
                        case KeyEvent.VK_M:
                            saver.name = saver.name + "M";
                            break;
                        case KeyEvent.VK_ENTER:
                            gameData.saveScore = false;
                            saver.saveScore();
                            saver.setDefoultGameData();
                            musicPlayer.playSound(1);
                            break;
                        case KeyEvent.VK_BACK_SPACE:
                            if (saver.name.length() > 0) {
                                saver.name = saver.name.substring(0, saver.name.length() - 1);
                            }
                            break;
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        }
        );

        this.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                //counting clicks
                if (gameData.whilePlay()) {
                    gameData.currentClickingTime++;
                }
                //pause
                if (e.getX() < 880 & e.getX() > 770 & e.getY() > 35 & e.getY() < 85 & gameData.whilePlay()) {
                    gameData.currentClickingTime--;
                    gameData.pause = true;
                    musicPlayer.playSound(1);
                }

                //resume game
                if (e.getX() < 580 & e.getX() > 400 & e.getY() > 200 & e.getY() < 260 & gameData.endGame == false & gameData.pause == true) {
                    gameData.pause = false;
                    musicPlayer.playSound(1);
                }
                //saving manu
                if (e.getX() < 570 & e.getX() > 260 & e.getY() > 390 & e.getY() < 432 & gameData.endGame == true) {
                    gameData.saveScore = true;
                    saver.setGameData(gameData.points, gameData.playTime, gameData.clickingTime);
                    musicPlayer.playSound(1);
                } else //save score
                if (e.getX() < 510 & e.getX() > 350 & e.getY() > 465 & e.getY() < 510 & gameData.endGame == true & gameData.saveScore == true) {
                    gameData.saveScore = false;
                    saver.saveScore();
                    saver.setDefoultGameData();
                    musicPlayer.playSound(1);
                } else //end program
                if (e.getX() < 447 & e.getX() > 299 & e.getY() > 470 & e.getY() < 510 & gameData.endGame == true & gameData.saveScore == false) {
                    System.exit(0);
                } else //new game
                if ((e.getX() < 701 & e.getX() > 476 & e.getY() > 470 & e.getY() < 510 & gameData.endGame == true & gameData.saveScore == false) || (e.getX() < 627 & e.getX() > 403 & e.getY() > 320 & e.getY() < 360 & gameData.pause == true)) {
                    gameData.clickingTime = 0;
                    gameData.playTime = 0;
                    gameData.lastPlayTime = System.currentTimeMillis();
                    gameData.level = 1;
                    cloud.setTypeOfCloud(1);
                    gameData.points = 0;
                    gameData.destroyedClouds = 0;
                    gameData.endGame = false;
                    gameData.pause = false;
                    cloud.setNewHighForLevel(gameData.level);
                    musicPlayer.playSound(1);
                }

                //end of game
                if (e.getX() < 600 & e.getX() > 400 & e.getY() > 410 & e.getY() < 460 & gameData.pause == true & gameData.endGame == false) {
                    gameData.endGame = true;
                    musicPlayer.playSound(1);
                }
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        }
        );
    }



    class Task extends TimerTask {

        public void updateClickingTime() {
            if (gameData.countedClicks != 0) {
                gameData.clickingTime = gameData.clickingTime + (gameData.currentTime - gameData.lastClickingTime);
                gameData.lastClickingTime = gameData.currentTime;
            } else {
                gameData.lastClickingTime = gameData.currentTime;
            }

        }

        public void updatePlayTime() {

            if (gameData.whilePlay()) {
                gameData.playTime = gameData.playTime + (gameData.currentTime - gameData.lastPlayTime);
                gameData.lastPlayTime = gameData.currentTime;
            } else {
                gameData.lastPlayTime = gameData.currentTime;
            }

        }

        public void updateCountedClicks() {
            if (gameData.currentTime > gameData.nextHalfSecond) {
                gameData.nextHalfSecond += 500;
                gameData.countedClicks = gameData.currentClickingTime;
                gameData.currentClickingTime = 0;
            }
        }

        public void run() {

            if (gameData.whilePlay()) {

                gameData.fallingPanalty();

                if (gameData.checkRightClickingSpeed(cloud.getPositionY(), cloud.getCloudType())) {
                    cloud.increasePosY();
                } else {
                    cloud.decreasePosY();
                }

            }
            gameData.checkGameOver(cloud.getPositionY());

            images.setBackgroundForLevel(gameData.level);

            gameData.checkIfWinGame();

            images.setCloudImage(cloud.getCloudType());

            if (cloud.getPositionY() < 150) {
                gameData.destroyedClouds++;
                musicPlayer.playSound(2);
                gameData.changeLevel();
                // cloud.setTypeOfCloud(gameData.level);
                cloud = new Cloud(gameData.level);

                gameData.addPointsForDestroyedCloud();
                cloud.setNewHighForLevel(gameData.level);
            }

            gameData.currentTime = System.currentTimeMillis();
            updateClickingTime();

            updatePlayTime();
            updateCountedClicks();
            repaint();
        }
    }
    
    public void paint(Graphics g) {
        try {
            BufferStrategy bstrategy = this.getBufferStrategy();
            Graphics2D g2d = (Graphics2D) bstrategy.getDrawGraphics();

            g2d.drawImage(images.usedBackgroundImage, 0, 0, null);
            g2d.drawImage(images.windmill, 300, 640, null);
            g2d.drawImage(images.spinePipe, 0, 140, null);
            g2d.drawImage(images.label, 0, 0, null);
            g2d.drawImage(images.menu, 700, 0, null);
            g2d.drawImage(images.instructions, 20, 200, null);
            g2d.drawImage(images.cloudOnPause, -20, 80, 250, 50, null);
            g2d.setColor(Color.DARK_GRAY);
            g2d.setFont(new Font("Arial", Font.BOLD, 20));
            if (gameData.toFast || gameData.toSlow) {
                g2d.drawImage(images.toFastToSlowCloud, 700, 200, null);
            } else {
                g2d.drawImage(images.OkCloud, 700, 200, null);
            }

            try {
                g2d.drawString("Czas: " + gameData.playTime / 1000 + "s", 50, 55);
                g2d.drawString("Czas klikania: " + gameData.clickingTime / 1000 + "s", 170, 55);
                g2d.drawString("Punkty: " + gameData.points, 380, 55);
                g2d.drawString("Poziom " + gameData.level, 50, 110);
                g2d.drawString("Zniszczone chmurki: " + gameData.destroyedClouds, 500, 55);
                g2d.drawString("KLIKAJ LPM W OKNO!!!", 60, 300);
                if (gameData.rightSpeed) {
                    g2d.drawString("Tak trzymaj!", 800, 300);
                } else if (gameData.toFast) {
                    g2d.drawString("Za szybko!", 800, 300);
                } else if (gameData.toSlow) {
                    g2d.drawString("Za wolno!", 800, 300);
                }
            } catch (Exception e) {
                g2d.drawString("Czas: " + 0 / 1000 + "s", 50, 55);
                g2d.drawString("Czas klikania: " + 0 / 1000 + "s", 200, 55);
                g2d.drawString("Punkty: " + 0, 500, 55);
            }

            g2d.drawImage(images.usedCloud, cloud.getPositionX(), cloud.getPositionY(), null);

            if (gameData.pause == true) {
                g2d.drawImage(images.cloudOnPause, 150, 100, null);
                g2d.setFont(new Font("Arial", Font.BOLD, 50));
                g2d.drawString("Wznów", 400, 256);
                g2d.drawString("Nowa gra", 400, 356);
                g2d.drawString("Zakoncz", 400, 456);
            }

            if (gameData.endGame == true) {
                g2d.drawImage(images.cloudOnPause, 50, 100, null);
                g2d.drawImage(images.cloudOnPause, 250, 100, null);
                g2d.setFont(new Font("Arial", Font.BOLD, 50));
                g2d.drawString("Punkty: " + gameData.points, 250, 220);
                g2d.drawString("Czas klikania: " + gameData.clickingTime / 1000 + "s", 250, 290);
                g2d.drawString("Czas gry: " + gameData.playTime / 1000 + "s", 250, 360);

                if (gameData.saveScore == false) {
                    g2d.drawString("Wyjdz  Nowa gra", 300, 506);
                    g2d.drawString("Zapisz wynik ", 250, 430);
                } else {
                    g2d.drawString("Wpisz imie:" + saver.name, 250, 430);
                    g2d.drawString("Zapisz ", 350, 500);
                }
            }
            g2d.setFont(new Font("Arial", Font.BOLD, 20));

            g2d.dispose();
            bstrategy.show();

        } catch (Exception e) {

            System.out.printf("Images are not loaded yet");
            //e.printStackTrace();
        }
    }

}
