package zx.learn.redis;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/2
 * Time: 11:01
 * Description:
 */


public class RedisLock {

    @Autowired
    RedisTemplate template;


    //    6. 获取分布式锁
    public boolean getLock(String lockId) {

        synchronized (RedisLock.class) {
            boolean ifLock = false;
            Object res = template.opsForValue().get(lockId);
            ifLock = res == null ? false : (Boolean) res;
            if (ifLock) {
                return false;
            } else {
                template.opsForValue().set(lockId, Boolean.TRUE);
                return true;
            }
        }
    }

    //释放锁
    public boolean releaseLock(String lockId) {
        synchronized (RedisLock.class) {
            Boolean ifLock = (Boolean) template.opsForValue().get(lockId);
            if (ifLock) {
                template.opsForValue().set(lockId, Boolean.FALSE);
                return true;
            } else {
                return false;
            }
        }
    }
}
