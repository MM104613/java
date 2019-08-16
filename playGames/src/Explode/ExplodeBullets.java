package Explode;

import Utils.GameUtils;

import java.awt.*;

//子弹爆炸
public class ExplodeBullets {
    double x, y;
    static Image[] images = new Image[16];

    static {
        for (int i = 0; i < 16; i++) {
            images[i] = GameUtils.getImage("images/explodeBullet/e" + (i + 1) + ".gif");
            images[i].getWidth(null);
        }
    }

    int count;

    public void draw(Graphics g) {
        if (count <= 15) {
            g.drawImage(images[count], (int) x, (int) y, null);
            count++;
        }
    }

    public ExplodeBullets(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
