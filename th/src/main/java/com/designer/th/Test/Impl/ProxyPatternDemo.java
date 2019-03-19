package com.designer.th.Test.Impl;

import java.util.Date;

public class ProxyPatternDemo {

    public static void main(String[] args) {
//      Image image = new ProxyImage("test_10mb.jpg");
        Business business = new LogProxy();
        business.addLog("Method方法被调用，调用时间" + new Date());
        // 图像将从磁盘加载
//      image.display();
//      System.out.println("");
//      // 图像不需要从磁盘加载
//      image.display();
    }
}