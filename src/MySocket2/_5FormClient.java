package MySocket2;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
public class _5FormClient extends JFrame {
    private JTextField txtMsg;
    private JTextArea areaMsgs;
    private JButton send;
    private Socket s;
    PrintWriter out;

    public _5FormClient() {
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

        //窗体显式时，需要连接服务器，获得Socket对象.
        try {
            s = new Socket("127.0.0.1", 9000);
            out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String msg = in.readLine();
                            if (!msg.isEmpty()) {
                                areaMsgs.append(msg + "\n");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        } catch (IOException e) {
            System.out.println("连接不到服务端");
        }

        //注册发送消息事件
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = txtMsg.getText();
                if (!msg.isEmpty()) {
                    out.println(msg);
                    out.flush();
                }
            }
        });

        //手动关闭窗体，
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "确定关闭吗？") == JOptionPane.YES_OPTION) {
                    out.print("exit");
                    _5FormClient.this.dispose();
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        new _5FormClient().setVisible(true);
    }

}
