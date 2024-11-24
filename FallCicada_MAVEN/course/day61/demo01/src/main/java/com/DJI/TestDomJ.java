package com.DJI;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

/*
 * @Description: xml解析
 * @Author: FallCicada
 * @Date: 2024/11/22/11:25
 * @LastEditors: 86138
 * @: 無限進步
 */
public class TestDomJ {
    public static void main(String[] args) {
        System.out.println("hello Copilot");

        TestDomJ testDomJ = new TestDomJ();
        String filePath = "src/main/java/com/DJI/class.xml";
        try {
            Document document = testDomJ.parse(new File(filePath));
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    //获取dom4j的文档对象
    public Document parse(File file) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        return document;
    }

}
