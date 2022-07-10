import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Images {

    BufferedImage icon;
    public void getImage(String path) throws IOException {
        try{
            icon = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
