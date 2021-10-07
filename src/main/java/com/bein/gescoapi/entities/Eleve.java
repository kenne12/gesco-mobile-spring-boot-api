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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Arianne
 */
@Entity
@Table(name = "eleve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eleve.findAll", query = "SELECT e FROM Eleve e"),
    @NamedQuery(name = "Eleve.findByIdeleve", query = "SELECT e FROM Eleve e WHERE e.ideleve = :ideleve"),
    @NamedQuery(name = "Eleve.findByMatricule", query = "SELECT e FROM Eleve e WHERE e.matricule = :matricule"),
    @NamedQuery(name = "Eleve.findByNom", query = "SELECT e FROM Eleve e WHERE e.nom = :nom"),
    @NamedQuery(name = "Eleve.findByPrenom", query = "SELECT e FROM Eleve e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Eleve.findByDatenais", query = "SELECT e FROM Eleve e WHERE e.datenais = :datenais"),
    @NamedQuery(name = "Eleve.findByLieunais", query = "SELECT e FROM Eleve e WHERE e.lieunais = :lieunais"),
    @NamedQuery(name = "Eleve.findByDosmedical", query = "SELECT e FROM Eleve e WHERE e.dosmedical = :dosmedical"),
    @NamedQuery(name = "Eleve.findByEtat", query = "SELECT e FROM Eleve e WHERE e.etat = :etat"),
    @NamedQuery(name = "Eleve.findByTerminal", query = "SELECT e FROM Eleve e WHERE e.terminal = :terminal"),
    @NamedQuery(name = "Eleve.findByExclu", query = "SELECT e FROM Eleve e WHERE e.exclu = :exclu"),
    @NamedQuery(name = "Eleve.findByNomparent", query = "SELECT e FROM Eleve e WHERE e.nomparent = :nomparent"),
    @NamedQuery(name = "Eleve.findByPrenomparent", query = "SELECT e FROM Eleve e WHERE e.prenomparent = :prenomparent"),
    @NamedQuery(name = "Eleve.findByCumulsms", query = "SELECT e FROM Eleve e WHERE e.cumulsms = :cumulsms")})
public class Eleve implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ideleve")
    private Integer ideleve;
    @Column(name = "matricule" , length = 254)
    private String matricule;
    @Column(name = "nom" , length = 254)
    private String nom;

    @Column(name = "prenom" , length = 254)
    private String prenom;
    @Column(name = "datenais")
    @Temporal(TemporalType.DATE)
    private Date datenais;
    @Column(name = "lieunais" , length = 254)
    private String lieunais;
    @Column(name = "dosmedical")
    private Boolean dosmedical;
    @Column(name = "etat")
    private Boolean etat;
    @Column(name = "terminal")
    private Boolean terminal;
    @Column(name = "exclu")
    private Boolean exclu;
    @Column(name = "nomparent" , length = 254)
    private String nomparent;
    @Column(name = "prenomparent" , length = 254)
    private String prenomparent;
    @Column(name = "nommere" , length = 254)
    private String nommere;
    @Column(name = "prenommere" , length = 254)
    private String prenommere;
    @Column(name = "cumulsms")
    private Integer cumulsms;
    @JoinColumn(name = "idadresse", referencedColumnName = "idadresse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adresse idadresse;
    @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
    @ManyToOne(fetch = FetchType.LAZY)
    private Institution idinstitution;
    @JoinColumn(name = "idsexe", referencedColumnName = "idsexe")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sexe idsexe;
    @OneToMany(mappedBy = "ideleve", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;

    public Eleve() {
    }

    public Eleve(Integer ideleve) {
        this.ideleve = ideleve;
    }

    public Integer getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(Integer ideleve) {
        this.ideleve = ideleve;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public Date getDatenais() {
        return datenais;
    }

    public void setDatenais(Date datenais) {
        this.datenais = datenais;
    }

    public String getLieunais() {
        return lieunais;
    }

    public void setLieunais(String lieunais) {
        this.lieunais = lieunais;
    }

    public Boolean getDosmedical() {
        return dosmedical;
    }

    public void setDosmedical(Boolean dosmedical) {
        this.dosmedical = dosmedical;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Boolean getTerminal() {
        return terminal;
    }

    public void setTerminal(Boolean terminal) {
        this.terminal = terminal;
    }

    public Boolean getExclu() {
        return exclu;
    }

    public void setExclu(Boolean exclu) {
        this.exclu = exclu;
    }

    public String getNomparent() {
        return nomparent;
    }

    public void setNomparent(String nomparent) {
        this.nomparent = nomparent;
    }

    public String getPrenomparent() {
        return prenomparent;
    }

    public void setPrenomparent(String prenomparent) {
        this.prenomparent = prenomparent;
    }

    public String getNommere() {
        return nommere;
    }

    public void setNommere(String nommere) {
        this.nommere = nommere;
    }

    public String getPrenommere() {
        return prenommere;
    }

    public void setPrenommere(String prenommere) {
        this.prenommere = prenommere;
    }

    public Integer getCumulsms() {
        return cumulsms;
    }

    public void setCumulsms(Integer cumulsms) {
        this.cumulsms = cumulsms;
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

    public Sexe getIdsexe() {
        return idsexe;
    }

    public void setIdsexe(Sexe idsexe) {
        this.idsexe = idsexe;
    }

    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideleve != null ? ideleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.ideleve == null && other.ideleve != null) || (this.ideleve != null && !this.ideleve.equals(other.ideleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Eleve[ ideleve=" + ideleve + " ]";
    }
    
}
