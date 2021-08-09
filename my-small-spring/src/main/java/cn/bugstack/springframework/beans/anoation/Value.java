package cn.bugstack.springframework.beans.anoation;

import java.lang.annotation.*;

/**
 * @Description: Value
 * @Author wangyuj
 * @Date 2021/8/9
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface Value {
    String value();
}
