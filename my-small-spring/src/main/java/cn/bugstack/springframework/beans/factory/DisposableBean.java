package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: DisposableBean 销毁方法接口
 * @Author wangyuj
 * @Date 2021/8/3
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
