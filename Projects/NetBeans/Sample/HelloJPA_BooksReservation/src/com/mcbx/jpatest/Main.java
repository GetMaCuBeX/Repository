package com.mcbx.jpatest;

import com.mcbx.main.entity.Authors;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class Main extends Application {

    StackPane root;
    Button btn;
    Scene scene;
    Label lbl;
    VBox vbx;
    EntityManagerFactory emf;
    EntityManager em;
    int count;

    @Override
    public void start(Stage primaryStage) {
        initializeMain(primaryStage);

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void initializeMain(Stage primaryStage) {

//        testJPA();
        root = new StackPane();
        scene = new Scene(root, 300, 250);

        vbx = new VBox();
        btn = new Button("Say 'Hello World'");
        lbl = new Label();

        btn.setOnAction((ActionEvent event) -> {
            System.out.println("Hello World!");
            testJPA();
        });

        vbx.getChildren().addAll(btn, lbl);
        root.getChildren().addAll(vbx);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
//        
    }

    private void testJPA() {
        System.out.println("Hello World");
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("booksreservation");
//        EntityManager em = emf.createEntityManager();
        emf = Persistence.createEntityManagerFactory("booksreservation");
        em = emf.createEntityManager();
        em.getTransaction().begin();

        /*---------------------------------CREATE--------------------------------------------*/
//        Authors a = new Authors();
////        EVEN 0, STILL AUTO
////        -GENERATED IN FIELD ID
//        a.setIdauthors(0);
//        a.setFirstname("New Author");
//        a.setLastname("New Athor Lastname");
//        a.setContactinformation("Administrator");
//        /*PUT OBJECT TO DATABASE*/
//        em.persist(a);
//        em.getTransaction().commit();

        /*--------------------------------FIND-----------------------------------------------*/
 /*Query Table at ID 2*/
        Authors a = em.find(Authors.class, 2);
        System.out.println(a.getFirstname());
        btn.setText(a.getFirstname()+" Count "+count++);

        /*-----------------------------UPDATE-----------------------------------------------*/
 /*Update Table at ID 8*/
//        Authors a = em.find(Authors.class, 8);
//        a.setFirstname("UPDATED");
//        em.getTransaction().commit();
//        lbl.setText("First name is updated: @ID:"+a.getIdauthors());
        /*--------------------------------DELETE--------------------------------------------*/
 /*Update Table at ID 8*/
//        Authors a = em.find(Authors.class, 6);
//        em.remove(a);
//        em.getTransaction().commit();
//        lbl.setText("Author Deleted: @ID:"+a.getIdauthors());
        /*--------------------------CREATE QUERY--------------------------------------------*/
//        Query query = em.createQuery("Select UPPER(a.firstname) from Authors a");
//        List<String> list = query.getResultList();
//
//        list.forEach((e) -> {
//            System.out.println("Authors Firstname :" + e);
//        });

        /*---------------------------FIND BY PARAMETERS-------------------------------------*/
//        Query query = em.createNamedQuery("Authors.findByIdauthors");
//        query.setParameter("idauthors", 3);
//        List<Authors> list = query.getResultList();
//
//        for (Authors e : list) {
//            System.out.print("FNAME :" + e.getFirstname());
//            System.out.print("\t LNAME :" + e.getLastname());
//            System.out.println("\t INFO :" + e.getContactinformation());
//        }

        em.close();
        emf.close();
    }

}
