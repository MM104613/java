package Bullet;

import GameObject.GameObject;
import Utils.Constant;

import java.awt.*;

public class Bullet extends GameObject {
    double degree;

    public Bullet(){
        x = 300;
        y = 300;
        width = 20;
        height = 20;
        speed = 6;
        //产生一个0-2π之间的随机数
        degree = Math.random()*Math.PI*2;
    }
    public void drawBullet(Graphics g){
        Color colorOld = g.getColor();
        g.setColor(Color.BLUE);
        g.fillOval((int)x,(int)y,width,height);

        //子弹沿任意角度飞
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);

        if(x<10 || x >Constant.WINDOWS_WIDTH-width-10){
        degree = Math.PI - degree;
        }
        if(y<40 || y >Constant.WINDOWS_HEIGHT-height-10){
            degree = -degree;
        }

        g.setColor(colorOld);
    }
}
