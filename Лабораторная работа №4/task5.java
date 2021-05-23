package com.company;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class task5  {
    public task5 (String str) {
        Deque stc = new LinkedList();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='[')
                stc.push(str.charAt(i));
            else if(str.charAt(i)==']'&&!stc.isEmpty())
                stc.remove();
        }
        if(stc.size()==0)
            System.out.println("Task5: true");
        else
            System.out.println("Task5: false");
    }
}
