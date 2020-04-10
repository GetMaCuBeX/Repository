/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfacetest;

/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {


        Student student1 = new Student();
        student1.setStudentID(111);
        student1.setName("Joel");
        student1.setLastName("Benaldo");
        UserDAO t1;
        UserDAO s1 = student1;
        
        s1.createUser();

    }

}
