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
@Table(name = "groupe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g"),
    @NamedQuery(name = "Groupe.findByIdgroupe", query = "SELECT g FROM Groupe g WHERE g.idgroupe = :idgroupe"),
    @NamedQuery(name = "Groupe.findByCode", query = "SELECT g FROM Groupe g WHERE g.code = :code"),
    @NamedQuery(name = "Groupe.findByNom", query = "SELECT g FROM Groupe g WHERE g.nom = :nom")})
public class Groupe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idgroupe")
    private Integer idgroupe;
    @Column(name = "code" , length = 254)
    private String code;
    @Column(name = "nom" , length = 254)
    private String nom;
    @OneToMany(mappedBy = "idgroupe", fetch = FetchType.LAZY)
    private List<Fraisscolarite> fraisscolariteList;
    @OneToMany(mappedBy = "idgroupe", fetch = FetchType.LAZY)
    private List<Classe> classeList;

    public Groupe() {
    }

    public Groupe(Integer idgroupe) {
        this.idgroupe = idgroupe;
    }

    public Integer getIdgroupe() {
        return idgroupe;
    }

    public void setIdgroupe(Integer idgroupe) {
        this.idgroupe = idgroupe;
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
    public List<Fraisscolarite> getFraisscolariteList() {
        return fraisscolariteList;
    }

    public void setFraisscolariteList(List<Fraisscolarite> fraisscolariteList) {
        this.fraisscolariteList = fraisscolariteList;
    }

    @XmlTransient
    public List<Classe> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<Classe> classeList) {
        this.classeList = classeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgroupe != null ? idgroupe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.idgroupe == null && other.idgroupe != null) || (this.idgroupe != null && !this.idgroupe.equals(other.idgroupe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Groupe[ idgroupe=" + idgroupe + " ]";
    }

    }
