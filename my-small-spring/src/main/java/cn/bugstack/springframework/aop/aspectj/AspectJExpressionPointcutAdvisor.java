package cn.bugstack.springframework.aop.aspectj;

import cn.bugstack.springframework.aop.PointCut;
import cn.bugstack.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @Description: AspectJExpressionPointcutAdvisor 切面拦截器
 * @Author wangyuj
 * @Date 2021/8/5
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    private AspectJExpressionPointCut pointCut;
    private Advice advice;
    private String expression;

    public void setAspectJExpressionPointCut(AspectJExpressionPointCut pointCut) {
        this.pointCut = pointCut;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public PointCut getPointcut() {
        if (pointCut == null) {
            pointCut = new AspectJExpressionPointCut(expression);
        }
        return pointCut;
    }
}
