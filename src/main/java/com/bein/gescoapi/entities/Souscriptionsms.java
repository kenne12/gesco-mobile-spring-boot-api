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
@Table(name = "souscriptionsms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Souscriptionsms.findAll", query = "SELECT s FROM Souscriptionsms s"),
    @NamedQuery(name = "Souscriptionsms.findByIdsouscriptionsms", query = "SELECT s FROM Souscriptionsms s WHERE s.idsouscriptionsms = :idsouscriptionsms"),
    @NamedQuery(name = "Souscriptionsms.findByDatesouscription", query = "SELECT s FROM Souscriptionsms s WHERE s.datesouscription = :datesouscription"),
    @NamedQuery(name = "Souscriptionsms.findByEtat", query = "SELECT s FROM Souscriptionsms s WHERE s.etat = :etat")})
public class Souscriptionsms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idsouscriptionsms" , nullable = false)
    private Integer idsouscriptionsms;
    @Column(name = "datesouscription")
    @Temporal(TemporalType.DATE)
    private Date datesouscription;
    @Column(name = "etat")
    private Boolean etat;
    @JoinColumn(name = "idinscription", referencedColumnName = "idinscription")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inscription idinscription;
    @OneToMany(mappedBy = "idsouscriptionsms", fetch = FetchType.LAZY)
    private List<SouscriptionsmsMatiere> souscriptionsmsMatiereList;
    @OneToMany(mappedBy = "idsouscriptionsms", fetch = FetchType.LAZY)
    private List<Payementsouscription> payementsouscriptionList;

    public Souscriptionsms() {
    }

    public Souscriptionsms(Integer idsouscriptionsms) {
        this.idsouscriptionsms = idsouscriptionsms;
    }

    public Integer getIdsouscriptionsms() {
        return idsouscriptionsms;
    }

    public void setIdsouscriptionsms(Integer idsouscriptionsms) {
        this.idsouscriptionsms = idsouscriptionsms;
    }

    public Date getDatesouscription() {
        return datesouscription;
    }

    public void setDatesouscription(Date datesouscription) {
        this.datesouscription = datesouscription;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Inscription getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(Inscription idinscription) {
        this.idinscription = idinscription;
    }

    @XmlTransient
    public List<SouscriptionsmsMatiere> getSouscriptionsmsMatiereList() {
        return souscriptionsmsMatiereList;
    }

    public void setSouscriptionsmsMatiereList(List<SouscriptionsmsMatiere> souscriptionsmsMatiereList) {
        this.souscriptionsmsMatiereList = souscriptionsmsMatiereList;
    }

    @XmlTransient
    public List<Payementsouscription> getPayementsouscriptionList() {
        return payementsouscriptionList;
    }

    public void setPayementsouscriptionList(List<Payementsouscription> payementsouscriptionList) {
        this.payementsouscriptionList = payementsouscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsouscriptionsms != null ? idsouscriptionsms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Souscriptionsms)) {
            return false;
        }
        Souscriptionsms other = (Souscriptionsms) object;
        if ((this.idsouscriptionsms == null && other.idsouscriptionsms != null) || (this.idsouscriptionsms != null && !this.idsouscriptionsms.equals(other.idsouscriptionsms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Souscriptionsms[ idsouscriptionsms=" + idsouscriptionsms + " ]";
    }
    
}
