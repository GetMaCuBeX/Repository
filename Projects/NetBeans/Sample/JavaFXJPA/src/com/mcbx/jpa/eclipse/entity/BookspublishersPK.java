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
public class BookspublishersPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "books_idbooks")
    private int booksIdbooks;
    @Basic(optional = false)
    @Column(name = "publishers_idpublishers")
    private int publishersIdpublishers;

    public BookspublishersPK() {
    }

    public BookspublishersPK(int booksIdbooks, int publishersIdpublishers) {
        this.booksIdbooks = booksIdbooks;
        this.publishersIdpublishers = publishersIdpublishers;
    }

    public int getBooksIdbooks() {
        return booksIdbooks;
    }

    public void setBooksIdbooks(int booksIdbooks) {
        this.booksIdbooks = booksIdbooks;
    }

    public int getPublishersIdpublishers() {
        return publishersIdpublishers;
    }

    public void setPublishersIdpublishers(int publishersIdpublishers) {
        this.publishersIdpublishers = publishersIdpublishers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) booksIdbooks;
        hash += (int) publishersIdpublishers;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookspublishersPK)) {
            return false;
        }
        BookspublishersPK other = (BookspublishersPK) object;
        if (this.booksIdbooks != other.booksIdbooks) {
            return false;
        }
        if (this.publishersIdpublishers != other.publishersIdpublishers) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.BookspublishersPK[ booksIdbooks=" + booksIdbooks + ", publishersIdpublishers=" + publishersIdpublishers + " ]";
    }
    
}
