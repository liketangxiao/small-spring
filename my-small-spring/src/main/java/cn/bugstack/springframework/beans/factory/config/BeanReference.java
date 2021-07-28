package cn.bugstack.springframework.beans.factory.config;

/**
 * @Description: BeanReference
 * @Author wangyuj
 * @Date 2021/7/27
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
