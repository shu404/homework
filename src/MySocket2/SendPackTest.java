package MySocket2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author shu
 * @project_name homework
 * @package_name MySocket2
 * @date 2020/10/9 - 9:45
 */
public class SendPackTest {
    public static void main(String[] args)
    {
        DatagramSocket ds=null;
        DatagramPacket dpSend=null;
        InetAddress ia = null;
        try {
             ia=InetAddress.getByName("127.0.0.1");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        int port=3021;

        try
        {
            ds=new DatagramSocket();
            for(int i=0;i<5;i++)
            {
                byte[] data=("我是 UDP 客户端"+i).getBytes();
                dpSend=new DatagramPacket(data,data.length,ia,port);
                ds.send(dpSend);
                Thread.sleep(1000);
            }
            ds.close();
        }
        catch(IOException | InterruptedException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }


}
