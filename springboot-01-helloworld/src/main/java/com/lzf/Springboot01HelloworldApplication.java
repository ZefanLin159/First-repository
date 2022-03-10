package com.lzf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//标注这个类是一个springboot的应用，启动类下的所有资源被导入
@SpringBootApplication
public class Springboot01HelloworldApplication {
    //    SpringApplication类
//1、推断应用的类型是普通的项目还是Web项目
//2、查找并加载所有可用初始化器 ， 设置到initializers属性中
//3、找出所有的应用程序监听器，设置到listeners属性中
//4、推断并设置main方法的定义类，找到运行的主类
//    run方法
    public static void main(String[] args) {
        SpringApplication.run(Springboot01HelloworldApplication.class, args);
    }

}
