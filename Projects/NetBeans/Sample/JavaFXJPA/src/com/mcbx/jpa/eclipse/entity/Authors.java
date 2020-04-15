/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.jpa.eclipse.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "authors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a")
    , @NamedQuery(name = "Authors.findByIdauthors", query = "SELECT a FROM Authors a WHERE a.idauthors = :idauthors")})
public class Authors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauthors")
    private Integer idauthors;
    @Lob
    @Column(name = "firstname")
    private String firstname;
    @Lob
    @Column(name = "lastname")
    private String lastname;
    @Lob
    @Column(name = "contactinformation")
    private String contactinformation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authors")
    private Collection<Booksauthors> booksauthorsCollection;
    @Lob
    @Column(name = "gender")
    private String gender;
    

    public Authors() {
    }

    public Authors(Integer idauthors) {
        this.idauthors = idauthors;
    }

    public Authors(Integer idauthors, String firstname, String lastname, String contactinformation ,String gender) {
        this.idauthors = idauthors;
        this.firstname = firstname;
        this.lastname = lastname;
        this.contactinformation = contactinformation;
        this.gender = gender;
    }

    public Integer getIdauthors() {
        return idauthors;
    }

    public void setIdauthors(Integer idauthors) {
        this.idauthors = idauthors;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContactinformation() {
        return contactinformation;
    }

    public void setContactinformation(String contactinformation) {
        this.contactinformation = contactinformation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    
    
    @XmlTransient
    public Collection<Booksauthors> getBooksauthorsCollection() {
        return booksauthorsCollection;
    }

    public void setBooksauthorsCollection(Collection<Booksauthors> booksauthorsCollection) {
        this.booksauthorsCollection = booksauthorsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauthors != null ? idauthors.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authors)) {
            return false;
        }
        Authors other = (Authors) object;
        if ((this.idauthors == null && other.idauthors != null) || (this.idauthors != null && !this.idauthors.equals(other.idauthors))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.Authors[ idauthors=" + idauthors + " ]";
    }

}
