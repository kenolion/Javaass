/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emergency;

import Interfaces.NameInterface;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;

/**
 *
 * @author USER
 */
public class Tasks implements NameInterface{

String taskname;
boolean isCompleted;
private ZonedDateTime date;
private String formattedDate;
private String description;
private String endDate;
int duration;


    public Tasks() {

    }

    public Tasks(String taskname,ZonedDateTime date,int duration) {

        this.taskname = taskname;
        formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm", Locale.ENGLISH));
        this.duration = duration;
        date = date.plusHours(duration);
        endDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm", Locale.ENGLISH));
        isCompleted = false;
    }

    public boolean CompleteTask() {
        return isCompleted = true;

    }
   @Override
    public String getName() {
        return taskname;
    }

    public void setTaskName(String taskname) {
        this.taskname = taskname;
    }

    public boolean getisCompleted() {
        return isCompleted;
    }

@Override
    public String toString() {

        String s = "Task Name - ";
        s += taskname;
        s += "\nDescription - ";
        s += description;
        s += "\nDate and Time Assigned - ";
        s += formattedDate;
        s += "\nDuration - ";
        s += duration + " hours";
        s += "\nDate and Time Due - ";
        s += endDate ;
        s += "\nStatus - ";
        if (getisCompleted()) {
            s += "Complete\n";
        } else {
            s += "Incomplete\n";
        }

        return s;

    }

 


//    public String DisplayTask() {
//
//        String t = "";
//        Tasks task;
//
//        Iterator TaskIterator = guard.TaskQueue.getIterator();
//        int count = 1;
//  if(!guard.TaskQueue.isEmpty()){
//        while (TaskIterator.hasNext()) {
//           
//            task = (Tasks) TaskIterator.next();
//            t += count++ + ". " + task.toString() + "\n";
//            TaskIterator.remove();
//
//        }
//       }
//
//
//        return t;
//    }

    /**
     * @return the date
     */
    public ZonedDateTime getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(ZonedDateTime date) {
      
        this.date = date;
    }

    /**
     * @return the formattedDate
     */
    public String getFormattedDate() {
        return formattedDate;
    }

    /**
     * @param formattedDate the formattedDate to set
     */
    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

 

    @Override
    public int getID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(NameInterface o) {
        return this.getName().compareTo(o.getName());
    }

}
