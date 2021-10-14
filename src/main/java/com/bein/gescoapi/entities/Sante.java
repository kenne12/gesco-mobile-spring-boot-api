/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bein.gescoapi.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author Arianne
 */
@Entity
@Table(name = "sante")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Sante.findAll", query = "SELECT s FROM Sante s"),
        @NamedQuery(name = "Sante.findByIdsante", query = "SELECT s FROM Sante s WHERE s.idsante = :idsante"),
        @NamedQuery(name = "Sante.findByCode", query = "SELECT s FROM Sante s WHERE s.code = :code"),
        @NamedQuery(name = "Sante.findByNom", query = "SELECT s FROM Sante s WHERE s.nom = :nom")})
public class Sante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idsante", nullable = false)
    private Integer idsante;

    @Column(name = "code", length = 254)
    private String code;

    @Column(name = "nom", length = 254)
    private String nom;
    @OneToMany(mappedBy = "idsante", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;

    public Sante() {
    }

    public Sante(Integer idsante) {
        this.idsante = idsante;
    }

    public Integer getIdsante() {
        return idsante;
    }

    public void setIdsante(Integer idsante) {
        this.idsante = idsante;
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


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsante != null ? idsante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sante)) {
            return false;
        }
        Sante other = (Sante) object;
        if ((this.idsante == null && other.idsante != null) || (this.idsante != null && !this.idsante.equals(other.idsante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sante[ idsante=" + idsante + " ]";
    }

}
