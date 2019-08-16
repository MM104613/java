package MyGame1;

import GameObject.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
    boolean up,down,left,right;
    boolean planeLive = true;
    public  void drawSelf(Graphics g){
        if(planeLive){
            g.drawImage(img,(int)x,(int)y,null);
            if(up){
                y -=speed;
            }
            if(down){
                y += speed;
            }
            if(left){
                x -= speed;
            }
            if(right){
                x += speed;
            }
        }

    }

    public Plane(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = 15;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }
    //方向增加
    public void addDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }
    }
        //方向减少
        public void descDirection(KeyEvent e){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    up = false;
                    break;
                case KeyEvent.VK_DOWN:
                    down = false;
                    break;
                case KeyEvent.VK_LEFT:
                    left = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = false;
                    break;

            }
        }

    }

