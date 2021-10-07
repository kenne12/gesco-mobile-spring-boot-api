/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bein.gescoapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author USER
 */
@Entity
public class Discipline implements Serializable {

    @Id
    @Basic(optional = false)
    private Long iddiscipline;

    @Column(length = 500)
    private String motif;

    @Column(name = "date_jour")
    @Temporal(TemporalType.DATE)
    private Date dateJour;

    @Column(length = 200)
    private String decision;

    @JoinColumn(name = "id_periode", referencedColumnName = "id_periode")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periode periode;

    @JoinColumn(name = "id_disc", referencedColumnName = "id_disc")
    @ManyToOne(fetch = FetchType.LAZY)
    private DossierDiscipline dossierDiscipline;

    public Discipline() {
    }

    public Discipline(Long iddiscipline) {
        this.iddiscipline = iddiscipline;
    }

    public Long getIddiscipline() {
        return iddiscipline;
    }

    public void setIddiscipline(Long iddiscipline) {
        this.iddiscipline = iddiscipline;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateJour() {
        return dateJour;
    }

    public void setDateJour(Date dateJour) {
        this.dateJour = dateJour;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public DossierDiscipline getDossierDiscipline() {
        return dossierDiscipline;
    }

    public void setDossierDiscipline(DossierDiscipline dossierDiscipline) {
        this.dossierDiscipline = dossierDiscipline;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.iddiscipline);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Discipline other = (Discipline) obj;
        return Objects.equals(this.iddiscipline, other.iddiscipline);
    }

    @Override
    public String toString() {
        return "Discipline{" + "iddiscipline=" + iddiscipline + ", motif=" + motif + ", dateJour=" + dateJour + ", decision=" + decision + '}';
    }

}
