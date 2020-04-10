package com.example;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "alien")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "findAll", query = "SELECT a FROM Alien a")
        , @NamedQuery(name = "findByAid", query = "SELECT a FROM Alien a WHERE a.id = :id")
        , @NamedQuery(name = "findByName", query = "SELECT a FROM Alien a WHERE a.name = :name")
        , @NamedQuery(name = "findByTechnology", query = "SELECT a FROM Alien a WHERE a.technology = :technology")
})
public class Alien {
    private Integer id;
    private String name;
    private String technology;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "technology", nullable = true, length = 255)
    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alien alien = (Alien) o;

        if (id != null ? !id.equals(alien.id) : alien.id != null) return false;
        if (name != null ? !name.equals(alien.name) : alien.name != null) return false;
        if (technology != null ? !technology.equals(alien.technology) : alien.technology != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (technology != null ? technology.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", technology='" + technology + '\'' +
                '}';
    }
}
