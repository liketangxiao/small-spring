package cn.bugstack.springframework.beans.factory;

/**
 * @Description: BeanNameAware 感知其所属BeanName
 * @Author wangyuj
 * @Date 2021/8/3
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);

}
