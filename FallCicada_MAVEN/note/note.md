<!--
 * @Description: 
 * @Author: FallCicada
 * @Date: 2024-11-20 10:30:35
 * @LastEditors: FallCicada
 * @LastEditTime: 2024-11-24 16:17:46
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
│   ── main => 实际项目资源
│        ├── java => java源代码目录
│        └── resources => 配置文件目录
├── test
│    ├── java => 测试项目资源
│    └── resources
└── pom.xml => 项目配置文件
```
完整配置文件
```xml
├──  pom.xml                               # Maven 项目管理文件 
├──  src
    ├──  main                              # 项目主要代码
    │   ├──  java                          # Java 源代码目录
    │   │   └──  com/example/myapp         # 开发者代码主目录
    │   │       ├──  controller            # 存放 Controller 层代码的目录
    │   │       ├──  service               # 存放 Service 层代码的目录
    │   │       ├──  dao                   # 存放 DAO 层代码的目录
    │   │       └──  model                 # 存放数据模型的目录
    │   ├──  resources                     # 资源目录，存放配置文件、静态资源等
    │   │   ├──  log4j.properties          # 日志配置文件
    │   │   ├──  spring-mybatis.xml        # Spring Mybatis 配置文件
    │   │   └──  static                    # 存放静态资源的目录
    │   │       ├──  css                   # 存放 CSS 文件的目录
    │   │       ├──  js                    # 存放 JavaScript 文件的目录
    │   │       └──  images                # 存放图片资源的目录
    │   └──  webapp                        # 存放 WEB 相关配置和资源
    │       ├──  WEB-INF                   # 存放 WEB 应用配置文件
    │       │   ├──  web.xml               # Web 应用的部署描述文件
    │       │   └──  classes               # 存放编译后的 class 文件
    │       └──  index.html                # Web 应用入口页面
    └──  test                              # 项目测试代码
        ├──  java                          # 单元测试目录
        └──  resources                     # 测试资源目录
