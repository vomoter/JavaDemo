package ui;


import cn.hutool.core.io.FileUtil;
import domain.User;
import util.CodeUtil;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class LoginJFrame extends JFrame implements MouseListener {

    ArrayList<User> allUsers = new ArrayList<>();

    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();
    //正确的验证码
    JLabel rightCode = new JLabel();

    //图片路径
    String pathUsrNameText = "image\\login\\用户名.png";
    String pathPasswordText = "image\\login\\密码.png";
    String pathCodeText = "image\\login\\验证码.png";
    String pathBackground = "image\\login\\background.png";
    String pathLongin = "image\\login\\登录按钮.png";
    String pathLonginPressed="image/login/登录按下.png";
    String pathRegister = "image\\login\\注册按钮.png";
    String pathRegisterPressed="image/login/注册按下.png";


    //游戏登录界面
    public LoginJFrame() {
        //读取本地用户信息
        readUsersInfo();
        //初始化界面
        initJFrame();
        //初始化菜单
        initView();
        //让界面显示在屏幕上
        this.setVisible(true);
    }

    private void readUsersInfo() {
        //1.读取数据
        List<String> userInfo = FileUtil.readUtf8Lines("D:\\CodeApp\\Idea\\java\\puzzlegame\\src\\userInfo.txt");
        //2.遍历集合获取用户信息并创建Usr对象
        for (String str : userInfo) {
            //    username 张三 password 123
            String[] userInfoArr = str.split("&");
            String[] split1 = userInfoArr[0].split("=");
            String[] split2 = userInfoArr[1].split("=");

            User u = new User(split1[1], split2[1]);
            allUsers.add(u);
        }
        System.out.println(allUsers);
    }

    //判断用户在集合中是否存在
    private boolean contains(User userInfo) {
        for (int i = 0; i < allUsers.size(); i++) {
            User getUser = allUsers.get(i);
            if (userInfo.getUsername().equalsIgnoreCase(getUser.getUsername())
                    && userInfo.getPassword().equalsIgnoreCase(getUser.getPassword()))
            {
                //有相同的代表存在，返回true，后面的不需要再比了
                return true;
            }
        }
        return false;
    }

    //初始化界面
    private void initJFrame() {
        //设置界面的尺寸
       this.setSize(488, 430);
       // this.setSize(508, 560);
        //设置界面标题
        this.setTitle("拼图小游戏  v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面关闭
        this.setLocationRelativeTo(null);
        //取消默认的居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setLayout(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置键盘监听
        //this.addKeyListener(this);

        //刷新一下界面
       this.getContentPane().repaint();
    }

    //初始化菜单
    private void initView() {
        //1. 添加用户名文字
        JLabel usernameText=new JLabel(new ImageIcon(pathUsrNameText));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon(pathPasswordText));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);
        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon(pathCodeText));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);
        //验证码的输入框
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        String codeStr = CodeUtil.getCode();
        //设置内容
        rightCode.setText(codeStr);
        //绑定鼠标事件
        rightCode.addMouseListener(this);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);

        //5.添加登录按钮
        login.setBounds(100, 310, 128, 47);
        login.setIcon(new ImageIcon(pathLongin));
        //去除按钮的边框
        login.setBorderPainted(false);
        //去除按钮的背景
        login.setContentAreaFilled(false);
        //给登录按钮绑定鼠标事件
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //6.添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon(pathRegister));
        //去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        //给注册按钮绑定鼠标事件
        register.addMouseListener(this);
        this.getContentPane().add(register);

        //7.添加背景图片
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

        //创建一个管理图片的容器对象JLabel
        // JLabel jLabel=new JLabel(new ImageIcon("D:\\CodeApp\\Idea\\java\\puzzlegame\\image\\damie.jpg"));
        // JLabel jLabe2=new JLabel(new ImageIcon("image/girl/girl1/all.jpg"));
        //设置图片位置和宽高
        // jLabel.setBounds(0,0,100,100);
        // jLabe2.setBounds(0,0,288,288);
        //把图片添加到弹框中
        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(str);
        // warning.setBounds(200, 0, 200, 150);
        jDialog.getContentPane().add(warning);
        //jDialog.getContentPane().add(warning);

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
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==login)
        {
            System.out.println("点击了登录按钮");
            //获取两个文本输入框中的内容
            String userNameInput=username.getText();
            String userPasswordInput=password.getText();
            //获取用户输入的验证码
            String codeInput=code.getText();

            //创建一个User对象
            User userInfo=new User(userNameInput,userPasswordInput);
            System.out.println(userInfo);

            if(userNameInput.length()==0 || userPasswordInput.length()==0) {
                showJDialog("用户名或者密码不能为空");
            }   else if (codeInput.length()==0 ){
                showJDialog("验证码不能为空");
            }   else if(!codeInput.equalsIgnoreCase(rightCode.getText())){
                showJDialog("验证码输入错误");
            } else if (contains(userInfo)) {
                System.out.println("用户名和密码正确！");
                this.setVisible(false); //关闭当前登录界面
                //打开游戏的主界面
                //需要把当前登录的用户名传递给游戏界面
                new GameJFrame();
            } else{
                System.out.println("用户名或者密码错误");
                showJDialog("用户名或密码错误");
            }
        } else if (e.getSource()==register) {
            System.out.println("点击了注册按钮");
            this.setVisible(false);     //关闭登录页面
            new RegisterJFrame(allUsers);   //打开注册页面
        } else if (e.getSource()==rightCode) {
            for (int i = 0; i <this.allUsers.size() ; i++) {
                System.out.println(this.allUsers.get(i));
            }
            System.out.println("更换验证码");
            String code=CodeUtil.getCode();
            rightCode.setText(code);
        }
    }


    //按下不松
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==login){
            login.setIcon(new ImageIcon(pathLonginPressed));
        } else if (e.getSource()==register) {
            register.setIcon(new ImageIcon(pathRegisterPressed));
        }
    }

    //松开按钮
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    //鼠标划入
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    //鼠标划出
    @Override
    public void mouseExited(MouseEvent e) {

    }
}

