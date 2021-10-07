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
@Table(name = "evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e"),
    @NamedQuery(name = "Evaluation.findByIdevaluation", query = "SELECT e FROM Evaluation e WHERE e.idevaluation = :idevaluation"),
    @NamedQuery(name = "Evaluation.findByDateevaluation", query = "SELECT e FROM Evaluation e WHERE e.dateevaluation = :dateevaluation"),
    @NamedQuery(name = "Evaluation.findByHeureDebut", query = "SELECT e FROM Evaluation e WHERE e.heureDebut = :heureDebut"),
    @NamedQuery(name = "Evaluation.findByHeureFin", query = "SELECT e FROM Evaluation e WHERE e.heureFin = :heureFin"),
    @NamedQuery(name = "Evaluation.findByCoefficient", query = "SELECT e FROM Evaluation e WHERE e.coefficient = :coefficient")})
public class Evaluation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idevaluation")
    private Long idevaluation;
    @Column(name = "dateevaluation")
    @Temporal(TemporalType.DATE)
    private Date dateevaluation;
    @Column(name = "heure_debut")
    @Temporal(TemporalType.TIME)
    private Date heureDebut;
    @Column(name = "heure_fin")
    @Temporal(TemporalType.TIME)
    private Date heureFin;
    @Column(name = "coefficient")
    private Integer coefficient;
    @OneToMany(mappedBy = "idevaluation", fetch = FetchType.LAZY)
    private List<Note> noteList;
    @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
    @ManyToOne(fetch = FetchType.LAZY)
    private Institution idinstitution;
    @JoinColumn(name = "idmatiere_niveau", referencedColumnName = "idmatiere_niveau")
    @ManyToOne(fetch = FetchType.LAZY)
    private MatiereNiveau idmatiereNiveau;
    @JoinColumn(name = "id_periode", referencedColumnName = "id_periode")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periode idPeriode;

    public Evaluation() {
    }

    public Evaluation(Long idevaluation) {
        this.idevaluation = idevaluation;
    }

    public Long getIdevaluation() {
        return idevaluation;
    }

    public void setIdevaluation(Long idevaluation) {
        this.idevaluation = idevaluation;
    }

    public Date getDateevaluation() {
        return dateevaluation;
    }

    public void setDateevaluation(Date dateevaluation) {
        this.dateevaluation = dateevaluation;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public Institution getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Institution idinstitution) {
        this.idinstitution = idinstitution;
    }

    public MatiereNiveau getIdmatiereNiveau() {
        return idmatiereNiveau;
    }

    public void setIdmatiereNiveau(MatiereNiveau idmatiereNiveau) {
        this.idmatiereNiveau = idmatiereNiveau;
    }

    public Periode getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Periode idPeriode) {
        this.idPeriode = idPeriode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevaluation != null ? idevaluation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.idevaluation == null && other.idevaluation != null) || (this.idevaluation != null && !this.idevaluation.equals(other.idevaluation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Evaluation[ idevaluation=" + idevaluation + " ]";
    }
    
}
