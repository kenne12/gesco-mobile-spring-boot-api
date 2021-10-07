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
@Table(name = "ville")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ville.findAll", query = "SELECT v FROM Ville v"),
    @NamedQuery(name = "Ville.findByIdville", query = "SELECT v FROM Ville v WHERE v.idville = :idville"),
    @NamedQuery(name = "Ville.findByCode", query = "SELECT v FROM Ville v WHERE v.code = :code"),
    @NamedQuery(name = "Ville.findByNom", query = "SELECT v FROM Ville v WHERE v.nom = :nom")})
public class Ville implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idville" , nullable = false)
    private Integer idville;

    @Column(name = "code" , length = 254)
    private String code;

    @Column(name = "nom" , length = 254)
    private String nom;
    @OneToMany(mappedBy = "idville", fetch = FetchType.LAZY)
    private List<Quartier> quartierList;

    public Ville() {
    }

    public Ville(Integer idville) {
        this.idville = idville;
    }

    public Integer getIdville() {
        return idville;
    }

    public void setIdville(Integer idville) {
        this.idville = idville;
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
    public List<Quartier> getQuartierList() {
        return quartierList;
    }

    public void setQuartierList(List<Quartier> quartierList) {
        this.quartierList = quartierList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idville != null ? idville.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ville)) {
            return false;
        }
        Ville other = (Ville) object;
        if ((this.idville == null && other.idville != null) || (this.idville != null && !this.idville.equals(other.idville))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ville[ idville=" + idville + " ]";
    }
    
}
