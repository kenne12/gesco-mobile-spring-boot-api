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
@Table(name = "dossier_discipline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DossierDiscipline.findAll", query = "SELECT d FROM DossierDiscipline d"),
    @NamedQuery(name = "DossierDiscipline.findByIdDisc", query = "SELECT d FROM DossierDiscipline d WHERE d.idDisc = :idDisc"),
    @NamedQuery(name = "DossierDiscipline.findByIntitule", query = "SELECT d FROM DossierDiscipline d WHERE d.intitule = :intitule"),
    @NamedQuery(name = "DossierDiscipline.findByExclus", query = "SELECT d FROM DossierDiscipline d WHERE d.exclus = :exclus")})
public class DossierDiscipline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_disc")
    private Integer idDisc;
    @Column(name = "intitule" , length = 254)
    private String intitule;
    @Column(name = "exclus")
    private Boolean exclus;
    @OneToMany(mappedBy = "idDisc", fetch = FetchType.LAZY)
    private List<Abcences> abcencesList;
    @OneToMany(mappedBy = "idDisc", fetch = FetchType.LAZY)
    private List<Retards> retardsList;
    @JoinColumn(name = "idinscription", referencedColumnName = "idinscription")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inscription idinscription;
    @OneToMany(mappedBy = "idDisc", fetch = FetchType.LAZY)
    private List<Bulletin> bulletinList;

    @OneToMany(mappedBy = "idDisc", fetch = FetchType.LAZY)
    private List<Exclusionstemporaires> exclusionstemporairesList;
    @OneToMany(mappedBy = "idDisc", fetch = FetchType.LAZY)
    private List<Avertissements> avertissementsList;
    @OneToMany(mappedBy = "idDisc", fetch = FetchType.LAZY)
    private List<Blames> blamesList;

    public DossierDiscipline() {
    }

    public DossierDiscipline(Integer idDisc) {
        this.idDisc = idDisc;
    }

    public Integer getIdDisc() {
        return idDisc;
    }

    public void setIdDisc(Integer idDisc) {
        this.idDisc = idDisc;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Boolean getExclus() {
        return exclus;
    }

    public void setExclus(Boolean exclus) {
        this.exclus = exclus;
    }

    @XmlTransient
    public List<Abcences> getAbcencesList() {
        return abcencesList;
    }

    public void setAbcencesList(List<Abcences> abcencesList) {
        this.abcencesList = abcencesList;
    }

    @XmlTransient
    public List<Retards> getRetardsList() {
        return retardsList;
    }

    public void setRetardsList(List<Retards> retardsList) {
        this.retardsList = retardsList;
    }

    public Inscription getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(Inscription idinscription) {
        this.idinscription = idinscription;
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
        hash += (idDisc != null ? idDisc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DossierDiscipline)) {
            return false;
        }
        DossierDiscipline other = (DossierDiscipline) object;
        if ((this.idDisc == null && other.idDisc != null) || (this.idDisc != null && !this.idDisc.equals(other.idDisc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DossierDiscipline[ idDisc=" + idDisc + " ]";
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
