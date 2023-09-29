package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener{

    //创建一个按钮对象
    JButton jButton1=new JButton("点一下");
    //创建一个按钮对象
    JButton jButton2=new JButton("再点一下");
    public MyJFrame(){

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
        //对按钮添加动作监听
        jButton1.addActionListener(this);


        //设置一个按钮宽高
        jButton2.setBounds(100,0,100,50);
        //对按钮添加动作监听
        jButton2.addActionListener(this);




        //把按钮添加到界面中
        this.getContentPane().add(jButton1);
        this.getContentPane().add(jButton2);

        //让界面显示在屏幕上
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //对当前的按钮进行判断

        //获取当前被操作的那个按钮对象
        Object source=e.getSource();
        if(source==jButton1){
            jButton1.setSize(200,200);
        }   else if(source==jButton2){
            Random r=new Random();
            jButton2.setLocation(r.nextInt(500),r.nextInt(500));

        }
    }
}

