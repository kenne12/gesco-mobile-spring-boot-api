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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "modeappreciation")
public class ModeAppreciation implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_mode")
    private Integer idMode;
    @Column(length = 50)
    private String nom;
    @Column(length = 10)
    private String code;

    public ModeAppreciation() {
    }

    public ModeAppreciation(Integer idMode) {
        this.idMode = idMode;
    }

    public Integer getIdMode() {
        return idMode;
    }

    public void setIdMode(Integer idMode) {
        this.idMode = idMode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idMode);
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
        final ModeAppreciation other = (ModeAppreciation) obj;
        return Objects.equals(this.idMode, other.idMode);
    }

}
