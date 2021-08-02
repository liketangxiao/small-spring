package cn.bugstack.springframework.context.support;

/**
 * @Description: ClassPathXmlApplicationContext 应用上下文实现类
 * @Author wangyuj
 * @Date 2021/8/2
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    private String[] configloactions;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String configloaction) {
        this(new String[]{configloaction});
    }

    public ClassPathXmlApplicationContext(String[] configloactions) {
        this.configloactions = configloactions;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configloactions;
    }
}
