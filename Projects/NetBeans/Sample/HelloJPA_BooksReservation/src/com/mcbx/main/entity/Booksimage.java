/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "booksimage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booksimage.findAll", query = "SELECT b FROM Booksimage b")
    , @NamedQuery(name = "Booksimage.findByBooksIdbooks", query = "SELECT b FROM Booksimage b WHERE b.booksIdbooks = :booksIdbooks")})
public class Booksimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "books_idbooks")
    private Integer booksIdbooks;
    @Lob
    @Column(name = "fileextension")
    private String fileextension;
    @Lob
    @Column(name = "imgblob")
    private byte[] imgblob;
    @JoinColumn(name = "books_idbooks", referencedColumnName = "idbooks", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Books books;

    public Booksimage() {
    }

    public Booksimage(Integer booksIdbooks) {
        this.booksIdbooks = booksIdbooks;
    }

    public Integer getBooksIdbooks() {
        return booksIdbooks;
    }

    public void setBooksIdbooks(Integer booksIdbooks) {
        this.booksIdbooks = booksIdbooks;
    }

    public String getFileextension() {
        return fileextension;
    }

    public void setFileextension(String fileextension) {
        this.fileextension = fileextension;
    }

    public byte[] getImgblob() {
        return imgblob;
    }

    public void setImgblob(byte[] imgblob) {
        this.imgblob = imgblob;
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
        hash += (booksIdbooks != null ? booksIdbooks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booksimage)) {
            return false;
        }
        Booksimage other = (Booksimage) object;
        if ((this.booksIdbooks == null && other.booksIdbooks != null) || (this.booksIdbooks != null && !this.booksIdbooks.equals(other.booksIdbooks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.main.entity.Booksimage[ booksIdbooks=" + booksIdbooks + " ]";
    }
    
}
