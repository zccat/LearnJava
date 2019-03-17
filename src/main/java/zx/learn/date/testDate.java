package zx.learn.date;

import java.util.Date;

/**
 * @Auther: 胡志新
 * @Date: 2019/3/11 16:20
 * @Description:
 */
public class testDate {

    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date.toString());
    }
}
