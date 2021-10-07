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
@Table(name = "tranche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tranche.findAll", query = "SELECT t FROM Tranche t"),
    @NamedQuery(name = "Tranche.findByIdtranche", query = "SELECT t FROM Tranche t WHERE t.idtranche = :idtranche"),
    @NamedQuery(name = "Tranche.findByCode", query = "SELECT t FROM Tranche t WHERE t.code = :code"),
    @NamedQuery(name = "Tranche.findByNom", query = "SELECT t FROM Tranche t WHERE t.nom = :nom")})
public class Tranche implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idtranche" , nullable = false)
    private Integer idtranche;
    @Column(name = "code" , length = 254)
    private String code;

    @Column(name = "nom" , length = 254)
    private String nom;
    @OneToMany(mappedBy = "idtranche", fetch = FetchType.LAZY)
    private List<Programmationscolarite> programmationscolariteList;

    public Tranche() {
    }

    public Tranche(Integer idtranche) {
        this.idtranche = idtranche;
    }

    public Integer getIdtranche() {
        return idtranche;
    }

    public void setIdtranche(Integer idtranche) {
        this.idtranche = idtranche;
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
    public List<Programmationscolarite> getProgrammationscolariteList() {
        return programmationscolariteList;
    }

    public void setProgrammationscolariteList(List<Programmationscolarite> programmationscolariteList) {
        this.programmationscolariteList = programmationscolariteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtranche != null ? idtranche.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tranche)) {
            return false;
        }
        Tranche other = (Tranche) object;
        if ((this.idtranche == null && other.idtranche != null) || (this.idtranche != null && !this.idtranche.equals(other.idtranche))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tranche[ idtranche=" + idtranche + " ]";
    }
    
}
