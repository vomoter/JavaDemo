package test;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3() {
        //设置界面的宽高
        this.setSize(600,680);
        //设置界面的标题
        this.setTitle("事件演示");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的集中放置，只有取消了才会按照xy轴的形式添加图片
        this.setLayout(null);

        //给扎=整个窗体添加键盘监听
        //调用者this:本类对象，当前的界面对象，表示我要给整个界面添加监听
        //参数addKeyListener:表示给本界面添加键盘监听
        //参数this:当事件被触发之后，会执行本类中的对应代码
        this.addKeyListener(this);


        //让界面显示出来
        this.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按住不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
    }
}
