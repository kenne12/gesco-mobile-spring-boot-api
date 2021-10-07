/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bein.gescoapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author USER
 */
@Entity
public class Notification implements Serializable {

    @Id
    private Long idnotification;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private String contact;
    private int nombredestinataire;
    private int nombrepages;
    private int nombremot;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateenvoi;
    @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
    @ManyToOne(fetch = FetchType.LAZY)
    private Institution idinstitution;

    @JoinColumn(name = "idanneescolaire", referencedColumnName = "idanneescolaire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anneescolaire idanneescolaire;

    private String rapport;
    private int echec;
    private int succes;

    public Notification() {
    }

    public Notification(Long idnotification) {
        this.idnotification = idnotification;
    }

    public Long getIdnotification() {
        return idnotification;
    }

    public void setIdnotification(Long idnotification) {
        this.idnotification = idnotification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getNombredestinataire() {
        return nombredestinataire;
    }

    public void setNombredestinataire(int nombredestinataire) {
        this.nombredestinataire = nombredestinataire;
    }

    public int getNombrepages() {
        return nombrepages;
    }

    public void setNombrepages(int nombrepages) {
        this.nombrepages = nombrepages;
    }

    public int getNombremot() {
        return nombremot;
    }

    public void setNombremot(int nombremot) {
        this.nombremot = nombremot;
    }

    public Date getDateenvoi() {
        return dateenvoi;
    }

    public void setDateenvoi(Date dateenvoi) {
        this.dateenvoi = dateenvoi;
    }

    public Institution getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Institution idinstitution) {
        this.idinstitution = idinstitution;
    }

    public Anneescolaire getIdanneescolaire() {
        return idanneescolaire;
    }

    public void setIdanneescolaire(Anneescolaire idanneescolaire) {
        this.idanneescolaire = idanneescolaire;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    public int getEchec() {
        return echec;
    }

    public void setEchec(int echec) {
        this.echec = echec;
    }

    public int getSucces() {
        return succes;
    }

    public void setSucces(int succes) {
        this.succes = succes;
    }

    @Override
    public String toString() {
        return "Notification{" + "idnotification=" + idnotification + ", message=" + message + ", contact=" + contact + ", nombredestinataire=" + nombredestinataire + ", nombrepages=" + nombrepages + ", nombremot=" + nombremot + ", dateenvoi=" + dateenvoi + ", idinstitution=" + idinstitution + ", idanneescolaire=" + idanneescolaire + ", rapport=" + rapport + ", echec=" + echec + ", succes=" + succes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.idnotification);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Notification other = (Notification) obj;
        if (!Objects.equals(this.idnotification, other.idnotification)) {
            return false;
        }
        return true;
    }

}
