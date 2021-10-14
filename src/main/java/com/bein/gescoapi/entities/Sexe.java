/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bein.gescoapi.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Arianne
 */
@Entity
@Table(name = "sexe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sexe.findAll", query = "SELECT s FROM Sexe s"),
    @NamedQuery(name = "Sexe.findByIdsexe", query = "SELECT s FROM Sexe s WHERE s.idsexe = :idsexe"),
    @NamedQuery(name = "Sexe.findByCode", query = "SELECT s FROM Sexe s WHERE s.code = :code"),
    @NamedQuery(name = "Sexe.findByNom", query = "SELECT s FROM Sexe s WHERE s.nom = :nom")})
public class Sexe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idsexe" , nullable = false)
    private Integer idsexe;

    @Column(name = "code" , length = 10)
    private String code;

    @Column(name = "nom" , length = 254)
    private String nom;

    @OneToMany(mappedBy = "idsexe", fetch = FetchType.LAZY)
    private List<Eleve> eleveList;

    public Sexe() {
    }

    public Sexe(Integer idsexe) {
        this.idsexe = idsexe;
    }

    public Integer getIdsexe() {
        return idsexe;
    }

    public void setIdsexe(Integer idsexe) {
        this.idsexe = idsexe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlTransient
    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsexe != null ? idsexe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sexe)) {
            return false;
        }
        Sexe other = (Sexe) object;
        if ((this.idsexe == null && other.idsexe != null) || (this.idsexe != null && !this.idsexe.equals(other.idsexe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sexe[ idsexe=" + idsexe + " ]";
    }

}
