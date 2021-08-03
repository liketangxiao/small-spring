package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: InitializingBean 初始化接口
 * @Author wangyuj
 * @Date 2021/8/3
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
