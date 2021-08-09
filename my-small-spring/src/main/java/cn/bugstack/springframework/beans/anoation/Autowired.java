package cn.bugstack.springframework.beans.anoation;

import java.lang.annotation.*;

/**
 * @Description: AutoWired
 * @Author wangyuj
 * @Date 2021/8/9
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
public @interface Autowired {
}
