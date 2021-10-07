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
@Table(name = "classe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findByIdclasse", query = "SELECT c FROM Classe c WHERE c.idclasse = :idclasse"),
    @NamedQuery(name = "Classe.findByCode", query = "SELECT c FROM Classe c WHERE c.code = :code"),
    @NamedQuery(name = "Classe.findByNom", query = "SELECT c FROM Classe c WHERE c.nom = :nom")})
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idclasse")
    private Integer idclasse;

    @Column(name = "code",length = 254)
    private String code;

    @Column(name = "nom" , length = 254)
    private String nom;
    @OneToMany(mappedBy = "idclasse", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;
    @JoinColumn(name = "idgroupe", referencedColumnName = "idgroupe")
    @ManyToOne(fetch = FetchType.LAZY)
    private Groupe idgroupe;
    @JoinColumn(name = "idniveauclasse", referencedColumnName = "idniveauclasse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Niveauclasse idniveauclasse;
    @OneToMany(mappedBy = "idclasse", fetch = FetchType.LAZY)
    private List<Principal> principalList;
    @OneToMany(mappedBy = "idclasse", fetch = FetchType.LAZY)
    private List<Programmationcours> programmationcoursList;

    public Classe() {
    }

    public Classe(Integer idclasse) {
        this.idclasse = idclasse;
    }

    public Integer getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Integer idclasse) {
        this.idclasse = idclasse;
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
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    public Groupe getIdgroupe() {
        return idgroupe;
    }

    public void setIdgroupe(Groupe idgroupe) {
        this.idgroupe = idgroupe;
    }

    public Niveauclasse getIdniveauclasse() {
        return idniveauclasse;
    }

    public void setIdniveauclasse(Niveauclasse idniveauclasse) {
        this.idniveauclasse = idniveauclasse;
    }

    @XmlTransient
    public List<Programmationcours> getProgrammationcoursList() {
        return programmationcoursList;
    }

    public void setProgrammationcoursList(List<Programmationcours> programmationcoursList) {
        this.programmationcoursList = programmationcoursList;
    }

    @XmlTransient
    public List<Principal> getPrincipalList() {
        return principalList;
    }

    public void setPrincipalList(List<Principal> principalList) {
        this.principalList = principalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclasse != null ? idclasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.idclasse == null && other.idclasse != null) || (this.idclasse != null && !this.idclasse.equals(other.idclasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Classe[ idclasse=" + idclasse + " ]";
    }

}
