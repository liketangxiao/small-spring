package cn.bugstack.springframework.beans;

/**
 * @Description: 属性
 * @Author wangyuj
 * @Date 2021/7/27
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
