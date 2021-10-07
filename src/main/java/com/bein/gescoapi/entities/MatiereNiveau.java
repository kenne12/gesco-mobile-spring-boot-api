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
@Table(name = "matiere_niveau")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MatiereNiveau.findAll", query = "SELECT m FROM MatiereNiveau m"),
    @NamedQuery(name = "MatiereNiveau.findByIdmatiereNiveau", query = "SELECT m FROM MatiereNiveau m WHERE m.idmatiereNiveau = :idmatiereNiveau"),
    @NamedQuery(name = "MatiereNiveau.findByCoefficient", query = "SELECT m FROM MatiereNiveau m WHERE m.coefficient = :coefficient")})
public class MatiereNiveau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "idmatiere_niveau")
    private Integer idmatiereNiveau;
    @Column(name = "coefficient")
    private Integer coefficient;
    private boolean notification;
    @OneToMany(mappedBy = "idmatiereNiveau", fetch = FetchType.LAZY)
    private List<SouscriptionsmsMatiere> souscriptionsmsMatiereList;
    @OneToMany(mappedBy = "idmatiereNiveau", fetch = FetchType.LAZY)
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "idgroupematiere", referencedColumnName = "idgroupematiere")
    @ManyToOne(fetch = FetchType.LAZY)
    private Groupematiere idgroupematiere;
    @JoinColumn(name = "idmatiere", referencedColumnName = "idmatiere")
    @ManyToOne(fetch = FetchType.LAZY)
    private Matiere idmatiere;
    @JoinColumn(name = "idniveauclasse", referencedColumnName = "idniveauclasse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Niveauclasse idniveauclasse;

    public MatiereNiveau() {
    }

    public MatiereNiveau(Integer idmatiereNiveau) {
        this.idmatiereNiveau = idmatiereNiveau;
    }

    public Integer getIdmatiereNiveau() {
        return idmatiereNiveau;
    }

    public void setIdmatiereNiveau(Integer idmatiereNiveau) {
        this.idmatiereNiveau = idmatiereNiveau;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    @XmlTransient
    public List<SouscriptionsmsMatiere> getSouscriptionsmsMatiereList() {
        return souscriptionsmsMatiereList;
    }

    public void setSouscriptionsmsMatiereList(List<SouscriptionsmsMatiere> souscriptionsmsMatiereList) {
        this.souscriptionsmsMatiereList = souscriptionsmsMatiereList;
    }

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public Groupematiere getIdgroupematiere() {
        return idgroupematiere;
    }

    public void setIdgroupematiere(Groupematiere idgroupematiere) {
        this.idgroupematiere = idgroupematiere;
    }

    public Matiere getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(Matiere idmatiere) {
        this.idmatiere = idmatiere;
    }

    public Niveauclasse getIdniveauclasse() {
        return idniveauclasse;
    }

    public void setidniveauclasse(Niveauclasse idniveauclasse) {
        this.idniveauclasse = idniveauclasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatiereNiveau != null ? idmatiereNiveau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatiereNiveau)) {
            return false;
        }
        MatiereNiveau other = (MatiereNiveau) object;
        if ((this.idmatiereNiveau == null && other.idmatiereNiveau != null) || (this.idmatiereNiveau != null && !this.idmatiereNiveau.equals(other.idmatiereNiveau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.MatiereNiveau[ idmatiereNiveau=" + idmatiereNiveau + " ]";
    }

}
