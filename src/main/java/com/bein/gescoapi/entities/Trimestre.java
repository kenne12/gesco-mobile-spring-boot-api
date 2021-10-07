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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t"),
    @NamedQuery(name = "Trimestre.findByIdTrimestre", query = "SELECT t FROM Trimestre t WHERE t.idTrimestre = :idTrimestre"),
    @NamedQuery(name = "Trimestre.findByNom", query = "SELECT t FROM Trimestre t WHERE t.nom = :nom"),
    @NamedQuery(name = "Trimestre.findByNumero", query = "SELECT t FROM Trimestre t WHERE t.numero = :numero"),
    @NamedQuery(name = "Trimestre.findByDatedebut", query = "SELECT t FROM Trimestre t WHERE t.datedebut = :datedebut"),
    @NamedQuery(name = "Trimestre.findByDatefin", query = "SELECT t FROM Trimestre t WHERE t.datefin = :datefin")})
public class Trimestre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_trimestre" , nullable = false)
    private Integer idTrimestre;
    @Column(length = 254)
    private String nom;
    private Integer numero;
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Column(length = 254)
    private String nomcolumn1;
    @Column(length = 254)
    private String codecolumn1;
    @Column(length = 254)
    private String nomcolumn2;
    @Column(length = 254)
    private String codecolumn2;

    public Trimestre() {
    }

    public Trimestre(Integer idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public Integer getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(Integer idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getNomcolumn1() {
        return nomcolumn1;
    }

    public void setNomcolumn1(String nomcolumn1) {
        this.nomcolumn1 = nomcolumn1;
    }

    public String getCodecolumn1() {
        return codecolumn1;
    }

    public void setCodecolumn1(String codecolumn1) {
        this.codecolumn1 = codecolumn1;
    }

    public String getNomcolumn2() {
        return nomcolumn2;
    }

    public void setNomcolumn2(String nomcolumn2) {
        this.nomcolumn2 = nomcolumn2;
    }

    public String getCodecolumn2() {
        return codecolumn2;
    }

    public void setCodecolumn2(String codecolumn2) {
        this.codecolumn2 = codecolumn2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrimestre != null ? idTrimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.idTrimestre == null && other.idTrimestre != null) || (this.idTrimestre != null && !this.idTrimestre.equals(other.idTrimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Trimestre[ idTrimestre=" + idTrimestre + " ]";
    }
    
}
