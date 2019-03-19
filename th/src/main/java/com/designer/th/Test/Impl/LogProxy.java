package com.designer.th.Test.Impl;

public class LogProxy implements Business {
    private Subject subject;
    private String output;

    public LogProxy() {

    }

    public LogProxy(String output) {
        this.output = output;
    }

    @Override
    public void addLog(String s) {
        if (subject == null) {
            subject = new Subject();
        }
        System.out.println(s);
        if (subject.getString() == "0") {
            System.out.println("Mehtod方法调用成功");
        } else
        {
            System.out.println("Mehtod方法调用失败");
        }

    }
}
