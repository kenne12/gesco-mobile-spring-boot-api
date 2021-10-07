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
@Table(name = "programmationscolarite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programmationscolarite.findAll", query = "SELECT p FROM Programmationscolarite p"),
    @NamedQuery(name = "Programmationscolarite.findByIdprogrammationscolarite", query = "SELECT p FROM Programmationscolarite p WHERE p.idprogrammationscolarite = :idprogrammationscolarite"),
    @NamedQuery(name = "Programmationscolarite.findByDatelimite", query = "SELECT p FROM Programmationscolarite p WHERE p.datelimite = :datelimite"),
    @NamedQuery(name = "Programmationscolarite.findByMontant", query = "SELECT p FROM Programmationscolarite p WHERE p.montant = :montant")})
public class Programmationscolarite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idprogrammationscolarite", nullable = false)
    private Integer idprogrammationscolarite;
    @Column(name = "datelimite")
    @Temporal(TemporalType.DATE)
    private Date datelimite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Double montant;
    @OneToMany(mappedBy = "idprogrammationscolarite", fetch = FetchType.LAZY)
    private List<Lignescolarite> lignescolariteList;
    @JoinColumn(name = "idanneescolaire", referencedColumnName = "idanneescolaire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anneescolaire idanneescolaire;
    @JoinColumn(name = "idfraisscolarite", referencedColumnName = "idfraisscolarite")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fraisscolarite idfraisscolarite;
    @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
    @ManyToOne(fetch = FetchType.LAZY)
    private Institution idinstitution;
    @JoinColumn(name = "idtranche", referencedColumnName = "idtranche")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tranche idtranche;

    public Programmationscolarite() {
    }

    public Programmationscolarite(Integer idprogrammationscolarite) {
        this.idprogrammationscolarite = idprogrammationscolarite;
    }

    public Integer getIdprogrammationscolarite() {
        return idprogrammationscolarite;
    }

    public void setIdprogrammationscolarite(Integer idprogrammationscolarite) {
        this.idprogrammationscolarite = idprogrammationscolarite;
    }

    public Date getDatelimite() {
        return datelimite;
    }

    public void setDatelimite(Date datelimite) {
        this.datelimite = datelimite;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    @XmlTransient
    public List<Lignescolarite> getLignescolariteList() {
        return lignescolariteList;
    }

    public void setLignescolariteList(List<Lignescolarite> lignescolariteList) {
        this.lignescolariteList = lignescolariteList;
    }

    public Anneescolaire getIdanneescolaire() {
        return idanneescolaire;
    }

    public void setIdanneescolaire(Anneescolaire idanneescolaire) {
        this.idanneescolaire = idanneescolaire;
    }

    public Fraisscolarite getIdfraisscolarite() {
        return idfraisscolarite;
    }

    public void setIdfraisscolarite(Fraisscolarite idfraisscolarite) {
        this.idfraisscolarite = idfraisscolarite;
    }

    public Institution getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Institution idinstitution) {
        this.idinstitution = idinstitution;
    }

    public Tranche getIdtranche() {
        return idtranche;
    }

    public void setIdtranche(Tranche idtranche) {
        this.idtranche = idtranche;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprogrammationscolarite != null ? idprogrammationscolarite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programmationscolarite)) {
            return false;
        }
        Programmationscolarite other = (Programmationscolarite) object;
        if ((this.idprogrammationscolarite == null && other.idprogrammationscolarite != null) || (this.idprogrammationscolarite != null && !this.idprogrammationscolarite.equals(other.idprogrammationscolarite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Programmationscolarite[ idprogrammationscolarite=" + idprogrammationscolarite + " ]";
    }
    
}
