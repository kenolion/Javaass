/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Iterator;

/**
 *
 * @author Sean
 */
public interface QueueInterfaceV2<T> extends QueueInterface<T>{
  Iterator getIterator();
  
  
    
}
