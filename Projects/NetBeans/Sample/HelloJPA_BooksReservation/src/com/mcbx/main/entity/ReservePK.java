/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Administrator
 */
@Embeddable
public class ReservePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idreserve")
    private int idreserve;
    @Basic(optional = false)
    @Column(name = "members_idmembers")
    private int membersIdmembers;
    @Basic(optional = false)
    @Column(name = "books_idbooks")
    private int booksIdbooks;

    public ReservePK() {
    }

    public ReservePK(int idreserve, int membersIdmembers, int booksIdbooks) {
        this.idreserve = idreserve;
        this.membersIdmembers = membersIdmembers;
        this.booksIdbooks = booksIdbooks;
    }

    public int getIdreserve() {
        return idreserve;
    }

    public void setIdreserve(int idreserve) {
        this.idreserve = idreserve;
    }

    public int getMembersIdmembers() {
        return membersIdmembers;
    }

    public void setMembersIdmembers(int membersIdmembers) {
        this.membersIdmembers = membersIdmembers;
    }

    public int getBooksIdbooks() {
        return booksIdbooks;
    }

    public void setBooksIdbooks(int booksIdbooks) {
        this.booksIdbooks = booksIdbooks;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idreserve;
        hash += (int) membersIdmembers;
        hash += (int) booksIdbooks;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservePK)) {
            return false;
        }
        ReservePK other = (ReservePK) object;
        if (this.idreserve != other.idreserve) {
            return false;
        }
        if (this.membersIdmembers != other.membersIdmembers) {
            return false;
        }
        if (this.booksIdbooks != other.booksIdbooks) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.main.entity.ReservePK[ idreserve=" + idreserve + ", membersIdmembers=" + membersIdmembers + ", booksIdbooks=" + booksIdbooks + " ]";
    }
    
}
