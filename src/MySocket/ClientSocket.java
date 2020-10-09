package MySocket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.*;
import java.net.Socket;

public class ClientSocket extends JFrame {

    private JTextField txtMsg;
    private JTextArea areaMsgs;
    private JButton send;
    private Socket socket;


    public ClientSocket() {
        UI();


        try {
            socket = new Socket("127.0.0.1", 9000);
        } catch (IOException e) {
            e.printStackTrace();
        }


        receiveMsg();
        sendMsg();


    }

    //设置UI界面
    public void UI() {
        setSize(600, 500);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        Container c = getContentPane();
        c.setLayout(null);
        areaMsgs = new JTextArea();
        JScrollPane sp = new JScrollPane(areaMsgs);
        sp.setBounds(20, 10, 550, 380);
        areaMsgs.setEditable(false);
        c.add(sp);

        txtMsg = new JTextField();
        txtMsg.setBounds(10, 400, 450, 30);
        c.add(txtMsg);

        send = new JButton("发送");
        send.setBounds(470, 400, 100, 30);
        c.add(send);
    }


    //发送消息
    public void sendMsg() {

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrintWriter out = null;
                try {
                    out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String msg = txtMsg.getText();
                if (!msg.isEmpty()) {
                    out.println(msg);
                    out.flush();
                }
            }
        });
    }

    //接收消息
    public void receiveMsg() {

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    BufferedReader in = null;
                    try {
                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        String s = in.readLine();
                        if (!s.isEmpty()) {
                            areaMsgs.append(s + "\n");
                        }

                    } catch (IOException e) {

                        System.out.println("连接不到服务器");
                    }

                }
            }
        }.start();
    }


    public static void main(String[] args) {
        new ClientSocket();
    }


}
