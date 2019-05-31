package com.tianhaolin.myioc.xml.element.loader;

import org.dom4j.Document;
import org.dom4j.Element;

import java.util.Map;

/** 加载Dom中的所有元素
 * @author:tianhaolin
 * @version:1.0
 */
public interface ElementLoader {

    /**
     * @description 将document下的所有element放入ElementLoader
     * @param: document
     * @return void
     * @date 2019/5/30 0030 11:18
     */
    void putElements(Document document);

    /**
     * @description 通过id获取Element
     * @param: id
     * @return element
     * @date 2019/5/30 0030 11:19
     */
    Element getElement(String id);

    /**
     * @description 获取所有的Elements
     * @param:
     * @return java.util.List<org.dom4j.Element>
     * @date 2019/5/30 0030 11:19
     */
    Map<String,Element> getBeanElements();
}
