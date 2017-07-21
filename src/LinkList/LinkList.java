/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkList;

/**
 *
 * @author Sean
 */
public class LinkList<T> implements LinkListInterface<T> {

    private Node start;
    private Node end;
    private int size;

    public LinkList() {

        start = null;
        end = null;
        size = 0;
    }

    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        size++;
        if (start == null) {
            start = newNode;
            end = start;
        } else {

            end.next = newNode;
            end = newNode;
        }
        return true;
    }

    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;
        Node newNode = new Node(newEntry);
      
        Node nodeAfter;
 
    if ((newPosition >= 1) && (newPosition <= size + 1)) {

      if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
        newNode.next = start;
        start = newNode;
      } else {								                      // case 2: list is not empty and newPosition > 1
        Node nodeBefore = getNodeAt(newPosition - 1);                           
        nodeAfter = nodeBefore.next;
        newNode.setNext(nodeAfter);
        nodeBefore.setNext(newNode);
      }

      size++;
    } else {
      isSuccessful = false;
    }
    // 
        return isSuccessful;
    }

    public T remove(int givenPosition) {
        T result = null;

        if (givenPosition >= 1 && givenPosition <= size) {
            if (givenPosition == 1) {
                result = start.data;
                start = start.next;
            } else if (givenPosition == size) {

            } else {
                Node nodeBefore = start;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }
                result = nodeBefore.next.data;
                nodeBefore.next = nodeBefore.next.next;
            }
            size--;

        }
        return result;
    }

    public void clear() {
        start = null;
        end = null;
        size = 0;
    }

    public boolean replace(int givenPosition, T newEntry) {
        return true;
    }

    public T getEntry(int givenPosition) {
        if (givenPosition == 1) {
            return start.data;
        } else if (givenPosition == size) {
            return end.data;
        } else {
            Node tempNode = new Node();
            tempNode = start;
            for (int i = 2; i <= size; i++) {
                tempNode = tempNode.next;
                if (i == givenPosition) {
                    return tempNode.data;
                }
            }
        }
        return null;
    }

    public boolean contains(T anEntry) {
        return true;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size != 0) {
            return false;
        }
        return true;
    }

    public boolean isFull() {
        return true;
    }

    private Node getNodeAt(int position) {
    Node tempNode = start;
        for (int i = 0; i < position; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    // traverse the list to locate the desired node
   

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
