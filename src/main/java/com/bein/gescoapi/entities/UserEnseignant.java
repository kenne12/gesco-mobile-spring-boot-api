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
 * @author Louis Stark
 */
@Entity
@Table(name = "user_enseignant")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UserEnseignant.findAll", query = "SELECT u FROM UserEnseignant u"),
        @NamedQuery(name = "UserEnseignant.findByIduserEns", query = "SELECT u FROM UserEnseignant u WHERE u.iduserEns = :iduserEns")})
public class UserEnseignant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "iduser_ens", nullable = false)
    private Integer iduserEns;
    @JoinColumn(name = "idenseignant", referencedColumnName = "idenseignant")
    @ManyToOne(fetch = FetchType.LAZY)
    private Enseignant idenseignant;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur idutilisateur;

    public UserEnseignant() {
    }

    public UserEnseignant(Integer iduserEns) {
        this.iduserEns = iduserEns;
    }

    public Integer getIduserEns() {
        return iduserEns;
    }

    public void setIduserEns(Integer iduserEns) {
        this.iduserEns = iduserEns;
    }

    public Enseignant getIdenseignant() {
        return idenseignant;
    }

    public void setIdenseignant(Enseignant idenseignant) {
        this.idenseignant = idenseignant;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduserEns != null ? iduserEns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEnseignant)) {
            return false;
        }
        UserEnseignant other = (UserEnseignant) object;
        if ((this.iduserEns == null && other.iduserEns != null) || (this.iduserEns != null && !this.iduserEns.equals(other.iduserEns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserEnseignant[ iduserEns=" + iduserEns + " ]";
    }

}
