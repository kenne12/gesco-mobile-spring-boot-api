/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bein.gescoapi.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Louis Stark
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exclusionstemporaires.findAll", query = "SELECT e FROM Exclusionstemporaires e"),
    @NamedQuery(name = "Exclusionstemporaires.findByIdExclusion", query = "SELECT e FROM Exclusionstemporaires e WHERE e.idExclusion = :idExclusion"),
    @NamedQuery(name = "Exclusionstemporaires.findByMotif", query = "SELECT e FROM Exclusionstemporaires e WHERE e.motif = :motif"),
    @NamedQuery(name = "Exclusionstemporaires.findByDecision", query = "SELECT e FROM Exclusionstemporaires e WHERE e.decision = :decision"),
    @NamedQuery(name = "Exclusionstemporaires.findByDateExclusion", query = "SELECT e FROM Exclusionstemporaires e WHERE e.dateExclusion = :dateExclusion"),
    @NamedQuery(name = "Exclusionstemporaires.findByDateDebut", query = "SELECT e FROM Exclusionstemporaires e WHERE e.dateDebut = :dateDebut"),
    @NamedQuery(name = "Exclusionstemporaires.findByDateFin", query = "SELECT e FROM Exclusionstemporaires e WHERE e.dateFin = :dateFin")})
public class Exclusionstemporaires implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_exclusion")
    private Integer idExclusion;
    @Column(length = 254)
    private String motif;
    @Column(length = 254)
    private String decision;
    @Column(name = "date_exclusion")
    @Temporal(TemporalType.DATE)
    private Date dateExclusion;
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column (name = "nbrejours")
    private Integer nbrejours;
    @JoinColumn(name = "id_disc", referencedColumnName = "id_disc")
    @ManyToOne(fetch = FetchType.LAZY)
    private DossierDiscipline idDisc;
    @JoinColumn(name = "id_periode", referencedColumnName = "id_periode")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periode idPeriode;

    public Exclusionstemporaires() {
    }

    public Exclusionstemporaires(Integer idExclusion) {
        this.idExclusion = idExclusion;
    }

    public Integer getIdExclusion() {
        return idExclusion;
    }

    public void setIdExclusion(Integer idExclusion) {
        this.idExclusion = idExclusion;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Date getDateExclusion() {
        return dateExclusion;
    }

    public void setDateExclusion(Date dateExclusion) {
        this.dateExclusion = dateExclusion;
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

    public DossierDiscipline getIdDisc() {
        return idDisc;
    }

    public void setIdDisc(DossierDiscipline idDisc) {
        this.idDisc = idDisc;
    }

    public Periode getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Periode idPeriode) {
        this.idPeriode = idPeriode;
    }

    public Integer getNbrejours() {
        return nbrejours;
    }

    public void setNbrejours(Integer nbrejours) {
        this.nbrejours = nbrejours;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExclusion != null ? idExclusion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exclusionstemporaires)) {
            return false;
        }
        Exclusionstemporaires other = (Exclusionstemporaires) object;
        if ((this.idExclusion == null && other.idExclusion != null) || (this.idExclusion != null && !this.idExclusion.equals(other.idExclusion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Exclusionstemporaires[ idExclusion=" + idExclusion + " ]";
    }
    
}
