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
@Table(name = "groupematiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupematiere.findAll", query = "SELECT g FROM Groupematiere g"),
    @NamedQuery(name = "Groupematiere.findByIdgroupematiere", query = "SELECT g FROM Groupematiere g WHERE g.idgroupematiere = :idgroupematiere"),
    @NamedQuery(name = "Groupematiere.findByCode", query = "SELECT g FROM Groupematiere g WHERE g.code = :code"),
    @NamedQuery(name = "Groupematiere.findByNom", query = "SELECT g FROM Groupematiere g WHERE g.nom = :nom")})
public class Groupematiere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idgroupematiere")
    private Integer idgroupematiere;
    @Column(name = "code" , length = 10)
    private String code;
    @Column(name = "nom" , length = 50)
    private String nom;
    @OneToMany(mappedBy = "idgroupematiere", fetch = FetchType.LAZY)
    private List<Matiere> matiereList;
    @OneToMany(mappedBy = "idgroupematiere", fetch = FetchType.LAZY)
    private List<MatiereNiveau> matiereNiveauList;

    public Groupematiere() {
    }

    public Groupematiere(Integer idgroupematiere) {
        this.idgroupematiere = idgroupematiere;
    }

    public Integer getIdgroupematiere() {
        return idgroupematiere;
    }

    public void setIdgroupematiere(Integer idgroupematiere) {
        this.idgroupematiere = idgroupematiere;
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
    public List<Matiere> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }

    @XmlTransient
    public List<MatiereNiveau> getMatiereNiveauList() {
        return matiereNiveauList;
    }

    public void setMatiereNiveauList(List<MatiereNiveau> matiereNiveauList) {
        this.matiereNiveauList = matiereNiveauList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgroupematiere != null ? idgroupematiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupematiere)) {
            return false;
        }
        Groupematiere other = (Groupematiere) object;
        if ((this.idgroupematiere == null && other.idgroupematiere != null) || (this.idgroupematiere != null && !this.idgroupematiere.equals(other.idgroupematiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Groupematiere[ idgroupematiere=" + idgroupematiere + " ]";
    }
    
}
