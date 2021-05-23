package com.company;

import java.util.Deque;
import java.util.LinkedList;

public class task1 {
    public static boolean cpv(String str1, String str2) {
        boolean y1 = false;
        int len=Math.min(str1.length(),str2.length());
        for (int i = 0; i < len; i++) {
                if(str1.charAt(i)>str2.charAt(i)){
                    return true;
                }
        }
        if(len==0)
            return true;
        return y1;
    }
    public static boolean cpv2(String str1, String str2) {
        boolean y1 = true;
        int len=Math.min(str1.length(),str2.length());
        for (int i = 0; i < len; i++) {
            if(str1.charAt(i)!=str2.charAt(i)){
                return false;
            }
        }
        return y1;
    }

    public task1(String Str) {
        String[] words = Str.split(" ");
        Deque a = new LinkedList();
        Deque b = new LinkedList();
        for (int i = 0; i < words.length; i++) {
            a.push(words[i]);
        }
        String str = " ";
        while (!a.isEmpty()) {
            for (int i = 0; i < a.size(); i++) {
                if (cpv(str, a.peekFirst().toString())) {
                    str = a.peekFirst().toString();
                }
                a.addLast(a.removeFirst());
            }
            for (int i = 0; i < a.size(); i++) {
                if (cpv2(str, a.peekFirst().toString())) {
                    a.removeFirst();
                    break;
                }
                a.addLast(a.removeFirst());
            }
            b.addLast(str);
            str="";
        }
        System.out.print("task1: ");
        while (!b.isEmpty()){
            System.out.print(b.removeFirst()+" ");
        }
    }
}
