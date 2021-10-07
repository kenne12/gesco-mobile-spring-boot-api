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
@Table(name = "matiere")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m"),
    @NamedQuery(name = "Matiere.findByIdmatiere", query = "SELECT m FROM Matiere m WHERE m.idmatiere = :idmatiere"),
    @NamedQuery(name = "Matiere.findByCode", query = "SELECT m FROM Matiere m WHERE m.code = :code"),
    @NamedQuery(name = "Matiere.findByNom", query = "SELECT m FROM Matiere m WHERE m.nom = :nom")})
public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idmatiere")
    private Integer idmatiere;

    @Column(name = "code" , length = 15)
    private String code;
    @Column(name = "nom" , length = 254)
    private String nom;


    @Column(name = "nom_anglais" , length = 254)
    private String nomAnglais;

    @OneToMany(mappedBy = "idmatiere", fetch = FetchType.LAZY)
    private List<Lecon> leconList;
    @JoinColumn(name = "idgroupematiere", referencedColumnName = "idgroupematiere")
    @ManyToOne(fetch = FetchType.LAZY)
    private Groupematiere idgroupematiere;
    @OneToMany(mappedBy = "idmatiere", fetch = FetchType.LAZY)
    private List<Programmationcours> programmationcoursList;
    @OneToMany(mappedBy = "idmatiere", fetch = FetchType.LAZY)
    private List<MatiereNiveau> matiereNiveauList;
    @OneToMany(mappedBy = "idmatiere", fetch = FetchType.LAZY)
    private List<Tarifhoraire> tarifhoraireList;

    public Matiere() {
    }

    public Matiere(Integer idmatiere) {
        this.idmatiere = idmatiere;
    }

    public Integer getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(Integer idmatiere) {
        this.idmatiere = idmatiere;
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

    public String getNomAnglais() {
        return nomAnglais;
    }

    public void setNomAnglais(String nomAnglais) {
        this.nomAnglais = nomAnglais;
    }

    @XmlTransient
    public List<Lecon> getLeconList() {
        return leconList;
    }

    public void setLeconList(List<Lecon> leconList) {
        this.leconList = leconList;
    }

    public Groupematiere getIdgroupematiere() {
        return idgroupematiere;
    }

    public void setIdgroupematiere(Groupematiere idgroupematiere) {
        this.idgroupematiere = idgroupematiere;
    }

    @XmlTransient
    public List<Programmationcours> getProgrammationcoursList() {
        return programmationcoursList;
    }

    public void setProgrammationcoursList(List<Programmationcours> programmationcoursList) {
        this.programmationcoursList = programmationcoursList;
    }

    @XmlTransient
    public List<MatiereNiveau> getMatiereNiveauList() {
        return matiereNiveauList;
    }

    public void setMatiereNiveauList(List<MatiereNiveau> matiereNiveauList) {
        this.matiereNiveauList = matiereNiveauList;
    }

    @XmlTransient
    public List<Tarifhoraire> getTarifhoraireList() {
        return tarifhoraireList;
    }

    public void setTarifhoraireList(List<Tarifhoraire> tarifhoraireList) {
        this.tarifhoraireList = tarifhoraireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatiere != null ? idmatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.idmatiere == null && other.idmatiere != null) || (this.idmatiere != null && !this.idmatiere.equals(other.idmatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Matiere[ idmatiere=" + idmatiere + " ]";
    }

}
