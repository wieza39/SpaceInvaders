import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class Player extends Images {

    public int x_axis = 400;
    public int y_axis = 650;
    public int player_height = 50;
    public int player_width = 50;
  //  boolean tangoDown = false;


    public void position(int pos_x, int pos_y){
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
 //       super.getImage("/Users/wieza/Desktop/Uczelnia/POJ/Projekt/src/ship.png");
    }

    public void drawPlayer(Graphics g) {
/*        Graphics2D player = (Graphics2D) g;
        Rectangle2D.Double player_ship = new Rectangle2D.Double(x_axis, y_axis, player_width, player_height);
        player.setColor(Color.yellow);
        player.fill(player_ship);*/
        g.drawImage(Toolkit.getDefaultToolkit().getImage("/Users/wieza/Desktop/Uczelnia/POJ/Projekt/src/ship.png"), x_axis, y_axis, player_width, player_height, null);

    }

/*    public boolean isHit(int x, int y) {
        if(x >= x_axis && x <= x_axis + player_width) {
            if(y <= y_axis){
                System.out.println("trafilo Cie");
                return true;
            }
        }
        return false;
    }*/
}

