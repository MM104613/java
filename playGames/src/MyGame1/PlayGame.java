package MyGame1;

import Utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class PlayGame extends JFrame {
    Image plane = GameUtils.getImage("images/plane.png");
    Image bg = GameUtils.getImage("images/bg.jpg");
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bg,0,0,null);
        g.drawImage(plane,250,250,null);

    }

    //初始化窗口大小
    public void windowsFrame(){
        this.setTitle("雷霆战机");
        this.setVisible(true);//设置窗口大小
        this.setSize(500,500);//设置窗口位置
        this.setLocation(700,300);
        //匿名内部类，关闭窗口
        this.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e){
              System.exit(0);
          }
        });
    }

    public static void main(String[] args) {
        PlayGame  playGame = new PlayGame();
        playGame.windowsFrame();
    }

}