package cn.bugstack.springframework.context.anoation;

import cn.bugstack.springframework.beans.anoation.AutowiredAnnotationBeanPostProcessor;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.bugstack.springframework.stereotype.Component;
import cn.hutool.core.util.StrUtil;

import java.sql.Struct;
import java.util.Set;

/**
 * @Description: ClassPathBeanDefinitionScanner 获取bean作用域和类名
 * @Author wangyuj
 * @Date 2021/8/9
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {
    private final BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... baseScanPackages) {
        for (String baseScanPackage : baseScanPackages) {
            Set<BeanDefinition> candidateComponents = findCandidateComponents(baseScanPackage);
            for (BeanDefinition beanDefinition : candidateComponents) {
                String beanScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                String value = determineBeanName(beanDefinition);
                registry.registerBeanDefinition(value, beanDefinition);
            }
        }
        registry.registerBeanDefinition("cn.bugstack.springframework.context.annotation.internalAutowiredAnnotationProcessor", new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));

    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)) {
            value = StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (null != scope) return scope.value();
        return StrUtil.EMPTY;
    }
}
