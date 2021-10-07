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
 * @author Arianne
 */
@Entity
@Table(name = "retards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retards.findAll", query = "SELECT r FROM Retards r"),
    @NamedQuery(name = "Retards.findByIdRetard", query = "SELECT r FROM Retards r WHERE r.idRetard = :idRetard"),
    @NamedQuery(name = "Retards.findByDateEnreg", query = "SELECT r FROM Retards r WHERE r.dateEnreg = :dateEnreg"),
    @NamedQuery(name = "Retards.findByNbreRetards", query = "SELECT r FROM Retards r WHERE r.nbreRetards = :nbreRetards"),
    @NamedQuery(name = "Retards.findByDateRetard", query = "SELECT r FROM Retards r WHERE r.dateRetard = :dateRetard"),
    @NamedQuery(name = "Retards.findByJustifie", query = "SELECT r FROM Retards r WHERE r.justifie = :justifie")})
public class Retards implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_retard" , nullable = false)
    private Long idRetard;
    @Column(name = "date_enreg")
    @Temporal(TemporalType.DATE)
    private Date dateEnreg;
    @Column(name = "nbre_retards")
    private Integer nbreRetards;
    @Column(name = "date_retard")
    @Temporal(TemporalType.DATE)
    private Date dateRetard;
    @Column(name = "justifie")
    private Boolean justifie;
    @Column(name = "heure_arr")
    @Temporal(TemporalType.TIME)
    private Date heureArr;
    @Column (name = "justification")
    private String justification;
    @JoinColumn(name = "id_disc", referencedColumnName = "id_disc")
    @ManyToOne(fetch = FetchType.LAZY)
    private DossierDiscipline idDisc;
    @JoinColumn(name = "id_periode", referencedColumnName = "id_periode")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periode idPeriode;

    public Retards() {
    }

    public Retards(Long idRetard) {
        this.idRetard = idRetard;
    }

    public Long getIdRetard() {
        return idRetard;
    }

    public void setIdRetard(Long idRetard) {
        this.idRetard = idRetard;
    }

    public Date getDateEnreg() {
        return dateEnreg;
    }

    public void setDateEnreg(Date dateEnreg) {
        this.dateEnreg = dateEnreg;
    }

    public Integer getNbreRetards() {
        return nbreRetards;
    }

    public void setNbreRetards(Integer nbreRetards) {
        this.nbreRetards = nbreRetards;
    }

    public Date getDateRetard() {
        return dateRetard;
    }

    public void setDateRetard(Date dateRetard) {
        this.dateRetard = dateRetard;
    }

    public Boolean getJustifie() {
        return justifie;
    }

    public void setJustifie(Boolean justifie) {
        this.justifie = justifie;
    }

    public Date getHeureArr() {
        return heureArr;
    }

    public void setHeureArr(Date heureArr) {
        this.heureArr = heureArr;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRetard != null ? idRetard.hashCode() : 0);
        return hash;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retards)) {
            return false;
        }
        Retards other = (Retards) object;
        if ((this.idRetard == null && other.idRetard != null) || (this.idRetard != null && !this.idRetard.equals(other.idRetard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Retards[ idRetard=" + idRetard + " ]";
    }
    
}
