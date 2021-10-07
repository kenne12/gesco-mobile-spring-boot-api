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
@Table(name = "statut")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statut.findAll", query = "SELECT s FROM Statut s"),
    @NamedQuery(name = "Statut.findByIdstatut", query = "SELECT s FROM Statut s WHERE s.idstatut = :idstatut"),
    @NamedQuery(name = "Statut.findByCode", query = "SELECT s FROM Statut s WHERE s.code = :code"),
    @NamedQuery(name = "Statut.findByNom", query = "SELECT s FROM Statut s WHERE s.nom = :nom")})
public class Statut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idstatut" , nullable = false)
    private Integer idstatut;
    @Column(name = "code" , length = 254)
    private String code;

    @Column(name = "nom" , length = 254)
    private String nom;
    @OneToMany(mappedBy = "idstatut", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;

    public Statut() {
    }

    public Statut(Integer idstatut) {
        this.idstatut = idstatut;
    }

    public Integer getIdstatut() {
        return idstatut;
    }

    public void setIdstatut(Integer idstatut) {
        this.idstatut = idstatut;
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
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstatut != null ? idstatut.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statut)) {
            return false;
        }
        Statut other = (Statut) object;
        if ((this.idstatut == null && other.idstatut != null) || (this.idstatut != null && !this.idstatut.equals(other.idstatut))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Statut[ idstatut=" + idstatut + " ]";
    }
    
}
