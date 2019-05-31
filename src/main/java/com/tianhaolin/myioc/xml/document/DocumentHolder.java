package com.tianhaolin.myioc.xml.document;


import org.dom4j.Document;

public interface DocumentHolder {

    /**
     * @description 用于获取filePath的xml文件解析结果
     * @param: filePath
     * @return org.dom4j.Document
     * @date 2019/5/30 0030 10:09
     */
    Document getDocument(String filePath);
}
