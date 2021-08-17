package cn.bugstack.springframework.aop;

import cn.bugstack.springframework.util.ClassUtils;

/**
 * @Description: TargetSource 目标对象
 * @Author wangyuj
 * @Date 2021/8/4
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        Class<?> clazz = target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
