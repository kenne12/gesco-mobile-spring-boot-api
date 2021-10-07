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
@Table(name = "anneescolaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anneescolaire.findAll", query = "SELECT a FROM Anneescolaire a"),
    @NamedQuery(name = "Anneescolaire.findByIdanneescolaire", query = "SELECT a FROM Anneescolaire a WHERE a.idanneescolaire = :idanneescolaire"),
    @NamedQuery(name = "Anneescolaire.findByCode", query = "SELECT a FROM Anneescolaire a WHERE a.code = :code"),
    @NamedQuery(name = "Anneescolaire.findByNom", query = "SELECT a FROM Anneescolaire a WHERE a.nom = :nom")})
public class Anneescolaire implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idanneescolaire")
    private Integer idanneescolaire;
    @Column(name = "code" , length = 254)
    private String code;
    @Column(name = "nom" , length = 254)
    private String nom;
    @OneToMany(mappedBy = "idanneescolaire", fetch = FetchType.LAZY)
    private List<Lecon> leconList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idanneescolaire", fetch = FetchType.LAZY)
    private List<Periode> periodeList;
    @OneToMany(mappedBy = "idanneescolaire", fetch = FetchType.LAZY)
    private List<Fraisscolarite> fraisscolariteList;
    @OneToMany(mappedBy = "idanneescolaire", fetch = FetchType.LAZY)
    private List<Programmationcours> programmationcoursList;
    @OneToMany(mappedBy = "idanneescolaire", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;
    @OneToMany(mappedBy = "idanneescolaire", fetch = FetchType.LAZY)
    private List<Programmationscolarite> programmationscolariteList;
    @OneToMany(mappedBy = "idanneescolaire", fetch = FetchType.LAZY)
    private List<Notification> notificationList;
    @OneToMany(mappedBy = "idanneescolaire", fetch = FetchType.LAZY)
    private List<Principal> principalList;

    private Boolean actif;
    
    public Anneescolaire() {
    }

    public Anneescolaire(Integer idanneescolaire) {
        this.idanneescolaire = idanneescolaire;
    }

    public Integer getIdanneescolaire() {
        return idanneescolaire;
    }

    public void setIdanneescolaire(Integer idanneescolaire) {
        this.idanneescolaire = idanneescolaire;
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
    public List<Lecon> getLeconList() {
        return leconList;
    }

    public void setLeconList(List<Lecon> leconList) {
        this.leconList = leconList;
    }

    @XmlTransient
    public List<Periode> getPeriodeList() {
        return periodeList;
    }

    public void setPeriodeList(List<Periode> periodeList) {
        this.periodeList = periodeList;
    }

    @XmlTransient
    public List<Fraisscolarite> getFraisscolariteList() {
        return fraisscolariteList;
    }

    public void setFraisscolariteList(List<Fraisscolarite> fraisscolariteList) {
        this.fraisscolariteList = fraisscolariteList;
    }

    @XmlTransient
    public List<Programmationcours> getProgrammationcoursList() {
        return programmationcoursList;
    }

    public void setProgrammationcoursList(List<Programmationcours> programmationcoursList) {
        this.programmationcoursList = programmationcoursList;
    }

    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @XmlTransient
    public List<Programmationscolarite> getProgrammationscolariteList() {
        return programmationscolariteList;
    }

    public void setProgrammationscolariteList(List<Programmationscolarite> programmationscolariteList) {
        this.programmationscolariteList = programmationscolariteList;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
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
        hash += (idanneescolaire != null ? idanneescolaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anneescolaire)) {
            return false;
        }
        Anneescolaire other = (Anneescolaire) object;
        if ((this.idanneescolaire == null && other.idanneescolaire != null) || (this.idanneescolaire != null && !this.idanneescolaire.equals(other.idanneescolaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Anneescolaire[ idanneescolaire=" + idanneescolaire + " ]";
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

}
