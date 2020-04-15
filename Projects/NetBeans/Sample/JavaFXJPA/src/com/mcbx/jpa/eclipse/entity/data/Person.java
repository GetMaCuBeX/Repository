package com.mcbx.jpa.eclipse.entity.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private String firstname;
    private String lastname;
    private String information;

    public Person(String firstname, String lastname, String information) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.information = information;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
 
    public String getInformation() {
        return information;
    }

    public void setInformation(String Information) {
        this.information = Information;
    }

}
