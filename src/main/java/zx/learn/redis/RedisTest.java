package zx.learn.redis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import zx.learn.redis.config.OldRedisConfig;
import zx.learn.redis.config.RedisConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/8/29
 * Time: 14:11
 * Description:
 */


public class RedisTest {

    @Test
    public void testRedisObj() {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        RedisTemplate template = context.getBean(RedisTemplate.class);
        Map<String, Object> properties = new HashMap<>();
        properties.put("123", "hello");
        properties.put("abc", 456 + "");


        template.opsForHash().putAll("hhhhash", properties);

        Map<Object, Object> ans = template.opsForHash().entries("hhhhash");

//        template.opsForList().rightPushAll("list_key", "1", "2", "3", "4", "5");

        template.opsForSet().isMember("key", "ob");

        //从右边弹出一个元素，如果不存在，等待 1 S
        template.opsForList().rightPopAndLeftPush("key_key", "kk", 1, TimeUnit.SECONDS);

        System.out.println("ans: " + ans);
//        List<String> strings = template.opsForList().range("list_key", 0, -1);
//        System.out.println(strings);
    }


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(OldRedisConfig.class);
        JedisPool pool = context.getBean(JedisPool.class);
//        获得连接
        Jedis jedis = pool.getResource();
//        输入密码
//        jedis.auth("123456");
        System.out.println(jedis.ping());
        jedis.set("name", "老王");
        System.out.println(jedis.get("name"));
        System.out.println("----------------------------");
        jedis.hset("user", "name", "老王");
        System.out.println(jedis.hget("user", "name"));
//        关闭连接
        jedis.close();
    }


}
