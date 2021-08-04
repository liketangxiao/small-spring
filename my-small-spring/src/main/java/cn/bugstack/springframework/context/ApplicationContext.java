package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.factory.HierarchicalBeanFactory;
import cn.bugstack.springframework.beans.factory.ListableBeanFactory;
import cn.bugstack.springframework.core.io.ResourceLoader;

/**
 * @Description: AplicationContext 应用上下文功能接口
 * @Author wangyuj
 * @Date 2021/8/2
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {

}
