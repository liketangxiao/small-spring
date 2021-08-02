package cn.bugstack.springframework.core.io;

/**
 * @Description: ResourceLoader
 * @Author wangyuj
 * @Date 2021/7/29
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String classPath);
}
