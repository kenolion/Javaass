/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Sean
 */
public class LinkQueue<T> implements QueueInterfaceV2<T> {

    Node lastNode;

    @Override
    public void enqueue(T newEntry) {

        if (isEmpty()) {
            Node newNode = new Node(newEntry);
            lastNode = newNode;
            lastNode.next = lastNode;
        } else {
            Node newNode = new Node(newEntry, lastNode.next);
            lastNode.next = newNode;
            //lastNode = newNode;

        }

    }

    @Override
    public T dequeue() {
        T temp = (T) lastNode.next.data;
        if (!isEmpty()) {
            if (lastNode.next == lastNode) {
                lastNode = null;
            } else {
                lastNode.next = lastNode.next.next;

            }
        }
        return temp;
    }

    @Override
    public T getFront() {
        return lastNode.next.data;
    }

    @Override
    public boolean isEmpty() {
        return lastNode == null;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator getIterator() {
        return new QueueIterator();
    }

    public Node getNodeAt(int position){
        Iterator qIterator = getIterator();
        for(int i = 1 ; i< position-1;i++){
            if
            
        }
        
    }
    
    private class QueueIterator<T> implements Iterator {

        Node currNode = lastNode.next;
        @Override
        public boolean hasNext() {

            return currNode != null;//got next element

        }

        @Override
        public T next() {

            T temp = (T) currNode.data;
            currNode = currNode.next;

            return temp;

        }
        
       
        public void remove() {
                if (currNode == lastNode.next) {
                    currNode = null;
                } 
        }

    }

    private class Node {

        private T data;
        private Node next;

        Node() {
            data = null;
        }

        private Node(T data) {
            this.data = data;
            next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        /**
         * @return the data
         */
        public T getData() {
            return data;
        }

        /**
         * @param data the data to set
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * @return the next
         */
        public Node getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }

}
