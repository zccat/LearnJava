package zx.learn;

/**
 * @Auther: 胡志新
 * @Date: 2019/3/9 17:01
 * @Description:
 */
public class MergeString {

    public static void main(String[] args) {
        String str = " teachClassId,  " +
                "    courseName,  " +
                "    classNames,  " +
                "    mainTeacherId,  " +
                "    mainTeacherName,  " +
                "    examTypeId,  " +
                "    examType,  " +
                "    theoryHours,  " +
                "    studentNum,  " +
                "    advStatusId,  " +
                "    advStatusName,  " +
                "    ppaStatusId,  " +
                "    ppaStatusName";
        String[] strings = str.split(",");
//        System.out.println(str);
//        for (String string : strings) {
//            String asName = " as pjc"+string.trim().toUpperCase().charAt(4)+string.trim().substring(5,string.trim().length())+",";
//            System.out.println(string.trim() + asName);
//        }

//        for (String string : strings) {
//            String getName = "get"+string.trim().toUpperCase().charAt(0)+string.trim().substring(1,string.trim().length())+"();";
//            System.out.print(getName);
//        }
//        for (String string : strings) {
//            String getName = "get"+string.trim().toUpperCase().charAt(0)+string.trim().substring(1,string.trim().length())+"()";
//            String objectPut = "object.put(\""+string.trim()+"\",info."+getName+");";
//            System.out.println(objectPut);
//        }
//        String test = "1234";
//        System.out.println(test);


        String mergeStr = "and  mainTeacherId in (select JSDM  " +
                "                        from T_XG_JYS_JS  " +
                "                        where JYSDM = :jsyId )  " +
                " and schoolYear = :schoolYear and semester = :semester  ";



        System.out.print(mergeStr);
    }



}
