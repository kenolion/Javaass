/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkList;

import LinkList.LinkListInterface;
import java.util.Iterator;

/**
 *
 * @author Sean
 */
public interface ListIteratorInterface<T> extends LinkListInterface<T> {
     Iterator getIterator();
  
    
}
