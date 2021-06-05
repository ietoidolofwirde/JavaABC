package com.grand.ch06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {
    private Object target;

    /*
    * constructs a TraceHandler
    * @param t the implicit parameter of the method call
    * */
    public TraceHandler(Object t){
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(target.getClass().getName());
        System.out.print(target);
        //print the method name
        System.out.print("." + method.getName()+"(");
        //print explict arguments
        if(args != null){
            for(int i=0;i<args.length;i++){
                System.out.print(args[i]);
                if(i<args.length -1) System.out.print(",");
            }
        }
        System.out.println(")");
        return method.invoke(target,args);
    }
}
