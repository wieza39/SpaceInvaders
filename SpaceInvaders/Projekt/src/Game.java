import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class Game extends JPanel {

    Fleet fleet = new Fleet();
    Player player = new Player();
    Laser laser = new Laser();
    AlienLaser alienLaser = new AlienLaser();

    Font fontScore = new Font ("Monospaced Plain", 1, 20);
    Font fontEnd = new Font ("Monospaced Plain", 1, 40);

    static boolean goRight = false;
    static boolean goLeft = false;
    static boolean laserShot = false;
    int window_width = 900;


    public Game() {
		setPreferredSize(new Dimension(900,700));
        final JFrame window = new JFrame();
		window.setTitle("Space Invaders");
		window.setBackground(Color.DARK_GRAY);
    //    window.setContentPane(new JLabel(new ImageIcon("/Users/wieza/Desktop/Uczelnia/POJ/Projekt/src/background.png")));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
        window.setResizable(false);
		window.pack();
		window.setVisible(true);
        fleet.setlayout();
        window.addKeyListener(new Listener());
        Timer timerClock = new Timer(5, e -> {
            //ruch player'a w prawo
            if (goRight){
                if(player.current_x() != window_width - 100) {
                    player.position(player.x_axis += 10, player.y_axis);
                    if(!laserShot) {
                        laser.position(laser.shot_x += 10, player.y_axis);
                    }
                }else {
                    player.position(player.x_axis, player.y_axis);
                }
            }
            //ruch player'a w lewo
            if (goLeft){
                if(player.current_x() != window_width - 850) {
                    player.position(player.x_axis -= 10, player.y_axis);
                    if(!laserShot) {
                        laser.position(laser.shot_x -= 10, player.y_axis);
                    }
                }else {
                    player.position(player.x_axis, player.y_axis);
                }
            }
            //strzal player'a
            if (laserShot) {
                fleet.checkPlayerShot(laser.shot_x, laser.shot_y);
                laser.shotMove(player.x_axis);
            }
    //      fleet.attack();
            fleet.moveFleet();
            repaint();
        });
        timerClock.start();
    }

    public void paintComponent(Graphics g) {
        if(!fleet.displayEnd) {
            g.clearRect(0, 0, 900, 700);
            fleet.drawFleet(g);
            player.drawPlayer(g);
            alienLaser.drawAlienLaser(g);
            laser.drawLaser(g);
            g.setFont(fontScore);
            g.drawString("SCORE: " + fleet.score, 50, 30);
        }else {
            g.setFont(fontEnd);
            g.drawString("KONIEC GRY", 350, 320);
            g.drawString("wynik: " + fleet.score, 360, 360);
        }
    }

    static class Listener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT){
                goRight = true;
            }else if (key == KeyEvent.VK_LEFT) {
                goLeft = true;
            }else if (key == KeyEvent.VK_SPACE) {
                laserShot = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT){
                goRight = false;
            }
            if (key == KeyEvent.VK_LEFT) {
                goLeft = false;
            }
        }
    }

    public static void main(String[] args) {

        var game = new Game();
    }


}
