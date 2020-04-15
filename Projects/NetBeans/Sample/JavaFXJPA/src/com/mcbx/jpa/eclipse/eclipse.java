/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.jpa.eclipse;

import com.mcbx.jpa.eclipse.entity.Authors;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class eclipse extends Application {

    private final String persistentUnit = "booksreservation";
    private EntityManagerFactory emf;
    private EntityManager em;

    @Override
    public void start(Stage primaryStage) {
        try {
            /**/
            careteEntityManagerFactory();
            /**/
//            Parent root = FXMLLoader.load(getClass().getResource("eclipse.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("table1/Table1.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setOnCloseRequest((event) -> {
                emf.close();
                Platform.exit();
                System.exit(0);
            });

            em = emf.createEntityManager();
            em.getTransaction().begin();
            /**/
            executeQuery();
            /**/
            em.close();
            /**/
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
//------------------------------------------------------------------------------ CREATE

    private void createAuthor() {
        try {
            /**/
            Integer authorsid1 = addAuthors("Zara", "Ali", "");
//            Integer authorsid2 = addAuthors("Daisy", "Das", "");
//            Integer authorsid3 = addAuthors("John", "Paul", "");
            /**/
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
//------------------------------------------------------------------------------ READ

    private void readAuthor() {
        boolean isExist = isEntityIDExist(Authors.class, 2);
        if (isExist) {
            Authors a = em.find(Authors.class, 2);
            System.out.println(a.getFirstname());
        }
    }
//------------------------------------------------------------------------------ UPDATE

    private void updateAuthor() {
        boolean isExist = isEntityIDExist(Authors.class, 8);
        if (isExist) {
            Authors a = em.find(Authors.class, 8);
            a.setFirstname("Joel");
            em.persist(a);
            em.getTransaction().commit();
        }
    }

//------------------------------------------------------------------------------ DELETE
    private void deleteAuthor() {
        boolean isExist = isEntityIDExist(Authors.class, 5);
        if (isExist) {
            Authors a = em.find(Authors.class, 5);
            em.remove(a);
            em.getTransaction().commit();
        }
    }

//------------------------------------------------------------------------------ FIND NAME
    private void find() {
        Query query = em.createQuery("Select UPPER(a.firstname) from Authors a");
        List<String> list = query.getResultList();
        list.forEach((e) -> {
            System.out.println("Authors Name :" + e);
        });
    }

//------------------------------------------------------------------------------ FIND BY ID
    private void find2() {
        boolean isExist = isEntityIDExist(Authors.class, 3);
        if (isExist) {
            Query query = em.createNamedQuery("Authors.findByIdauthors");
            query.setParameter("idauthors", 3);
            List<Authors> list = query.getResultList();
            for (Authors e : list) {
                System.out.print("ID :" + e.getIdauthors());
                System.out.print("\t Firstname :" + e.getFirstname());
                System.out.println("\t Lastname :" + e.getLastname());
            }
        }
    }
    
//------------------------------------------------------------------------------ FIND ALL
    private void find3() {
        Query query = em.createQuery("Select a from Authors a");
        List<Authors> list = query.getResultList(); 
        list.forEach((e) -> {
            System.out.println("Authors Name :" + e.getLastname());
        }); 
    }

    private void executeQuery() {
//        createAuthor();
//        readAuthor();
//        updateAuthor();
//        deleteAuthor();
//        find();
//        find2();
//        find3();
    }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------ CREATE AUTHOR ENTRY

    public Integer addAuthors(String firstname, String lastname, String contactinformation) {
        /**/
        Authors a = new Authors();
        a.setFirstname(firstname);
        a.setLastname(lastname);
        a.setContactinformation(contactinformation);
        /**/
        em.persist(a);
        em.getTransaction().commit();
        /**/
        System.out.println(a.getIdauthors() + " - ID");
        /**/
        return a.getIdauthors();
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
