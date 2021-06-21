package com.learning;

public class Tree<E> {

    Node root;
    int currentSize;


    class Node<E>{
        E data;
        Node<E> right;
        Node<E> left;

         Node(E obj) {
            data = obj;
            right = null;
            left = null;
        }
    }


    public void add(E obj){
        if(root == null){
            root = new Node(obj);
        }else {
            add(obj,this.root);
        }
        currentSize ++;
    }

    private void add(E obj, Node<E> node){
        if(((Comparable<E>) obj).compareTo(node.data) >= 0){
            if(node.right == null){
                node.right = new Node<E>(obj);
                return;
            }else {
                add(obj,node.right);
            }
        }else{
            if(node.left == null){
                node.left = new Node<>(obj);
            }else {
                add(obj,node.left);
            }
        }
    }
}
