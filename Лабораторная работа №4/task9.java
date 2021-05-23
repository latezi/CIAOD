package com.company;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;

public class task9 {
    public static boolean cpv(String str1,String str2){
        boolean y1=false;
        if(str1.charAt(0)==str2.charAt(0))
            y1=true;
        return y1;
    }

    public task9(String Str) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        StringBuilder str1 = new StringBuilder();
        Stack stk= new Stack();
        Stack stk2 = new Stack();
        for (int i = 0; i < Str.length(); i++) {
            stk.add(Str.charAt(i));
        }
        for (int i = 0; i < Str.length(); i++) {
            stk2.add(stk.pop());
        }
        for (int i = 0; i < Str.length(); i++) {
            if (cpv(stk2.peek().toString(), "T"))
                str1.append("true ");
            if (cpv(stk2.peek().toString(), "F"))
                str1.append("false ");
            if (cpv(stk2.peek().toString(), "N"))
                str1.append("! ");
            if (cpv(stk2.peek().toString(), "A") || cpv(stk2.peek().toString(), "*"))
                str1.append("&& ");
            if (cpv(stk2.peek().toString(), "X"))
                str1.append("!= ");
            if (cpv(stk2.peek().toString(), "O") || cpv(stk2.peek().toString(), "+"))
                str1.append("|| ");
            if (cpv(stk2.peek().toString(), "("))
                str1.append("( ");
            if (cpv(stk2.peek().toString(), ")"))
                str1.append(")");
            stk2.pop();
        }

        Object o =engine.eval(str1.toString());
        System.out.println("task9: "+o);
    }
}
