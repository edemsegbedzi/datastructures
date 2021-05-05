package com.learning;


public class LinkedList<E>  implements ListI {

    Node head;
    Node tail;
    int currentSize = 0;

    public void addFirst(E data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        currentSize++;
        if(currentSize == 1){
            tail = node;
        }
    }

    // Has a Big O of O(n)
//    public void addLast(E data){
//        if(head == null){
//            head = new Node(data);
//            currentSize++;
//            return;
//        }
//        Node temp = head;
//        while(temp.next != null){
//            temp = temp.next;
//        }
//        temp.next = new Node(data);
//        currentSize++;
//    }


    //has a big O of O(1)
    public void addLast(E data){
        Node node = new Node(data);
        if(head == null){
            head = tail = node;
            currentSize ++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize ++;
    }

    public Object removeLast(){
        if(currentSize == 0){
            return null;
        }else if (currentSize ==1){
            Object data = head.data;
            head = tail = null;
            return data;
        }else {
            Node temp = head;
            while (temp.next != tail){
                temp = temp.next;
            }
            Object data = tail.data;
            tail = temp;
            tail.next = null;
            return data;
        }
    }


    class Node<E>{
        Node<E> next;
        E data;

        public Node(E data) {
            this.data = data;
            next = null;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node {" +
                    "next=" + next +
                    ", data=" + data +
                    '}';
        }
    }

    public void printAll(){
        if(currentSize == 0){
            System.out.println("Empty List");
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
