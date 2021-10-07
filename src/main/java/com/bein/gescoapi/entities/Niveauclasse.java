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
@Table(name = "niveauclasse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveauclasse.findAll", query = "SELECT n FROM Niveauclasse n"),
    @NamedQuery(name = "Niveauclasse.findByIdniveauclasse", query = "SELECT n FROM Niveauclasse n WHERE n.idniveauclasse = :idniveauclasse"),
    @NamedQuery(name = "Niveauclasse.findByNom", query = "SELECT n FROM Niveauclasse n WHERE n.nom = :nom"),
    @NamedQuery(name = "Niveauclasse.findByNumero", query = "SELECT n FROM Niveauclasse n WHERE n.numero = :numero")})
public class Niveauclasse implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idniveauclasse")
    private Integer idniveauclasse;
    @Column(name = "nom" , length = 100)
    private String nom;
    @Column(name = "numero")
    private Integer numero;
    @OneToMany(mappedBy = "idniveauclasse", fetch = FetchType.LAZY)
    private List<MatiereNiveau> matiereNiveauList;
    @OneToMany(mappedBy = "idniveauclasse", fetch = FetchType.LAZY)
    private List<Classe> classeList;

    public Niveauclasse() {
    }

    public Niveauclasse(Integer idniveauclasse) {
        this.idniveauclasse = idniveauclasse;
    }

    public Integer getIdniveauclasse() {
        return idniveauclasse;
    }

    public void setIdniveauclasse(Integer idniveauclasse) {
        this.idniveauclasse = idniveauclasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @XmlTransient
    public List<MatiereNiveau> getMatiereNiveauList() {
        return matiereNiveauList;
    }

    public void setMatiereNiveauList(List<MatiereNiveau> matiereNiveauList) {
        this.matiereNiveauList = matiereNiveauList;
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
        hash += (idniveauclasse != null ? idniveauclasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveauclasse)) {
            return false;
        }
        Niveauclasse other = (Niveauclasse) object;
        if ((this.idniveauclasse == null && other.idniveauclasse != null) || (this.idniveauclasse != null && !this.idniveauclasse.equals(other.idniveauclasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Niveauclasse[ idniveauclasse=" + idniveauclasse + " ]";
    }

    }
