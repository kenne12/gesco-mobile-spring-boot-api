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
@Table(name = "scolarite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scolarite.findAll", query = "SELECT s FROM Scolarite s"),
    @NamedQuery(name = "Scolarite.findByIdscolarite", query = "SELECT s FROM Scolarite s WHERE s.idscolarite = :idscolarite"),
    @NamedQuery(name = "Scolarite.findByMontanpayer", query = "SELECT s FROM Scolarite s WHERE s.montanpayer = :montanpayer"),
    @NamedQuery(name = "Scolarite.findByReste", query = "SELECT s FROM Scolarite s WHERE s.reste = :reste"),
    @NamedQuery(name = "Scolarite.findByDatepaiement", query = "SELECT s FROM Scolarite s WHERE s.datepaiement = :datepaiement"),
    @NamedQuery(name = "Scolarite.findByCode", query = "SELECT s FROM Scolarite s WHERE s.code = :code")})
public class Scolarite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idscolarite" , nullable = false)
    private Integer idscolarite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montanpayer")
    private Double montanpayer;
    @Column(name = "reste")
    private Double reste;
    @Column(name = "datepaiement")
    @Temporal(TemporalType.DATE)
    private Date datepaiement;

    @Column(name = "code" , length = 50)
    private String code;
    @JoinColumn(name = "idinscription", referencedColumnName = "idinscription")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inscription idinscription;
    @OneToMany(mappedBy = "idscolarite", fetch = FetchType.LAZY)
    private List<Lignescolarite> lignescolariteList;

    private Double remboursement;

    public Scolarite() {
    }

    public Scolarite(Integer idscolarite) {
        this.idscolarite = idscolarite;
    }

    public Integer getIdscolarite() {
        return idscolarite;
    }

    public void setIdscolarite(Integer idscolarite) {
        this.idscolarite = idscolarite;
    }

    public Double getMontanpayer() {
        return montanpayer;
    }

    public void setMontanpayer(Double montanpayer) {
        this.montanpayer = montanpayer;
    }

    public Double getReste() {
        return reste;
    }

    public void setReste(Double reste) {
        this.reste = reste;
    }

    public Date getDatepaiement() {
        return datepaiement;
    }

    public void setDatepaiement(Date datepaiement) {
        this.datepaiement = datepaiement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Inscription getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(Inscription idinscription) {
        this.idinscription = idinscription;
    }

    public Double getRemboursement() {
        return remboursement;
    }

    public void setRemboursement(Double remboursement) {
        this.remboursement = remboursement;
    }

    @XmlTransient
    public List<Lignescolarite> getLignescolariteList() {
        return lignescolariteList;
    }

    public void setLignescolariteList(List<Lignescolarite> lignescolariteList) {
        this.lignescolariteList = lignescolariteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idscolarite != null ? idscolarite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scolarite)) {
            return false;
        }
        Scolarite other = (Scolarite) object;
        if ((this.idscolarite == null && other.idscolarite != null) || (this.idscolarite != null && !this.idscolarite.equals(other.idscolarite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Scolarite[ idscolarite=" + idscolarite + " ]";
    }

    }
