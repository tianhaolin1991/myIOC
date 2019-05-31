package com.tianhaolin.myioc.xml.element.element;

/**是最基础的Element
 * @author:tianhaolin
 * @version:1.0
 */
public interface LeafElement  {

    /**
     * @description 得到相关信息,是ref标签还是value标签
     * @param:
     * @return java.lang.String
     * @date 2019/5/30 0030 13:46
     */
    LeafType getType();

    /**取得<value type="">value</value>的value值
     * @description
     * @param:
     * @return java.lang.Object
     * @date 2019/5/30 0030 13:46
     */
    Object getValue();

}
