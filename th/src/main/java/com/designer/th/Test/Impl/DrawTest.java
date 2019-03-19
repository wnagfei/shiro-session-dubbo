package com.designer.th.Test.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawTest {
    public static void main(String[] args) {
        Account acct = new Account("0329", 1000);

        new DrawThread("老张", acct, 800).start();
        new DrawThread("老王", acct, 800).start();
    }
}
