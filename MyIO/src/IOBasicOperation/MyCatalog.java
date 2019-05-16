package IOBasicOperation;
import java.io.File;
import java.io.IOException;
import java.util.Date;

//判断父目录存不存在
// 取得父目录getParentFile()
// 不存在创建父目录 mkdirs()
/*public class MyCatalog {
    public static void main(String[] args) throws IOException {
        File file = new File("D:"+File.separator+"下载"+File.separator+ "java"+File.separator+ "MyIO"
                +File.separator+"src"+File.separator+"text"+File.separator+"text.txt");
        if (!file.getParentFile().exists()){  //取得父目录并判断父目录是否存在
            file.getParentFile().mkdirs();//  不存在创建mkdirs()无论多少级父目录一并创建
        }
        if(file.exists()){
            file.delete();
        }else{
            file.createNewFile();
        }
    }
}*/

//判断是否是文件 isFile()  是否是目录isDirectory()
//取得文件大小 long length()  最后一次修改long lastModified()
public class MyCatalog {
    public static void main(String[] args) {
       File file =new File("D:"+File.separator+"下载"+File.separator+"java"+File.separator+
               "MyIO"+File.separator+"src"+File.separator+"text"+File.separator+"text.txt");
       if(file.exists()&& file.isFile()){
           System.out.println("文件的大小"+file.length());
           System.out.println("最后一次修改文件"+new Date(file.lastModified()));
             //new date （） 输出时间  不然直接file.lastModified() 不然输出从1970年一段看不懂的数字
       }
    }
}