package zx.learn.redis;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import zx.learn.redis.config.RedisConfig;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/3
 * Time: 14:24
 * Description:
 * 就是一个非常简单的队列，没有防丢，没有出错重试，
 */
public class EmailMQ {


    public static RedisTemplate template;


    static {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        template = context.getBean(RedisTemplate.class);
    }

    public static void main(String[] args) throws InterruptedException {

        MailThread mailThread = new MailThread();
        Thread thread1 = new Thread(mailThread);
        Thread thread2 = new Thread(mailThread);
        Thread thread3 = new Thread(mailThread);
        Thread thread4 = new Thread(mailThread);
        Thread thread5 = new Thread(mailThread);
        Thread thread6 = new Thread(mailThread);

        template.delete("mailMQ");

//        随时读取邮件
        Thread thread = new Thread(new MessageSender());
        thread.start();

//        模拟请求添加需要发送邮件的Message
        thread1.start();
        Thread.sleep(10);
        thread2.start();
        Thread.sleep(10);
        thread3.start();
        Thread.sleep(10);
        thread4.start();
        Thread.sleep(10);
        thread5.start();
        Thread.sleep(10);
        thread6.start();
        Thread.sleep(10);

    }


}

//读取Redis 处理请求
class MessageSender implements Runnable {
    @Override
    public void run() {
        while (true) {
            Message msg = (Message) EmailMQ.template.opsForList().rightPop("mailMQ");
//            读取队列，如果为空，则
            if (msg == null) {
                try {
                    Thread.sleep(1000);
                    continue;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                SendMailService.sendMail(msg);
                SendMessageService.sendMessage(msg);
            }
        }
    }
}

//后台发送邮件的服务
class SendMailService {
    public static boolean sendMail(Message message) {
        System.out.println("开始向" + message.aimMail + "发送邮件" + message);
//            发送邮件的动作
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成发送邮件" + message);
        return true;
    }
}

class SendMessageService {
    public static boolean sendMessage(Message message) {
        System.out.println("开始向" + message.aimNum + "发送短信" + message);
//            发送邮件的动作
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        new Random().nextBoolean();
        System.out.println("完成发送短信" + message);
        return true;
    }
}


//请求发送邮件
class MailThread implements Runnable {
    @Override
    public void run() {
        Message message = new Message();
        message.aimMail = "aimMail" + Thread.currentThread().getId();
        message.aimNum = "aimNum" + Thread.currentThread().getId();
        message.msgStr = "msgStr" + Thread.currentThread().getId();
        EmailMQ.template.opsForList().leftPush("mailMQ", message);
        System.out.println("将" + message + "放到队列");
    }
}

//队列中的消息
class Message implements Serializable {
    String aimMail;
    String aimNum;
    String msgStr;

    @Override
    public String toString() {
        return "Message{" +
                "aimMail='" + aimMail + '\'' +
                ", aimNum='" + aimNum + '\'' +
                ", msgStr='" + msgStr + '\'' +
                '}';
    }
}