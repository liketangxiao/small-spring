package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Description: MethodMatcher 方法匹配器
 * @Author wangyuj
 * @Date 2021/8/4
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> clazz);
}
