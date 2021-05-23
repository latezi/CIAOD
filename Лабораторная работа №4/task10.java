package com.company;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;

public class task10 {
    public static boolean cpv(String str1, String str2) {
        boolean y1 = false;
        if (str1.charAt(0) == str2.charAt(0))
            y1 = true;
        return y1;
    }

    public task10(String Str) throws ScriptException {
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
            if (cpv(stk2.peek().toString(), "0"))
                str1.append("0");
            if (cpv(stk2.peek().toString(), "1"))
                str1.append("1");
            if (cpv(stk2.peek().toString(), "2"))
                str1.append("2");
            if (cpv(stk2.peek().toString(), "3"))
                str1.append("3");
            if (cpv(stk2.peek().toString(), "4"))
                str1.append("4");
            if (cpv(stk2.peek().toString(), "5"))
                str1.append("5");
            if (cpv(stk2.peek().toString(), "6"))
                str1.append("6");
            if (cpv(stk2.peek().toString(), "7"))
                str1.append("7");
            if (cpv(stk2.peek().toString(), "8"))
                str1.append("8");
            if (cpv(stk2.peek().toString(), "9"))
                str1.append("9");
            if (cpv(stk2.peek().toString(), "M"))
                str1.append("Math.max");
            if (cpv(stk2.peek().toString(), "N"))
                str1.append("Math.min");
            if (cpv(stk2.peek().toString(), ","))
                str1.append(",");
            if (cpv(stk2.peek().toString(), "("))
                str1.append("( ");
            if (cpv(stk2.peek().toString(), ")"))
                str1.append(")");
            stk2.pop();
        }

        Object o = engine.eval(str1.toString());
        System.out.println("task10: " + o);
    }
}
