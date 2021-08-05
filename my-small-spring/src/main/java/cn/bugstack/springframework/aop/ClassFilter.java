package cn.bugstack.springframework.aop;

/**
 * @Description: ClassFilter 类拦截器, 匹配类
 * @Author wangyuj
 * @Date 2021/8/4
 */
public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
