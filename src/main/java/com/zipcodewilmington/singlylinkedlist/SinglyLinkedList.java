package com.zipcodewilmington.singlylinkedlist;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {

    transient int size = 0;

    transient Node<T> head;
//    transient Node<T> tail;


    public SinglyLinkedList() {

    }

    private static class Node<T extends Comparable<T>> {
        T item;
        Node<T> next;

        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    //Good
    public void add(T item) {
//        if (head == null) {
//            head = new Node<T>(item, null);
//            tail = head;
//        } else {
//            tail.next = new Node<>(item, null);
//            tail = tail.next;
//        }

        if (head == null) {
            head = new Node<>(item, null);
        } else {
            Node<T> node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(new Node<>(item, null));
        }
        size++;
    }


    public void remove(int indexNumber) throws IndexOutOfBoundsException {
//        int index = 0;
//
//        if(index >= size) {
//            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
//        } else if(index ==0) {
//            head = head.next;
//        } else if (index > 0) {
//
//        }
        if (indexNumber >= size) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundException");
        } else if (indexNumber == 0) {
            head = head.next;
        } else {
            Node<T> previous = null;
            Node<T> nodeToRemove = head;
            for (int i = 0; i < indexNumber; i++) {
                previous = nodeToRemove;
                nodeToRemove = nodeToRemove.next;
            }
            previous.next = nodeToRemove.next;

        }
        size--;
    }


    public Boolean contains(T object) {
        if (find(object) >= 0) {
            return true;
        } else {
            return false;
        }
    }


    //Good
    public int find(T object) {
        int index = 0;
        if (object == null) {
            for (Node<T> i = head; i != null; i = i.next) {
                if (i.next == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<T> i = head; i != null; i = i.next) {
                if (i.item.equals(object)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }


    public int size() {
        return size;
    }


    public T get(int index) {
        T item = (T) getNode(index).getItem();
        return item;
    }

    //Good
    private Node getNode(int index) {
        int counter = 0;
        Node<T> node = head;
        while (counter != index) {
            node = node.getNext();
            counter++;
            if (counter == index) {
                return node;
            }
        }
        return node;
    }


    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copyList = new SinglyLinkedList<>();
        for (Node<T> i = head; i != null; i = i.next) {
            copyList.add(i.item);
        }
        return copyList;
    }


    public void sort() {
        for (int i = 0; i < size; i++) {
            Node current = head;
            Node nextNode = head.next;
            for (int j = 0; j < size; j++) {
                if (current.item.compareTo(nextNode.item) >0){
                    Node temp = current;
                    current = nextNode;
                    nextNode = temp;
                }
                current = nextNode;
                nextNode = nextNode.next;
            }
        }
    }


}
