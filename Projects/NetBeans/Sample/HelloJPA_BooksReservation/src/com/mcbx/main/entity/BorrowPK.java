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
public class BorrowPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idborrow")
    private int idborrow;
    @Basic(optional = false)
    @Column(name = "members_idmembers")
    private int membersIdmembers;
    @Basic(optional = false)
    @Column(name = "books_idbooks")
    private int booksIdbooks;

    public BorrowPK() {
    }

    public BorrowPK(int idborrow, int membersIdmembers, int booksIdbooks) {
        this.idborrow = idborrow;
        this.membersIdmembers = membersIdmembers;
        this.booksIdbooks = booksIdbooks;
    }

    public int getIdborrow() {
        return idborrow;
    }

    public void setIdborrow(int idborrow) {
        this.idborrow = idborrow;
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
        hash += (int) idborrow;
        hash += (int) membersIdmembers;
        hash += (int) booksIdbooks;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BorrowPK)) {
            return false;
        }
        BorrowPK other = (BorrowPK) object;
        if (this.idborrow != other.idborrow) {
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
        return "com.mcbx.main.entity.BorrowPK[ idborrow=" + idborrow + ", membersIdmembers=" + membersIdmembers + ", booksIdbooks=" + booksIdbooks + " ]";
    }
    
}
