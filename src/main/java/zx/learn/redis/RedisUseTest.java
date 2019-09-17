package zx.learn.redis;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import zx.learn.redis.config.RedisConfig;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/2
 * Time: 8:57
 * Description:
 */
public class RedisUseTest {


    RedisTemplate template = null;
    ApplicationContext context = null;

    @Before
    public void before() {
        context = new AnnotationConfigApplicationContext(RedisConfig.class);
        template = context.getBean(RedisTemplate.class);

    }

    //    1. CookIe 操作
    public boolean addCookie(String cookId) {
        long i = System.currentTimeMillis() + 30 * 60 * 1000;
        i = i / 1000;
        //记录有效期
        try {
            template.opsForSet().add("spring:session:expireations" + cookId, i);
            template.opsForValue().set("spring:session:sessions:expires:[" + cookId + "]", "");
            //使用Redis的过期机制 设置有效期
            template.expire("spring:session:sessions:expires:[" + cookId + "]", i, TimeUnit.MINUTES);
//        存放 cookie 的有效值 记录了 creationTime，maxInactiveInterval，lastAccessedTime，attribute。前两个数据是用于 session 过期管理的辅助数据结构
            template.opsForHash().put("spring:session:sessions:expires:[" + cookId + "]", "creationTime", System.currentTimeMillis());
        } catch (Exception e) {
            return false;
        }
        return true;

    }

    // 2。 某些值的缓存
    public JSONObject getSomeValue() {
        //读取缓存
        JSONObject object = (JSONObject) template.opsForValue().get("MethodName:" + "arg");
        if (object != null) {
            return object;
        }

        //通过 Service 查出 Object 。。。 写入缓存
        object = null;

        //放入 Service 有效时间随机一下，防止雪崩
        template.opsForValue().set("MethodName:" + "arg", object);
        long timeout = 30 + (long) (5 * Math.random());
        template.expire("MethodName:" + "arg", timeout, TimeUnit.MINUTES);
        return object;
    }


    //    3. 点赞   高频操作
    public void good(String userId, String articleId) {
        //从服务中拿取article信息
        String article = "";

        //加入点赞列表
        long v = template.opsForSet().add("article:[" + articleId + "]", userId);

//      如果以前没点过赞 点赞数量加一
        if (v == 1) {
            template.opsForHash().increment("articleGoodCount", articleId, 1);
        }
        return;
    }


    //4. 消息队列
    public void put(String key, Object v) {
        template.opsForList().leftPush(key, v);
    }

    public Object get(String key) {
        return template.opsForList().rightPop(key);
    }


    //5. 计算 两个 账号 的 共同好友
    @Test
    public void getSameFriendNum() {
        String a = "1";
        String b = "2";
        //通过服务读取好友
        List<String> aFriends = Arrays.asList("11", "22", "33");
        List<String> bFriends = Arrays.asList("11", "33", "44");

        template.opsForSet().add(a + "friends", aFriends);
        template.opsForSet().add(b + "friends", bFriends);

        Set<String> fri = template.opsForSet().union(a + "friends", b + "friends");
        assert fri.size() == 2;
        template.delete(a + "friends");
        template.delete(b + "friends");

//        return fri;

    }


    @Test
    public void testLock() {
        RedisLock lock = context.getBean(RedisLock.class);
        String lockId = "lock1";
        int i = 0;
        int j = 0;

        long start = System.nanoTime();
        while (true) {
            if (lock.getLock(lockId)) {
                i++;
//                System.out.println("我获得了Lock" + i);
//                lock.releaseLock(lockId);
            } else {
                j++;
                lock.releaseLock(lockId);
            }
            if (TimeUnit.NANOSECONDS.toSeconds((System.nanoTime() - start)) >= 10) {
                break;
            }
        }
        System.out.println("每秒获得锁：" + i /10 + "次");
        System.out.println("每秒释放锁：" + j /10 + "次");

    }


}
