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
public class BooksauthorsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "books_idbooks")
    private int booksIdbooks;
    @Basic(optional = false)
    @Column(name = "authors_idauthors")
    private int authorsIdauthors;

    public BooksauthorsPK() {
    }

    public BooksauthorsPK(int booksIdbooks, int authorsIdauthors) {
        this.booksIdbooks = booksIdbooks;
        this.authorsIdauthors = authorsIdauthors;
    }

    public int getBooksIdbooks() {
        return booksIdbooks;
    }

    public void setBooksIdbooks(int booksIdbooks) {
        this.booksIdbooks = booksIdbooks;
    }

    public int getAuthorsIdauthors() {
        return authorsIdauthors;
    }

    public void setAuthorsIdauthors(int authorsIdauthors) {
        this.authorsIdauthors = authorsIdauthors;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) booksIdbooks;
        hash += (int) authorsIdauthors;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BooksauthorsPK)) {
            return false;
        }
        BooksauthorsPK other = (BooksauthorsPK) object;
        if (this.booksIdbooks != other.booksIdbooks) {
            return false;
        }
        if (this.authorsIdauthors != other.authorsIdauthors) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.BooksauthorsPK[ booksIdbooks=" + booksIdbooks + ", authorsIdauthors=" + authorsIdauthors + " ]";
    }
    
}
