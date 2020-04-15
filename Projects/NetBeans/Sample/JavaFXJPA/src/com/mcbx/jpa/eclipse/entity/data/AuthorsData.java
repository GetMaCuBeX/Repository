 
package com.mcbx.jpa.eclipse.entity.data;
 
public class AuthorsData {
    
    private int id;
    private String firstname;
    private String lastname;
    private String contactinformation;

    public AuthorsData(int id, String firstname, String lastname, String contactinformation) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.contactinformation = contactinformation;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getContactinformation() {
        return contactinformation;
    }

    public void setContactinformation(String contactinformation) {
        this.contactinformation = contactinformation;
    }

 
    
}
