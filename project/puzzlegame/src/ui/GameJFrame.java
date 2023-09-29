package ui;

import cn.hutool.core.io.IoUtil;
import domain.GameInfo;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener{
    //GameJFrame这个界面表示的是游戏的主界面
    int[][] data = new int[4][4];

    public GameJFrame() {
        //初始化界面
        initJFrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据(打乱图片)
        initData();
        //初始化图片(打乱后的结果来加载图片)
        initImage();
        //让界面显示在屏幕上
        this.setVisible(true);
    }

    //记录空白方块在二维数组中的位置
    int x = 0, y = 0;

    //记录当前展示图的路径
    String path = "D:\\CodeApp\\Idea\\java\\puzzlegame\\image\\animal\\animal4\\";
    String pathBackground="image\\background.png";
    String pathWin="image\\win.png";
    String pathNot="image\\damie.jpg";
    String pathAnimal="image\\animal\\animal";
    String pathSport="image\\sport\\sport";
    String pathGirl="image\\girl\\girl";
    String pathSave="save\\save";
    //定义移动图片的步数
    int count=0;

    //创建选择下面的项目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
   // JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem explain=new JMenuItem("游戏说明");
    JMenuItem theVision = new JMenuItem("版本信息");
    JMenuItem animal=new JMenuItem("动物");
    JMenuItem sport=new JMenuItem("运动");
    JMenuItem girl =new JMenuItem("美女");

    JMenu save=new JMenu("存档");
    JMenu load=new JMenu("读档");

    JMenuItem savaItem1=new JMenuItem("存档1(空)");
    JMenuItem savaItem2=new JMenuItem("存档2(空)");
    JMenuItem savaItem3=new JMenuItem("存档3(空)");
    JMenuItem savaItem4=new JMenuItem("存档4(空)");

    JMenuItem loadItem1=new JMenuItem("读档1(空)");
    JMenuItem loadItem2=new JMenuItem("读档2(空)");
    JMenuItem loadItem3=new JMenuItem("读档3(空)");
    JMenuItem loadItem4=new JMenuItem("读档4(空)");


    //定义一个二维数组，存储正确的数据
    int[][] win=
    {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 0},
    };



    private void initData() {

        int[] tempA = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tempA.length; i++) {
            //获取随机索引
            int index = r.nextInt(tempA.length);
            int temp = tempA[i];
            tempA[i] = tempA[index];
            tempA[index] = temp;
        }
        //历遍tempA数组，把元素放到二维数组中
        for (int i = 0; i < tempA.length; i++) {
            if (tempA[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
                data[i / 4][i % 4] = tempA[i];
        }
    }

    private void initImage() {
        /*
         * 文件路径分为两种:
         * 绝对路径:一定是从盘符开始的。C:\   D:\
         * 相对路径:不是从盘符开始的。 aaa\\bbb
         * 在当前项目下，去找aaa文件夹,里面再找bbb文件夹
         * */
        //清空已经出现的所有图片
        this.getContentPane().removeAll();


        if (victory()) {
            //显示胜利的图片
            JLabel win=new JLabel(new ImageIcon (pathWin));
            win.setBounds(203,283,197,73);
            this.getContentPane().add(win);
        }

        JLabel setpcount=new JLabel("步数:"+count);
        setpcount.setBounds(50,30,100,20);
        this.getContentPane().add(setpcount);

        //定义图片计算
        int number = 1;
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                int temp = data[i][j];
                ImageIcon icon = new ImageIcon(path +temp + ".jpg");
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(icon);
                //指定图片位置
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                number++;
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        ImageIcon bd = new ImageIcon(pathBackground);
        JLabel background = new JLabel(bd);

        background.setBounds(40, 40, 508, 560);
        //把背景图片添加到界面中
        this.getContentPane().add(background);

        //刷新一下界面
        this.getContentPane().repaint();

    }


    private void initJFrame() {
        //设置界面的尺寸
        this.setSize(603, 680);
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
        this.addKeyListener(this);
    }

    private void initJMenuBar() {
        //初始化菜单
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上面的两个选项的对象（功能 关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        JMenu changeImageMenu=new JMenu("更换图片");

        //将每一个选项下面的条目添加到选择中
        functionJMenu.add(changeImageMenu);
        functionJMenu.add(replayItem);

//        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);
        functionJMenu.add(save);
        functionJMenu.add(load);

        aboutJMenu.add(explain);
        aboutJMenu.add(theVision);

        //把动物、运动小条目添加到changeImage中
        changeImageMenu.add(animal);
        changeImageMenu.add(sport);
        changeImageMenu.add(girl);

        save.add(savaItem1);
        save.add(savaItem2);
        save.add(savaItem3);
        save.add(savaItem4);

        load.add(loadItem1);
        load.add(loadItem2);
        load.add(loadItem3);
        load.add(loadItem4);

        //给条目绑定事件
        animal.addActionListener(this);
        sport.addActionListener(this);
        girl.addActionListener(this);
        replayItem.addActionListener(this);
//      reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        savaItem1.addActionListener(this);
        savaItem2.addActionListener(this);
        savaItem3.addActionListener(this);
        savaItem4.addActionListener(this);

        loadItem1.addActionListener(this);
        loadItem2.addActionListener(this);
        loadItem3.addActionListener(this);
        loadItem4.addActionListener(this);


        explain.addActionListener(this);
        theVision.addActionListener(this);

        //将菜单的两个选择添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);
        //显示读档和存档信息
        getGameInfo();
        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }
    public void getGameInfo(){
        //1.创建File对象表示所有存档所在的文件夹
        File file=new File("save");
        //2,进入文件夹获取里面所有的存档文件
        File[] files=file.listFiles();
        //3。遍历数字，得到每一个存档
        for (File f:files){
            try {
                GameInfo gi=null;
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
                gi=(GameInfo)ois.readObject();
                ois.close();

                int step=gi.getStep();
                //获取当前文件的名称
                String name=f.getName();
                //获取当前文件的索引
                int index=name.charAt(4)-'0';
                save.getItem(index-1).setText("存档"+index+"("+step+"步)");
                load.getItem(index-1).setText("读档"+index+"("+step+"步)");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 16) {
            //把界面的所有图片删除
            this.getContentPane().removeAll();
            //加载第一张完整的图片
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            //添加背景图片
            ImageIcon bd = new ImageIcon(pathBackground);
            JLabel background = new JLabel(bd);

            background.setBounds(40, 40, 508, 560);
            //s刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，如果胜利，则结束该方法，不执行下面的代码
        if (victory()) {
            //return的作用:1返回结果 2:结束方法
            return;
        }
        //对上、下、左、右进行判断
        //左:37 上:38 右:39 下:40
        int code = e.getKeyCode();
        if (code == 37) {
            System.out.println("向左移动");
            if (y == 3) {
                return;
            }
            // 把空白方块右方的方块向左移动
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            //每移动一次，计数器自增一次
            count++;
            initImage();

        } else if (code == 38) {
            System.out.println("向上移动");
            if (x == 3) {
                return;
            }
            /*逻辑:
             * 把空白方块下方的方块向上移动
             * 即:x+1,y不变
             * */

            //把空白方块下方方块赋值给空白方块
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            //每移动一次，计数器自增一次
            count++;
            //调用方法来加载最新的图片
            initImage();

        } else if (code == 39) {
            System.out.println("向右移动");
            if (y == 0) {
                return;
            }
            // 把空白方块左方的方块向右移动
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            //每移动一次，计数器自增一次
            count++;
            initImage();
        } else if (code == 40) {
            System.out.println("向下移动");
            if (x == 0) {
                return;
            }
            //把空白方块上方的方块向下移动
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            //每移动一次，计数器自增一次
            count++;
            initImage();
        } else if (code == 16) {
            initImage();
        } else if (code == 49) {
            data = new int[][]{
                    {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0},
            };
            initImage();

        } else {
            System.out.println(code);
        }
    }

    //判断data数组中的数据是否与win数组的相同
    //如完全相同返回true,否则返回false
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                //两者有有数据不相同，返回false
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return  true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前被点击的条目对象
        Object eSource=e.getSource();
        //判断
        if(eSource==replayItem){
            //重新游戏
            //刷新一下界面
            this.getContentPane().repaint();
            //再一次打乱二维数组中的数据
            initImage();
            //再次初始化数据(打乱图片)
            initData();
            //记数器清零
            count=0;
        } /*else if (eSource==reLoginItem) {
            //重新登录

            //关闭当前的游戏界面
            this.setVisible(false);
            //打开登录界面
           new LoginJFrame();
        } */
        else if (eSource==closeItem) {
            //关闭游戏
            System.exit(0);
        } else if(eSource==theVision){
            //版本信息

            //创建文本信息
            JLabel tx=new JLabel("给个好评 !");
            //创建一个弹窗对象
            JDialog jDialog=new JDialog();
            //创建一个管理图片的容器对象JLabel
            JLabel jLabel=new JLabel(new ImageIcon(pathNot));
            //设置图片位置和宽高
            jLabel.setBounds(0,0,258,258);
            //把图片添加到弹框中
            jDialog.getContentPane().add(jLabel);
            //把文本信息添加到弹框中
            jDialog.getContentPane().add(tx);
            //设置弹框大小
            jDialog.setSize(344,344);
            //让弹框置顶
            jDialog.setAlwaysOnTop(true);
            //让弹框居中
            jDialog.setLocationRelativeTo(null);
            //弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            //让弹框显示出来
            jDialog.setVisible(true);
        }
        else if (eSource==animal) {
            //用Random类来产生随机数
            Random r=new Random();
            int n=r.nextInt(9)+1;
            //更新path路径
            path=pathAnimal+n+"\\";
            //再次打乱二维数组中的数据
            initImage();
            //再次初始化数据(打乱图片)
            initData();
            //记数器清零
            count=0;
        }
        else if(eSource==sport){
            //用Random类来产生随机数
            Random r=new Random();
            int n=r.nextInt(11)+1;
            //更新path路径
            path=pathSport+n+"\\";
            //再一次打乱二维数组中的数据
            initImage();
            //再次初始化数据(打乱图片)
            initData();
            //记数器清零
            count=0;
        }else if(e.getSource()==girl){
            //用Random类来产生随机数
            Random r=new Random();
            int n=r.nextInt(9)+1;
            //更新path路径
            path=pathGirl+n+"\\";
            //再一次打乱二维数组中的数据
            initImage();
            //再次初始化数据(打乱图片)
            initData();
            //记数器清零
            count=0;
        } else if (eSource==savaItem1 || eSource==savaItem2 ||eSource==savaItem3 || eSource==savaItem4) {
           JMenuItem item=(JMenuItem) eSource;
           String str=item.getText();
           int index=str.charAt(2)-'0';
           String temp=pathSave+index+".data";
            //把游戏的数据写入本地文件
            ObjectOutputStream oos= null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(temp));
                GameInfo gi=new GameInfo(data,x,y,path,count);
                //糊涂包的方法，第一个参数为流对象，第二个为是否关闭流，第三首写入的集合
                IoUtil.writeObj(oos,true,gi);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            //修改存档的展示信息
            item.setText("存档"+index+"("+count+"步)");
            //修改读档的提示信息，索引默认从0开始
            load.getItem(index-1).setText("读档"+index+"("+count+"步)");

        } else if (eSource==loadItem1 || eSource==loadItem2 ||eSource==loadItem3 || eSource==loadItem4) {
            GameInfo gi=null;
            try {
                JMenuItem item=(JMenuItem) eSource;
                String str=item.getText();
                int index=str.charAt(2)-'0';
                String temp=pathSave+index+".data";
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream(temp));
                gi=(GameInfo) ois.readObject();
                ois.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            //修改数据
            data=gi.getData();
            path=gi.getPath();
            x=gi.getX();
            y=gi.getY();
            count=gi.getStep();
            //刷新界面
            initImage();

        } else if (eSource==explain) {
            //显示游戏说明
            new  Good();
        }
    }
}







