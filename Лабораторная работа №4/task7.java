package com.company;

import java.lang.reflect.Array;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class task7 {
    public task7(int[] arr) {
        Deque deq= new LinkedList();
        for (int i=0;i<arr.length;i++){
            if(arr[i]<0)
                deq.addLast(arr[i]);
            else
                deq.addFirst(arr[i]);
        }
        System.out.print("task7: ");
        for (int i=0;i<arr.length;i++){
            System.out.print(" "+deq.removeLast());
        }
    }
}
