package com.tianhaolin.myioc.xml.create;

/**创建Bean
 * @author:tianhaolin
 * @version:1.0
 */
public interface BeanCreator {

    /**
     * @description 使用无参构造创建Bean
     * @param: clazz
     * @return T
     * @date 2019/5/30 0030 18:05
     */
    <T> T createBeanWithDefaultConstructor(Class<T> clazz);

    /**
     * @description 使用有参构造创建Bean
     * @param: clazz
     * @param: args
     * @return T
     * @date 2019/5/30 0030 18:05
     */
    <T> T createBeanWithDefinedConstructor(Class<T> clazz,Object... args);
}
