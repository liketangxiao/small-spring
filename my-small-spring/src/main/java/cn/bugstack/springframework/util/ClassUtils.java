package cn.bugstack.springframework.util;

/**
 * @Description: ClassUtils
 * @Author wangyuj
 * @Date 2021/7/27
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        return ClassUtils.class.getClassLoader();
    }
}
