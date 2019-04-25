package zx.learn.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Auther: 胡志新
 * @Date: 2019/3/23 14:07
 * @Description:
 */
public class testTransferJson {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        //    String name;
        //    String nickName;
        //    int age;
        //    String studentId;
//        jsonObject.put("name","张三");
        
        
        String str = "teachClassId,  " +
                "       schoolYear,  " +
                "       semester,  " +
                "       courseId,  " +
                "       courseName,  " +
                "       examPropId,  " +
                "       examProp,  " +
                "       examTypeId,  " +
                "       examType,  " +
                "       offeredCollegeId,  " +
                "       offeredCollegeName,  " +
                "       classNames,  " +
                "       teacherNames,  " +
                "       theoryHours,  " +
                "       expHours,  " +
                "       totalHours,  " +
                "       mainTeacherId,  " +
                "       mainTeacherName,  " +
                "       createrId,  " +
                "       createrName,  " +
                "       createTime,  " +
                "       ifJwcCreate,  " +
                "       studentNum,  " +
                "       maxClassNum,  " +
                "       bkTime,  " +
                "       jkTime,  " +
                "       selfExamPlace,  " +
                "       selfExamTimeBegin,  " +
                "       selfExamTimeEnd,  " +
                "       ifAdvExam,  " +
                "       currentApplyId,  " +
                "       syncGroupId";
        
        String[] strs = str.split(",");

        StringBuilder result = new StringBuilder();
        for (String s : strs) {
            result.append(" "+s.trim()+" as "+s.trim()+ ", ") ;
        }

        System.out.println(result.toString());
        

        Student student = new Student("张三","刘关张",18,"1234567");
        JSONObject object = (JSONObject) JSON.toJSON(student);
        System.out.println(object.toJSONString());

    }

}
