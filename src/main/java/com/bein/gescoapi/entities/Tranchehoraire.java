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
@Table(name = "tranchehoraire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tranchehoraire.findAll", query = "SELECT t FROM Tranchehoraire t"),
    @NamedQuery(name = "Tranchehoraire.findByIdtranchehoraire", query = "SELECT t FROM Tranchehoraire t WHERE t.idtranchehoraire = :idtranchehoraire"),
    @NamedQuery(name = "Tranchehoraire.findByCode", query = "SELECT t FROM Tranchehoraire t WHERE t.code = :code"),
    @NamedQuery(name = "Tranchehoraire.findByNom", query = "SELECT t FROM Tranchehoraire t WHERE t.nom = :nom"),
    @NamedQuery(name = "Tranchehoraire.findByDuree", query = "SELECT t FROM Tranchehoraire t WHERE t.duree = :duree")})
public class Tranchehoraire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtranchehoraire" , nullable = false)
    private Integer idtranchehoraire;
    @Column(name = "code" , length = 254)
    private String code;

    @Column(name = "nom" , length = 254)
    private String nom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "duree")
    private Double duree;
    @OneToMany(mappedBy = "idtranchehoraire", fetch = FetchType.LAZY)
    private List<Programmationcours> programmationcoursList;

    public Tranchehoraire() {
    }

    public Tranchehoraire(Integer idtranchehoraire) {
        this.idtranchehoraire = idtranchehoraire;
    }

    public Integer getIdtranchehoraire() {
        return idtranchehoraire;
    }

    public void setIdtranchehoraire(Integer idtranchehoraire) {
        this.idtranchehoraire = idtranchehoraire;
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

    public Double getDuree() {
        return duree;
    }

    public void setDuree(Double duree) {
        this.duree = duree;
    }

    @XmlTransient
    public List<Programmationcours> getProgrammationcoursList() {
        return programmationcoursList;
    }

    public void setProgrammationcoursList(List<Programmationcours> programmationcoursList) {
        this.programmationcoursList = programmationcoursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtranchehoraire != null ? idtranchehoraire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tranchehoraire)) {
            return false;
        }
        Tranchehoraire other = (Tranchehoraire) object;
        if ((this.idtranchehoraire == null && other.idtranchehoraire != null) || (this.idtranchehoraire != null && !this.idtranchehoraire.equals(other.idtranchehoraire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tranchehoraire[ idtranchehoraire=" + idtranchehoraire + " ]";
    }
    
}
