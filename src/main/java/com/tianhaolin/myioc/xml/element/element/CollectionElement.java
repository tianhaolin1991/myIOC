package com.tianhaolin.myioc.xml.element.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * 这里我们使用的是组合模式，一个集合元素本身包含了多个叶子元素ref或者value
 * 本身可以不用实现LeafElement但是这里我们为了使CollectionElement和LeafElement
 * 以同样的方式被处理所以我们实现了LeafElement
 * @author rongdi
 */
public class CollectionElement implements LeafElement {

    private Object value;

    public CollectionElement(Collection collection){
        this.value = collection;
    }

    @Override
    public LeafType getType() {
        return LeafType.COLLECTION;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
