package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: Resource
 * @Author wangyuj
 * @Date 2021/7/27
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
