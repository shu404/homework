package MySocket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;

public class ServiceSocket extends JFrame {
    private JButton start,stop;
    private JLabel msg;
    private ServerSocket ss;


    //UI界面
    public void UI() {
        setSize(200,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        start = new JButton("启动");
        start.setBounds(10,10,150,30);
        c.add(start);
        stop = new JButton("停止");
        stop.setBounds(10,50,150,30);
        c.add(stop);
        msg = new JLabel();
        msg.setForeground(Color.RED);
        msg.setBounds(10,85,180,25);
        c.add(msg);
    }

    //接收消息
    public void receiveMsg() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
