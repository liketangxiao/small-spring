package cn.bugstack.springframework.aop;

/**
 * @Description: ClassFilter 类拦截器, 匹配类
 * @Author wangyuj
 * @Date 2021/8/4
 */
public interface ClassFilter {

    /**
     * Should the pointcut apply to the given interface or target class?
     *
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);
}
