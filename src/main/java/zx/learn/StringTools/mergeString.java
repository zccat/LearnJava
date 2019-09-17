package zx.learn.StringTools;

/**
 * @Auther: 胡志新
 * @Date: 2019/4/13 16:21
 * @Description:
 */
public class mergeString {

    public static void main(String[] args) {
        String str = "[学号]\n" +
                "      ,[姓名]\n" +
                "      ,[班级]\n" +
                "      ,[专业]\n" +
                "      ,[系部]\n" +
                "      ,[校级志愿活动参与时长]\n" +
                "      ,[系级志愿活动参与时长]\n" +
                "      ,[班级志愿活动参与时长]\n" +
                "      ,[暑假社会实践天数]\n" +
                "      ,[寒假社会实践天数]\n" +
                "      ,[总结班会]\n" +
                "      ,[参与读书社团活动数量]\n" +
                "      ,[参与体育社团活动数量]\n" +
                "      ,[参与文娱社团活动数量]\n" +
                "      ,[参与读书社团数量]\n" +
                "      ,[参与体育社团数量]\n" +
                "      ,[参与文娱社团数量]";
        String[] strings = str.split(",");

        StringBuilder stringBuilder = new StringBuilder();

        for (String string : strings) {
//            if(!string.equals(""))
            String str_trim = string.trim();
                stringBuilder.append(str_trim.substring(1,str_trim.length()-1)).append(", ");
        }

//        for (String string : strings) {
//            String str_trim = string.trim();
//            String asName = " as paa" + str_trim.toUpperCase().charAt(4) + str_trim.substring(5, str_trim.length()) + ",";
//            System.out.println(string.trim() + asName);
//        }


        System.out.print(stringBuilder);
    }
}
