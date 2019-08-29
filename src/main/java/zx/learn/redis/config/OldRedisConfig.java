package zx.learn.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/8/29
 * Time: 14:12
 * Description:
 */
public class OldRedisConfig {

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(5);
        config.setMaxIdle(1);
        return config;
    }

    @Bean
    public JedisPool jedisPool() {
        return new JedisPool(jedisPoolConfig(), "localhost");
    }

}
