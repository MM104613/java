//IO文件的创建、删除
package IOBasicOperation.StreamTest;
import java.io.File;
import java.io.IOException;

//文件的创建调用createNewFile()
/*public class IOUse {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\62424\\Desktop\\Test");
        try {
            file.createNewFile();  // 文件的创建
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/

//判断文件是否存在exists()  删除文件delete()
/*
public class IOUse {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\62424\\Desktop\\Test.txt");
        if(file.exists()){
            file.delete(); //如果文件存在进行删除
        }else{
            file.createNewFile();
        }
    }
}*/

//为了在任何平台下版本兼容所以 所有“/”用File.separator
public class IOUse {
    public static void main(String[] args) throws IOException {
        File file = new File("C:"+File.separator+"Users"
                +File.separator+"62424"+File.separator+"Desktop"+File.separator+"Test.txt");
        file.createNewFile();
    }
}
