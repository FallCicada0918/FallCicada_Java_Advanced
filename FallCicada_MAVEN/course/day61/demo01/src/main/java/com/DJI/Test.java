package com.DJI;
/*
 * @Description:
 * @Author: FallCicada
 * @Date: 2024/11/22/09:29
 * @LastEditors: 86138
 * @: 無限進步
 */
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Test test = new Test();
        String filpath="src/main/java/com/DJI/class.xml";
        test.domParse(filpath);

    }
    public static void domParse(String filePath){
        DocumentBuilderFactory builderfactory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder documentBuilder = builderfactory.newDocumentBuilder();
            Document document= documentBuilder.parse(filePath);
            Element root = document.getDocumentElement();
            System.out.println("root = " + root);
            NodeList childNodes = root.getChildNodes();
            for(int i = 0; i< childNodes.getLength(); i++){
                Node node = childNodes.item(i);
//                System.out.println(node.getNodeType());
//                System.out.println(node.getNodeName());
                if (node.getNodeType() == 1){
                    System.out.println(node.getNodeType());
                    System.out.println(node.getNodeName());
                    System.out.println(node.getAttributes());
                    NamedNodeMap attributes = node.getAttributes();
                    for (int j = 0; j< attributes.getLength(); j++){
                        Node attr = attributes.item(j);
                        String attrName = attr.getNodeName();
                        String attrValue = attr.getNodeValue();
                        System.out.println( attrName + " = " + attrValue);
                    }
                }
                //获取当前节点的子节点
                NodeList childNodeList = node.getChildNodes();
                for (int k = 0; k< childNodeList.getLength(); k++){
                    Node childNode = childNodeList.item(k);
                    //判断子节点是不是元素
                    if (childNode.getNodeType() == Node.ELEMENT_NODE){
                        System.out.println(childNode.getNodeName() + " = " + childNode.getTextContent());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
