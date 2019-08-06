package chatroom.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//封装基础的工具方法，加载配置文件、json序列化等
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommUtils {
    private  static final Gson gson = new GsonBuilder().create();
    private CommUtils(){}

    public static Properties loadProperties(String fileName){
        Properties properties = new Properties();
        //获取当前配置文件输入流
        InputStream in = CommUtils.class.getClassLoader()
                .getResourceAsStream(fileName);
        //加载配置文件中的所有内容
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    /*@Test
    public void loadProperties(){
        String fileName = "datasource.properties";
        Properties properties = CommUtils.loadProperties(fileName);
        System.out.println(properties);
        String url = properties.getProperty("url");
        Assert.assertEquals(null,url);
    }*/

    public static String object2Json (Object obj){
     return gson.toJson(obj);
    }
    public static Object json2Object(String jsonStr,Class objClass){
        return gson.fromJson(jsonStr,objClass);
    }

    public static boolean strIsNull(String str){
        return str == null || str.equals("");
    }

}

