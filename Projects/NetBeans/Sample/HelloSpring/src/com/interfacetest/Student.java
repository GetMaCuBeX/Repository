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
public class Student implements UserDAO {

    private int studentID;
    private String name;
    private String lastName;

    public Student() {
    }

    public Student(int studentID, String name, String lastName) {
        this.studentID = studentID;
        this.name = name;
        this.lastName = lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void createUser() {
        System.out.println("create user");
        bar();
    }

    @Override
    public void updateUser() {
        System.out.println("update user");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete user");
    }

    @Override
    public void bar() {
        // override from X, Y
    }

}
