/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.jpa.eclipse.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "bookssubjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookssubjects.findAll", query = "SELECT b FROM Bookssubjects b")
    , @NamedQuery(name = "Bookssubjects.findByBooksIdbooks", query = "SELECT b FROM Bookssubjects b WHERE b.bookssubjectsPK.booksIdbooks = :booksIdbooks")
    , @NamedQuery(name = "Bookssubjects.findBySubjectsIdsubjects", query = "SELECT b FROM Bookssubjects b WHERE b.bookssubjectsPK.subjectsIdsubjects = :subjectsIdsubjects")})
public class Bookssubjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BookssubjectsPK bookssubjectsPK;
    @JoinColumn(name = "subjects_idsubjects", referencedColumnName = "idsubjects", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subjects subjects;
    @JoinColumn(name = "books_idbooks", referencedColumnName = "idbooks", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;

    public Bookssubjects() {
    }

    public Bookssubjects(BookssubjectsPK bookssubjectsPK) {
        this.bookssubjectsPK = bookssubjectsPK;
    }

    public Bookssubjects(int booksIdbooks, int subjectsIdsubjects) {
        this.bookssubjectsPK = new BookssubjectsPK(booksIdbooks, subjectsIdsubjects);
    }

    public BookssubjectsPK getBookssubjectsPK() {
        return bookssubjectsPK;
    }

    public void setBookssubjectsPK(BookssubjectsPK bookssubjectsPK) {
        this.bookssubjectsPK = bookssubjectsPK;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookssubjectsPK != null ? bookssubjectsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookssubjects)) {
            return false;
        }
        Bookssubjects other = (Bookssubjects) object;
        if ((this.bookssubjectsPK == null && other.bookssubjectsPK != null) || (this.bookssubjectsPK != null && !this.bookssubjectsPK.equals(other.bookssubjectsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.Bookssubjects[ bookssubjectsPK=" + bookssubjectsPK + " ]";
    }
    
}
