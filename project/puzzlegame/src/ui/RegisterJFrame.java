package ui;

import cn.hutool.core.io.FileUtil;
import domain.User;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class RegisterJFrame extends JFrame implements MouseListener {

    ArrayList<User> allUsers = new ArrayList<>();


    JButton reset = new JButton();
    JButton register = new JButton();

    JTextField username = new JTextField();

    JPasswordField password1 = new JPasswordField();

    JPasswordField password2=new JPasswordField();
    JTextField code = new JTextField();
    //正确的验证码
    JLabel rightCode = new JLabel();

    //图片路径
    String pathRegisterUserNameText = "image/register/注册用户名.png";
    String pathRegisterPasswordText = "image/register/注册密码.png";
    String pathAgainPasswordText = "image/register/再次输入密码.png";
    String pathBackground = "image\\login\\background.png";

    String pathRegister = "image\\login\\注册按钮.png";
    String pathRegisterPressed="image/login/注册按下.png";
    String pathReset = "image/register/重置按钮.png";

    String pathResetPressed="image/register/重置按下.png";

    //注册界面
    public RegisterJFrame(ArrayList<User> allUsers){
        this.allUsers=allUsers;
        //初始化界面
        initJFrame();
        //初始化菜单
        initView();
        //让界面显示在屏幕上
        this.setVisible(true);
    }

    void initJFrame(){
        this.setSize(488,430);
        //设置界面的标题
        this.setTitle("拼图 注册");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //取消默认的居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setLayout(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //让显示显示出来，建议写在最后
    }

    void initView(){
        //1. 添加用户注册名文字
        JLabel usernameText=new JLabel(new ImageIcon(pathRegisterUserNameText));
        usernameText.setBounds(100, 135, 80, 17);
        this.getContentPane().add(usernameText);
        //2.添加用户名注册输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加注册密码文字
        JLabel passwordText = new JLabel(new ImageIcon(pathRegisterPasswordText));
        passwordText.setBounds(105, 195, 80, 16);
        this.getContentPane().add(passwordText);
        //4.注册密码输入框
        password1.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password1);

        //5.添加再次输入密码文字
        JLabel codeText = new JLabel(new ImageIcon(pathAgainPasswordText));
        codeText.setBounds(70, 256, 120, 30);
        this.getContentPane().add(codeText);
        //6.再次输入密码输入框
        password2.setBounds(195, 256, 200, 30);
        this.getContentPane().add(password2);

        //7.添加注册按钮
        register.setBounds(100, 310, 128, 47);
        register.setIcon(new ImageIcon(pathRegister));
        //去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        //给登录按钮绑定鼠标事件
        register.addMouseListener(this);
        this.getContentPane().add(register);

        //8.添加重置按钮
        reset.setBounds(256, 310, 128, 47);
        reset.setIcon(new ImageIcon(pathReset));
        //去除按钮的边框
        reset.setBorderPainted(false);
        //去除按钮的背景
        reset.setContentAreaFilled(false);
        //给注册按钮绑定鼠标事件
        reset.addMouseListener(this);
        this.getContentPane().add(reset);

        //添加背景图片
        ImageIcon icon11=new ImageIcon(pathBackground);
        JLabel jLabel1=new JLabel(icon11);
        jLabel1.setBounds(0, 0, 470, 390);
        this.getContentPane().add(jLabel1);
    }

    public void showJDialog(String str) {

        //创建一个弹窗对象
        JDialog jDialog=new JDialog();
        //设置弹框大小
        jDialog.setSize(200,150);
        //建立文本
        JLabel warning = new JLabel(str);
        //设置文本位置
        warning.setBounds(200, 0, 200, 150);
        //管理文字添加到弹框当中
        jDialog.getContentPane().add(warning);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭则无法操作下面的界面
        jDialog.setModal(true);
        //取消默认的居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setLayout(null);
        //让弹框显示出来
        jDialog.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==register){
            System.out.println("点击注册按钮");
            //获取两个文本输入框中的内容
            String userName=username.getText();
            String userPassword=password1.getText();
            String useAgainPassword=password2.getText();

            if(userName.length()==0 || userPassword.length()==0 ||useAgainPassword.length()==0) {
                showJDialog("用户名或者密码不能为空");
            } else if(!userPassword.equals(useAgainPassword)) {
                showJDialog("密码不一致");
            }  else if(!userName.matches("[a-zA-Z0=9]{4,16}")){
                showJDialog("用户名不符号规则");
            } else if(userPassword.matches("\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[a-z])\\S*")){
                showJDialog("密码不符合规则，至少包含1个小写字母，一个数字，长度至少6位");
            } else if (containsUsername(userName)) {
                showJDialog("用户名已经存在，请重新输入" );
            } else if (userPassword.equals(useAgainPassword)) {
                //创建一个User对象
                User userInfo=new User(userName,userPassword);
                allUsers.add(userInfo);
                System.out.println("用户名和密码正确！");
                //写入文件
                FileUtil.writeLines(allUsers,"D:\\CodeApp\\Idea\\java\\puzzlegame\\src\\userInfo.txt","UTF-8");
                this.setVisible(false); //关闭当前登录界面
                //打开游戏的主界面
                //需要把当前登录的用户名传递给游戏界面
                new GameJFrame();
            }
        }else if(e.getSource()==reset){
            this.setVisible(false);
            new RegisterJFrame(allUsers);
            for (int i = 0; i <this.allUsers.size() ; i++) {
                System.out.println(this.allUsers.get(i));
            }
        }
    }

   public boolean containsUsername(String username){
       for (int i=0;i<allUsers.size();i++)
       {
           User user=allUsers.get(i);
           if(user.getUsername().equals(username) ){
              return true;
           }
       }
       return false;
   }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource()==register){
            register.setIcon(new ImageIcon(pathRegisterPressed));
        }   else if(e.getSource()==reset){
            reset.setIcon(new ImageIcon(pathResetPressed));
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
