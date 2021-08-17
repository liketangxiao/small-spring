package cn.bugstack.springframework.beans;

/**
 * @Description: BeansException 异常类
 * @Author wangyuj
 * @Date 2021/7/27
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
