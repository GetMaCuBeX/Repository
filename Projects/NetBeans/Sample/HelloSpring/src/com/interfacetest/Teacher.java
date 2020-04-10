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
public class Teacher implements UserDAO {

    private int teacherID;
    private String name;
    private String lastName;

    public Teacher() {
    }

    public Teacher(int teacherID, String name, String lastName) {
        this.teacherID = teacherID;
        this.name = name;
        this.lastName = lastName;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
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
        System.out.println("create teacher");
    }

    @Override
    public void updateUser() {
        System.out.println("update teacher");
    }

    @Override
    public void deleteUser() {
        System.out.println("delete teacher");
    }

}
