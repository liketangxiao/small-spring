package cn.bugstack.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Description: DefaultResourceLoader
 * @Author wangyuj
 * @Date 2021/7/29
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String classPath) {
        Assert.notNull(classPath, "classpath must not be null");
        if (classPath.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(classPath.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(classPath);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(classPath);
            }
        }
    }
}
