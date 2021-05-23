package com.company;

import java.util.Deque;

public class task2 {
    public static boolean cpv(String str1, String str2) {
        boolean y1 = false;
        if (str1.charAt(0) == str2.charAt(0))
            y1 = true;
        return y1;
    }

    public task2(Deque dec, String str) {
        String str1 = "";
        for (int i = 0; i < str.length(); i++) {
            while (str1.length() < i + 1) {
                if (cpv(Character.toString(str.charAt(i)), dec.peekLast().toString())) {
                    dec.add(dec.pop());
                    dec.add(dec.pop());

                    str1 += dec.peekLast();
                }
                dec.add(dec.pop());
            }
        }
        System.out.println("task2: " + str1);
    }

}
