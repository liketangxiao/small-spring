package cn.bugstack.springframework.context.anoation;

import java.lang.annotation.*;

/**
 * @Description: Scope
 * @Author wangyuj
 * @Date 2021/8/9
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Scope {
    String value() default "singleton";
}
