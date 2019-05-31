package com.tianhaolin.myioc.xml.element.element;

import java.util.List;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class PropertyElement {

    private String name;

    private LeafElement leafElement;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LeafElement getLeafElement() {
        return this.leafElement;
    }

    public void setLeafElement(LeafElement leafElements) {
        this.leafElement = leafElements;
    }
}
