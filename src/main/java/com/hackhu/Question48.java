package com.hackhu;

class Father {
    private static Father single = new Father();
    public static Father getFather() {
        return single;
    }
    private Father() { }
}

/**
 * 题：设计一个不能被继承的类
 * 根据单例模式思想，创建一个私有构造器的类，无法被继承（子类对象需要要先调用父类的构造方法）
 */
public class Question48 {

}
