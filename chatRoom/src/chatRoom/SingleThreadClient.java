package chatRoom;
/*客户端
1.与服务器建立连接
  Socket client = new Socket("127.0.0.1",6666);
 */
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadClient {
    public static void main(String[] args) throws IOException {
     //1.与服务器连接
        Socket client = new Socket("127.0.0.1",6666);
        System.out.println("与服务器连接成功");
       //拿到输出流向服务器发送一条消息
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("Hi i am Client!");
        //拿到输入流读取服务器发来的信息
        Scanner in = new Scanner(client.getInputStream());
        if(in.hasNext()){
            String str = in.nextLine();
            System.out.println("服务器发来的消息为："+str);
        }
        //关闭流
        in.close();
        out.close();
        client.close();
    }
}
