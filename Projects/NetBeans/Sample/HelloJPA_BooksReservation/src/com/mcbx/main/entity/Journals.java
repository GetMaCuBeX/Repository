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
@Table(name = "journals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Journals.findAll", query = "SELECT j FROM Journals j")
    , @NamedQuery(name = "Journals.findByIdjournals", query = "SELECT j FROM Journals j WHERE j.idjournals = :idjournals")
    , @NamedQuery(name = "Journals.findByBarcode", query = "SELECT j FROM Journals j WHERE j.barcode = :barcode")
    , @NamedQuery(name = "Journals.findByTitle", query = "SELECT j FROM Journals j WHERE j.title = :title")
    , @NamedQuery(name = "Journals.findByCopynumber", query = "SELECT j FROM Journals j WHERE j.copynumber = :copynumber")
    , @NamedQuery(name = "Journals.findByAcquireddate", query = "SELECT j FROM Journals j WHERE j.acquireddate = :acquireddate")
    , @NamedQuery(name = "Journals.findByCost", query = "SELECT j FROM Journals j WHERE j.cost = :cost")
    , @NamedQuery(name = "Journals.findByPurchasedcost", query = "SELECT j FROM Journals j WHERE j.purchasedcost = :purchasedcost")})
public class Journals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjournals")
    private Integer idjournals;
    @Column(name = "barcode")
    private String barcode;
    @Column(name = "title")
    private String title;
    @Column(name = "copynumber")
    private Integer copynumber;
    @Column(name = "acquireddate")
    @Temporal(TemporalType.DATE)
    private Date acquireddate;
    @Lob
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;
    @Column(name = "purchasedcost")
    private Double purchasedcost;
    @JoinColumn(name = "category_name", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Category categoryName;

    public Journals() {
    }

    public Journals(Integer idjournals) {
        this.idjournals = idjournals;
    }

    public Integer getIdjournals() {
        return idjournals;
    }

    public void setIdjournals(Integer idjournals) {
        this.idjournals = idjournals;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCopynumber() {
        return copynumber;
    }

    public void setCopynumber(Integer copynumber) {
        this.copynumber = copynumber;
    }

    public Date getAcquireddate() {
        return acquireddate;
    }

    public void setAcquireddate(Date acquireddate) {
        this.acquireddate = acquireddate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPurchasedcost() {
        return purchasedcost;
    }

    public void setPurchasedcost(Double purchasedcost) {
        this.purchasedcost = purchasedcost;
    }

    public Category getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjournals != null ? idjournals.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Journals)) {
            return false;
        }
        Journals other = (Journals) object;
        if ((this.idjournals == null && other.idjournals != null) || (this.idjournals != null && !this.idjournals.equals(other.idjournals))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.main.entity.Journals[ idjournals=" + idjournals + " ]";
    }
    
}
