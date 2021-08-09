package cn.bugstack.springframework.beans.anoation;

import java.lang.annotation.*;

/**
 * @Description: Qualifier
 * @Author wangyuj
 * @Date 2021/8/9
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
public @interface Qualifier {
    String value() default "";
}
