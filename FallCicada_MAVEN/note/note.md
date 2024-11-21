<!--
 * @Description: 
 * @Author: FallCicada
 * @Date: 2024-11-20 10:30:35
 * @LastEditors: FallCicada
 * @LastEditTime: 2024-11-21 10:21:37
 * @: 無限進步
-->
# Maven
## 介绍
    是apache旗下的开源项目 是用于管理和构建Java项目的工具
## 作用
1. 管理项目依赖 jar包
   1. 方便快捷的管理jar包
   2. 项目需要的依赖能够快速下载
   3. 依赖的依赖也自动下载
      + pom.xml 
      + .xml
2. 统一项目结构 各种构建工具创建(idea ecplise sts)的Java项目目录不太一致，而Mavem创建的项目目录是统一的
3. 项目构建
提供了标准的、跨平台的自动化项目构建方式

项目清理 => 再去编译 => 测试 => 报告 => 打包 => 安装 => 部署
1. 清理[clean]：将旧的字节码文件删除
2. 编译[compile]：将java源代码编译成.class文件
3. 测试[test (Junit)]：自动调用junit程序测试
4. 报告[report]：程序执行的结果
5. 打包[package]：Java程序打包时(类型：jar包 war包）
6. 安装[install]：maven的特定概念，将打包好的jar包复制到Maven仓库中的指定位置
7. 部署[deploy]：将打包好的jar包复制到容器或者服务器中，使其可以运行
>Maven仓库：本地仓库，Maven仓库是maven的存储库，时多个项目公用的
### 下载
[MAVEN官网](https://maven.apache.org/)
### 安装&配置
1. 免安装
2. 配置环境变量
```
MAVEN_HOME = 软件实际路径
PATH = %MAVEN_HOME%\bin
```
3. 三个确定点掉
4. 打开新的终端检测
```
mvn -v
mvn --version
```
### idea集成maven
如果想在idea中使用maven，需要做两件事情
>方式1：可以使用自己电脑上已经安装好的maven环境3.8.8 
>
>方式2：idea本身也可以提供maven环境
#### idea新建maven项目
>1. 新建项目
>2. Java 
>3. 项目名称 maven-test
>4. 位置 /briup/maven/day01/
>5. 选择是否创建git仓库
>6. 构建系统 Maven 
>7. JDK  1.8
>8. 添加示例代码
>9. 高级设置
>
>       组ID（公司域名倒写）：com.briup
>
>       工件ID：和项目名相同
>
>       点击Create
#### 运行jar包的命令
    java -jar jar包名字.jar 
    
### maven仓库
>本地仓库 maven的仓库是多个项目共用的
>
>所以里面的依赖会比较多
### maven目录结构说明
```java
maven-project/
├── src
│   └── main => 实际项目资源
│        ├── java => java源代码目录
│        └── resources => 配置文件目录
├── test
│    ├── java => 测试项目资源
│    └── resources
└── pom.xml => 项目配置文件
```
#### pom.xml
Project Object Model 项目对象模型
### 范围
<scope>compile</scope>
1. 默认值 compile 适用于所有阶段

    开发、测试、部署、运行
    
2. provided 开发、测试阶段使用
    
    打包的时候 不需要打包这些依赖
    
3. runtime 运行时 比如：jdbc驱动

4. test 测试时 Junit

### 生命周期 lifecycle 
maven项目中有三套生命周期，了解主要阶段

maven对项目构建的生命周期划分为

`clean`,`default`,`site`
    
- 清理 `clean`  
- 测试 `test` （junit） 编译 、测试
- 打包 `package` 打包的类型：jar war
- 安装 `install`：maven的特定概念，将打包的文件
  
idea为了快速使用maven生命周期 提供了一个工具栏 给出了快速访问通
#### 生命周期如何执行
方法1 ：双击idea中的快速通道按钮
    
方法2 ：通过maven命令执行 
```
      mvn clean 
      mvn compile 
      mvn test 
      mav package 
      mvn install 
      ...
```
## XML
+ <font size=10>**.xml**</font>
  + 文件后缀为 .xml
  + 和html类似
  + .html : 超文本标记语言
  + .xml : 可扩展标记语言 EXtensible Markup Language
    + 可扩展    ：指用户可以自定义标签
    + 标记语言  ：标签语言 可以使用一系列的标签来对数据进行描述 
    ```xml
     <version>1.0</version>
    ``` 
  + CSS 层叠样式表
#### 作用
1. 作为配置文件  （类似json文件） 

    很多软件和框架，都会提供xml类型的配置文件，以便快捷的修改软件或框架的功能

2. 作为数据传输标准 

    作为数据的一种传输标准，要考虑可读性、可扩展性、可维护性，并且最好是和语言无关。

3. 持久化数据 

    可以将数据临时写入xml文件中，作为临时数据库

4. 简化了平台变更

    990在系统更换平台的时候，普通的数据会存在不兼容的情况，但是xml更容易扩展和升级
#### 历史 
+ 1969年 GML 通用标记语言 

    用于计算机之间通信 数据传输 

+ 1985年 SGML 标准通用标记语言

    对GML的完善

+ 1993年 HTML 超文本标记语言

    随着万维网的推广，在SGML的基础上，出现了HTML语言，用于网页展示

+ 1998年 XML 可扩展标记语言 

    HTML语言的标记不能自定义，W3C组织在推出XML的时候，是想替代HTML的，但是两种语言还有差异，所以出现了一个过渡语言XHTML

    但是实际上很难替代 HTML语言使用比较广泛

#### 对比 
+ XML主要是用来 描述 数据
+ HTML主要是  展示 数据  

#### 语法
##### 3.1 文档声明 需要放到文档的第一行
```xml
<?xml version="1.0" encoding="UTF-8"?>
```
##### 3.2 元素 指的就是xml中的标记（标签、节点）
命名规则：
    
- 可以包含字母、数字以及其它一些可见字符
- 不能以数字开头
- 不能包含空格、冒号、分号、逗号、尖括号等特殊字符
- 标签必须成对出现
- 根元素有且只有一个，是其他所有元素的父元素
- 大小写敏感，必须使用相同的大小写状态来开始和结束标签
```xml
    <!--可以的：-->
      <a></a>
      <A></A>
    <!--不可以的：-->
      <A></a>
      <a></A>
  <!--允许多层嵌套但是不允许交叉嵌套-->
    <message>
      <a></a>
    </message>
    <message>
      <a>
    </message>
      </a>
  <!--元素的开始标签和结束标签之间的内容叫标签体，标签体可有可无-->
    <a>标签体</a>
    <a></a>
```
###### 实体
|  实体  |字符| 简介|
|:-----:|:---:|:---------:|
|`&lt;` |  <  |Less than  |
|`&gt;` |  >  |Greater than| 
|`&amp;`|  &  |Ampersand|
|`&apos`|  '  |Apostrophe|
|`&quot`|  "  |Quotation mark|
|`&nbsp;`|     |Non-breaking space|
|`&cent;` |  ¢  |Cent sign|
|`&pound;`|  £  |Pound sign|
|`&yen;`  |  ¥  |Yen sign|
|`&euro;`|  €  |Euro sign|
|`&sect;`|  §  |Section sign|
|`&copy;`|  ©  |Copyright sign|
|`&reg;` |  ®  |Registered sign|
|`&trade;`| ™  |Trademark sign|
|`&iexcl;`|  ¡  |Inverted exclamation mark|
|`&laquo;`|  «  |Left-pointing double angle quotation mark|
|`&raquo;`|  »  |Right-pointing double angle quotation mark|
|`&para;` |  ¶  |Pilcrow sign|
|`&middot;`| ·  |Middle dot|
|`&iquest;`|  ¿  |Inverted question mark|
|`&times;`|  ×  |Multiplication sign|
|`&divide;`| ÷  |Division sign|
x'm'l'
##### 3.3 属性 
属性值写到开始标签中 属性值必须加引号 可以是单引号也可以是双引号
```xml
          <person gender="male"></person>
          <person gender='male'></person>
```
可以有多个属性值
```xml
          <person gender='male' age="18" name="张三"></person>
```
有多个同名标签时，可以用id区分
##### 3.4 示例 
描述以下数据 
- 一条消息 
- 发送日期 2024-11-21 
- 发送人 tom 
- 收信人 jerry 
- 信息内容 下来吃午饭
##### 3.5 实体 
- 内置 预定义的实体 &lt;
- 自定义实体 
##### 3.6 注释
- `<!-- 注释内容 -->`
- 注释内容中不能出现 --
-   `<!-- --  -->`
- 开始标签或者结束标签中不能使用注释
- 注释不可以嵌套使用
###### CSS
- 标签选择器 
- ID选择器
- 类选择器？    


