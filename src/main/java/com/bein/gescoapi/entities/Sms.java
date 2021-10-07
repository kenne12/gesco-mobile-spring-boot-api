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
@Table(name = "sms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sms.findAll", query = "SELECT s FROM Sms s"),
    @NamedQuery(name = "Sms.findByIdsms", query = "SELECT s FROM Sms s WHERE s.idsms = :idsms"),
    @NamedQuery(name = "Sms.findByLibelle", query = "SELECT s FROM Sms s WHERE s.libelle = :libelle"),
    @NamedQuery(name = "Sms.findByDateenvoi", query = "SELECT s FROM Sms s WHERE s.dateenvoi = :dateenvoi"),
    @NamedQuery(name = "Sms.findByIdsouscriptionsms", query = "SELECT s FROM Sms s WHERE s.idsouscriptionsms = :idsouscriptionsms")})
public class Sms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idsms" , nullable = false)
    private Long idsms;
    @Column(name = "libelle" , length = 256)
    private String libelle;
    @Column(name = "dateenvoi")
    @Temporal(TemporalType.DATE)
    private Date dateenvoi;
    @Column(name = "idsouscriptionsms")
    private Integer idsouscriptionsms;
    @JoinColumn(name = "idinscription", referencedColumnName = "idinscription")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inscription idinscription;

    public Sms() {
    }

    public Sms(Long idsms) {
        this.idsms = idsms;
    }

    public Long getIdsms() {
        return idsms;
    }

    public void setIdsms(Long idsms) {
        this.idsms = idsms;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDateenvoi() {
        return dateenvoi;
    }

    public void setDateenvoi(Date dateenvoi) {
        this.dateenvoi = dateenvoi;
    }

    public Integer getIdsouscriptionsms() {
        return idsouscriptionsms;
    }

    public void setIdsouscriptionsms(Integer idsouscriptionsms) {
        this.idsouscriptionsms = idsouscriptionsms;
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
        hash += (idsms != null ? idsms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sms)) {
            return false;
        }
        Sms other = (Sms) object;
        if ((this.idsms == null && other.idsms != null) || (this.idsms != null && !this.idsms.equals(other.idsms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sms[ idsms=" + idsms + " ]";
    }
    
}
