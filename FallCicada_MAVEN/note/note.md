<!--
 * @Description: 
 * @Author: FallCicada
 * @Date: 2024-11-20 10:30:35
 * @LastEditors: FallCicada
 * @LastEditTime: 2024-11-20 17:19:49
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
        + 和html类似
        + html 超文本 标记语言
        + 可扩展语言
        + CSS 层叠样式表
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
  pom.xml文件补充