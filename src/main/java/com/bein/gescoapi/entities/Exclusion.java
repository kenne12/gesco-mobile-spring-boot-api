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
@Table(name = "exclusion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exclusion.findAll", query = "SELECT e FROM Exclusion e"),
    @NamedQuery(name = "Exclusion.findByIdexclusion", query = "SELECT e FROM Exclusion e WHERE e.idexclusion = :idexclusion"),
    @NamedQuery(name = "Exclusion.findByMotif", query = "SELECT e FROM Exclusion e WHERE e.motif = :motif"),
    @NamedQuery(name = "Exclusion.findByDateexclusion", query = "SELECT e FROM Exclusion e WHERE e.dateexclusion = :dateexclusion")})
public class Exclusion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idexclusion")
    private Integer idexclusion;

    @Column(name = "motif" , length = 400)
    private String motif;
    @Column(name = "dateexclusion")
    @Temporal(TemporalType.DATE)
    private Date dateexclusion;
    @JoinColumn(name = "idinscription", referencedColumnName = "idinscription")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inscription idinscription;

    public Exclusion() {
    }

    public Exclusion(Integer idexclusion) {
        this.idexclusion = idexclusion;
    }

    public Integer getIdexclusion() {
        return idexclusion;
    }

    public void setIdexclusion(Integer idexclusion) {
        this.idexclusion = idexclusion;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateexclusion() {
        return dateexclusion;
    }

    public void setDateexclusion(Date dateexclusion) {
        this.dateexclusion = dateexclusion;
    }

    public Inscription getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(Inscription idinscription) {
        this.idinscription = idinscription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexclusion != null ? idexclusion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exclusion)) {
            return false;
        }
        Exclusion other = (Exclusion) object;
        if ((this.idexclusion == null && other.idexclusion != null) || (this.idexclusion != null && !this.idexclusion.equals(other.idexclusion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Exclusion[ idexclusion=" + idexclusion + " ]";
    }
    
}
