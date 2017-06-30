/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractdata;

import DataStructures.DataStructures;
import Employee.Guards;
/**
 *
 * @author Sean
 */
public class AbstractData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataStructures[] data = new DataStructures[4];
        data[1] = new DataStructures();
        data[2] = new DataStructures();
        data[1].printName();
        data[2].printName();

    }

}
