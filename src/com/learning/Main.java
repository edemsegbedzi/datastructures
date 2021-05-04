package com.learning;

public class Main {

    public static void main(String[] args) {
	// write your code here

        LinkedList linkedList = new LinkedList();
        linkedList.addLast("E");
        linkedList.addFirst("D");
        linkedList.addFirst("C");
        linkedList.addFirst("B");
        linkedList.addFirst("A");
        linkedList.addLast("E");
        linkedList.addLast("F");


        linkedList.printAll();
    }
}
