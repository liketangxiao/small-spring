package cn.bugstack.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Description: Advisor 访问者
 * @Author wangyuj
 * @Date 2021/8/5
 */
public interface Advisor {
    Advice getAdvice();
}
