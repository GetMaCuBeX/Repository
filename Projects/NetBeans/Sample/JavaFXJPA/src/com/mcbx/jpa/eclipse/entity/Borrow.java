/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.jpa.eclipse.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "borrow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Borrow.findAll", query = "SELECT b FROM Borrow b")
    , @NamedQuery(name = "Borrow.findByIdborrow", query = "SELECT b FROM Borrow b WHERE b.borrowPK.idborrow = :idborrow")
    , @NamedQuery(name = "Borrow.findByMembersIdmembers", query = "SELECT b FROM Borrow b WHERE b.borrowPK.membersIdmembers = :membersIdmembers")
    , @NamedQuery(name = "Borrow.findByBooksIdbooks", query = "SELECT b FROM Borrow b WHERE b.borrowPK.booksIdbooks = :booksIdbooks")
    , @NamedQuery(name = "Borrow.findByBorroweddate", query = "SELECT b FROM Borrow b WHERE b.borroweddate = :borroweddate")
    , @NamedQuery(name = "Borrow.findByBorrowedduedate", query = "SELECT b FROM Borrow b WHERE b.borrowedduedate = :borrowedduedate")
    , @NamedQuery(name = "Borrow.findByCopies", query = "SELECT b FROM Borrow b WHERE b.copies = :copies")
    , @NamedQuery(name = "Borrow.findByReturneddate", query = "SELECT b FROM Borrow b WHERE b.returneddate = :returneddate")
    , @NamedQuery(name = "Borrow.findByFinedamount", query = "SELECT b FROM Borrow b WHERE b.finedamount = :finedamount")
    , @NamedQuery(name = "Borrow.findByStatus", query = "SELECT b FROM Borrow b WHERE b.status = :status")
    , @NamedQuery(name = "Borrow.findByReturnedcopies", query = "SELECT b FROM Borrow b WHERE b.returnedcopies = :returnedcopies")})
public class Borrow implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BorrowPK borrowPK;
    @Column(name = "borroweddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date borroweddate;
    @Column(name = "borrowedduedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowedduedate;
    @Column(name = "copies")
    private Integer copies;
    @Lob
    @Column(name = "notes")
    private String notes;
    @Column(name = "returneddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returneddate;
    @Lob
    @Column(name = "remarks")
    private String remarks;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "finedamount")
    private Double finedamount;
    @Column(name = "status")
    private String status;
    @Column(name = "returnedcopies")
    private Integer returnedcopies;
    @JoinColumn(name = "members_idmembers", referencedColumnName = "idmembers", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Members members;
    @JoinColumn(name = "books_idbooks", referencedColumnName = "idbooks", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;

    public Borrow() {
    }

    public Borrow(BorrowPK borrowPK) {
        this.borrowPK = borrowPK;
    }

    public Borrow(int idborrow, int membersIdmembers, int booksIdbooks) {
        this.borrowPK = new BorrowPK(idborrow, membersIdmembers, booksIdbooks);
    }

    public BorrowPK getBorrowPK() {
        return borrowPK;
    }

    public void setBorrowPK(BorrowPK borrowPK) {
        this.borrowPK = borrowPK;
    }

    public Date getBorroweddate() {
        return borroweddate;
    }

    public void setBorroweddate(Date borroweddate) {
        this.borroweddate = borroweddate;
    }

    public Date getBorrowedduedate() {
        return borrowedduedate;
    }

    public void setBorrowedduedate(Date borrowedduedate) {
        this.borrowedduedate = borrowedduedate;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getReturneddate() {
        return returneddate;
    }

    public void setReturneddate(Date returneddate) {
        this.returneddate = returneddate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Double getFinedamount() {
        return finedamount;
    }

    public void setFinedamount(Double finedamount) {
        this.finedamount = finedamount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getReturnedcopies() {
        return returnedcopies;
    }

    public void setReturnedcopies(Integer returnedcopies) {
        this.returnedcopies = returnedcopies;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
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
        hash += (borrowPK != null ? borrowPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Borrow)) {
            return false;
        }
        Borrow other = (Borrow) object;
        if ((this.borrowPK == null && other.borrowPK != null) || (this.borrowPK != null && !this.borrowPK.equals(other.borrowPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.Borrow[ borrowPK=" + borrowPK + " ]";
    }
    
}
