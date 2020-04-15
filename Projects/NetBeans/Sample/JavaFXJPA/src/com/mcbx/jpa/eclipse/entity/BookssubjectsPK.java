/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.jpa.eclipse.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrator
 */
@Embeddable
public class BookssubjectsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "books_idbooks")
    private int booksIdbooks;
    @Basic(optional = false)
    @Column(name = "subjects_idsubjects")
    private int subjectsIdsubjects;

    public BookssubjectsPK() {
    }

    public BookssubjectsPK(int booksIdbooks, int subjectsIdsubjects) {
        this.booksIdbooks = booksIdbooks;
        this.subjectsIdsubjects = subjectsIdsubjects;
    }

    public int getBooksIdbooks() {
        return booksIdbooks;
    }

    public void setBooksIdbooks(int booksIdbooks) {
        this.booksIdbooks = booksIdbooks;
    }

    public int getSubjectsIdsubjects() {
        return subjectsIdsubjects;
    }

    public void setSubjectsIdsubjects(int subjectsIdsubjects) {
        this.subjectsIdsubjects = subjectsIdsubjects;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) booksIdbooks;
        hash += (int) subjectsIdsubjects;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookssubjectsPK)) {
            return false;
        }
        BookssubjectsPK other = (BookssubjectsPK) object;
        if (this.booksIdbooks != other.booksIdbooks) {
            return false;
        }
        if (this.subjectsIdsubjects != other.subjectsIdsubjects) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.BookssubjectsPK[ booksIdbooks=" + booksIdbooks + ", subjectsIdsubjects=" + subjectsIdsubjects + " ]";
    }
    
}
