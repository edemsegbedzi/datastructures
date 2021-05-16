package com.learning;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E>  implements ListI,Iterable {

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

    public E removeLast(){
        if(currentSize == 0){
            return null;
        }else if (currentSize ==1){
            Object data = head.data;
            head = tail = null;
            return (E) data;
        }else {
            Node temp = head;
            while (temp.next != tail){
                temp = temp.next;
            }
            E data = (E) tail.data;
            tail = temp;
            tail.next = null;
            return data;
        }
    }

    public E removeFirst(){
        if(currentSize == 0){
            return null;
        }else if(currentSize == 1){
            E data = (E) head.data;
            tail = head = null;
            currentSize --;
            return data;
        }else {
            E data = (E) head.data;
            head = head.next;
            currentSize --;
            return data;
        }
    }

    public boolean contains(E data){
        if(head== null) return false;

        Node temp = head;

        while (temp != null){
            if(((Comparable<E>) data).compareTo((E) temp.data) == 0){
                return true;
            }
            temp = temp.next;
        }
        return  false;
    }

    public E remove (E data){

        Node current = head;
        Node previous = null;

        while( current != null){

            if(((Comparable<E> ) data).compareTo( (E) current.data) == 0){

                if(currentSize == 1){
                    return  removeFirst();
                }else if(current.next == null){
                    return removeLast();
                }
                currentSize --;
                previous.next = current.next;
                return (E) current.data;
            }else {
                previous = current;
                current = current.next;
            }

        }
        return null;
    }

    public E find (E data){
        Node current = head;

        while (current != null){
            if(((Comparable<E>)data).compareTo((E) data) == 0){
                return (E) current.data;
            }
            current = current.next;
        }
        return null;
    }

    public E peekFirst(){
        if(head == null) return null;

        return (E) head.data;
    }

    public E peekLast(){
        if(tail == null) return  null;

        return (E) tail.data;
    }

    @Override
    public Iterator iterator() {
        return new IteratorHelper();
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

    class IteratorHelper<E> implements Iterator<E>{

        Node index;

        IteratorHelper(){
            index = head;
        }


        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public E next() {
            if(hasNext()){
                E data = (E) index.data;
                index = index.next;
                return data;
            }
            throw new NoSuchElementException();
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
