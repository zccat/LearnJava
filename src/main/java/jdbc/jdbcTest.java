package jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcTest {

    public static void main(String[] args) {
        //1.加载驱动(开发推荐的方式)


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_demo?characterEncoding=UTF-8&serverTimezone=UTC",
                    "root", "root");

            Statement statement = c.createStatement();

//            直接通过 Statement 执行SQL
//            String sql = "INSERT INTO `websites` VALUES ('6', 'Test', 'https://www.test.cm/', '1', 'CN')";
//
//            statement.execute(sql);

//            通过prepareStatement执行
//            addOne(7, "Google", "www.gee.ee", 1, "country");


//            查询语句
            ResultSet rs = null;
            String sql = "select id, name, url, alexa, country from websites ";
            rs = statement.executeQuery(sql);
            List<Website> websites = new ArrayList<>();
            while (rs.next()) {
                Website website = new Website();
                website.id = rs.getInt(1);
                website.name = rs.getString(2);
                website.url = rs.getString(3);
                website.alexa = rs.getInt(4);
                website.country = rs.getString(5);
                websites.add(website);
            }
            for (Website website : websites) {
                System.out.println(website);
            }

            System.out.println("执行成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用prepareStatement 查询
     * @param id      id
     * @param name    名称
     * @param url     URL
     * @param alexa   不知道
     * @param country 国家
     * @param id      id
     */
    public static void addOne(Integer id, String name, String url, Integer alexa, String country) {
        String sql = "insert into websites (id, `name`, url, alexa, country) VALUES (?,?,?,?,?)";
        //该语句为每个 IN 参数保留一个问号（“？”）作为占位符
        Connection conn = null;                //和数据库取得连接
        PreparedStatement pstmt = null;        //创建statement
        try {
            conn = DbUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id + ""); //给占位符赋值
            pstmt.setString(2, name); //给占位符赋值
            pstmt.setString(3, url); //给占位符赋值
            pstmt.setString(4, alexa + ""); //给占位符赋值
            pstmt.setString(5, country); //给占位符赋值
            pstmt.executeUpdate();            //执行
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(pstmt);
            DbUtil.close(conn);        //必须关闭
        }
    }

}
