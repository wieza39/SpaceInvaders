import java.awt.*;
import java.awt.geom.Rectangle2D;

public class AlienLaser {

    Player player = new Player();
 //   Fleet fleet = new Fleet();
    Alien alien = new Alien();

    int shot_x = 0;
    int shot_y = 0;

    public void position(int pos_x, int pos_y){
        shot_x = pos_x;
        shot_y = pos_y;
    }

    public int current_x() {
        return shot_x ;
    }

    public int current_y() {
        shot_y = player.y_axis;
        return shot_y;
    }

    public void drawAlienLaser(Graphics g) {
        Graphics2D laser = (Graphics2D) g;
        Rectangle2D.Double laser_alien = new Rectangle2D.Double(shot_x, shot_y, 5, 10);
        laser.setColor(Color.black);
        laser.fill(laser_alien);
    }


/*   public void shotMove(int x, int y){
        if(player.isHit(x, y)){
            alien.shotStatus = false;
        }
        y += 10;
        if(y > 700){
            alien.shotStatus = false;
        }
    }*/

}

