package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @Description: CglibSubclassingInstantiationStrategy CGLIB动态代理
 * @Author wangyuj
 * @Date 2021/7/27
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] agrs) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanClass);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (constructor != null) {
            return enhancer.create(constructor.getParameterTypes(), agrs);
        }
        return enhancer.create();
    }
}
