package cn.bugstack.springframework.aop.framework;

import cn.bugstack.springframework.aop.AdvisedSupport;

/**
 * @Description: ProxyFactory 动态代理工厂
 * @Author wangyuj
 * @Date 2021/8/5
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }
    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }

}
