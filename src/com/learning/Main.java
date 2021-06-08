package com.learning;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        LinkedList linkedList = new LinkedList();
//        linkedList.addFirst("D");
//        linkedList.addFirst("C");
//        linkedList.addFirst("B");
//        linkedList.addFirst("A");
//        linkedList.addLast("E");
//        linkedList.addLast("F");
//        linkedList.removeLast();
//        linkedList.addLast("F");
//        linkedList.removeLast();
//        linkedList.addLast("F");
//        linkedList.removeFirst();
//        linkedList.remove("F");
//
//        for(Object item : linkedList){
//            System.out.println(item);
//        }

        Hash<String , String > hashy = new Hash<>(10);
        hashy.add("a", "Alphabet");
        hashy.remove("a");
        hashy.add("b", "Baked beans");
        hashy.add("a", "Acrobat");
        hashy.add("a", "Awwww");




       // linkedList.printAll();
    }
}
