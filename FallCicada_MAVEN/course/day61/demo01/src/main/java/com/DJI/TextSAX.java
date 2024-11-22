package com.DJI;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/22/10:50
 * @LastEditors: 86138
 * @: 無限進步
 */
public class TextSAX {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        TextSAX textSAX = new TextSAX();
        String filepath="src/main/java/com/DJI/class.xml";
        textSAX.saxParse(filepath);
    }
    public void saxParse(String filePath) {
        //1. 创建工厂对象
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            //2. 创建解析器对象
            SAXParser saxParser = saxParserFactory.newSAXParser();
            //3. 解析xml文件    重写handler的方法    进行事件处理
            saxParser.parse(filePath, new DefaultHandler() {
                @Override
                public void startDocument() throws SAXException {
                    //TODO Auto-generated method stub
                    System.out.println("解析器发现了文档的开始标签-文档开头，开始解析文档");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("解析器发现了元素的开始标签-元素开始，开始解析元素");
//                    System.out.println("uri = " + uri);
//                    System.out.println("localName = " + localName);
                    System.out.println("qName = " + qName);
                    if (attributes.getLength() > 0) {
                        System.out.println("属性列表");
                        for (int i = 0; i < attributes.getLength(); i++) {
                            System.out.println(attributes.getQName(i) + " = " + attributes.getValue(i));
                        }
                    }


                }
                @Override
                public void endDocument() throws SAXException {
                    System.out.println("解析器发现了文档的结束标签-文档结束，解析文档结束");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
