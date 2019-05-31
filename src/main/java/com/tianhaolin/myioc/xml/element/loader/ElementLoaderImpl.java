package com.tianhaolin.myioc.xml.element.loader;

import org.dom4j.Document;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class ElementLoaderImpl implements ElementLoader {

    private Map<String,Element> elementMap = new HashMap<>();

    @Override
    public void putElements(Document document) {
        List<Element> elementList = document.getRootElement().elements();
        for (Element element : elementList) {
            String id = element.attributeValue("id");
            elementMap.put(id,element);
        }
    }

    @Override
    public Element getElement(String id) {
        return elementMap.get(id);
    }

    @Override
    public Map<String,Element> getBeanElements() {
        return elementMap;
    }


}
