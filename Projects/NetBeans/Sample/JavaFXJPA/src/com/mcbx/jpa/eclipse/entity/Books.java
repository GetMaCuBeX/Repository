/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.jpa.eclipse.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "books")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b")
    , @NamedQuery(name = "Books.findByIdbooks", query = "SELECT b FROM Books b WHERE b.idbooks = :idbooks")
    , @NamedQuery(name = "Books.findByBarcode", query = "SELECT b FROM Books b WHERE b.barcode = :barcode")
    , @NamedQuery(name = "Books.findByIsbn", query = "SELECT b FROM Books b WHERE b.isbn = :isbn")
    , @NamedQuery(name = "Books.findByPages", query = "SELECT b FROM Books b WHERE b.pages = :pages")
    , @NamedQuery(name = "Books.findByLanguage", query = "SELECT b FROM Books b WHERE b.language = :language")
    , @NamedQuery(name = "Books.findByCost", query = "SELECT b FROM Books b WHERE b.cost = :cost")
    , @NamedQuery(name = "Books.findByPurchasedcost", query = "SELECT b FROM Books b WHERE b.purchasedcost = :purchasedcost")
    , @NamedQuery(name = "Books.findByCopynumber", query = "SELECT b FROM Books b WHERE b.copynumber = :copynumber")
    , @NamedQuery(name = "Books.findByAcquireddate", query = "SELECT b FROM Books b WHERE b.acquireddate = :acquireddate")
    , @NamedQuery(name = "Books.findByIsborrowable", query = "SELECT b FROM Books b WHERE b.isborrowable = :isborrowable")})
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbooks")
    private Integer idbooks;
    @Column(name = "barcode")
    private String barcode;
    @Column(name = "isbn")
    private String isbn;
    @Lob
    @Column(name = "title")
    private String title;
    @Column(name = "pages")
    private Integer pages;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "language")
    private String language;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;
    @Column(name = "purchasedcost")
    private Double purchasedcost;
    @Column(name = "copynumber")
    private Integer copynumber;
    @Column(name = "acquireddate")
    @Temporal(TemporalType.DATE)
    private Date acquireddate;
    @Column(name = "isborrowable")
    private Boolean isborrowable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "books")
    private Collection<Bookspublishers> bookspublishersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "books")
    private Collection<Booksauthors> booksauthorsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "books")
    private Booksimage booksimage;
    @JoinColumn(name = "category_name", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Category categoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "books")
    private Collection<Bookssubjects> bookssubjectsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "books")
    private Collection<Reserve> reserveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "books")
    private Collection<Borrow> borrowCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booksIdbooks")
    private Collection<Logsborrowedbooks> logsborrowedbooksCollection;

    public Books() {
    }

    public Books(Integer idbooks) {
        this.idbooks = idbooks;
    }

    public Integer getIdbooks() {
        return idbooks;
    }

    public void setIdbooks(Integer idbooks) {
        this.idbooks = idbooks;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public Boolean getIsborrowable() {
        return isborrowable;
    }

    public void setIsborrowable(Boolean isborrowable) {
        this.isborrowable = isborrowable;
    }

    @XmlTransient
    public Collection<Bookspublishers> getBookspublishersCollection() {
        return bookspublishersCollection;
    }

    public void setBookspublishersCollection(Collection<Bookspublishers> bookspublishersCollection) {
        this.bookspublishersCollection = bookspublishersCollection;
    }

    @XmlTransient
    public Collection<Booksauthors> getBooksauthorsCollection() {
        return booksauthorsCollection;
    }

    public void setBooksauthorsCollection(Collection<Booksauthors> booksauthorsCollection) {
        this.booksauthorsCollection = booksauthorsCollection;
    }

    public Booksimage getBooksimage() {
        return booksimage;
    }

    public void setBooksimage(Booksimage booksimage) {
        this.booksimage = booksimage;
    }

    public Category getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }

    @XmlTransient
    public Collection<Bookssubjects> getBookssubjectsCollection() {
        return bookssubjectsCollection;
    }

    public void setBookssubjectsCollection(Collection<Bookssubjects> bookssubjectsCollection) {
        this.bookssubjectsCollection = bookssubjectsCollection;
    }

    @XmlTransient
    public Collection<Reserve> getReserveCollection() {
        return reserveCollection;
    }

    public void setReserveCollection(Collection<Reserve> reserveCollection) {
        this.reserveCollection = reserveCollection;
    }

    @XmlTransient
    public Collection<Borrow> getBorrowCollection() {
        return borrowCollection;
    }

    public void setBorrowCollection(Collection<Borrow> borrowCollection) {
        this.borrowCollection = borrowCollection;
    }

    @XmlTransient
    public Collection<Logsborrowedbooks> getLogsborrowedbooksCollection() {
        return logsborrowedbooksCollection;
    }

    public void setLogsborrowedbooksCollection(Collection<Logsborrowedbooks> logsborrowedbooksCollection) {
        this.logsborrowedbooksCollection = logsborrowedbooksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbooks != null ? idbooks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.idbooks == null && other.idbooks != null) || (this.idbooks != null && !this.idbooks.equals(other.idbooks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.jpa.entity.Books[ idbooks=" + idbooks + " ]";
    }
    
}
