package chatroom.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

public class CommUtilsTest {

    @Test
    public void loadProperties() {
        String fileName = "db.properties";
        Properties properties =CommUtils.loadProperties(fileName);
        String url = properties.getProperty("url");
        Assert.assertNotEquals(null,url);
    }
}