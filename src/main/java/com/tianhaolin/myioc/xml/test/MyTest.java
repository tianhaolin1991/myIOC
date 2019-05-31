package com.tianhaolin.myioc.xml.test;

import com.tianhaolin.myioc.xml.document.DocumentHolder;
import com.tianhaolin.myioc.xml.document.XmlDocumentHolder;
import com.tianhaolin.myioc.xml.element.element.ConstructorArgsElement;
import com.tianhaolin.myioc.xml.element.element.PropertyElement;
import com.tianhaolin.myioc.xml.element.loader.ElementLoader;
import com.tianhaolin.myioc.xml.element.loader.ElementLoaderImpl;
import com.tianhaolin.myioc.xml.element.parser.BeanElementParser;
import com.tianhaolin.myioc.xml.element.parser.BeanElementParserImpl;
import org.dom4j.Document;
import org.dom4j.Element;

import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class MyTest {
    public static void main(String[] args) {
        String filePath = MyTest.class.getClassLoader().getResource("parser/beanElementParser.xml").getPath();
        DocumentHolder documentHolder = new XmlDocumentHolder();
        Document document = documentHolder.getDocument(filePath);

        ElementLoader loader = new ElementLoaderImpl();
        loader.putElements(document);
        Map<String, Element> beanElements = loader.getBeanElements();

        Element element = beanElements.get("test12");

        BeanElementParser beanElementParser = new BeanElementParserImpl();

        List<PropertyElement> propertyValues = beanElementParser.getPropertyValues(element);
        List<ConstructorArgsElement> constructorArgsValues = beanElementParser.getConstructorArgsValues(element);
        System.out.println(constructorArgsValues);
        System.out.println(propertyValues);
    }
}
