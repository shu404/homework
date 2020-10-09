package MySocket2;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class _4FormServer extends JFrame {
    private JButton start,stop;
    private JLabel msg;
    private ServerSocket ss;
    private List<Socket> sockets = new ArrayList<>(); //保存所有已连接的客户端socket

    public _4FormServer(){
        setSize(200,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        try {
            ss = new ServerSocket(9000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        start = new JButton("启动");
        start.setBounds(10,10,150,30);
        c.add(start);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        stop = new JButton("停止");
        stop.setBounds(10,50,150,30);
        c.add(stop);
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        msg = new JLabel();
        msg.setForeground(Color.RED);
        msg.setBounds(10,85,180,25);
        c.add(msg);
    }

    private void start(){
        new Thread("监听线程"){
            @Override
            public void run() {
                while(true){
                    try {
                        Socket s = ss.accept(); // 不停监听所有客户端连接
                        sockets.add(s); //将Socket保存
                        new Thread(new SocketThread(s)).start(); // 启动子线程维护和客户端的交互
                    } catch (IOException ex) {
                        break;
                    }
                }
            }
        }.start();
        start.setEnabled(false);
        msg.setText("服务器开始监听...");
    }

    private void stop(){
        try {
            ss.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        start.setEnabled(true);
        msg.setText("服务器停止监听");
    }

    public static void main(String[] args) {
        new _4FormServer().setVisible(true);
    }



    // 维护每个客户端Socket的子线程
    class SocketThread implements Runnable {
        private Socket socket;
        private BufferedReader in;
        public SocketThread(Socket socket){
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void fenFa() throws IOException {
            String msg = in.readLine(); //读取数据 , 阻塞
            if(!msg.isEmpty()){
                String hostPort = socket.getInetAddress().getHostAddress()+"_"+socket.getPort();
                for(Socket s : sockets){
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
                    pw.println(hostPort+"说："+msg);
                    pw.flush();
                }
            }
        }

        @Override
        public void run() {
            while(true){
                try {
                    fenFa(); //读取客户端的信息， 分发给所有客户端
                } catch (IOException e) {
                    sockets.remove(socket);
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
