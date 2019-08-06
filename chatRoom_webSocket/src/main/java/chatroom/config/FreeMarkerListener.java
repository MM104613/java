package chatroom.config;


import freemarker.template.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FreeMarkerListener implements ServletContextListener {
    public static  final  String TEMPLATE_KEY = "_template_";
    public void contextInitialized(ServletContextEvent sce){
        //配置版本
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        //配置加载路径
        try{
            cfg.setDirectoryForTemplateLoading(new File("D:\\下载\\java\\chatRoom_webSocket\\src\\main\\webapp"));

        }catch(IOException e){
            e.printStackTrace();
        }
        cfg.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        sce.getServletContext().setAttribute(TEMPLATE_KEY,cfg);
    }
    public  void contextDestroyed(ServletContextEvent sce){

    }
}
