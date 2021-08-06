package cn.bugstack.springframework.aop;

/**
 * @Description: PointcutAdvisor 访问者
 * @Author wangyuj
 * @Date 2021/8/5
 */
public interface PointcutAdvisor extends Advisor {
    PointCut getPointcut();
}
