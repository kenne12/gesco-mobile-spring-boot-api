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
@Table(name = "souscriptionsms_matiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SouscriptionsmsMatiere.findAll", query = "SELECT s FROM SouscriptionsmsMatiere s"),
    @NamedQuery(name = "SouscriptionsmsMatiere.findByIdsouscriptionsmsMatiere", query = "SELECT s FROM SouscriptionsmsMatiere s WHERE s.idsouscriptionsmsMatiere = :idsouscriptionsmsMatiere"),
    @NamedQuery(name = "SouscriptionsmsMatiere.findByValeurinferieur", query = "SELECT s FROM SouscriptionsmsMatiere s WHERE s.valeurinferieur = :valeurinferieur"),
    @NamedQuery(name = "SouscriptionsmsMatiere.findByValeursuperieur", query = "SELECT s FROM SouscriptionsmsMatiere s WHERE s.valeursuperieur = :valeursuperieur")})
public class SouscriptionsmsMatiere implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idsouscriptionsms_matiere" , nullable = false)
    private Long idsouscriptionsmsMatiere;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valeurinferieur")
    private Double valeurinferieur;
    @Column(name = "valeursuperieur")
    private Double valeursuperieur;
    @JoinColumn(name = "idmatiere_niveau", referencedColumnName = "idmatiere_niveau")
    @ManyToOne(fetch = FetchType.LAZY)
    private MatiereNiveau idmatiereNiveau;
    @JoinColumn(name = "idsouscriptionsms", referencedColumnName = "idsouscriptionsms")
    @ManyToOne(fetch = FetchType.LAZY)
    private Souscriptionsms idsouscriptionsms;

    public SouscriptionsmsMatiere() {
    }

    public SouscriptionsmsMatiere(Long idsouscriptionsmsMatiere) {
        this.idsouscriptionsmsMatiere = idsouscriptionsmsMatiere;
    }

    public Long getIdsouscriptionsmsMatiere() {
        return idsouscriptionsmsMatiere;
    }

    public void setIdsouscriptionsmsMatiere(Long idsouscriptionsmsMatiere) {
        this.idsouscriptionsmsMatiere = idsouscriptionsmsMatiere;
    }

    public Double getValeurinferieur() {
        return valeurinferieur;
    }

    public void setValeurinferieur(Double valeurinferieur) {
        this.valeurinferieur = valeurinferieur;
    }

    public Double getValeursuperieur() {
        return valeursuperieur;
    }

    public void setValeursuperieur(Double valeursuperieur) {
        this.valeursuperieur = valeursuperieur;
    }

    public MatiereNiveau getIdmatiereNiveau() {
        return idmatiereNiveau;
    }

    public void setIdmatiereNiveau(MatiereNiveau idmatiereNiveau) {
        this.idmatiereNiveau = idmatiereNiveau;
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
        hash += (idsouscriptionsmsMatiere != null ? idsouscriptionsmsMatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SouscriptionsmsMatiere)) {
            return false;
        }
        SouscriptionsmsMatiere other = (SouscriptionsmsMatiere) object;
        if ((this.idsouscriptionsmsMatiere == null && other.idsouscriptionsmsMatiere != null) || (this.idsouscriptionsmsMatiere != null && !this.idsouscriptionsmsMatiere.equals(other.idsouscriptionsmsMatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SouscriptionsmsMatiere[ idsouscriptionsmsMatiere=" + idsouscriptionsmsMatiere + " ]";
    }
    
}
