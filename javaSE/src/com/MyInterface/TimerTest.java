package com.MyInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.*;
import javax.swing.Timer;//这里要消除二义性（util中也又Timer）
import javax.swing.*;

public class TimerTest {
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();


        Timer t = new Timer(20000, listener);//时间一到（每个delay，listener执行一次）
        t.start();//启动定时器
        JOptionPane.showMessageDialog(null, "退出程序？");//弹出退出程序按钮面板
        System.exit(0);

    }
}

//实现acionPerformed方法，
class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("在...时候，时间是" + new Date());
    }
}
