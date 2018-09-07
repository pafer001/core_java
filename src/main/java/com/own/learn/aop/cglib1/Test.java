package com.own.learn.aop.cglib1;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class Test {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./tmp");
        //实例化一个增强器，也就是cglib中的一个class generator
        Enhancer eh = new Enhancer();
        //设置目标类
        eh.setSuperclass(Target.class);
        // 设置拦截对象
        eh.setCallback(new Interceptor());
        // 生成代理类并返回一个实例
        Target t = (Target) eh.create();
        t.f();
        t.g();
    }
}
