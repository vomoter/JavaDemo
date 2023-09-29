package ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Good extends JFrame implements MouseListener {
    //创建一个按钮对象
    JButton jButton1=new JButton("点一下");
    public Good(){

        //设置界面的宽高
        this.setSize(344,344);
        //设置界面的标题
        this.setTitle("游戏说明");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
        //创建弹窗
        JDialog jDialog=new JDialog();
        //创建文本对象
        JLabel jLabel=new JLabel("按’1'可通关游戏");

        jDialog.getContentPane().add(jLabel);
        //设置弹框大小
        jDialog.setSize(344,344);
        //设置弹窗标题
        jDialog.setTitle("游戏说明");
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭则无法操作下面的界面
        jDialog.setModal(true);
        //让弹框显示出来
        jDialog.setVisible(true);
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
            jButton1.setLocation(r.nextInt(200),r.nextInt(200));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}

