package com.tianhaolin.myioc.xml.element.parser;

import com.tianhaolin.myioc.xml.element.element.*;
import com.tianhaolin.myioc.xml.element.loader.ElementLoader;
import com.tianhaolin.myioc.xml.uitl.IocUtil;
import org.dom4j.Attribute;
import org.dom4j.Element;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class BeanElementParserImpl implements BeanElementParser {

    @Override
    public List<Element> getPropertyElements(Element element) {
        return element.elements("property");
    }

    @Override
    public List<Element> getConstructorArgsElements(Element element) {
        return element.elements("constructor-arg");
    }

    @Override
    public List<PropertyElement> getPropertyValues(Element element) {
        List<Element> propertyElements = getPropertyElements(element);
        ArrayList<PropertyElement> propertyValues = new ArrayList<>();
        for (Element propertyElement : propertyElements) {

            String name = propertyElement.attributeValue("name");

            Element leafElement = getLeafElements(propertyElement).get(0);

            LeafElement value = getValue(leafElement);

            PropertyElement propertyValue= new PropertyElement();
            propertyValue.setName(name);
            propertyValue.setLeafElement(value);

            propertyValues.add(propertyValue);
        }
        return propertyValues;
    }


    @Override
    public List<ConstructorArgsElement> getConstructorArgsValues(Element element) {
        List<Element> constructorArgsElements = getConstructorArgsElements(element);
        List<ConstructorArgsElement> constructorValues = new ArrayList<>();
        for (Element constructorArgsElement : constructorArgsElements) {
            Element e = getLeafElements(constructorArgsElement).get(0);
            LeafElement value = getValue(e);

            ConstructorArgsElement constructorValue = new ConstructorArgsElement();
            constructorValue.setLeafElement(value);

            constructorValues.add(constructorValue);
        }
        return constructorValues;
    }

    @Override
    public List<Element> getLeafElements(Element element) {
        return element.elements();
    }

    @Override
    public LeafElement getValue(Element element) {
        String elementName = element.getName();
        if("value".equals(elementName)){
            return new ValueElement(this.getValueElementValue(element));
        }else if("ref".equals(elementName)){
            return new RefElement(this.getRefElementValue(element));
        }else if("collection".equals(elementName)){
            return new CollectionElement(this.getCollectionElementValue(element));
        }
        return null;
    }


    private Object getRefElementValue(Element element) {
        return element.attributeValue("bean");
    }

    private Object getValueElementValue(Element element) {
        return IocUtil.getValue(element.attributeValue("type"),element.getText());
    }

    private Collection getCollectionElementValue(Element element) {
        String type = element.attributeValue("type");
        Collection<Object> collection;
        List<Element> elements = element.elements();
        if("list".equals(type)){
            collection = new ArrayList<>();
        }else{
            collection = new HashSet<>();
        }
        for (Element e : elements) {
            LeafElement leafElement = null;
            if("value".equals(e.getName())){
                 leafElement =  new ValueElement(this.getValueElementValue(e));
            }else if("ref".equals(e.getName())){
                 leafElement = new RefElement(this.getRefElementValue(e));
            }
            if(leafElement!=null){
                collection.add(leafElement);
            }
        }
        return collection;
    }


}
