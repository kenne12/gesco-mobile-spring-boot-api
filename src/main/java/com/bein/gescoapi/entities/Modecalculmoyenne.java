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
 * @author Louis Stark
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modecalculmoyenne.findAll", query = "SELECT m FROM Modecalculmoyenne m"),
    @NamedQuery(name = "Modecalculmoyenne.findByIdmodecalcul", query = "SELECT m FROM Modecalculmoyenne m WHERE m.idmodecalcul = :idmodecalcul"),
    @NamedQuery(name = "Modecalculmoyenne.findByNommode", query = "SELECT m FROM Modecalculmoyenne m WHERE m.nommode = :nommode"),
    @NamedQuery(name = "Modecalculmoyenne.findByDescmode", query = "SELECT m FROM Modecalculmoyenne m WHERE m.descmode = :descmode"),
    @NamedQuery(name = "Modecalculmoyenne.findByCodemode", query = "SELECT m FROM Modecalculmoyenne m WHERE m.codemode = :codemode")})
public class Modecalculmoyenne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idmodecalcul;
    @Column(length = 100)
    private String nommode;
    @Column(length = 254)
    private String descmode;
    @Column(length = 4)
    private String codemode;
    @OneToMany(mappedBy = "idmodecalcul", fetch = FetchType.LAZY)
    private List<Institution> institutionList;

    public Modecalculmoyenne() {
    }

    public Modecalculmoyenne(Integer idmodecalcul) {
        this.idmodecalcul = idmodecalcul;
    }

    public Integer getIdmodecalcul() {
        return idmodecalcul;
    }

    public void setIdmodecalcul(Integer idmodecalcul) {
        this.idmodecalcul = idmodecalcul;
    }

    public String getNommode() {
        return nommode;
    }

    public void setNommode(String nommode) {
        this.nommode = nommode;
    }

    public String getDescmode() {
        return descmode;
    }

    public void setDescmode(String descmode) {
        this.descmode = descmode;
    }

    public String getCodemode() {
        return codemode;
    }

    public void setCodemode(String codemode) {
        this.codemode = codemode;
    }

    @XmlTransient
    public List<Institution> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodecalcul != null ? idmodecalcul.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modecalculmoyenne)) {
            return false;
        }
        Modecalculmoyenne other = (Modecalculmoyenne) object;
        if ((this.idmodecalcul == null && other.idmodecalcul != null) || (this.idmodecalcul != null && !this.idmodecalcul.equals(other.idmodecalcul))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Modecalculmoyenne[ idmodecalcul=" + idmodecalcul + " ]";
    }
    
}
