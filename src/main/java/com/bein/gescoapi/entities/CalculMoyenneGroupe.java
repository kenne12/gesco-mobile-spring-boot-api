/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bein.gescoapi.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "calcul_moyenne_groupe")
public class CalculMoyenneGroupe implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_calcul")
    private Long id;
    private double total_point;
    private double total_coef;
    private double moyenne;
    @Column(length = 30)
    private String appreciation;

    @JoinColumn(name = "id_bulletin", referencedColumnName = "id_bull")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bulletin bulletin;

    @JoinColumn(name = "idgroupematiere", referencedColumnName = "idgroupematiere")
    @ManyToOne(fetch = FetchType.LAZY)
    private Groupematiere groupematiere;

    public CalculMoyenneGroupe() {
    }

    public CalculMoyenneGroupe(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal_point() {
        return total_point;
    }

    public void setTotal_point(double total_point) {
        this.total_point = total_point;
    }

    public double getTotal_coef() {
        return total_coef;
    }

    public void setTotal_coef(double total_coef) {
        this.total_coef = total_coef;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public Bulletin getBulletin() {
        return bulletin;
    }

    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    public Groupematiere getGroupematiere() {
        return groupematiere;
    }

    public void setGroupematiere(Groupematiere groupematiere) {
        this.groupematiere = groupematiere;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final CalculMoyenneGroupe other = (CalculMoyenneGroupe) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CalculMoyenneGroupe{" + "id=" + id + ", total_point=" + total_point + ", total_coef=" + total_coef + ", moyenne=" + moyenne + ", bulletin=" + bulletin + ", groupematiere=" + groupematiere + '}';
    }

}
