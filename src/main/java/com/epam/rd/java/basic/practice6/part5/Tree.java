package com.epam.rd.java.basic.practice6.part5;

import java.util.ArrayList;
import java.util.Arrays;

public class Tree<E extends Comparable<E>> {
    private Node<E> rootNode;

    public Tree() {
        rootNode = null;
    }

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
            E minKey = find_min(node.rightChild).getValue();
            node.setValue(minKey);
            node.rightChild = removeElement(node.rightChild, minKey);
            return node;
        }
    }

    public Node<E> find_min(Node<E> node) {
        if (node.leftChild != null) {
            return find_min(node.leftChild);
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
            for (int i = 0; i < temp.length; i++) {
                result.add("  "+ temp[i]);
            }
        }
        result.add(node.getValue().toString());
        if (node.rightChild != null) {
            Object [] temp = printNode(node.rightChild);
            for (int i = 0; i < temp.length; i++) {
                result.add("  " + temp[i]);
            }
        }
        return result.toArray();
    }

    public int calcHeight(Node<E> node) {
        if (node != null) {
            return node.height = Math.max(calcHeight(node.leftChild), calcHeight(node.rightChild)) + 1;
        } else {
            return -1;
        }
    }


    private static final class Node<E> {
        E value;
        Node<E> leftChild;
        Node<E> rightChild;
        Node<E> parent;
        int height = 0;


        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }


        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<E> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<E> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<E> rightChild) {
            this.rightChild = rightChild;
        }
    }

}
