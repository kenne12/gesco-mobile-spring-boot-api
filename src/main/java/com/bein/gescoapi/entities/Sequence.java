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
import java.util.List;

/**
 *
 * @author Arianne
 */
@Entity
@Table(name = "sequence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sequence.findAll", query = "SELECT s FROM Sequence s"),
    @NamedQuery(name = "Sequence.findByIdsequence", query = "SELECT s FROM Sequence s WHERE s.idsequence = :idsequence"),
    @NamedQuery(name = "Sequence.findByNom", query = "SELECT s FROM Sequence s WHERE s.nom = :nom"),
    @NamedQuery(name = "Sequence.findByNumero", query = "SELECT s FROM Sequence s WHERE s.numero = :numero")})
public class Sequence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idsequence" , nullable = false)
    private Integer idsequence;

    @Column(name = "nom" , length = 100)
    private String nom;
    @Column(name = "numero")
    private Integer numero;
    @OneToMany(mappedBy = "idsequence", fetch = FetchType.LAZY)
    private List<Periode> periodeList;

    public Sequence() {
    }

    public Sequence(Integer idsequence) {
        this.idsequence = idsequence;
    }

    public Integer getIdsequence() {
        return idsequence;
    }

    public void setIdsequence(Integer idsequence) {
        this.idsequence = idsequence;
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

    @XmlTransient
    public List<Periode> getPeriodeList() {
        return periodeList;
    }

    public void setPeriodeList(List<Periode> periodeList) {
        this.periodeList = periodeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsequence != null ? idsequence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sequence)) {
            return false;
        }
        Sequence other = (Sequence) object;
        if ((this.idsequence == null && other.idsequence != null) || (this.idsequence != null && !this.idsequence.equals(other.idsequence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sequence[ idsequence=" + idsequence + " ]";
    }
    
}
