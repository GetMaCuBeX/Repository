package com.mcbx.jpa.eclipse;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EclipseController implements Initializable {

    private final String persistentUnit = "booksreservation";
    private EntityManagerFactory emf;
    private EntityManager em;
 

    ResultSet rs = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**/
        careteEntityManagerFactory(); 
    }
//------------------------------------------------------------------------------ ENTITY MANAGER FACTORY
    private void careteEntityManagerFactory() {
        try {
            /**/
            emf = Persistence.createEntityManagerFactory(persistentUnit);
            /**/
        } catch (Exception ex) {
            System.err.println("Failed to create sessionFactory object." + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }
//------------------------------------------------------------------------------ CHECK IF ENTITY ID IS EXIST

    public boolean isEntityIDExist(Class<?> entityClass, int classID) {
        return em.find(entityClass, classID) != null;
    }

}
