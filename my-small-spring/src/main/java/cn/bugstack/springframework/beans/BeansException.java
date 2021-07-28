package cn.bugstack.springframework.beans;

/**
 * @Description: BeansException 异常类
 * @Author wangyuj
 * @Date 2021/7/27
 */
public class BeansException extends RuntimeException {
    public BeansException() {
    }

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
