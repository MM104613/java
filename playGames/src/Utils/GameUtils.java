package Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
//工具类
public class GameUtils {
    private  GameUtils(){
    }
    //指定图片路径对象
    public static Image getImage(String path){
        BufferedImage bufferedImage = null;
        try {
            URL url = GameUtils.class.getClassLoader().getResource(path);
            bufferedImage = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }
}
