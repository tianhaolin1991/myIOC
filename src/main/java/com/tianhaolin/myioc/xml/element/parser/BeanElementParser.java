package com.tianhaolin.myioc.xml.element.parser;

import com.tianhaolin.myioc.xml.element.element.ConstructorArgsElement;
import com.tianhaolin.myioc.xml.element.element.LeafElement;
import com.tianhaolin.myioc.xml.element.element.PropertyElement;
import org.dom4j.Element;

import java.util.List;

/**Element解析器
 * @author:tianhaolin
 * @version:1.0
 */
public interface BeanElementParser {

    /**
     * @description 获取所有的Property元素
     * @param: element
     * @return java.util.List<org.dom4j.Element>
     * @date 2019/5/30 0030 15:45
     */
    List<Element> getPropertyElements(Element element);

    /**
     * @description 获取所有ConstructorArgs元素
     * @param: element
     * @return java.util.List<org.dom4j.Element>
     * @date 2019/5/30 0030 15:46
     */
    List<Element> getConstructorArgsElements(Element element);
    /**
     * @description 获取元素下的PropertyElement
     * @param: element
     * @return java.util.List<com.tianhaolin.myioc.xml.element.element.PriorityElement>
     * @date 2019/5/30 0030 13:59
     */
    List<PropertyElement> getPropertyValues(Element element);


    List<ConstructorArgsElement> getConstructorArgsValues(Element element);

    /**
     * @description获取元素下所有的LeafElement
     * @param: element
     * @return java.util.List<com.tianhaolin.myioc.xml.element.element.LeafElement>
     * @date 2019/5/30 0030 15:33
     */
    List<Element> getLeafElements(Element element);


    /**
     * @description 获取Value(即Value或ref标签的内容)
     * @param: element
     * @return java.util.List<com.tianhaolin.myioc.xml.element.element.LeafElement>
     * @date 2019/5/30 0030 14:11
     */
    LeafElement getValue(Element element);

}
