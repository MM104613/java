package chatroom.utils;

import chatroom.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

public class CommUtilsTest {

    @Test
    public void loadProperties() {
        String fileName = "datasource.properties";
        Properties properties =CommUtils.loadProperties(fileName);
        String url = properties.getProperty("url");
        Assert.assertNotEquals(null,url);
    }
    @Test
    public void objectToJson(){
        User u = new User();
        u.setId(1);
        u.setUserName("ma");
        u.setPassword("123");
        System.out.println(CommUtils.object2Json(u));

    }
    @Test
    public void JsonToObject(){
        String str = "{\"id\":1,\"userName\":\"ma\",\"password\":\"123\"}";
        System.out.println(CommUtils.json2Object(str,User.class));
    }
}