package zx.learn.date;

import java.sql.Date;

/**
 * @Auther: 胡志新
 * @Date: 2019/3/23 09:28
 * @Description:
 */

public class testSqlDate {

    public static void main(String[] args) {
        java.sql.Date date = new Date(System.currentTimeMillis());
        System.out.println(date.toString());

    }
}
