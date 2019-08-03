package chatRoom.Single;
/*服务端
1.建立服务端Socket
  ServerSocket serverSocket = new ServerSocket(int port);
2.等待客户端连接，会一直阻塞到有客户端成功连接，返回客户端连接
  Socket client =  serverSocket.accept();
3.
*/
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) throws IOException {
        //1.建立基站
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("等待客户端连接...");
        //2.等待客户端连接
        Socket client =  serverSocket.accept();
        System.out.println("客户端连接成功");
        System.out.println("客户端连接成功，端口号为："+client.getPort());
        //读取客户端发来的信息
        Scanner in = new Scanner(client.getInputStream()) ;
        if(in.hasNext()){
            String str = in.nextLine();
            System.out.println("客户端发来的消息为："+str);
        }
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("Hi i am Server!");
        //关闭流
        in.close();
        out.close();
        serverSocket.close();
    }
}
