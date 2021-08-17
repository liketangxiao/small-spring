package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Description: MethodMatcher 方法匹配器
 * @Author wangyuj
 * @Date 2021/8/4
 */
public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches. If this
     *
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);

}
