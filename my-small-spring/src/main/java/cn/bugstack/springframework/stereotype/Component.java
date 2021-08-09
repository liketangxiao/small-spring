package cn.bugstack.springframework.stereotype;

import java.lang.annotation.*;

/**
 * @Description: Deployment
 * @Author wangyuj
 * @Date 2021/8/9
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Component {
    String value() default "";
}
