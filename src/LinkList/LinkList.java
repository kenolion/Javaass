/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkList;

import Interfaces.ListIteratorInterface;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Terry
 */
public class LinkList<T> implements ListIteratorInterface<T>,Serializable{
    private Node firstNode;
    private int entriesCounter;
    
    public LinkList(){
        clearList();
    }
    
    
    @Override
    public boolean add(T newEntry) {
         Node newNode = new Node(newEntry);

    if (isEmpty()) {
      firstNode = newNode;
    }
    else {
      Node lastNode = getNodeAt(entriesCounter);
      lastNode.setNext(newNode);
    }

    entriesCounter++;
    return true;
    }

    @Override
    public boolean add(int newPosition, T newEntry) {
        boolean addSuccess = true;

    if ((newPosition >= 1) && (newPosition <= entriesCounter + 1)) {
      
        Node newNode = new Node(newEntry);

      if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
        newNode.setNext(firstNode);
        firstNode = newNode;
      } else {								                      // case 2: list is not empty and newPosition > 1
        Node nodeBefore = getNodeAt(newPosition - 1);
        Node nodeAfter = nodeBefore.next;
        newNode.setNext(nodeAfter);
        nodeBefore.setNext(newNode);
      }

      entriesCounter++;
    } 
    
    else {
      addSuccess = false;
    }

    return addSuccess;
    }

    @Override
    public T remove(int givenPosition) {
        T result = null;

    if ((givenPosition >= 1) && (givenPosition <= entriesCounter)) {
      if (givenPosition == 1) {      // case 1: remove first entry
        result = firstNode.getData();     // save entry to be removed 
        firstNode = firstNode.getNext();
      } else {                         // case 2: givenPosition > 1
        Node nodeBefore = getNodeAt(givenPosition - 1);
        Node nodeToRemove = nodeBefore.next;
        Node nodeAfter = nodeToRemove.next;
        nodeBefore.setNext(nodeAfter); // disconnect the node to be removed
        result = nodeToRemove.getData();  // save entry to be removed
      }

      entriesCounter--;
    }

    return result;
    }

    public void clearList() {
    
    firstNode = null;
    entriesCounter = 0;    
    
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
         boolean replaceSuccess = true;

    if ((givenPosition >= 1) && (givenPosition <= entriesCounter)) {
        Node desiredNode = getNodeAt(givenPosition);
        desiredNode.setData(newEntry);
    } 
    
    else {
      replaceSuccess = false;
     }

    return replaceSuccess;    
    
    }

    @Override
    public T getEntry(int givenPosition) {
        T result = null;

    if ((givenPosition >= 1) && (givenPosition <= entriesCounter)) {
      result = getNodeAt(givenPosition).getData();
      
    }

    return result;
    }

    @Override
    public boolean contains(T anEntry) {
       boolean found = false;
       Node currentNode = firstNode;

    while (!found && (currentNode != null)) {
      if (anEntry.equals(currentNode.getData())) {
        found = true;
      } else {
        currentNode = currentNode.next;
      }
    }

    return found;
    }

    public int getNumberOfEntries() {
        return entriesCounter;
    }

    @Override
    public boolean isEmpty() {
       boolean result;

    if (entriesCounter == 0) {
      result = true;
    }
    
    else {
      result = false;
    }

    return result;
    }

    @Override
    public boolean isFull() {
        return false;
    }
    
    public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.getData() + "\n";;
      currentNode = currentNode.next;
    }
    return outputStr;
  }

  private void displayChain(Node nodeOne) {
    if (nodeOne != null) {
      System.out.print(nodeOne.getData() + " ");
      displayChain(nodeOne.next);
    }
  }

  /**
   * Task: Returns a reference to the node at a given position. Precondition:
   * List is not empty; 1 <= givenPosition <= numberOfEntries.
   */
  private Node getNodeAt(int givenPosition) {
    Node currentNode = firstNode;

    // traverse the list to locate the desired node
    for (int counter = 1; counter < givenPosition; counter++) {
      currentNode = currentNode.next;
    }

    return currentNode;
  }


  public Iterator<T> getIterator() {
    return new LinkedListIterator();
  }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  private class LinkedListIterator implements Iterator<T> {
     
   
   private Node currentNode;
   
   
    public LinkedListIterator() {
      currentNode = firstNode;
    }

    @Override
    public boolean hasNext() {
      return currentNode != null;
    }

    @Override
    public T next() {
      if (hasNext()) {
        
       T returnData = (T)currentNode.data;
       currentNode = currentNode.next;
        
       return returnData;
      } 
      
      else {
        throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
      }
    }

    @Override
    public void remove() {
        
    }
  }  
  
    private class Node implements Serializable{

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
