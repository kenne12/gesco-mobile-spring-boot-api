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
@Table(name = "periode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periode.findAll", query = "SELECT p FROM Periode p"),
    @NamedQuery(name = "Periode.findByIdPeriode", query = "SELECT p FROM Periode p WHERE p.idPeriode = :idPeriode"),
    @NamedQuery(name = "Periode.findByDateDebut", query = "SELECT p FROM Periode p WHERE p.dateDebut = :dateDebut"),
    @NamedQuery(name = "Periode.findByDateFin", query = "SELECT p FROM Periode p WHERE p.dateFin = :dateFin"),
    @NamedQuery(name = "Periode.findByEstdevoir", query = "SELECT p FROM Periode p WHERE p.estdevoir = :estdevoir"),
    @NamedQuery(name = "Periode.findByEstcompos", query = "SELECT p FROM Periode p WHERE p.estcompos = :estcompos"),
    @NamedQuery(name = "Periode.findByDenomination", query = "SELECT p FROM Periode p WHERE p.denomination = :denomination")})
public class Periode implements Serializable {
    @OneToMany(mappedBy = "idPeriode", fetch = FetchType.LAZY)
    private List<Exclusionstemporaires> exclusionstemporairesList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_periode" , nullable = false)
    private Integer idPeriode;
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(name = "denomination" , length = 254)
    private String denomination;
    @Column(name = "poids")
    private Integer poids;

    @Column(name = "codeperiode" , length = 254)
    private String codeperiode;
    @Column (name = "estdevoir")
    private Boolean estdevoir;
    @Column (name = "estcompos")
    private Boolean estcompos;
    @OneToMany(mappedBy = "idPeriode", fetch = FetchType.LAZY)
    private List<Abcences> abcencesList;
    @JoinColumn(name = "idanneescolaire", referencedColumnName = "idanneescolaire")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Anneescolaire idanneescolaire;
    @JoinColumn(name = "idsequence", referencedColumnName = "idsequence")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sequence idsequence;
    @JoinColumn(name = "id_trimestre", referencedColumnName = "id_trimestre")
    @ManyToOne(fetch = FetchType.LAZY)
    private Trimestre idTrimestre;
    @OneToMany(mappedBy = "idPeriode", fetch = FetchType.LAZY)
    private List<Evaluation> evaluationList;
    @OneToMany(mappedBy = "idPeriode", fetch = FetchType.LAZY)
    private List<Retards> retardsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriode", fetch = FetchType.LAZY)
    private List<Bulletin> bulletinList;
    @OneToMany(mappedBy = "idPeriode", fetch = FetchType.LAZY)
    private List<Avertissements> avertissementsList;
    @OneToMany(mappedBy = "idPeriode", fetch = FetchType.LAZY)
    private List<Blames> blamesList;

    public Periode() {
    }

    public Periode(Integer idPeriode) {
        this.idPeriode = idPeriode;
    }

    public Integer getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Integer idPeriode) {
        this.idPeriode = idPeriode;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    @XmlTransient
    public List<Abcences> getAbcencesList() {
        return abcencesList;
    }

    public void setAbcencesList(List<Abcences> abcencesList) {
        this.abcencesList = abcencesList;
    }

    public Anneescolaire getIdanneescolaire() {
        return idanneescolaire;
    }

    public void setIdanneescolaire(Anneescolaire idanneescolaire) {
        this.idanneescolaire = idanneescolaire;
    }

    public Sequence getIdsequence() {
        return idsequence;
    }

    public void setIdsequence(Sequence idsequence) {
        this.idsequence = idsequence;
    }

    public Trimestre getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(Trimestre idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public String getCodeperiode() {
        return codeperiode;
    }

    public void setCodeperiode(String codeperiode) {
        this.codeperiode = codeperiode;
    }

    public Boolean getEstdevoir() {
        return estdevoir;
    }

    public void setEstdevoir(Boolean estdevoir) {
        this.estdevoir = estdevoir;
    }

    public Boolean getEstcompos() {
        return estcompos;
    }

    public void setEstcompos(Boolean estcompos) {
        this.estcompos = estcompos;
    }

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    @XmlTransient
    public List<Retards> getRetardsList() {
        return retardsList;
    }

    public void setRetardsList(List<Retards> retardsList) {
        this.retardsList = retardsList;
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
        hash += (idPeriode != null ? idPeriode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periode)) {
            return false;
        }
        Periode other = (Periode) object;
        if ((this.idPeriode == null && other.idPeriode != null) || (this.idPeriode != null && !this.idPeriode.equals(other.idPeriode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Periode[ idPeriode=" + idPeriode + " ]";
    }

    @XmlTransient
    public List<Avertissements> getAvertissementsList() {
        return avertissementsList;
    }

    public void setAvertissementsList(List<Avertissements> avertissementsList) {
        this.avertissementsList = avertissementsList;
    }

    @XmlTransient
    public List<Blames> getBlamesList() {
        return blamesList;
    }

    public void setBlamesList(List<Blames> blamesList) {
        this.blamesList = blamesList;
    }

    @XmlTransient
    public List<Exclusionstemporaires> getExclusionstemporairesList() {
        return exclusionstemporairesList;
    }

    public void setExclusionstemporairesList(List<Exclusionstemporaires> exclusionstemporairesList) {
        this.exclusionstemporairesList = exclusionstemporairesList;
    }

}
