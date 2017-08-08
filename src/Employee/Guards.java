/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import Emergency.Tasks;
import Interfaces.NameInterface;
import Interfaces.QueueInterfaceV2;
import LinkList.LinkQueue;
import java.util.Iterator;

/**
 *
 * @author Sean
 */
public class Guards implements NameInterface{

    public QueueInterfaceV2<Tasks> TaskQueue;
    protected String name;
    protected int age;

    public Guards(String name, int age, String task) {
        this.name = name;
        this.age = age;
        TaskQueue = new LinkQueue();

    }

    public String toString(Guards guard) {

        return "";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        
       String s = "Guard Name - ";
       s += name;
       s += "Task Details\n";
       s += TaskQueue.toString();
       
       
        return s;
    }

    @Override
    public int compareTo(NameInterface o) {
       return this.getName().compareTo(o.getName());
    }

}
