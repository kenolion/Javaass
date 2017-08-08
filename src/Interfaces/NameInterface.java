/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.Serializable;

/**
 *
 * @author Sean
 */
public interface NameInterface extends Serializable,Comparable<NameInterface>{
    public String getName();
    public int getID();
    
    
}
