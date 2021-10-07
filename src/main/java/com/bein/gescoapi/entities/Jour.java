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
 * @author Arianne
 */
@Entity
@Table(name = "jour")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Jour.findAll", query = "SELECT j FROM Jour j"),
        @NamedQuery(name = "Jour.findByIdjour", query = "SELECT j FROM Jour j WHERE j.idjour = :idjour"),
        @NamedQuery(name = "Jour.findByCode", query = "SELECT j FROM Jour j WHERE j.code = :code"),
        @NamedQuery(name = "Jour.findByNom", query = "SELECT j FROM Jour j WHERE j.nom = :nom")})
public class Jour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idjour")
    private Integer idjour;

    @Column(name = "code", length = 254)
    private String code;

    @Column(name = "nom", length = 254)
    private String nom;
    @OneToMany(mappedBy = "idjour", fetch = FetchType.LAZY)
    private List<Programmationcours> programmationcoursList;

    public Jour() {
    }

    public Jour(Integer idjour) {
        this.idjour = idjour;
    }

    public Integer getIdjour() {
        return idjour;
    }

    public void setIdjour(Integer idjour) {
        this.idjour = idjour;
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
    public List<Programmationcours> getProgrammationcoursList() {
        return programmationcoursList;
    }

    public void setProgrammationcoursList(List<Programmationcours> programmationcoursList) {
        this.programmationcoursList = programmationcoursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjour != null ? idjour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jour)) {
            return false;
        }
        Jour other = (Jour) object;
        if ((this.idjour == null && other.idjour != null) || (this.idjour != null && !this.idjour.equals(other.idjour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Jour[ idjour=" + idjour + " ]";
    }

}
