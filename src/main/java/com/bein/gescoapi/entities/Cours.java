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
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Arianne
 */
@Entity
@Table(name = "cours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c"),
    @NamedQuery(name = "Cours.findByIdcours", query = "SELECT c FROM Cours c WHERE c.idcours = :idcours"),
    @NamedQuery(name = "Cours.findByDatecours", query = "SELECT c FROM Cours c WHERE c.datecours = :datecours"),
    @NamedQuery(name = "Cours.findByHeureplanifiee", query = "SELECT c FROM Cours c WHERE c.heureplanifiee = :heureplanifiee"),
    @NamedQuery(name = "Cours.findByHeurerealisee", query = "SELECT c FROM Cours c WHERE c.heurerealisee = :heurerealisee"),
    @NamedQuery(name = "Cours.findByCu", query = "SELECT c FROM Cours c WHERE c.cu = :cu"),
    @NamedQuery(name = "Cours.findByMontant", query = "SELECT c FROM Cours c WHERE c.montant = :montant"),
    @NamedQuery(name = "Cours.findByPayer", query = "SELECT c FROM Cours c WHERE c.payer = :payer")})
public class Cours implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcours")
    private Integer idcours;
    @Column(name = "datecours")
    @Temporal(TemporalType.DATE)
    private Date datecours;
    @Column(name = "heureplanifiee")
    private BigInteger heureplanifiee;
    @Column(name = "heurerealisee")
    private BigInteger heurerealisee;
    @Column(name = "cu")
    private BigInteger cu;
    @Column(name = "montant")
    private BigInteger montant;
    @Column(name = "payer")
    private Boolean payer;
    @JoinTable(name = "courslecon", joinColumns = {
        @JoinColumn(name = "idcours", referencedColumnName = "idcours")}, inverseJoinColumns = {
        @JoinColumn(name = "idlecon", referencedColumnName = "idlecon")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Lecon> leconList;
    @JoinColumn(name = "idprogrammationcours", referencedColumnName = "idprogrammationcours")
    @ManyToOne(fetch = FetchType.LAZY)
    private Programmationcours idprogrammationcours;
    @JoinColumn(name = "idtarifhoraire", referencedColumnName = "idtarifhoraire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tarifhoraire idtarifhoraire;

    public Cours() {
    }

    public Cours(Integer idcours) {
        this.idcours = idcours;
    }

    public Integer getIdcours() {
        return idcours;
    }

    public void setIdcours(Integer idcours) {
        this.idcours = idcours;
    }

    public Date getDatecours() {
        return datecours;
    }

    public void setDatecours(Date datecours) {
        this.datecours = datecours;
    }

    public BigInteger getHeureplanifiee() {
        return heureplanifiee;
    }

    public void setHeureplanifiee(BigInteger heureplanifiee) {
        this.heureplanifiee = heureplanifiee;
    }

    public BigInteger getHeurerealisee() {
        return heurerealisee;
    }

    public void setHeurerealisee(BigInteger heurerealisee) {
        this.heurerealisee = heurerealisee;
    }

    public BigInteger getCu() {
        return cu;
    }

    public void setCu(BigInteger cu) {
        this.cu = cu;
    }

    public BigInteger getMontant() {
        return montant;
    }

    public void setMontant(BigInteger montant) {
        this.montant = montant;
    }

    public Boolean getPayer() {
        return payer;
    }

    public void setPayer(Boolean payer) {
        this.payer = payer;
    }

    @XmlTransient
    public List<Lecon> getLeconList() {
        return leconList;
    }

    public void setLeconList(List<Lecon> leconList) {
        this.leconList = leconList;
    }

    public Programmationcours getIdprogrammationcours() {
        return idprogrammationcours;
    }

    public void setIdprogrammationcours(Programmationcours idprogrammationcours) {
        this.idprogrammationcours = idprogrammationcours;
    }

    public Tarifhoraire getIdtarifhoraire() {
        return idtarifhoraire;
    }

    public void setIdtarifhoraire(Tarifhoraire idtarifhoraire) {
        this.idtarifhoraire = idtarifhoraire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcours != null ? idcours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.idcours == null && other.idcours != null) || (this.idcours != null && !this.idcours.equals(other.idcours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cours[ idcours=" + idcours + " ]";
    }
    
}
