package cn.bugstack.springframework.aop;

/**
 * @Description: PointCut 定义切点接口
 * @Author wangyuj
 * @Date 2021/8/4
 */
public interface PointCut {
    ClassFilter getCalssFilter();

    MethodMatcher getMethodMatcher();
}
