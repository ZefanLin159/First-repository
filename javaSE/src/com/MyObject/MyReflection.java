package com.MyObject;

import java.lang.reflect.Modifier;
import java.util.Scanner;

public class MyReflection {
    public static void main(String[] args) {
        String name;
        if (args.length > 0) name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date):");
            name = in.next();
        }

        try {
            Class cl = Class.forName(name);
            Class superCl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print("class" + name);
                if (superCl != null && superCl != Object.class)
                    System.out.print("extends " + superCl.getName());
                //未完成
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
