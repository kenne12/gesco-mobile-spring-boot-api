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
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Arianne
 */
@Entity
@Table(name = "tarifhoraire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifhoraire.findAll", query = "SELECT t FROM Tarifhoraire t"),
    @NamedQuery(name = "Tarifhoraire.findByIdtarifhoraire", query = "SELECT t FROM Tarifhoraire t WHERE t.idtarifhoraire = :idtarifhoraire"),
    @NamedQuery(name = "Tarifhoraire.findByCu", query = "SELECT t FROM Tarifhoraire t WHERE t.cu = :cu")})
public class Tarifhoraire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtarifhoraire" , nullable = false)
    private Integer idtarifhoraire;
    @Column(name = "cu")
    private BigInteger cu;
    @OneToMany(mappedBy = "idtarifhoraire", fetch = FetchType.LAZY)
    private List<Cours> coursList;
    @JoinColumn(name = "idenseignant", referencedColumnName = "idenseignant")
    @ManyToOne(fetch = FetchType.LAZY)
    private Enseignant idenseignant;
    @JoinColumn(name = "idmatiere", referencedColumnName = "idmatiere")
    @ManyToOne(fetch = FetchType.LAZY)
    private Matiere idmatiere;

    public Tarifhoraire() {
    }

    public Tarifhoraire(Integer idtarifhoraire) {
        this.idtarifhoraire = idtarifhoraire;
    }

    public Integer getIdtarifhoraire() {
        return idtarifhoraire;
    }

    public void setIdtarifhoraire(Integer idtarifhoraire) {
        this.idtarifhoraire = idtarifhoraire;
    }

    public BigInteger getCu() {
        return cu;
    }

    public void setCu(BigInteger cu) {
        this.cu = cu;
    }

    @XmlTransient
    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    public Enseignant getIdenseignant() {
        return idenseignant;
    }

    public void setIdenseignant(Enseignant idenseignant) {
        this.idenseignant = idenseignant;
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
        hash += (idtarifhoraire != null ? idtarifhoraire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifhoraire)) {
            return false;
        }
        Tarifhoraire other = (Tarifhoraire) object;
        if ((this.idtarifhoraire == null && other.idtarifhoraire != null) || (this.idtarifhoraire != null && !this.idtarifhoraire.equals(other.idtarifhoraire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tarifhoraire[ idtarifhoraire=" + idtarifhoraire + " ]";
    }
    
}
