package com.learning;

public class LinkedList<E>  implements ListI {

    Node head;
    int currentSize = 0;

    public void addFirst(E data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        currentSize++;
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
    }
}
