package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test1 {
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        //设置界面的宽高
        jFrame.setSize(600,680);
        //设置界面的标题
        jFrame.setTitle("事件演示");
        //设置界面置顶
        jFrame.setAlwaysOnTop(true);
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的集中放置，只有取消了才会按照xy轴的形式添加图片
        jFrame.setLayout(null);

        //创建一个按钮对象
        JButton jButton=new JButton("点一下");
        //设置按钮宽高
        jButton.setBounds(0,0,100,50);
        //对按钮添加动作监听
        //jButton:组件对象，表示你要给哪一个组件添加事件
        //addActionListener:表示我要给事件添加动作监听(动作监听鼠标左键点击，或空格)
        //参数:表示事件被触发之后执行的代码
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被我点了");
            }
        });
        jButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code=e.getKeyCode();
                System.out.println((char)code);

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        //把按钮添加到界面中
        jFrame.getContentPane().add(jButton);

        //设置显示界面
        jFrame.setVisible(true);
    }
}
