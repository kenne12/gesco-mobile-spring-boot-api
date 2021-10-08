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
@Table(name = "fraisscolarite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fraisscolarite.findAll", query = "SELECT f FROM Fraisscolarite f"),
    @NamedQuery(name = "Fraisscolarite.findByIdfraisscolarite", query = "SELECT f FROM Fraisscolarite f WHERE f.idfraisscolarite = :idfraisscolarite"),
    @NamedQuery(name = "Fraisscolarite.findByPension", query = "SELECT f FROM Fraisscolarite f WHERE f.pension = :pension"),
    @NamedQuery(name = "Fraisscolarite.findByInscription", query = "SELECT f FROM Fraisscolarite f WHERE f.inscription = :inscription"),
    @NamedQuery(name = "Fraisscolarite.findByTd", query = "SELECT f FROM Fraisscolarite f WHERE f.td = :td"),
    @NamedQuery(name = "Fraisscolarite.findByInscriptionNouveau", query = "SELECT f FROM Fraisscolarite f WHERE f.inscriptionNouveau = :inscriptionNouveau")})
public class Fraisscolarite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idfraisscolarite")
    private Integer idfraisscolarite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pension")
    private Double pension;
    @Column(name = "inscription")
    private Double inscription;
    @Column(name = "td")
    private Double td;
    @Column(name = "inscription_nouveau")
    private Double inscriptionNouveau;
    @JoinColumn(name = "idanneescolaire", referencedColumnName = "idanneescolaire")
    @ManyToOne(fetch = FetchType.EAGER)
    private Anneescolaire idanneescolaire;
    @JoinColumn(name = "idgroupe", referencedColumnName = "idgroupe")
    @ManyToOne(fetch = FetchType.EAGER)
    private Groupe idgroupe;
    @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
    @ManyToOne(fetch = FetchType.EAGER)
    private Institution idinstitution;
    @OneToMany(mappedBy = "idfraisscolarite", fetch = FetchType.EAGER)
    private List<Programmationscolarite> programmationscolariteList;

    public Fraisscolarite() {
    }

    public Fraisscolarite(Integer idfraisscolarite) {
        this.idfraisscolarite = idfraisscolarite;
    }

    public Integer getIdfraisscolarite() {
        return idfraisscolarite;
    }

    public void setIdfraisscolarite(Integer idfraisscolarite) {
        this.idfraisscolarite = idfraisscolarite;
    }

    public Double getPension() {
        return pension;
    }

    public void setPension(Double pension) {
        this.pension = pension;
    }

    public Double getInscription() {
        return inscription;
    }

    public void setInscription(Double inscription) {
        this.inscription = inscription;
    }

    public Double getTd() {
        return td;
    }

    public void setTd(Double td) {
        this.td = td;
    }

    public Double getInscriptionNouveau() {
        return inscriptionNouveau;
    }

    public void setInscriptionNouveau(Double inscriptionNouveau) {
        this.inscriptionNouveau = inscriptionNouveau;
    }

    public Anneescolaire getIdanneescolaire() {
        return idanneescolaire;
    }

    public void setIdanneescolaire(Anneescolaire idanneescolaire) {
        this.idanneescolaire = idanneescolaire;
    }

    public Groupe getIdgroupe() {
        return idgroupe;
    }

    public void setIdgroupe(Groupe idgroupe) {
        this.idgroupe = idgroupe;
    }

    public Institution getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Institution idinstitution) {
        this.idinstitution = idinstitution;
    }

    @XmlTransient
    public List<Programmationscolarite> getProgrammationscolariteList() {
        return programmationscolariteList;
    }

    public void setProgrammationscolariteList(List<Programmationscolarite> programmationscolariteList) {
        this.programmationscolariteList = programmationscolariteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfraisscolarite != null ? idfraisscolarite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fraisscolarite)) {
            return false;
        }
        Fraisscolarite other = (Fraisscolarite) object;
        if ((this.idfraisscolarite == null && other.idfraisscolarite != null) || (this.idfraisscolarite != null && !this.idfraisscolarite.equals(other.idfraisscolarite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fraisscolarite[ idfraisscolarite=" + idfraisscolarite + " ]";
    }
    
}
