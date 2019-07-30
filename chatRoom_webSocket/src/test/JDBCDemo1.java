import org.junit.Test;

import java.sql.*;

/*
1.加载驱动         DriverManager
2.获取数据库连接  Connection
3.执行SQL语句
Statement类执行SQL
  PrepareStatement类  （常用这个类） 预编译sql类，会使用占位符？占位用户名密码等需要外部传入的字段
ResultSet类封装查询的结果集
查询 select
ResultSet statement.executeQuery(sql)
更新 insert/update/delete
int executeUpdate(String sql, int autoGeneratedKeys) 返回值为执行更新sql后的影响行数

4.释放资源（连接）
*/
public class JDBCDemo1 {
  @Test
  //select
    public void test(){
      try {
          //1.加载驱动
          Class.forName("com.mysql.jdbc.Driver");
          //2.获取连接
          Connection connection = DriverManager
                  .getConnection("jdbc:mysql://localhost:3306/jdbc","root","104613");
          //3.执行SQL
          String sql = "select * from user";
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery(sql);
          //遍历结果集
          while(resultSet.next()){
              int id = resultSet.getInt("id");
              String userName = resultSet.getString("username");
              String passWord = resultSet.getString("password");
              System.out.println("id为："+id+",用户名为："+userName+",密码为："+passWord);
          }
          //4.释放资源
          connection.close();
          statement.close();
          resultSet.close();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
    @Test
    //insert
    public void test1(){
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/jdbc","root","104613");
            //3.执行SQL
            String sql = "insert into user(username, password)"+"values('test','465')";
            Statement statement = connection.createStatement();
            int resultRows = statement.executeUpdate(sql,
                    Statement.RETURN_GENERATED_KEYS);
            System.out.println(resultRows);
            //4.释放资源
            connection.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    //delect
    public void test2(){
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/jdbc","root","104613");
            //3.执行SQL
            String sql = "delete from user where username='test'";
            Statement statement = connection.createStatement();
            int resultRows = statement.executeUpdate(sql,
                    Statement.RETURN_GENERATED_KEYS);
            System.out.println(resultRows);
            //4.释放资源
            connection.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
