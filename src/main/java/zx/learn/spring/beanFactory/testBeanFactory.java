package zx.learn.spring.beanFactory;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/8/15
 * Time: 15:24
 * Description:
 */
public class testBeanFactory implements BeanFactoryAware {

    @Test
    public void getBean() throws Exception {
        //获取资源
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:/beans.xml");
        System.out.println(resource.getURL());

//      创建 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

//        启动 BeanFactory
        reader.loadBeanDefinitions(resource);

//        从 BeanFactory 拿取 Bean
        Car car = beanFactory.getBean("car", Car.class);

        System.out.println(car);

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
