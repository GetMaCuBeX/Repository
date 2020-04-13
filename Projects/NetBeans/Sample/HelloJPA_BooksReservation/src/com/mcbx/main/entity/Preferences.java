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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "preferences")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preferences.findAll", query = "SELECT p FROM Preferences p")
    , @NamedQuery(name = "Preferences.findByIdpreferences", query = "SELECT p FROM Preferences p WHERE p.idpreferences = :idpreferences")
    , @NamedQuery(name = "Preferences.findBySettings", query = "SELECT p FROM Preferences p WHERE p.settings = :settings")
    , @NamedQuery(name = "Preferences.findByValue", query = "SELECT p FROM Preferences p WHERE p.value = :value")})
public class Preferences implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpreferences")
    private Integer idpreferences;
    @Column(name = "settings")
    private String settings;
    @Column(name = "value")
    private Integer value;

    public Preferences() {
    }

    public Preferences(Integer idpreferences) {
        this.idpreferences = idpreferences;
    }

    public Integer getIdpreferences() {
        return idpreferences;
    }

    public void setIdpreferences(Integer idpreferences) {
        this.idpreferences = idpreferences;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpreferences != null ? idpreferences.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preferences)) {
            return false;
        }
        Preferences other = (Preferences) object;
        if ((this.idpreferences == null && other.idpreferences != null) || (this.idpreferences != null && !this.idpreferences.equals(other.idpreferences))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.main.entity.Preferences[ idpreferences=" + idpreferences + " ]";
    }
    
}
