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
@Table(name = "inscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i"),
    @NamedQuery(name = "Inscription.findByIdinscription", query = "SELECT i FROM Inscription i WHERE i.idinscription = :idinscription"),
    @NamedQuery(name = "Inscription.findByMontantinscription", query = "SELECT i FROM Inscription i WHERE i.montantinscription = :montantinscription"),
    @NamedQuery(name = "Inscription.findByMontanttd", query = "SELECT i FROM Inscription i WHERE i.montanttd = :montanttd"),
    @NamedQuery(name = "Inscription.findByDateinscription", query = "SELECT i FROM Inscription i WHERE i.dateinscription = :dateinscription"),
    @NamedQuery(name = "Inscription.findByEtat", query = "SELECT i FROM Inscription i WHERE i.etat = :etat"),
    @NamedQuery(name = "Inscription.findByNouveau", query = "SELECT i FROM Inscription i WHERE i.nouveau = :nouveau"),
    @NamedQuery(name = "Inscription.findByCode", query = "SELECT i FROM Inscription i WHERE i.code = :code"),
    @NamedQuery(name = "Inscription.findByAvancepension", query = "SELECT i FROM Inscription i WHERE i.avancepension = :avancepension"),
    @NamedQuery(name = "Inscription.findByRedoublant", query = "SELECT i FROM Inscription i WHERE i.redoublant = :redoublant")})
public class Inscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idinscription")
    private Integer idinscription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montantinscription")
    private Double montantinscription;
    @Column(name = "montanttd")
    private Double montanttd;
    @Column(name = "dateinscription")
    @Temporal(TemporalType.DATE)
    private Date dateinscription;
    @Column(name = "etat")
    private Boolean etat;
    @Column(name = "nouveau")
    private Boolean nouveau;
    @Column(name = "code" , length = 20)
    private String code;
    @Column(name = "avancepension")
    private Double avancepension;
    @Column(name = "redoublant")
    private Boolean redoublant;
    @OneToMany(mappedBy = "idinscription", fetch = FetchType.LAZY)
    private List<Souscriptionsms> souscriptionsmsList;
    @OneToMany(mappedBy = "idinscription", fetch = FetchType.LAZY)
    private List<Note> noteList;
    @OneToMany(mappedBy = "idinscription", fetch = FetchType.LAZY)
    private List<Scolarite> scolariteList;
    @OneToMany(mappedBy = "idinscription", fetch = FetchType.LAZY)
    private List<Exclusion> exclusionList;
    @OneToMany(mappedBy = "idinscription", fetch = FetchType.LAZY)
    private List<Sms> smsList;
    @JoinColumn(name = "idanneescolaire", referencedColumnName = "idanneescolaire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anneescolaire idanneescolaire;
    @JoinColumn(name = "idclasse", referencedColumnName = "idclasse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Classe idclasse;
    @JoinColumn(name = "ideleve", referencedColumnName = "ideleve")
    @ManyToOne(fetch = FetchType.LAZY)
    private Eleve ideleve;
    @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
    @ManyToOne(fetch = FetchType.LAZY)
    private Institution idinstitution;
    @JoinColumn(name = "idsante", referencedColumnName = "idsante")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sante idsante;
    @JoinColumn(name = "idstatut", referencedColumnName = "idstatut")
    @ManyToOne(fetch = FetchType.LAZY)
    private Statut idstatut;
    @OneToMany(mappedBy = "idinscription", fetch = FetchType.LAZY)
    private List<DossierDiscipline> dossierDisciplineList;
    @OneToMany(mappedBy = "idinscription", fetch = FetchType.LAZY)
    private List<Bulletin> bulletinList;

    public Inscription() {
    }

    public Inscription(Integer idinscription) {
        this.idinscription = idinscription;
    }

    public Integer getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(Integer idinscription) {
        this.idinscription = idinscription;
    }

    public Double getMontantinscription() {
        return montantinscription;
    }

    public void setMontantinscription(Double montantinscription) {
        this.montantinscription = montantinscription;
    }

    public Double getMontanttd() {
        return montanttd;
    }

    public void setMontanttd(Double montanttd) {
        this.montanttd = montanttd;
    }

    public Date getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(Date dateinscription) {
        this.dateinscription = dateinscription;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Boolean getNouveau() {
        return nouveau;
    }

    public void setNouveau(Boolean nouveau) {
        this.nouveau = nouveau;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getAvancepension() {
        return avancepension;
    }

    public void setAvancepension(Double avancepension) {
        this.avancepension = avancepension;
    }

    public Boolean getRedoublant() {
        return redoublant;
    }

    public void setRedoublant(Boolean redoublant) {
        this.redoublant = redoublant;
    }

    @XmlTransient
    public List<Souscriptionsms> getSouscriptionsmsList() {
        return souscriptionsmsList;
    }

    public void setSouscriptionsmsList(List<Souscriptionsms> souscriptionsmsList) {
        this.souscriptionsmsList = souscriptionsmsList;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    @XmlTransient
    public List<Scolarite> getScolariteList() {
        return scolariteList;
    }

    public void setScolariteList(List<Scolarite> scolariteList) {
        this.scolariteList = scolariteList;
    }

    @XmlTransient
    public List<Exclusion> getExclusionList() {
        return exclusionList;
    }

    public void setExclusionList(List<Exclusion> exclusionList) {
        this.exclusionList = exclusionList;
    }

    @XmlTransient
    public List<Sms> getSmsList() {
        return smsList;
    }

    public void setSmsList(List<Sms> smsList) {
        this.smsList = smsList;
    }

    public Anneescolaire getIdanneescolaire() {
        return idanneescolaire;
    }

    public void setIdanneescolaire(Anneescolaire idanneescolaire) {
        this.idanneescolaire = idanneescolaire;
    }

    public Classe getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Classe idclasse) {
        this.idclasse = idclasse;
    }

    public Eleve getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(Eleve ideleve) {
        this.ideleve = ideleve;
    }

    public Institution getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Institution idinstitution) {
        this.idinstitution = idinstitution;
    }

    public Sante getIdsante() {
        return idsante;
    }

    public void setIdsante(Sante idsante) {
        this.idsante = idsante;
    }

    public Statut getIdstatut() {
        return idstatut;
    }

    public void setIdstatut(Statut idstatut) {
        this.idstatut = idstatut;
    }

    @XmlTransient
    public List<DossierDiscipline> getDossierDisciplineList() {
        return dossierDisciplineList;
    }

    public void setDossierDisciplineList(List<DossierDiscipline> dossierDisciplineList) {
        this.dossierDisciplineList = dossierDisciplineList;
    }

    @XmlTransient
    public List<Bulletin> getBulletinList() {
        return bulletinList;
    }

    public void setBulletinList(List<Bulletin> bulletinList) {
        this.bulletinList = bulletinList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinscription != null ? idinscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.idinscription == null && other.idinscription != null) || (this.idinscription != null && !this.idinscription.equals(other.idinscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Inscription[ idinscription=" + idinscription + " ]";
    }
    
}
