/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main.entity;

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
@Table(name = "booksauthors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booksauthors.findAll", query = "SELECT b FROM Booksauthors b")
    , @NamedQuery(name = "Booksauthors.findByBooksIdbooks", query = "SELECT b FROM Booksauthors b WHERE b.booksauthorsPK.booksIdbooks = :booksIdbooks")
    , @NamedQuery(name = "Booksauthors.findByAuthorsIdauthors", query = "SELECT b FROM Booksauthors b WHERE b.booksauthorsPK.authorsIdauthors = :authorsIdauthors")})
public class Booksauthors implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BooksauthorsPK booksauthorsPK;
    @JoinColumn(name = "books_idbooks", referencedColumnName = "idbooks", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;
    @JoinColumn(name = "authors_idauthors", referencedColumnName = "idauthors", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Authors authors;

    public Booksauthors() {
    }

    public Booksauthors(BooksauthorsPK booksauthorsPK) {
        this.booksauthorsPK = booksauthorsPK;
    }

    public Booksauthors(int booksIdbooks, int authorsIdauthors) {
        this.booksauthorsPK = new BooksauthorsPK(booksIdbooks, authorsIdauthors);
    }

    public BooksauthorsPK getBooksauthorsPK() {
        return booksauthorsPK;
    }

    public void setBooksauthorsPK(BooksauthorsPK booksauthorsPK) {
        this.booksauthorsPK = booksauthorsPK;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (booksauthorsPK != null ? booksauthorsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booksauthors)) {
            return false;
        }
        Booksauthors other = (Booksauthors) object;
        if ((this.booksauthorsPK == null && other.booksauthorsPK != null) || (this.booksauthorsPK != null && !this.booksauthorsPK.equals(other.booksauthorsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.main.entity.Booksauthors[ booksauthorsPK=" + booksauthorsPK + " ]";
    }
    
}
