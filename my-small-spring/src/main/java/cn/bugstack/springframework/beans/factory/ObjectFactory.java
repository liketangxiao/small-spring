package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: ObjectFactory
 * @Author wangyuj
 * @Date 2021/8/16
 */
public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
