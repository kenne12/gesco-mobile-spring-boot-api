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
@Table(name = "enseignant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e"),
    @NamedQuery(name = "Enseignant.findByIdenseignant", query = "SELECT e FROM Enseignant e WHERE e.idenseignant = :idenseignant"),
    @NamedQuery(name = "Enseignant.findByNom", query = "SELECT e FROM Enseignant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Enseignant.findByPrenom", query = "SELECT e FROM Enseignant e WHERE e.prenom = :prenom")})
public class Enseignant implements Serializable {
    @OneToMany(mappedBy = "idenseignant", fetch = FetchType.LAZY)
    private List<UserEnseignant> userEnseignantList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idenseignant")
    private Integer idenseignant;

    @Column(name = "nom" , length = 254)
    private String nom;

    @Column(name = "prenom" , length = 254)
    private String prenom;
    @OneToMany(mappedBy = "idenseignant", fetch = FetchType.LAZY)
    private List<Programmationcours> programmationcoursList;
    @OneToMany(mappedBy = "idenseignant", fetch = FetchType.LAZY)
    private List<Tarifhoraire> tarifhoraireList;
    @JoinColumn(name = "idadresse", referencedColumnName = "idadresse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adresse idadresse;
    @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
    @ManyToOne(fetch = FetchType.LAZY)
    private Institution idinstitution;
    @OneToMany(mappedBy = "idenseignant", fetch = FetchType.LAZY)
    private List<Principal> principalList;

    public Enseignant() {
    }

    public Enseignant(Integer idenseignant) {
        this.idenseignant = idenseignant;
    }

    public Integer getIdenseignant() {
        return idenseignant;
    }

    public void setIdenseignant(Integer idenseignant) {
        this.idenseignant = idenseignant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlTransient
    public List<Programmationcours> getProgrammationcoursList() {
        return programmationcoursList;
    }

    public void setProgrammationcoursList(List<Programmationcours> programmationcoursList) {
        this.programmationcoursList = programmationcoursList;
    }

    @XmlTransient
    public List<Tarifhoraire> getTarifhoraireList() {
        return tarifhoraireList;
    }

    public void setTarifhoraireList(List<Tarifhoraire> tarifhoraireList) {
        this.tarifhoraireList = tarifhoraireList;
    }

    public Adresse getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Adresse idadresse) {
        this.idadresse = idadresse;
    }

    public Institution getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Institution idinstitution) {
        this.idinstitution = idinstitution;
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
        hash += (idenseignant != null ? idenseignant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.idenseignant == null && other.idenseignant != null) || (this.idenseignant != null && !this.idenseignant.equals(other.idenseignant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Enseignant[ idenseignant=" + idenseignant + " ]";
    }

    @XmlTransient
    public List<UserEnseignant> getUserEnseignantList() {
        return userEnseignantList;
    }

    public void setUserEnseignantList(List<UserEnseignant> userEnseignantList) {
        this.userEnseignantList = userEnseignantList;
    }

}
