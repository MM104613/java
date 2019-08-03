package chatRoom.Multi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MultiThreadClient {
    //发送信息线程
    private  static class SendMsgFromServer implements Runnable{
        private Socket client;
        public SendMsgFromServer(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
          //获取键盘输入流
            Scanner in = new Scanner(System.in);
            PrintStream out2Server = null;
            try {
                out2Server = new PrintStream(client.getOutputStream(),true,"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true){
                if(in.hasNextLine()){
                    System.out.println("请输入信息：");
                    String str2Server = in.nextLine();
                   //将信息发送到服务器
                    out2Server.println(str2Server);
                    //客户端退出标志
                    if(str2Server.contains("byebye")){
                        System.out.println("客户端退出");
                        break;
                    }
                }
            }
            in.close();
            out2Server.close();
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //读信息线程
    private static class ReadMsgFromServer implements Runnable{
        private Socket client;
        public ReadMsgFromServer(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            Scanner in =null;
            try {
                in = new Scanner(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true){
                if(client.isClosed()){
                    System.out.println("客户端退出");
                    break;
                }
                if(in.hasNextLine()){
                    String strFromServer = in.nextLine();
                    System.out.println("服务器发来的消息为："+strFromServer);
                }
            }
            in.close();
        }
    }
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",6666);
        //新建读取与发送线程
        Thread readThread = new Thread(new ReadMsgFromServer(client));
        Thread sendThread = new Thread(new SendMsgFromServer(client));
        readThread.start();
        sendThread.start();
    }
}
