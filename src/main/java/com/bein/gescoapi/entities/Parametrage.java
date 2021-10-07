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
@Table(name = "parametrage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametrage.findAll", query = "SELECT p FROM Parametrage p"),
    @NamedQuery(name = "Parametrage.findByIdparametrage", query = "SELECT p FROM Parametrage p WHERE p.idparametrage = :idparametrage"),
    @NamedQuery(name = "Parametrage.findByRepertoireLogo", query = "SELECT p FROM Parametrage p WHERE p.repertoireLogo = :repertoireLogo"),
    @NamedQuery(name = "Parametrage.findByCuSms", query = "SELECT p FROM Parametrage p WHERE p.cuSms = :cuSms")})
public class Parametrage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idparametrage", nullable = false)
    private Integer idparametrage;

    @Column(name = "repertoire_logo" , length = 150)
    private String repertoireLogo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cu_sms")
    private Double cuSms;

    public Parametrage() {
    }

    public Parametrage(Integer idparametrage) {
        this.idparametrage = idparametrage;
    }

    public Integer getIdparametrage() {
        return idparametrage;
    }

    public void setIdparametrage(Integer idparametrage) {
        this.idparametrage = idparametrage;
    }

    public String getRepertoireLogo() {
        return repertoireLogo;
    }

    public void setRepertoireLogo(String repertoireLogo) {
        this.repertoireLogo = repertoireLogo;
    }

    public Double getCuSms() {
        return cuSms;
    }

    public void setCuSms(Double cuSms) {
        this.cuSms = cuSms;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparametrage != null ? idparametrage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametrage)) {
            return false;
        }
        Parametrage other = (Parametrage) object;
        if ((this.idparametrage == null && other.idparametrage != null) || (this.idparametrage != null && !this.idparametrage.equals(other.idparametrage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Parametrage[ idparametrage=" + idparametrage + " ]";
    }
    
}
