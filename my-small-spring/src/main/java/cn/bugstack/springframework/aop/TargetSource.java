package cn.bugstack.springframework.aop;

/**
 * @Description: TargetSource 目标对象
 * @Author wangyuj
 * @Date 2021/8/4
 */
public class TargetSource {
    private Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
