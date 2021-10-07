/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bein.gescoapi.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Arianne
 */
@Entity
@Table(name = "lignescolarite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lignescolarite.findAll", query = "SELECT l FROM Lignescolarite l"),
    @NamedQuery(name = "Lignescolarite.findByIdlignescolarite", query = "SELECT l FROM Lignescolarite l WHERE l.idlignescolarite = :idlignescolarite"),
    @NamedQuery(name = "Lignescolarite.findByMontantpaye", query = "SELECT l FROM Lignescolarite l WHERE l.montantpaye = :montantpaye"),
    @NamedQuery(name = "Lignescolarite.findByReste", query = "SELECT l FROM Lignescolarite l WHERE l.reste = :reste"),
    @NamedQuery(name = "Lignescolarite.findByMontant", query = "SELECT l FROM Lignescolarite l WHERE l.montant = :montant"),
    @NamedQuery(name = "Lignescolarite.findByMontanttotal", query = "SELECT l FROM Lignescolarite l WHERE l.montanttotal = :montanttotal")})
public class Lignescolarite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idlignescolarite")
    private Long idlignescolarite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montantpaye")
    private Double montantpaye;
    @Column(name = "reste")
    private Double reste;
    @Column(name = "montant")
    private Double montant;
    @Column(name = "montanttotal")
    private Double montanttotal;
    @JoinColumn(name = "idprogrammationscolarite", referencedColumnName = "idprogrammationscolarite")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programmationscolarite idprogrammationscolarite;
    @JoinColumn(name = "idscolarite", referencedColumnName = "idscolarite")
    @ManyToOne(fetch = FetchType.LAZY)
    private Scolarite idscolarite;

    public Lignescolarite() {
    }

    public Lignescolarite(Long idlignescolarite) {
        this.idlignescolarite = idlignescolarite;
    }

    public Long getIdlignescolarite() {
        return idlignescolarite;
    }

    public void setIdlignescolarite(Long idlignescolarite) {
        this.idlignescolarite = idlignescolarite;
    }

    public Double getMontantpaye() {
        return montantpaye;
    }

    public void setMontantpaye(Double montantpaye) {
        this.montantpaye = montantpaye;
    }

    public Double getReste() {
        return reste;
    }

    public void setReste(Double reste) {
        this.reste = reste;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Double getMontanttotal() {
        return montanttotal;
    }

    public void setMontanttotal(Double montanttotal) {
        this.montanttotal = montanttotal;
    }

    public Programmationscolarite getIdprogrammationscolarite() {
        return idprogrammationscolarite;
    }

    public void setIdprogrammationscolarite(Programmationscolarite idprogrammationscolarite) {
        this.idprogrammationscolarite = idprogrammationscolarite;
    }

    public Scolarite getIdscolarite() {
        return idscolarite;
    }

    public void setIdscolarite(Scolarite idscolarite) {
        this.idscolarite = idscolarite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlignescolarite != null ? idlignescolarite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignescolarite)) {
            return false;
        }
        Lignescolarite other = (Lignescolarite) object;
        if ((this.idlignescolarite == null && other.idlignescolarite != null) || (this.idlignescolarite != null && !this.idlignescolarite.equals(other.idlignescolarite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lignescolarite[ idlignescolarite=" + idlignescolarite + " ]";
    }
    
}
