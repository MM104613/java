package MyGame1;

import Bullet.Bullet;
import Explode.ExplodeBullets;
import Utils.Constant;
import Utils.GameUtils;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;


public class PlayGame extends Frame {
    private Image offScreenImage = null;

    //解决闪烁问题
    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(Constant.WINDOWS_WIDTH, Constant.WINDOWS_HEIGHT);
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    Image planeImg = GameUtils.getImage("images/plane.png");
    Image bg = GameUtils.getImage("images/bg2.png");
    Plane plane = new Plane(planeImg, 400, 700);
    Bullet bullet = new Bullet();
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    Date startTime = new Date();
    Date endTime;
    int period;//游戏持续时间

    ExplodeBullets explodeBullet;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color colorOld = g.getColor();
        g.drawImage(bg, 0, 0, null);
        plane.drawSelf(g);

        //画出一堆炮弹
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            bullet.drawBullet(g);
            //检测是否相撞
            boolean crash = bullets.get(i).getRect().intersects(plane.getRect());
            if(crash){
              plane.planeLive = false;
              if(explodeBullet == null){
                  explodeBullet = new ExplodeBullets(plane.x ,plane.y);
                  endTime = new Date();
                  period = (int)((endTime.getTime() - startTime.getTime() )/1000);
              }
              explodeBullet.draw(g);
            }
            if(! plane.planeLive){
                g.setColor(Color.WHITE);
                Font font = new Font("微软雅黑",Font.BOLD,40 );
                g.setFont(font);
                g.drawString("游戏结束:生存"+period+"秒",250,400);
            }
        }
        g.setColor(colorOld);
    }

    //键盘监听
    class keyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.descDirection(e);
        }
    }

    //反复重画窗口
    class paintThread extends Thread {
        public void run() {
            while (true) {
                repaint(); //重画
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //初始化窗口大小
    public void windowsFrame() {
        this.setTitle("雷霆战机");
        this.setVisible(true);
        this.setSize(Constant.WINDOWS_WIDTH, Constant.WINDOWS_HEIGHT);//设置窗口大小
        this.setLocation(600, 150);//设置窗口位置
        //匿名内部类，关闭窗口
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        new paintThread().start();
        addKeyListener(new keyMonitor()); //键盘监听启动

        //初始化子弹
        for (int i = 0; i < 30; i++) {
            Bullet bullet = new Bullet();
            bullets.add(bullet);
        }
    }

    public static void main(String[] args) {
        PlayGame playGame = new PlayGame();
        playGame.windowsFrame();

    }

}