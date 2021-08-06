package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Description: MethodBeforeAdvice 方法拦截器
 * @Author wangyuj
 * @Date 2021/8/5
 */
public interface MethodBeforeAdvice {
    void before(Method method, Object[] args, Object target) throws Throwable;
}
