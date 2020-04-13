/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main.entity;

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
@Table(name = "reserve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserve.findAll", query = "SELECT r FROM Reserve r")
    , @NamedQuery(name = "Reserve.findByIdreserve", query = "SELECT r FROM Reserve r WHERE r.reservePK.idreserve = :idreserve")
    , @NamedQuery(name = "Reserve.findByMembersIdmembers", query = "SELECT r FROM Reserve r WHERE r.reservePK.membersIdmembers = :membersIdmembers")
    , @NamedQuery(name = "Reserve.findByBooksIdbooks", query = "SELECT r FROM Reserve r WHERE r.reservePK.booksIdbooks = :booksIdbooks")
    , @NamedQuery(name = "Reserve.findByReserveddate", query = "SELECT r FROM Reserve r WHERE r.reserveddate = :reserveddate")
    , @NamedQuery(name = "Reserve.findByReservedlimitdate", query = "SELECT r FROM Reserve r WHERE r.reservedlimitdate = :reservedlimitdate")
    , @NamedQuery(name = "Reserve.findByCopies", query = "SELECT r FROM Reserve r WHERE r.copies = :copies")
    , @NamedQuery(name = "Reserve.findByStatus", query = "SELECT r FROM Reserve r WHERE r.status = :status")})
public class Reserve implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReservePK reservePK;
    @Column(name = "reserveddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reserveddate;
    @Column(name = "reservedlimitdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reservedlimitdate;
    @Column(name = "copies")
    private Integer copies;
    @Lob
    @Column(name = "notes")
    private String notes;
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "members_idmembers", referencedColumnName = "idmembers", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Members members;
    @JoinColumn(name = "books_idbooks", referencedColumnName = "idbooks", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Books books;

    public Reserve() {
    }

    public Reserve(ReservePK reservePK) {
        this.reservePK = reservePK;
    }

    public Reserve(int idreserve, int membersIdmembers, int booksIdbooks) {
        this.reservePK = new ReservePK(idreserve, membersIdmembers, booksIdbooks);
    }

    public ReservePK getReservePK() {
        return reservePK;
    }

    public void setReservePK(ReservePK reservePK) {
        this.reservePK = reservePK;
    }

    public Date getReserveddate() {
        return reserveddate;
    }

    public void setReserveddate(Date reserveddate) {
        this.reserveddate = reserveddate;
    }

    public Date getReservedlimitdate() {
        return reservedlimitdate;
    }

    public void setReservedlimitdate(Date reservedlimitdate) {
        this.reservedlimitdate = reservedlimitdate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        hash += (reservePK != null ? reservePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserve)) {
            return false;
        }
        Reserve other = (Reserve) object;
        if ((this.reservePK == null && other.reservePK != null) || (this.reservePK != null && !this.reservePK.equals(other.reservePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.main.entity.Reserve[ reservePK=" + reservePK + " ]";
    }
    
}
