package zx.learn;

/**
 * @Auther: 胡志新
 * @Date: 2019/3/9 17:01
 * @Description:
 */
public class MergeString {

    public static void main(String[] args) {
        String str = " select * from (SELECT   " +
                "         T_STGL_CLUB_ACTIVITY.*,  " +
                "         clubName,  " +
                "     ISNULL(clubLinkName,'无') AS clubLinkName,   " +
                "     ISNULL(memberNames,'无') AS memberNames  " +
                "FROM T_STGL_CLUB_ACTIVITY  " +
                "LEFT JOIN T_STGL_ACTIVITY_CLUB_LINK  " +
                "    ON T_STGL_CLUB_ACTIVITY.clubActivityId = T_STGL_ACTIVITY_CLUB_LINK.clubActivityId  " +
                "        AND ifMain = 1  " +
                "LEFT JOIN T_STGL_CLUB  " +
                "    ON T_STGL_ACTIVITY_CLUB_LINK.clubId = T_STGL_CLUB.clubId   " +
                "LEFT JOIN   " +
                "    (SELECT clubActivityId,  " +
                "        clubLinkName = stuff(  " +
                "        (SELECT ',' + clubName  " +
                "        FROM T_STGL_ACTIVITY_CLUB_LINK tsacl1,T_STGL_CLUB tsc1  " +
                "        WHERE tsacl.clubActivityId = tsacl1.clubActivityId  " +
                "                AND tsacl1.clubId = tsc1.clubId  " +
                "                AND tsacl1.ifMain = 0 for xml path('')),1,1 ,'')  " +
                "        FROM T_STGL_ACTIVITY_CLUB_LINK tsacl,T_STGL_CLUB tsc  " +
                "        WHERE tsacl.clubId = tsc.clubId  " +
                "        GROUP BY  clubActivityId) clubLink  " +
                "        ON T_STGL_CLUB_ACTIVITY.clubActivityId = clubLink.clubActivityId  " +
                "LEFT JOIN   " +
                "    (SELECT tscam.clubActivityId,  " +
                "        memberNames = stuff(  " +
                "        (SELECT ',' + studentName  " +
                "        FROM T_STGL_CLUB_ACTIVITY_MEMBER tscam1  " +
                "        WHERE tscam.clubActivityId = tscam1.clubActivityId for xml path('')),1,1 ,'')  " +
                "        FROM T_STGL_CLUB_ACTIVITY_MEMBER tscam  " +
                "        GROUP BY  tscam.clubActivityId) memberLink  " +
                "        ON T_STGL_CLUB_ACTIVITY.clubActivityId = memberLink.clubActivityId  " +
                " where schoolYear = :schoolYear and semester = :semester ) totol";
        System.out.println(str);
    }
}
