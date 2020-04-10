package com.example;


import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /*---------------------------------CREATE--------------------------------------------*/
        /*CREATE OBJECT*/
        /*Alien a = new Alien();*/
        /*EVEN 0, STILL AUTO-GENERATED IN FIELD ID*/
        /*a.setId(0);
        a.setName("Monitor");
        a.setTechnology("Keyboard");*/

        /*PUT OBJECT TO DATABASE*/
        /*em.persist(a);
        em.getTransaction().commit();*/

        /*--------------------------------FIND-----------------------------------------------*/
        /*Query Table at ID 2*/
        /*Alien a = em.find(Alien.class, 2);
        System.out.println(a.getName());*/

        /*-----------------------------UPDATE-----------------------------------------------*/
        /*Update Table at ID 8*/
        /*Alien a = em.find(Alien.class, 8);
        a.setTechnology("UPDATED");
        em.getTransaction().commit();*/

        /*--------------------------------DELETE--------------------------------------------*/
        /*Update Table at ID 8*/
        /*Alien a = em.find(Alien.class, 6);
        em.remove(a);
        em.getTransaction().commit();*/

        /*--------------------------CREATE QUERY--------------------------------------------*/
        Query query = em.createQuery("Select UPPER(a.name)  from Alien a");
        List<String> list = query.getResultList();

        for(String e:list) {
            System.out.println("Alien Name :"+e);
        }

        /*---------------------------FIND BY PARAMETERS-------------------------------------*/
        /*Query query = em.createNamedQuery("findByName");
        query.setParameter("name", "Monitor");
        List<Alien> list = query.getResultList( );

        for( Alien e:list ){
            System.out.print("ID :" + e.getId( ));
            System.out.print("\t Name :" + e.getName( ));
            System.out.println("\t Tech :" + e.getTechnology( ));
        }*/

        /*----------------------------------------------------------------------------------*/
        /*----------------------------------------------------------------------------------*/
        /*----------------------------------------------------------------------------------*/
        /*----------------------------------------------------------------------------------*/
        /*----------------------------------------------------------------------------------*/
        /*----------------------------------------------------------------------------------*/



        em.close();
        emf.close();
        /*System.out.println(a.toString());*/
    }
}
