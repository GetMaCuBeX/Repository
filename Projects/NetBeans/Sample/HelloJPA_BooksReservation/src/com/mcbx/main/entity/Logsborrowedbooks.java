/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "logsborrowedbooks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logsborrowedbooks.findAll", query = "SELECT l FROM Logsborrowedbooks l")
    , @NamedQuery(name = "Logsborrowedbooks.findByIdlogsborrowedbooks", query = "SELECT l FROM Logsborrowedbooks l WHERE l.idlogsborrowedbooks = :idlogsborrowedbooks")
    , @NamedQuery(name = "Logsborrowedbooks.findByBorroweddate", query = "SELECT l FROM Logsborrowedbooks l WHERE l.borroweddate = :borroweddate")})
public class Logsborrowedbooks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlogsborrowedbooks")
    private Integer idlogsborrowedbooks;
    @Basic(optional = false)
    @Column(name = "borroweddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date borroweddate;
    @JoinColumn(name = "books_idbooks", referencedColumnName = "idbooks")
    @ManyToOne(optional = false)
    private Books booksIdbooks;

    public Logsborrowedbooks() {
    }

    public Logsborrowedbooks(Integer idlogsborrowedbooks) {
        this.idlogsborrowedbooks = idlogsborrowedbooks;
    }

    public Logsborrowedbooks(Integer idlogsborrowedbooks, Date borroweddate) {
        this.idlogsborrowedbooks = idlogsborrowedbooks;
        this.borroweddate = borroweddate;
    }

    public Integer getIdlogsborrowedbooks() {
        return idlogsborrowedbooks;
    }

    public void setIdlogsborrowedbooks(Integer idlogsborrowedbooks) {
        this.idlogsborrowedbooks = idlogsborrowedbooks;
    }

    public Date getBorroweddate() {
        return borroweddate;
    }

    public void setBorroweddate(Date borroweddate) {
        this.borroweddate = borroweddate;
    }

    public Books getBooksIdbooks() {
        return booksIdbooks;
    }

    public void setBooksIdbooks(Books booksIdbooks) {
        this.booksIdbooks = booksIdbooks;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlogsborrowedbooks != null ? idlogsborrowedbooks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logsborrowedbooks)) {
            return false;
        }
        Logsborrowedbooks other = (Logsborrowedbooks) object;
        if ((this.idlogsborrowedbooks == null && other.idlogsborrowedbooks != null) || (this.idlogsborrowedbooks != null && !this.idlogsborrowedbooks.equals(other.idlogsborrowedbooks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.main.entity.Logsborrowedbooks[ idlogsborrowedbooks=" + idlogsborrowedbooks + " ]";
    }
    
}
