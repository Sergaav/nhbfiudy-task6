package com.epam.rd.java.basic.practice6.part5;

import java.util.Stack;
import java.util.TreeMap;

public class Tree<E extends Comparable<E>> {
    private Node<E> rootNode;

    public Tree() {
        rootNode = null;
    }

    public boolean add(E element) {
        Node<E> newNode = new Node<>();
        newNode.setValue(element);
        if (rootNode == null) {
            rootNode = newNode;
        } else {
            Node<E> currentNode = rootNode;
            Node<E> parentNode;
            while (true) {
                parentNode = currentNode;
                if (element == currentNode.getValue()) {
                    return false;
                } else if (element.compareTo(currentNode.getValue()) < 0) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parentNode.setLeftChild(newNode);
                        return true;
                    }
                } else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parentNode.setRightChild(newNode);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public void add(E[] elements) {
        for (E e : elements) {
            add(e);
        }
    }

    public boolean remove(E element) {
        Node<E> currentNode = rootNode;
        Node<E> parentNode = rootNode;
        boolean isLeftChild = true;
        while (currentNode.getValue() != element) {
            parentNode = currentNode;
            if (element.compareTo(currentNode.getValue()) < 0) {
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null)
                return false;
        }

        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            if (currentNode == rootNode)
                rootNode = null;
            else if (isLeftChild)
                parentNode.setLeftChild(null);
            else
                parentNode.setRightChild(null);
        } else if (currentNode.getRightChild() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getLeftChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getLeftChild());
            else
                parentNode.setRightChild(currentNode.getLeftChild());
        } else if (currentNode.getLeftChild() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getRightChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getRightChild());
            else
                parentNode.setRightChild(currentNode.getRightChild());
        } else {
            Node<E> heir = receiveHeir(currentNode);
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeftChild)
                parentNode.setLeftChild(heir);
            else
                parentNode.setRightChild(heir);
        }
        return true;
    }


    private Node<E> receiveHeir(Node<E> node) {
        Node<E> parentNode = node;
        Node<E> heirNode = node;
        Node<E> currentNode = node.getRightChild();
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild();
        }

        if (heirNode != node.getRightChild()) {
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return heirNode;
    }

    public void print() {
        Stack<Node<E>> globalStack = new Stack<>(); // общий стек для значений дерева
        globalStack.push(rootNode);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (!isRowEmpty) {
            Stack <Node<E>> localStack = new Stack<>(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) { // покуда в общем стеке есть элементы
                Node<E> temp = globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
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
