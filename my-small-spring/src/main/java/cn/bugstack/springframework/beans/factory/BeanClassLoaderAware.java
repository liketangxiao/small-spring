package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Description: BeanClassLoaderAware 可以感知其所属的ClassLoader
 * @Author wangyuj
 * @Date 2021/8/3
 */
public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader) throws BeansException;
}