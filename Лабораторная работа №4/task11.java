package com.company;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;

public class task11 {
    public static boolean cpv(String str1, String str2) {
        boolean y1 = false;
        if (str1.charAt(0) == str2.charAt(0))
            y1 = true;
        return y1;
    }

    public task11(String Str) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        //Object o =engine.eval(code);
        StringBuilder str1 = new StringBuilder();
        Stack stk = new Stack();
        Stack stk2 = new Stack();
        for (int i = 0; i < Str.length(); i++) {
            stk.add(Str.charAt(i));
            //System.out.println(stk.peek());
        }
        for (int i = 0; i < Str.length(); i++) {
            stk2.add(stk.pop());
            //System.out.println(stk.peek());
        }
        for (int i = 0; i < Str.length(); i++) {
            if (cpv(stk2.peek().toString(), "x"))
                str1.append("1");
            if (cpv(stk2.peek().toString(), "y"))
                str1.append("2");
            if (cpv(stk2.peek().toString(), "z"))
                str1.append("3");
            if (cpv(stk2.peek().toString(), "("))
                str1.append("( ");
            if (cpv(stk2.peek().toString(), ")"))
                str1.append(")");
            if (cpv(stk2.peek().toString(), "+"))
                str1.append("+");
            if (cpv(stk2.peek().toString(), "-"))
                str1.append("-");
            stk2.pop();
        }
        try {
            Object o = engine.eval(str1.toString());
            System.out.println("task11: true" );
        } catch (Throwable e) {
            System.out.println("task11: false" );
        }

    }
}
