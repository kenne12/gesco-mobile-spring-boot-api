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
@Table(name = "abcences")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abcences.findAll", query = "SELECT a FROM Abcences a"),
    @NamedQuery(name = "Abcences.findByIdAbs", query = "SELECT a FROM Abcences a WHERE a.idAbs = :idAbs"),
    @NamedQuery(name = "Abcences.findByDateEnreg", query = "SELECT a FROM Abcences a WHERE a.dateEnreg = :dateEnreg"),
    @NamedQuery(name = "Abcences.findByNbreHeures", query = "SELECT a FROM Abcences a WHERE a.nbreHeures = :nbreHeures"),
    @NamedQuery(name = "Abcences.findByDateAbcence", query = "SELECT a FROM Abcences a WHERE a.dateAbcence = :dateAbcence"),
    @NamedQuery(name = "Abcences.findByJustifie", query = "SELECT a FROM Abcences a WHERE a.justifie = :justifie")})
public class Abcences implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_abs")
    private Long idAbs;
    @Column(name = "date_enreg")
    @Temporal(TemporalType.DATE)
    private Date dateEnreg;
    @Column(name = "nbre_heures")
    private Integer nbreHeures;
    @Column(name = "date_abcence")
    @Temporal(TemporalType.DATE)
    private Date dateAbcence;
    @Column(name = "justifie")
    private Boolean justifie;
    @Column (name = "justification")
    private String justification;
    @JoinColumn(name = "id_disc", referencedColumnName = "id_disc")
    @ManyToOne(fetch = FetchType.LAZY)
    private DossierDiscipline idDisc;
    @JoinColumn(name = "id_periode", referencedColumnName = "id_periode")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periode idPeriode;

    public Abcences() {
    }

    public Abcences(Long idAbs) {
        this.idAbs = idAbs;
    }

    public Long getIdAbs() {
        return idAbs;
    }

    public void setIdAbs(Long idAbs) {
        this.idAbs = idAbs;
    }

    public Date getDateEnreg() {
        return dateEnreg;
    }

    public void setDateEnreg(Date dateEnreg) {
        this.dateEnreg = dateEnreg;
    }

    public Integer getNbreHeures() {
        return nbreHeures;
    }

    public void setNbreHeures(Integer nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public Date getDateAbcence() {
        return dateAbcence;
    }

    public void setDateAbcence(Date dateAbcence) {
        this.dateAbcence = dateAbcence;
    }

    public Boolean getJustifie() {
        return justifie;
    }

    public void setJustifie(Boolean justifie) {
        this.justifie = justifie;
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
        hash += (idAbs != null ? idAbs.hashCode() : 0);
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
        if (!(object instanceof Abcences)) {
            return false;
        }
        Abcences other = (Abcences) object;
        if ((this.idAbs == null && other.idAbs != null) || (this.idAbs != null && !this.idAbs.equals(other.idAbs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Abcences[ idAbs=" + idAbs + " ]";
    }
    
}
