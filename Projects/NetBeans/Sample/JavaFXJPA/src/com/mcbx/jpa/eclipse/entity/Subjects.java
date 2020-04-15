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
@Table(name = "subjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subjects s")
    , @NamedQuery(name = "Subjects.findByIdsubjects", query = "SELECT s FROM Subjects s WHERE s.idsubjects = :idsubjects")
    , @NamedQuery(name = "Subjects.findByName", query = "SELECT s FROM Subjects s WHERE s.name = :name")})
public class Subjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubjects")
    private Integer idsubjects;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjects")
    private Collection<Bookssubjects> bookssubjectsCollection;

    public Subjects() {
    }

    public Subjects(Integer idsubjects) {
        this.idsubjects = idsubjects;
    }

    public Integer getIdsubjects() {
        return idsubjects;
    }

    public void setIdsubjects(Integer idsubjects) {
        this.idsubjects = idsubjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Bookssubjects> getBookssubjectsCollection() {
        return bookssubjectsCollection;
    }

    public void setBookssubjectsCollection(Collection<Bookssubjects> bookssubjectsCollection) {
        this.bookssubjectsCollection = bookssubjectsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubjects != null ? idsubjects.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.idsubjects == null && other.idsubjects != null) || (this.idsubjects != null && !this.idsubjects.equals(other.idsubjects))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.Subjects[ idsubjects=" + idsubjects + " ]";
    }
    
}
