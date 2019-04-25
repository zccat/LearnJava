package StringTools;

/**
 * @Auther: 胡志新
 * @Date: 2019/4/16 14:30
 * @Description:
 */
public class AsString {

    public static void main(String[] args) {
        String str = "syncGroupId,\n" +
                "       teachClassId,\n" +
                "       schoolYear,\n" +
                "       semester,\n" +
                "       courseName,\n" +
                "       studentNum,\n" +
                "       classNames,\n" +
                "       mainTeacherId,\n" +
                "       mainTeacherName,\n" +
                "       offeredCollegeId,\n" +
                "       offeredCollegeName,\n" +
                "       examTypeId,\n" +
                "       examType,\n" +
                "       createrId,\n" +
                "       createrName,\n" +
                "       createTime,\n" +
                "       ifSync,\n" +
                "       advApllyId,\n" +
                "       paaSyncGroupId,\n" +
                "       paaTeachClassId,\n" +
                "       paaReason,\n" +
                "       paaSort,\n" +
                "       advPlace,\n" +
                "       advDate,\n" +
                "       advPeriod,\n" +
                "       advTechIds,\n" +
                "       advTechNames,\n" +
                "       paaCreaterId,\n" +
                "       paaCreaterName,\n" +
                "       paaCreateTime,\n" +
                "       paaAuditStatusId,\n" +
                "       paaAuditStatus,\n" +
                "       paaAuditorId,\n" +
                "       paaAuditorName,\n" +
                "       paaOpinion,\n" +
                "       paaAuditTime,\n" +
                "       paaNextAuditStatusId,\n" +
                "       paaNextAuditStatus,\n" +
                "       paaNextAuditorId,\n" +
                "       paaNextAuditorName,\n" +
                "       paaNextOpinion,\n" +
                "       paaNextAuditTime,\n" +
                "       paaNum,\n" +
                "       prtApplyId,\n" +
                "       ppaSyncGroupId,\n" +
                "       ppaTeachClassId,\n" +
                "       ppaSort,\n" +
                "       ppaCreaterId,\n" +
                "       ppaCreaterName,\n" +
                "       ppaCreateTime,\n" +
                "       ppaAuditStatusId,\n" +
                "       ppaAuditStatus,\n" +
                "       ppaAuditorId,\n" +
                "       ppaAuditorName,\n" +
                "       ppaOpinion,\n" +
                "       ppaAuditTime,\n" +
                "       ppaNextAuditStatusId,\n" +
                "       ppaNextAuditStatus,\n" +
                "       ppaNextAuditorId,\n" +
                "       ppaNextAuditorName,\n" +
                "       ppaNextOpinion,\n" +
                "       ppaNextAuditTime,\n" +
                "       ppaNum,\n" +
                "       advStatusId,\n" +
                "       advStatusName,\n" +
                "       ppaStatusId,\n" +
                "       ppaStatusName";

//        System.out.println(str);

        String[] strings = str.split(",");
        for (String string : strings) {
            String str_trim = string.trim();
            String asName = " as "+str_trim +",";
            System.out.println(string.trim() + asName);
        }
    }
}
