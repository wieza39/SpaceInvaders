import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Alien extends Images {

    int x_axis = 0;
    int y_axis = 0;
    public int alien_height = 40;
    public int alien_width = 40;
    boolean alienStatus = true;
    boolean shotStatus = true;

    public void position(int pos_x, int pos_y) {
        x_axis = pos_x;
        y_axis = pos_y;
    }

    public int current_x() {
        return x_axis;
    }

    public int current_y() {
        return y_axis;
    }

    @Override
    public void getImage(String path) throws IOException {
        super.getImage("/Users/wieza/Desktop/Uczelnia/POJ/Projekt/src/images.png");
    }

    public void drawAlien(Graphics g) {

/*            Graphics2D alien = (Graphics2D) g;
            Rectangle2D.Double alien_ship = new Rectangle2D.Double(x_axis, y_axis, alien_width, alien_height);
            if(alienStatus) {
                alien.setColor(Color.red);
            }else{
                alien_width = 0;
                alien_height = 0;
      //          alien.setColor(Color.DARK_GRAY);
            }
            alien.fill(alien_ship);*/
        if (alienStatus) {
            g.drawImage(Toolkit.getDefaultToolkit().getImage("/Users/wieza/Desktop/Uczelnia/POJ/Projekt/src/alien.png"), x_axis, y_axis, alien_width, alien_height, null);
        }else {
            alien_width = 0;
            alien_height = 0;
        }
    }

    public boolean isAlive() {
        return alienStatus;
    }

    public boolean isShooting() {
        return shotStatus;
    }


}