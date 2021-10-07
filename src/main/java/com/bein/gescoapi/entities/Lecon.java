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
@Table(name = "lecon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecon.findAll", query = "SELECT l FROM Lecon l"),
    @NamedQuery(name = "Lecon.findByIdlecon", query = "SELECT l FROM Lecon l WHERE l.idlecon = :idlecon"),
    @NamedQuery(name = "Lecon.findByCode", query = "SELECT l FROM Lecon l WHERE l.code = :code"),
    @NamedQuery(name = "Lecon.findByNom", query = "SELECT l FROM Lecon l WHERE l.nom = :nom"),
    @NamedQuery(name = "Lecon.findByNumordre", query = "SELECT l FROM Lecon l WHERE l.numordre = :numordre")})
public class Lecon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idlecon")
    private Integer idlecon;

    @Column(name = "code" , length = 254)
    private String code;

    @Column(name = "nom" , length = 254)
    private String nom;
    @Column(name = "numordre")
    private Integer numordre;
    @ManyToMany(mappedBy = "leconList", fetch = FetchType.LAZY)
    private List<Cours> coursList;
    @JoinColumn(name = "idanneescolaire", referencedColumnName = "idanneescolaire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anneescolaire idanneescolaire;
    @JoinColumn(name = "idmatiere", referencedColumnName = "idmatiere")
    @ManyToOne(fetch = FetchType.LAZY)
    private Matiere idmatiere;

    public Lecon() {
    }

    public Lecon(Integer idlecon) {
        this.idlecon = idlecon;
    }

    public Integer getIdlecon() {
        return idlecon;
    }

    public void setIdlecon(Integer idlecon) {
        this.idlecon = idlecon;
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

    public Integer getNumordre() {
        return numordre;
    }

    public void setNumordre(Integer numordre) {
        this.numordre = numordre;
    }

    @XmlTransient
    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    public Anneescolaire getIdanneescolaire() {
        return idanneescolaire;
    }

    public void setIdanneescolaire(Anneescolaire idanneescolaire) {
        this.idanneescolaire = idanneescolaire;
    }

    public Matiere getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(Matiere idmatiere) {
        this.idmatiere = idmatiere;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlecon != null ? idlecon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecon)) {
            return false;
        }
        Lecon other = (Lecon) object;
        if ((this.idlecon == null && other.idlecon != null) || (this.idlecon != null && !this.idlecon.equals(other.idlecon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lecon[ idlecon=" + idlecon + " ]";
    }
    
}
