
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    //1. 使用dom解析方式 解析xml文件
    public void domParse(String filePath){
        //2. 创建一个DocumentBuilderFactory对象
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //解析xml文件
        try{
            //通过工厂创建解析器对象
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            //3.
            Document document = documentBuilder.parse(filePath);
            //获取根元素
            Element root = document.getDocumentElement;
            System.out.println("root = " + root);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}