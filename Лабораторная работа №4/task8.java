package com.company;

import java.util.Stack;

public class task8 {
    public task8(String str) {
        String[] words = str.split(" ");
        Stack stc = new Stack();
        System.out.print("task8: ");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(stc.push(words[i]) + " ");
        }
    }
}
