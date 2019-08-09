package GameObject;

import java.awt.*;

//战机的父类
public class GameObject {
   public Image img;//图片
   public double x,y;//坐标
   public int speed; //速度
   public int width,height; //物体宽高

   public  void drawSelf(Graphics g){
       g.drawImage(img,(int)x,(int)y,null);
       y--;
   }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;

    }

    public GameObject() {
    }

    public Rectangle getRect(){

       return new Rectangle((int)x,(int)y,width,height);
    }
}
