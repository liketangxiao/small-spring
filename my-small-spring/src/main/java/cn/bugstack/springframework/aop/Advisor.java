package cn.bugstack.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Description: Advisor 访问者
 * @Author wangyuj
 * @Date 2021/8/5
 */
public interface Advisor {

    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     *
     * @return the advice that should apply if the pointcut matches
     * @see org.aopalliance.intercept.MethodInterceptor
     * @see BeforeAdvice
     */
    Advice getAdvice();
}
