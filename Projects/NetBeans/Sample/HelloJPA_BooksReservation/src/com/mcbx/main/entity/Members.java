/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcbx.main.entity;

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
@Table(name = "members")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Members.findAll", query = "SELECT m FROM Members m")
    , @NamedQuery(name = "Members.findByIdmembers", query = "SELECT m FROM Members m WHERE m.idmembers = :idmembers")
    , @NamedQuery(name = "Members.findByIdnumber", query = "SELECT m FROM Members m WHERE m.idnumber = :idnumber")
    , @NamedQuery(name = "Members.findByFirstname", query = "SELECT m FROM Members m WHERE m.firstname = :firstname")
    , @NamedQuery(name = "Members.findByMiddleinitial", query = "SELECT m FROM Members m WHERE m.middleinitial = :middleinitial")
    , @NamedQuery(name = "Members.findByLastname", query = "SELECT m FROM Members m WHERE m.lastname = :lastname")
    , @NamedQuery(name = "Members.findByDateofbirth", query = "SELECT m FROM Members m WHERE m.dateofbirth = :dateofbirth")
    , @NamedQuery(name = "Members.findByGender", query = "SELECT m FROM Members m WHERE m.gender = :gender")
    , @NamedQuery(name = "Members.findByAddress1", query = "SELECT m FROM Members m WHERE m.address1 = :address1")
    , @NamedQuery(name = "Members.findByAddress2", query = "SELECT m FROM Members m WHERE m.address2 = :address2")
    , @NamedQuery(name = "Members.findByPhonenumber1", query = "SELECT m FROM Members m WHERE m.phonenumber1 = :phonenumber1")
    , @NamedQuery(name = "Members.findByPhonenumber2", query = "SELECT m FROM Members m WHERE m.phonenumber2 = :phonenumber2")
    , @NamedQuery(name = "Members.findByEmailaddress", query = "SELECT m FROM Members m WHERE m.emailaddress = :emailaddress")
    , @NamedQuery(name = "Members.findByRegistereddate", query = "SELECT m FROM Members m WHERE m.registereddate = :registereddate")
    , @NamedQuery(name = "Members.findByMembertype", query = "SELECT m FROM Members m WHERE m.membertype = :membertype")
    , @NamedQuery(name = "Members.findByIsblocked", query = "SELECT m FROM Members m WHERE m.isblocked = :isblocked")
    , @NamedQuery(name = "Members.findByUsername", query = "SELECT m FROM Members m WHERE m.username = :username")
    , @NamedQuery(name = "Members.findByPassword", query = "SELECT m FROM Members m WHERE m.password = :password")})
public class Members implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmembers")
    private Integer idmembers;
    @Column(name = "idnumber")
    private String idnumber;
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "middleinitial")
    private Character middleinitial;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "phonenumber1")
    private String phonenumber1;
    @Column(name = "phonenumber2")
    private String phonenumber2;
    @Column(name = "emailaddress")
    private String emailaddress;
    @Column(name = "registereddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registereddate;
    @Basic(optional = false)
    @Column(name = "membertype")
    private String membertype;
    @Column(name = "isblocked")
    private Boolean isblocked;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "members")
    private Membersimage membersimage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "members")
    private Collection<Reserve> reserveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "members")
    private Collection<Borrow> borrowCollection;

    public Members() {
    }

    public Members(Integer idmembers) {
        this.idmembers = idmembers;
    }

    public Members(Integer idmembers, Character middleinitial, String gender, String membertype) {
        this.idmembers = idmembers;
        this.middleinitial = middleinitial;
        this.gender = gender;
        this.membertype = membertype;
    }

    public Integer getIdmembers() {
        return idmembers;
    }

    public void setIdmembers(Integer idmembers) {
        this.idmembers = idmembers;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Character getMiddleinitial() {
        return middleinitial;
    }

    public void setMiddleinitial(Character middleinitial) {
        this.middleinitial = middleinitial;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhonenumber1() {
        return phonenumber1;
    }

    public void setPhonenumber1(String phonenumber1) {
        this.phonenumber1 = phonenumber1;
    }

    public String getPhonenumber2() {
        return phonenumber2;
    }

    public void setPhonenumber2(String phonenumber2) {
        this.phonenumber2 = phonenumber2;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public Date getRegistereddate() {
        return registereddate;
    }

    public void setRegistereddate(Date registereddate) {
        this.registereddate = registereddate;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public Boolean getIsblocked() {
        return isblocked;
    }

    public void setIsblocked(Boolean isblocked) {
        this.isblocked = isblocked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Membersimage getMembersimage() {
        return membersimage;
    }

    public void setMembersimage(Membersimage membersimage) {
        this.membersimage = membersimage;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmembers != null ? idmembers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Members)) {
            return false;
        }
        Members other = (Members) object;
        if ((this.idmembers == null && other.idmembers != null) || (this.idmembers != null && !this.idmembers.equals(other.idmembers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mcbx.main.entity.Members[ idmembers=" + idmembers + " ]";
    }
    
}
