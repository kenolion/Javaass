/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emergency;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



/**
 *
 * @author Sean
 */
public class Emergency implements Serializable{
    
    private String name;
    private String description;
    private ZonedDateTime date;
    private String formattedDate;
    private static int totalEmergency;
    private int emergencyID;
    public Emergency(String name,String description,ZonedDateTime date){
        this.name = name;
        this.description = description;
        this.date = date;
        formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm", Locale.ENGLISH));
        totalEmergency++;
        emergencyID = totalEmergency;
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
     * @return the emergencyID
     */
    public int getEmergencyID() {
        return emergencyID;
    }

    /**
     * @param emergencyID the emergencyID to set
     */
    public void setEmergencyID(int emergencyID) {
        this.emergencyID = emergencyID;
    }
    
    @Override
    public String toString(){
        String s = "\nEmergency ID:";
        s += emergencyID;
        s += "\nEmergency Name:";
        s += name;
        s += "\nEmergency Description:";
        s += description;
        s += "\nTime :";
        s += formattedDate;
        
        return s;
    }
}
