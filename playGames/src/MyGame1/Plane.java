package MyGame1;

import GameObject.GameObject;
import Utils.Constant;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
    boolean up,down,left,right;
    boolean planeLive = true;
    public  void drawSelf(Graphics g){
        if(planeLive){
            g.drawImage(img,(int)x,(int)y,null);
            if(up){
                if (y>40){
                    y -=speed;
                }
            }
            if(down){
                if (y <Constant.WINDOWS_HEIGHT-height-10){
                    y += speed;
                }
            }
            if(left){
                if (x>20){
                    x -= speed;
                }
            }
            if(right){
                if ( x < Constant.WINDOWS_WIDTH-width-10){
                    x += speed;
                }
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

