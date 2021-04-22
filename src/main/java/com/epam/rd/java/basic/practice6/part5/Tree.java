package com.epam.rd.java.basic.practice6.part5;

import java.util.ArrayList;

public class Tree<E extends Comparable<E>> {
    private Node<E> rootNode;

    public boolean add(E element) {
        rootNode = doInsert(rootNode, element);
        return rootNode != null;
    }

    public Node<E> doInsert(Node<E> node, E x) {
        if (node == null) {
            node = new Node<>();
            node.setValue(x);
            return node;
        }
        if (x.compareTo(node.getValue()) < 0) {
            node.leftChild = doInsert(node.leftChild, x);
        } else if (x.compareTo(node.getValue()) > 0) {
            node.rightChild = doInsert(node.rightChild, x);
        }
        if (x.compareTo(node.getValue()) == 0){
            return null;
        }
        return node;
    }


    public void add(E[] elements) {
        for (E e : elements) {
            add(e);
        }
    }

    public boolean remove(E element) {
        Node<E> node = removeElement(rootNode, element);
        return node != null;
    }

    public Node<E> removeElement(Node<E> node, E el) {
        if (node == null) {
            return null;
        }
        if (el.compareTo(node.getValue()) < 0) {
            node.leftChild = removeElement(node.leftChild, el);
            return node;
        } else if (el.compareTo(node.getValue()) > 0) {
            node.rightChild = removeElement(node.rightChild, el);
            return node;
        }
        if (node.leftChild == null) {
            return node.rightChild;
        } else if (node.rightChild == null) {
            return node.leftChild;
        } else {
            E minKey = findMin(node.rightChild).getValue();
            node.setValue(minKey);
            node.rightChild = removeElement(node.rightChild, minKey);
            return node;
        }
    }

    public Node<E> findMin(Node<E> node) {
        if (node.leftChild != null) {
            return findMin(node.leftChild);
        } else {
            return node;
        }
    }

    public void print() {
      Object [] result = printNode(rootNode);
      for (Object o : result){
          System.out.println(o.toString());
      }
    }

    public Object [] printNode(Node<E> node) {
        ArrayList<String> result = new ArrayList<>();
        if (node.leftChild != null) {
            Object [] temp = printNode(node.leftChild);
            for (Object o : temp) {
                result.add("  " + o);
            }
        }
        result.add(node.getValue().toString());
        if (node.rightChild != null) {
            Object [] temp = printNode(node.rightChild);
            for (Object o : temp) {
                result.add("  " + o);
            }
        }
        return result.toArray();
    }


    private static final class Node<E> {
        E value;
        Node<E> leftChild;
        Node<E> rightChild;

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

    }

}
