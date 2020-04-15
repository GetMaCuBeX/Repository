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
@Table(name = "publishers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publishers.findAll", query = "SELECT p FROM Publishers p")
    , @NamedQuery(name = "Publishers.findByIdpublishers", query = "SELECT p FROM Publishers p WHERE p.idpublishers = :idpublishers")})
public class Publishers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpublishers")
    private Integer idpublishers;
    @Lob
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "city")
    private String city;
    @Lob
    @Column(name = "contactinformation")
    private String contactinformation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publishers")
    private Collection<Bookspublishers> bookspublishersCollection;

    public Publishers() {
    }

    public Publishers(Integer idpublishers) {
        this.idpublishers = idpublishers;
    }

    public Integer getIdpublishers() {
        return idpublishers;
    }

    public void setIdpublishers(Integer idpublishers) {
        this.idpublishers = idpublishers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactinformation() {
        return contactinformation;
    }

    public void setContactinformation(String contactinformation) {
        this.contactinformation = contactinformation;
    }

    @XmlTransient
    public Collection<Bookspublishers> getBookspublishersCollection() {
        return bookspublishersCollection;
    }

    public void setBookspublishersCollection(Collection<Bookspublishers> bookspublishersCollection) {
        this.bookspublishersCollection = bookspublishersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpublishers != null ? idpublishers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publishers)) {
            return false;
        }
        Publishers other = (Publishers) object;
        if ((this.idpublishers == null && other.idpublishers != null) || (this.idpublishers != null && !this.idpublishers.equals(other.idpublishers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.Publishers[ idpublishers=" + idpublishers + " ]";
    }
    
}
