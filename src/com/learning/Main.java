package com.learning;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        LinkedList<String> linkedList = new LinkedList<String>();
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
////
//        for(String item : linkedList){
//            System.out.println(item);
//        }

        Hash<String , String > hashy = new Hash<>(10);
        hashy.add("a", "Alphabet");
        hashy.remove("a");
        hashy.add("b", "Baked beans");
        hashy.add("a", "Acrobat");
        hashy.add("a", "Awwww");
        System.out.println(hashy.getValue("b"));




       // linkedList.printAll();
    }
}
