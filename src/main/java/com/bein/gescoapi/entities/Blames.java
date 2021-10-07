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
    @NamedQuery(name = "Blames.findAll", query = "SELECT b FROM Blames b"),
    @NamedQuery(name = "Blames.findByIdBlame", query = "SELECT b FROM Blames b WHERE b.idBlame = :idBlame"),
    @NamedQuery(name = "Blames.findByMotif", query = "SELECT b FROM Blames b WHERE b.motif = :motif"),
    @NamedQuery(name = "Blames.findByDateEnregistrement", query = "SELECT b FROM Blames b WHERE b.dateEnregistrement = :dateEnregistrement"),
    @NamedQuery(name = "Blames.findByDecision", query = "SELECT b FROM Blames b WHERE b.decision = :decision")})
public class Blames implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "id_blame")
    private Integer idBlame;
    @Column(length = 254)
    private String motif;
    @Column(name = "date_enregistrement")
    @Temporal(TemporalType.DATE)
    private Date dateEnregistrement;
    @Column(name = "decision" , length = 254)
    private String decision;
    @JoinColumn(name = "id_disc", referencedColumnName = "id_disc")
    @ManyToOne(fetch = FetchType.LAZY)
    private DossierDiscipline idDisc;
    @JoinColumn(name = "id_periode", referencedColumnName = "id_periode")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periode idPeriode;

    public Blames() {
    }

    public Blames(Integer idBlame) {
        this.idBlame = idBlame;
    }

    public Integer getIdBlame() {
        return idBlame;
    }

    public void setIdBlame(Integer idBlame) {
        this.idBlame = idBlame;
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
        hash += (idBlame != null ? idBlame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blames)) {
            return false;
        }
        Blames other = (Blames) object;
        if ((this.idBlame == null && other.idBlame != null) || (this.idBlame != null && !this.idBlame.equals(other.idBlame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Blames[ idBlame=" + idBlame + " ]";
    }
    
}
