package LinkList;

import Interfaces.SortedListInterface;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedLinkedList<T extends Comparable<? super T>> implements SortedListInterface<T>, Serializable {

    private Node firstNode;
    private int length;

    public SortedLinkedList() {
        firstNode = null;
        length = 0;
    }

    public boolean add(T newEntry) {
//    Node newNode = new Node(newEntry);
//
//    Node nodeBefore = null;							// For linked list traversal: to reference the node before the current node
//    Node currentNode = firstNode;				// For linked list traversal: to reference the current node
//    while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
//      nodeBefore = currentNode;
//      currentNode = currentNode.next;
//    }
//
//    if (isEmpty() || (nodeBefore == null)) { // CASE 1: add at beginning
//      newNode.next = firstNode;
//      firstNode = newNode;
//    } else {	// CASE 2: add in the middle or at the end, i.e. after nodeBefore
//      newNode.next = currentNode;
//      nodeBefore.next = newNode;
//    }
//    length++;

        firstNode = add(newEntry, firstNode);
        length++;
        return true;
    }

    private Node add(T newEntry, Node currNode) {
        if ((currNode == null) || newEntry.compareTo(currNode.data) <= 0) {
            currNode = new Node(newEntry, currNode);
        } else {
            Node nodeAfter = add(newEntry, currNode.next);
            currNode.next = nodeAfter;
        }
        return currNode;
    }

    public boolean remove(T anEntry) {
        Node temp = firstNode;
        Node before = null;
        int position = 1;
        for (int i = 0; i < length; i++) {

            if (temp.data.compareTo(anEntry) == 0) {
                if (temp.next.next != null) {
                    before.next = temp.next.next;
                    return true;
                }

            } else {
                before = temp;
                temp = temp.next;

            }
            position++;
        }
        return false;
    }

    public int getPosition(T anEntry) {
        Iterator itr = new sortedLinkListIterator();
        int position = 1;

        while (itr.hasNext()) {
            T temp = (T) itr.next();
            if (temp.compareTo(anEntry) == 0) {
                return position;
            }
            position++;

        }
        return -1;
// Left as Practical exercise
    }

    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            result = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }

        return result;
    }

    public boolean contains(T anEntry) {
//    boolean found = false;
//    Node currentNode = firstNode;
//
//    while (!found && (currentNode != null)) {
//      if (anEntry.equals(currentNode.data)) {
//        found = true;
//      } else {
//        currentNode = currentNode.next;
//      }
//    }
//
//    return found;

        boolean found = false;
        Node tempNode = firstNode;
        int pos = 1;

        while (!found && (tempNode != null)) {
            if (anEntry.compareTo(tempNode.data) <= 0) {
                found = true;
            } else {
                tempNode = tempNode.next;
                pos++;
            }
        }
        if (tempNode != null && tempNode.data.equals(anEntry)) {
            return true;
        } else {
            return false;
        }
    }

    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= length)) {
            if (givenPosition == 1) {      	// CASE 1: remove first entry
                result = firstNode.data;     	// save entry to be removed 
                firstNode = firstNode.next;		// update firstNode to point to the next node
            } else {                         	// CASE 2: remove interior entry or last entry
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }
                result = nodeBefore.next.data;  	// save entry to be removed	
                nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the 
            } 															// one to be deleted (to disconnect node from chain)

            length--;
        }

        return result;
    }

    public final void clear() {
        firstNode = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public boolean isFull() {
        return false;
    }

    public String toString() {
        String outputStr = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";;
            currentNode = currentNode.next;
        }
        return outputStr;
    }

    @Override
    public Iterator<T> getIterator() {
        return new sortedLinkListIterator();
    }

    private class sortedLinkListIterator<T> implements Iterator {

        private Node currentNode;

        public sortedLinkListIterator() {
            currentNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (hasNext()) {

                T returnData = (T) currentNode.data;
                currentNode = currentNode.next;

                return returnData;
            } else {
                throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
            }
        }

        @Override
        public void remove() {

        }

    }

    private class Node implements Serializable {

        private T data;
        private Node next;

        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

    }
}
