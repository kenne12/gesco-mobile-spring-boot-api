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
    @NamedQuery(name = "Avertissements.findAll", query = "SELECT a FROM Avertissements a"),
    @NamedQuery(name = "Avertissements.findByIdAvertissement", query = "SELECT a FROM Avertissements a WHERE a.idAvertissement = :idAvertissement"),
    @NamedQuery(name = "Avertissements.findByMotif", query = "SELECT a FROM Avertissements a WHERE a.motif = :motif"),
    @NamedQuery(name = "Avertissements.findByDateEnregistrement", query = "SELECT a FROM Avertissements a WHERE a.dateEnregistrement = :dateEnregistrement"),
    @NamedQuery(name = "Avertissements.findByDecision", query = "SELECT a FROM Avertissements a WHERE a.decision = :decision")})
public class Avertissements implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "id_avertissement")
    private Integer idAvertissement;
    @Column(length = 254)
    private String motif;
    @Column(name = "date_enregistrement")
    @Temporal(TemporalType.DATE)
    private Date dateEnregistrement;
    @Column(length = 254)
    private String decision;
    @JoinColumn(name = "id_disc", referencedColumnName = "id_disc")
    @ManyToOne(fetch = FetchType.LAZY)
    private DossierDiscipline idDisc;
    @JoinColumn(name = "id_periode", referencedColumnName = "id_periode")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periode idPeriode;

    public Avertissements() {
    }

    public Avertissements(Integer idAvertissement) {
        this.idAvertissement = idAvertissement;
    }

    public Integer getIdAvertissement() {
        return idAvertissement;
    }

    public void setIdAvertissement(Integer idAvertissement) {
        this.idAvertissement = idAvertissement;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
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
        hash += (idAvertissement != null ? idAvertissement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avertissements)) {
            return false;
        }
        Avertissements other = (Avertissements) object;
        if ((this.idAvertissement == null && other.idAvertissement != null) || (this.idAvertissement != null && !this.idAvertissement.equals(other.idAvertissement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Avertissements[ idAvertissement=" + idAvertissement + " ]";
    }
    
}
