package IOBasicOperation.StreamTest;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.io.*;
import java.nio.channels.FileLockInterruptionException;
//字节流（InputStream、OutputStream）原生操作，不需要处理
//字符流(Reader、Writer)通过转换得来的，需要中间处理  （用于文字处理，除此之外所有的流处理均使用字节流）
//流的四部操作：1.取得终端对象 2.取得输入输出流 3. 进行数据的输入与输出 4.关闭流

//字节输出流OutputStream
/*public class MyStream {
    public static void main(String[] args) throws IOException {
        //1.取得终端对象
        File file = new File("C:"+ File.separator+"Users"+File.separator
                +File.separator+"62424"+File.separator+"Desktop"+File.separator+"hello.txt");
        if(! file.getParentFile().exists()){  //判断父目录是否存在
            file.getParentFile().mkdirs();
        }
        //2.取得相应的终端输出流  OutputStream()是一个抽象类必须使用子类 则用FileOutputStream
        OutputStream outputStream = new FileOutputStream(file,true);   //若需要追加文件则需在括号里加上true
        //3.将数据通过输出流输出
         outputStream.write("java我正在学习\n".getBytes(),0,5);  //部分输出给括号后加开始点 长度数字即可
         //4.关闭流
        outputStream.close();
        System.out.println("运行完毕");
    }
}*/

//字节输入流:InputStream
/*public class MyStream {
    public static void main(String[] args) {
        //1.取得终端对象
        File file = new File("C:"+File.separator+"Users"+File.separator+"62424"+File.separator
                +"Desktop"+File.separator+"hello.txt");
        //2.取得输入流
            try {
                InputStream inputStream = new FileInputStream(file);
                //读取数据
                int len= 0;
                byte[] data = new byte[2048];
                len= inputStream.read(data);
                System.out.println("文件内容为："+new String(data,0,len));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }*/

//字符输出流:Writer   字符流有缓冲区，若为关闭流，则数据默认都在缓冲区存放不会输出到终端
/*public class MyStream {
    public static void main(String[] args) throws IOException {
        File file =new File("C:"+File.separator+"Users"+File.separator+"62424"
                +File.separator+"Desktop"+File.separator+"hello.txt");
        Writer writers= new FileWriter(file);
        writers.write("我正在学java");
        writers.close();
        //writers.flush();   若在不关闭的基础上输出缓冲区数据，可以调用flush()强制刷新缓冲区
    }
}*/

//字符输入流：Reader
/*
public class MyStream {
    public static void main(String[] args) {
        File file = new File("C:"+File.separator+"Users"+File.separator+"62424"
                +File.separator+"Desktop"+File.separator+"hello.txt");
        try {
            Reader reader = new FileReader(file);
            int len=0;
            char[] data = new char[1024];
            len = reader.read(data);
            System.out.println("文件内容为："+new String(data,0,len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/

//文件拷贝
public class MyStream {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File("C:\\Users\\62424\\Desktop\\新建文件夹\\1543308226647.jpeg");
        File descFile = new File("C:\\Users\\62424\\Desktop\\123\\123.jpeg");
        InputStream inputStream = new FileInputStream(sourceFile);
        OutputStream outputStream = new FileOutputStream(descFile);
        copyFile(inputStream,outputStream);
    }
    private static void copyFile(InputStream inputStream, OutputStream outputStream) throws IOException {
        System.out.println("文件开始拷贝");
        long start =System.currentTimeMillis();
        int len=0;
        //边读边写，每次读一个字节，写一个字节
        byte[] data = new byte[1024];
        while((len = inputStream.read(data)) != -1){
            outputStream.write(len);
            }
            long end = System.currentTimeMillis();
        System.out.println("文件拷贝结束共耗时"+(end - start)+"毫秒");
    }
}