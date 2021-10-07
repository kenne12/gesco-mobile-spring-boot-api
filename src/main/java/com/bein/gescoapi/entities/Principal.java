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
 * @author Louis Stark
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Principal.findAll", query = "SELECT p FROM Principal p"),
    @NamedQuery(name = "Principal.findByIdPrincipal", query = "SELECT p FROM Principal p WHERE p.idPrincipal = :idPrincipal")})
public class Principal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_principal" , nullable = false)
    private Integer idPrincipal;
    @JoinColumn(name = "idanneescolaire", referencedColumnName = "idanneescolaire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anneescolaire idanneescolaire;
    @JoinColumn(name = "idclasse", referencedColumnName = "idclasse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Classe idclasse;
    @JoinColumn(name = "idenseignant", referencedColumnName = "idenseignant")
    @ManyToOne(fetch = FetchType.LAZY)
    private Enseignant idenseignant;
    @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
    @ManyToOne(fetch = FetchType.LAZY)
    private Institution idinstitution;

    public Principal() {
    }

    public Principal(Integer idPrincipal) {
        this.idPrincipal = idPrincipal;
    }

    public Integer getIdPrincipal() {
        return idPrincipal;
    }

    public void setIdPrincipal(Integer idPrincipal) {
        this.idPrincipal = idPrincipal;
    }

    public Anneescolaire getIdanneescolaire() {
        return idanneescolaire;
    }

    public void setIdanneescolaire(Anneescolaire idanneescolaire) {
        this.idanneescolaire = idanneescolaire;
    }

    public Classe getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Classe idclasse) {
        this.idclasse = idclasse;
    }

    public Enseignant getIdenseignant() {
        return idenseignant;
    }

    public void setIdenseignant(Enseignant idenseignant) {
        this.idenseignant = idenseignant;
    }

    public Institution getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Institution idinstitution) {
        this.idinstitution = idinstitution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrincipal != null ? idPrincipal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Principal)) {
            return false;
        }
        Principal other = (Principal) object;
        if ((this.idPrincipal == null && other.idPrincipal != null) || (this.idPrincipal != null && !this.idPrincipal.equals(other.idPrincipal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Principal[ idPrincipal=" + idPrincipal + " ]";
    }
    
}
