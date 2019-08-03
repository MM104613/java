package chatRoom.Multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {
    //保存所有连接的客户端
    private static Map<String,Socket> clientMap = new ConcurrentHashMap<>();
    private static class ExecuteClientMSG implements Runnable{
         private Socket client;

        public ExecuteClientMSG(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
          
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        ExecutorService service = Executors.newFixedThreadPool(20);
        for(int i = 0;i < 20;i++){
            System.out.println("等待客户端连接....");
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接，端口号为："+client.getPort());
            //新建一个线程处理客户端的连接
            service.submit(new ExecuteClientMSG(client));
        }
        serverSocket.close();
    }
}
