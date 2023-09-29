package test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MyJFrame2 extends JFrame implements MouseListener {
    //创建一个按钮对象
    JButton jButton1=new JButton("点一下");
    public MyJFrame2(){

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


        //设置一个按钮宽高
        jButton1.setBounds(0,0,100,50);
        //给按钮绑定鼠标事件
        jButton1.addMouseListener(this);

        //把按钮添加到界面中
        this.getContentPane().add(jButton1);

        //让界面显示在屏幕上
        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按住不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
        Object soure=e.getSource();
        if(soure==jButton1){
            Random r=new Random();
            jButton1.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
