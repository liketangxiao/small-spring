package cn.bugstack.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description: PropertyValues 属性集合
 * @Author wangyuj
 * @Date 2021/7/27
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        Optional<PropertyValue> propertyValueOptional = propertyValueList.stream().filter(propertyValue ->
                propertyValue.getName().equals(propertyName)).findFirst();
        return propertyValueOptional.orElse(null);
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }
}
