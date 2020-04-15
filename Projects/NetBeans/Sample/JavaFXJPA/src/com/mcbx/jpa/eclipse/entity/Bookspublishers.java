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
@Table(name = "bookspublishers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookspublishers.findAll", query = "SELECT b FROM Bookspublishers b")
    , @NamedQuery(name = "Bookspublishers.findByBooksIdbooks", query = "SELECT b FROM Bookspublishers b WHERE b.bookspublishersPK.booksIdbooks = :booksIdbooks")
    , @NamedQuery(name = "Bookspublishers.findByPublishersIdpublishers", query = "SELECT b FROM Bookspublishers b WHERE b.bookspublishersPK.publishersIdpublishers = :publishersIdpublishers")})
public class Bookspublishers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BookspublishersPK bookspublishersPK;
    @JoinColumn(name = "publishers_idpublishers", referencedColumnName = "idpublishers", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Publishers publishers;
    @JoinColumn(name = "books_idbooks", referencedColumnName = "idbooks", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;

    public Bookspublishers() {
    }

    public Bookspublishers(BookspublishersPK bookspublishersPK) {
        this.bookspublishersPK = bookspublishersPK;
    }

    public Bookspublishers(int booksIdbooks, int publishersIdpublishers) {
        this.bookspublishersPK = new BookspublishersPK(booksIdbooks, publishersIdpublishers);
    }

    public BookspublishersPK getBookspublishersPK() {
        return bookspublishersPK;
    }

    public void setBookspublishersPK(BookspublishersPK bookspublishersPK) {
        this.bookspublishersPK = bookspublishersPK;
    }

    public Publishers getPublishers() {
        return publishers;
    }

    public void setPublishers(Publishers publishers) {
        this.publishers = publishers;
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
        hash += (bookspublishersPK != null ? bookspublishersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookspublishers)) {
            return false;
        }
        Bookspublishers other = (Bookspublishers) object;
        if ((this.bookspublishersPK == null && other.bookspublishersPK != null) || (this.bookspublishersPK != null && !this.bookspublishersPK.equals(other.bookspublishersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.Bookspublishers[ bookspublishersPK=" + bookspublishersPK + " ]";
    }
    
}
