package com.tianhaolin.myioc.xml.element.element;

import sun.awt.SunHints;

/**
 * @author:tianhaolin
 * @version:1.0
 */
public class ValueElement implements LeafElement {

    private Object value;

    public ValueElement(Object value){
        this.value = value;
    };

    @Override
    public LeafType getType() {
        return LeafType.VALUE;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

}
