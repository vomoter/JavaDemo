package test;

import javax.swing.*;
import java.awt.*;

public class JTextAre extends JFrame {
    public JTextAre(){
        setSize(500,500);
        setTitle("jh");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container container=getContentPane();
        JTextArea jTextArea=new JTextArea("ijoohooo",6,6);
        jTextArea.setLineWrap(true);
        container.add(jTextArea);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTextAre();
    }
}
