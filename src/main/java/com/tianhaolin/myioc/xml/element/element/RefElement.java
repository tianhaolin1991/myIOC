package com.tianhaolin.myioc.xml.element.element;

/**RefElement
 * @author:tianhaolin
 * @version:1.0
 */

public class RefElement implements LeafElement {

    private Object value;

    public RefElement(Object value){
        this.value = value;
    };

    @Override
    public LeafType getType() {
        return LeafType.REF;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

}
