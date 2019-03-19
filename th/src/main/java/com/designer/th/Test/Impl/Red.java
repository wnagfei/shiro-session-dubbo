package com.designer.th.Test.Impl;

import com.designer.th.Test.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Red implements Color {

    @Override
    public void fill() {

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new Vector<>();
		list.add(1);
		list.add(2);
		list.add(3);
		// 直接打印
		list.forEach(System.out::println);
        list.forEach(i -> {list1.add(i);});
        Runnable r1 = () -> {System.out.println("Hello Lambda!");};
        list1.forEach(System.out::println);
        // 取值分别操作
		list.forEach(i -> {System.out.println(i * 3);});
    }

}
