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
@Table(name = "note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByIdnote", query = "SELECT n FROM Note n WHERE n.idnote = :idnote"),
    @NamedQuery(name = "Note.findByValeur", query = "SELECT n FROM Note n WHERE n.valeur = :valeur"),
    @NamedQuery(name = "Note.findByAppreciation", query = "SELECT n FROM Note n WHERE n.appreciation = :appreciation"),
    @NamedQuery(name = "Note.findByNotifie", query = "SELECT n FROM Note n WHERE n.notifie = :notifie"),
    @NamedQuery(name = "Note.findByMarkNotification", query = "SELECT n FROM Note n WHERE n.markNotification = :markNotification"),
    @NamedQuery(name = "Note.findByRang", query = "SELECT n FROM Note n WHERE n.rang = :rang"),
    @NamedQuery(name = "Note.findByMin", query = "SELECT n FROM Note n WHERE n.min = :min"),
    @NamedQuery(name = "Note.findByMax", query = "SELECT n FROM Note n WHERE n.max = :max"),
    @NamedQuery(name = "Note.findByMoy", query = "SELECT n FROM Note n WHERE n.moy = :moy")})
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idnote")
    private Long idnote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valeur")
    private Double valeur;
    @Column(name = "appreciation" , length = 30)
    private String appreciation;
    @Column(name = "notifie")
    private Boolean notifie;
    @Column(name = "mark_notification")
    private Boolean markNotification;
    @Column(name = "rang")
    private Integer rang;
    @Column(name = "min")
    private Double min;
    @Column(name = "max")
    private Double max;
    @Column(name = "moy")
    private Double moy;
    @JoinColumn(name = "idevaluation", referencedColumnName = "idevaluation")
    @ManyToOne(fetch = FetchType.LAZY)
    private Evaluation idevaluation;
    @JoinColumn(name = "idinscription", referencedColumnName = "idinscription")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inscription idinscription;

    public Note() {
    }

    public Note(Long idnote) {
        this.idnote = idnote;
    }

    public Long getIdnote() {
        return idnote;
    }

    public void setIdnote(Long idnote) {
        this.idnote = idnote;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public Boolean getNotifie() {
        return notifie;
    }

    public void setNotifie(Boolean notifie) {
        this.notifie = notifie;
    }

    public Boolean getMarkNotification() {
        return markNotification;
    }

    public void setMarkNotification(Boolean markNotification) {
        this.markNotification = markNotification;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMoy() {
        return moy;
    }

    public void setMoy(Double moy) {
        this.moy = moy;
    }

    public Evaluation getIdevaluation() {
        return idevaluation;
    }

    public void setIdevaluation(Evaluation idevaluation) {
        this.idevaluation = idevaluation;
    }

    public Inscription getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(Inscription idinscription) {
        this.idinscription = idinscription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnote != null ? idnote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.idnote == null && other.idnote != null) || (this.idnote != null && !this.idnote.equals(other.idnote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Note[ idnote=" + idnote + " ]";
    }
    
}