```

-   pom.xml：Maven 项目管理文件，用于描述项目的依赖和构建配置等信息。
-   src/main/java：存放项目的 Java 源代码。
-   src/main/resources：存放项目的资源文件，如配置文件、静态资源等。
-   src/main/webapp/WEB-INF：存放 Web 应用的配置文件。
-   src/main/webapp/index.jsp：Web 应用的入口页面。
-   src/test/java：存放项目的测试代码。
-   src/test/resources：存放测试相关的资源文件，如测试配置文件等。

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

| 依赖范围     | 描述                                                         |
| ------------ | ------------------------------------------------------------ |
| **`compile`**  | 编译依赖范围，scope 元素的缺省值。使用此依赖范围的 Maven 依赖，对于三种 classpath 均有效，即该 Maven 依赖在上述三种 classpath 均会被引入。例如，log4j 在编译、测试、运行过程都是必须的。 |
| **`test`**     | 测试依赖范围。使用此依赖范围的 Maven 依赖，只对测试 classpath 有效。例如，Junit 依赖只有在测试阶段才需要。 |
| **`provided`** | 已提供依赖范围。使用此依赖范围的 Maven 依赖，只对编译 classpath 和测试 classpath 有效。例如，servlet-api 依赖对于编译、测试阶段而言是需要的，但是运行阶段，由于外部容器已经提供，故不需要 Maven 重复引入该依赖。 |
| **`runtime`**      | 运行时依赖范围。使用此依赖范围的 Maven 依赖，只对测试 classpath、运行 classpath 有效。例如，JDBC 驱动实现依赖，其在编译时只需 JDK 提供的 JDBC 接口即可，只有测试、运行阶段才需要实现了 JDBC 接口的驱动。 |
| **`system`**       | 系统依赖范围，其效果与 provided 的依赖范围一致。其用于添加非 Maven 仓库的本地依赖，通过依赖元素 dependency 中的 systemPath 元素指定本地依赖的路径。鉴于使用其会导致项目的可移植性降低，一般不推荐使用。 |
| **`import`**       | 导入依赖范围，该依赖范围只能与 dependencyManagement 元素配合使用，其功能是将目标 pom.xml 文件中 dependencyManagement 的配置导入合并到当前 pom.xml 的 dependencyManagement 中。 |
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
| 命令        | 描述                        |
| ----------- | --------------------------- |
| mvn help    | 显示帮助信息                |
| mvn compile | 编译项目，生成target文件    |
| mvn package | 打包项目，生成jar或war文件  |
| mvn clean   | 清理编译或打包后的项目结构  |
| mvn install | 打包后上传到maven本地仓库   |
| mvn deploy  | 只打包，上传到maven私服仓库 |
| mvn site    | 生成站点                    |
| mvn test    | 执行测试源码                |
# XML
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
## 作用
1. 作为配置文件  （类似json文件） 

    很多软件和框架，都会提供xml类型的配置文件，以便快捷的修改软件或框架的功能

2. 作为数据传输标准 

    作为数据的一种传输标准，要考虑可读性、可扩展性、可维护性，并且最好是和语言无关。

3. 持久化数据 

    可以将数据临时写入xml文件中，作为临时数据库

4. 简化了平台变更

    990在系统更换平台的时候，普通的数据会存在不兼容的情况，但是xml更容易扩展和升级
## 历史 
+ 1969年 GML 通用标记语言 

    用于计算机之间通信 数据传输 

+ 1985年 SGML 标准通用标记语言

    对GML的完善

+ 1993年 HTML 超文本标记语言

    随着万维网的推广，在SGML的基础上，出现了HTML语言，用于网页展示

+ 1998年 XML 可扩展标记语言 

    HTML语言的标记不能自定义，W3C组织在推出XML的时候，是想替代HTML的，但是两种语言还有差异，所以出现了一个过渡语言XHTML

    但是实际上很难替代 HTML语言使用比较广泛

## 对比 
+ XML主要是用来 描述 数据
+ HTML主要是  展示 数据  

## 语法
### 3.1 文档声明 需要放到文档的第一行
```xml
<?xml version="1.0" encoding="UTF-8"?>
```
### 3.2 元素 指的就是xml中的标记（标签、节点）
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
#### 实体
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

### 3.3 属性 
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
### 3.4 示例 
描述以下数据 
- 一条消息 
- 发送日期 2024-11-21 
- 发送人 tom 
- 收信人 jerry 
- 信息内容 下来吃午饭
### 3.5 实体 
- 内置 预定义的实体 &lt;
- 自定义实体 
### 3.6 注释
- `<!-- 注释内容 -->`
- 注释内容中不能出现 --
-   `<!-- --  -->`
- 开始标签或者结束标签中不能使用注释
- 注释不可以嵌套使用
#### CSS
- 标签选择器 
- ID选择器
- 类选择器？  
## 命名空间
- 前缀
- 声明前缀属于哪个命名空间
  - `xmlnx:x`
  - `xmlnx:y`
- 直接定义命名空间
  - `xmlnx = "XXXXXX"`  
- 作用：

  为了让自定义的标具有唯一行，不会和别人定义的标签有冲突
## 约束
需要让用户按照我们的要求编写XML文件内容的情况下就需要对XML文件内容做出约束

约束的方式有两种，语法不同，效果相同
- dtd文件
- schema文件

### 良构和有效
- 良构：

  XML文件内容，满足基本语法要求
- 有效：
  
  在良构的基础上，满足约束文件的验证，那么就是有效的

  有效的必定是良构  
### DTD(document type define)约束
- 描述并规定了元素、属性和其他内容在xml中的使用规则
- 文件后缀名.dtd
- 属性类型：
  1. CDATA：属性值可以是任何字符（包括数字和中文）
  2. ID：属性值必须唯一,属性值必须满足xml命名规则
  3. IDREF：属性的值指向文档中其它地方声明的ID类型的值。
  4. IDREFS:同IDREF，但是可以具有由空格分开的多个引用。
  5. enumerated：(枚举值1|枚举值2|枚举值3...)，属性值必须在枚举值中
- 属性特点：
  1. #REQUIRED(必填)：元素的所有示例都必须有该属性
  2. #IMPLIED ：属性可以不出现
  3. default-value ：属性可以不出现，但是会有默认值
  4. #FIXED ：属性可以不出现，但是如果出现的话必须是指定的属性值
## XML解析
XML解析的方式一般分为俩种：
* DOM解析
* SAX解析

#### DOM，（Document Object Model）文档对象模型，是 W3C 组织推荐的处理 XML 的一种方式。

使用DOM方式解析，要求解析器把整个XML文档装载到一个Document对象中。Document对象包含文档元素，即根元素，根元素包含N个子元素。

根据DOM的定义，XML 文档中的每个元素都是一个**节点（Node）**：
* XML文档只有一个根节点
* XML中每个元素都是一个元素节点
* XML中每个文本都是一个文本节点
* XML中每个属性都是一个属性节点
* XML中每个注释都是一个注释节点

DOM 把 XML 文档解析为一种树结构。这种树结构被称为节点树，通过这棵树可以访问任何一个节点，也可以修改或删除它们的内容，或者创建新的元素。

**优点**：一个XML文档使用DOM方式解析后，会得到一个Document对象，由于元素与元素之间还保存着结构关系，所以解析期间可以方便的针对元素对象进行各种操作。
          
**缺点**：但如果XML文档过大，那么需要把整个XML文档装载进内存，这时候会对内存空间要求比较高

#### 第二种 SAX (Simple Api for XML)
是xml社区的标准 使用率也比较高 几乎所有的解析器也都支持

使用SAX方式解析，每当读取一个开始标签、结束标签或者文本内容的时候，都会调用我们重写的一个指定方法，该方法中编写当前需要完成的解析操作。直到XML文档读取结束，在整个过程中，SAX解析方法不会在内存中保存节点的信息和关系。

**优点**：使用SAX解析方式，不会占用大量内存来保存XML文档数据和关系，效率高。

**缺点**：但是在解析过程中，不会保存节点信息和关系，并且只能从前往后，顺序读取、解析。

解析器 实现了解析方式的代码

JAXP （Java API for XMLProcessing），不借助于第三方jar包，使用JDK自带的API，就可以完成对XML文档的解析。

1. DOM 
2. SAX
#### Dom4J
是一个java的XML api 用来读写xml文件 性能优异 功能强大 开源免费

使用：
- 方式1：下载jar包 自己导入
- 方式2：maven项目
  - 可以读取xml文件
  - 可以创建xml文件