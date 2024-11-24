package com.DJI;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.Writer;
import java.io.FileWriter;
import java.util.List;

/*
 * @Description: xml解析
 * @Author: FallCicada
 * @Date: 2024/11/22/11:25
  * @LastEditors: FallCicada
 * @: 無限進步
 */

public class TestDomJ {
    public static void main(String[] args) {
        TestDomJ testDomJ = new TestDomJ();
        String filePath = "src/main/java/com/DJI/class.xml";
        File file = new File(filePath);

        try {
            Document document = testDomJ.parse(file);
//            System.out.println("document : " + document);
            //调用自定义方法 处理文档对像
            testDomJ.handler(document);
            testDomJ.createDocument();
            Document document1 = testDomJ.createDocument();
            testDomJ.createXml(document1);
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
    //main方法中不放太多业务逻辑，所以将这些代码提取出来
    public void handler(Document document) {
        System.out.println("handler : " + document);

        List<Node> list= document.selectNodes("//age");
        list.forEach(node -> System.out.println(node.getName() + " : " + node.getText()));
    }

    public Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root =document.addElement("root");
        Element stu =root.addElement("stu").addAttribute("id","2024005")
                .addAttribute("gender","0");
        stu.addElement("name").addText("韩雪松");
        stu.addElement("age").addText("23");
        return document;
    }
    public void createXml(Document document) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/java/com/DJI/new.xml");
            document.write(fileWriter);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
