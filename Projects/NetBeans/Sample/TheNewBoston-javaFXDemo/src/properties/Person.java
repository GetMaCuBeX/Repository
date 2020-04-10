/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class Person {

    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    // Returns the StringProperty object
    public StringProperty firstNameProperty() {
        return firstName;
    }

    // Return the firstName value (ie. "Bucky")
    public String getFirstName() {
        return firstName.get();
    }

    // Set the firstName value
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

}
