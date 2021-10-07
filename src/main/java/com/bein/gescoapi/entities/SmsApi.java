/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bein.gescoapi.entities;

import java.io.Serializable;
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
@Table(name = "sms_api")
public class SmsApi implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "idsms_api")
    private Integer idSmsApi;
    @Column(length = 30)
    private String nom;
    @Column(length = 15)
    private String code;

    public SmsApi() {
    }

    public SmsApi(Integer idSmsApi) {
        this.idSmsApi = idSmsApi;
    }

    public Integer getIdSmsApi() {
        return idSmsApi;
    }

    public void setIdSmsApi(Integer idSmsApi) {
        this.idSmsApi = idSmsApi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
