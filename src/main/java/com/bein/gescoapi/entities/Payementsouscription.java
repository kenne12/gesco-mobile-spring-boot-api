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
@Table(name = "payementsouscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payementsouscription.findAll", query = "SELECT p FROM Payementsouscription p"),
    @NamedQuery(name = "Payementsouscription.findByIdpayementsouscription", query = "SELECT p FROM Payementsouscription p WHERE p.idpayementsouscription = :idpayementsouscription"),
    @NamedQuery(name = "Payementsouscription.findByMontant", query = "SELECT p FROM Payementsouscription p WHERE p.montant = :montant"),
    @NamedQuery(name = "Payementsouscription.findByUnite", query = "SELECT p FROM Payementsouscription p WHERE p.unite = :unite"),
    @NamedQuery(name = "Payementsouscription.findByNombresms", query = "SELECT p FROM Payementsouscription p WHERE p.nombresms = :nombresms"),
    @NamedQuery(name = "Payementsouscription.findByDatesouscription", query = "SELECT p FROM Payementsouscription p WHERE p.datesouscription = :datesouscription")})
public class Payementsouscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idpayementsouscription" , nullable = false)
    private Long idpayementsouscription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Double montant;
    @Column(name = "unite")
    private Double unite;
    @Column(name = "nombresms")
    private Integer nombresms;
    @Column(name = "datesouscription")
    @Temporal(TemporalType.DATE)
    private Date datesouscription;
    @JoinColumn(name = "idsouscriptionsms", referencedColumnName = "idsouscriptionsms")
    @ManyToOne(fetch = FetchType.LAZY)
    private Souscriptionsms idsouscriptionsms;

    public Payementsouscription() {
    }

    public Payementsouscription(Long idpayementsouscription) {
        this.idpayementsouscription = idpayementsouscription;
    }

    public Long getIdpayementsouscription() {
        return idpayementsouscription;
    }

    public void setIdpayementsouscription(Long idpayementsouscription) {
        this.idpayementsouscription = idpayementsouscription;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Double getUnite() {
        return unite;
    }

    public void setUnite(Double unite) {
        this.unite = unite;
    }

    public Integer getNombresms() {
        return nombresms;
    }

    public void setNombresms(Integer nombresms) {
        this.nombresms = nombresms;
    }

    public Date getDatesouscription() {
        return datesouscription;
    }

    public void setDatesouscription(Date datesouscription) {
        this.datesouscription = datesouscription;
    }

    public Souscriptionsms getIdsouscriptionsms() {
        return idsouscriptionsms;
    }

    public void setIdsouscriptionsms(Souscriptionsms idsouscriptionsms) {
        this.idsouscriptionsms = idsouscriptionsms;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpayementsouscription != null ? idpayementsouscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payementsouscription)) {
            return false;
        }
        Payementsouscription other = (Payementsouscription) object;
        if ((this.idpayementsouscription == null && other.idpayementsouscription != null) || (this.idpayementsouscription != null && !this.idpayementsouscription.equals(other.idpayementsouscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Payementsouscription[ idpayementsouscription=" + idpayementsouscription + " ]";
    }
    
}
