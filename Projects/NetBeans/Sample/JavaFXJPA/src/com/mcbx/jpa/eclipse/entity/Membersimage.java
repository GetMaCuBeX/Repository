/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.jpa.eclipse.entity;

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
@Table(name = "membersimage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membersimage.findAll", query = "SELECT m FROM Membersimage m")
    , @NamedQuery(name = "Membersimage.findByMembersIdmembers", query = "SELECT m FROM Membersimage m WHERE m.membersIdmembers = :membersIdmembers")})
public class Membersimage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "members_idmembers")
    private Integer membersIdmembers;
    @Lob
    @Column(name = "fileextension")
    private String fileextension;
    @Lob
    @Column(name = "imgblob")
    private byte[] imgblob;
    @JoinColumn(name = "members_idmembers", referencedColumnName = "idmembers", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Members members;

    public Membersimage() {
    }

    public Membersimage(Integer membersIdmembers) {
        this.membersIdmembers = membersIdmembers;
    }

    public Integer getMembersIdmembers() {
        return membersIdmembers;
    }

    public void setMembersIdmembers(Integer membersIdmembers) {
        this.membersIdmembers = membersIdmembers;
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

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membersIdmembers != null ? membersIdmembers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membersimage)) {
            return false;
        }
        Membersimage other = (Membersimage) object;
        if ((this.membersIdmembers == null && other.membersIdmembers != null) || (this.membersIdmembers != null && !this.membersIdmembers.equals(other.membersIdmembers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.Membersimage[ membersIdmembers=" + membersIdmembers + " ]";
    }
    
}
