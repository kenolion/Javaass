/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Emergency;

import Interfaces.NameInterface;
import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Sean
 */
public class Emergency implements NameInterface {

    private String name;
    private String description;
    private ZonedDateTime date;
    private String formattedDate;
    private static int totalEmergency;
    private int ID;
    static final long serialVersionUID = 1L;
    int priority;
    private boolean status;

    public Emergency(String name,String desc, ZonedDateTime date, int aPriority) {
        this.name = name;
        this.date = date;
        description = desc;
        formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm", Locale.ENGLISH));
        totalEmergency++;
        ID = totalEmergency;
        priority = aPriority + 1;

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
    public int getID() {
        return ID;
    }

    /**
     * @param emergencyID the emergencyID to set
     */
    public void setID(int emergencyID) {
        this.ID = emergencyID;
    }

    @Override
    public String toString() {
        String s = "Emergency ID:";
        s += ID;
        s += "\nStatus:";
        if (isStatus() == false) {
            s += "ONGOING";

        } else {
            s += "Resolved";
        }
        s += "\nEmergency Name:";
        s += name;
        s += "\nPriority :";
        s += priority;
        s += "\nEmergency Description:";
        s += description;
        s += "\nTime :";
        s += formattedDate;

        return s;
    }

    /**
     * @return the totalEmergency
     */
    public static int getTotalEmergency() {
        return totalEmergency;
    }

    /**
     * @param aTotalEmergency the totalEmergency to set
     */
    public static void setTotalEmergency(int aTotalEmergency) {
        totalEmergency = aTotalEmergency;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int compareTo(NameInterface o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
