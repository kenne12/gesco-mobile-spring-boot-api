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
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Arianne
 */
@Entity
@Table(name = "programmationcours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programmationcours.findAll", query = "SELECT p FROM Programmationcours p"),
    @NamedQuery(name = "Programmationcours.findByIdprogrammationcours", query = "SELECT p FROM Programmationcours p WHERE p.idprogrammationcours = :idprogrammationcours"),
    @NamedQuery(name = "Programmationcours.findByHeuremax", query = "SELECT p FROM Programmationcours p WHERE p.heuremax = :heuremax"),
    @NamedQuery(name = "Programmationcours.findByCumulheurerealisee", query = "SELECT p FROM Programmationcours p WHERE p.cumulheurerealisee = :cumulheurerealisee"),
    @NamedQuery(name = "Programmationcours.findByHeurerestante", query = "SELECT p FROM Programmationcours p WHERE p.heurerestante = :heurerestante")})
public class Programmationcours implements Serializable {
    @JoinColumn(name = "idclasse", referencedColumnName = "idclasse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Classe idclasse;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idprogrammationcours" , nullable = false)
    private Integer idprogrammationcours;
    @Column(name = "heuremax")
    private BigInteger heuremax;
    @Column(name = "cumulheurerealisee")
    private BigInteger cumulheurerealisee;
    @Column(name = "heurerestante")
    private BigInteger heurerestante;
    @JoinColumn(name = "idanneescolaire", referencedColumnName = "idanneescolaire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anneescolaire idanneescolaire;
    @JoinColumn(name = "idenseignant", referencedColumnName = "idenseignant")
    @ManyToOne(fetch = FetchType.LAZY)
    private Enseignant idenseignant;
    @JoinColumn(name = "idinstitution", referencedColumnName = "idinstitution")
    @ManyToOne(fetch = FetchType.LAZY)
    private Institution idinstitution;
    @JoinColumn(name = "idjour", referencedColumnName = "idjour")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jour idjour;
    @JoinColumn(name = "idmatiere", referencedColumnName = "idmatiere")
    @ManyToOne(fetch = FetchType.LAZY)
    private Matiere idmatiere;
    @JoinColumn(name = "idtranchehoraire", referencedColumnName = "idtranchehoraire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tranchehoraire idtranchehoraire;
    @OneToMany(mappedBy = "idprogrammationcours", fetch = FetchType.LAZY)
    private List<Cours> coursList;

    public Programmationcours() {
    }

    public Programmationcours(Integer idprogrammationcours) {
        this.idprogrammationcours = idprogrammationcours;
    }

    public Integer getIdprogrammationcours() {
        return idprogrammationcours;
    }

    public void setIdprogrammationcours(Integer idprogrammationcours) {
        this.idprogrammationcours = idprogrammationcours;
    }

    public BigInteger getHeuremax() {
        return heuremax;
    }

    public void setHeuremax(BigInteger heuremax) {
        this.heuremax = heuremax;
    }

    public BigInteger getCumulheurerealisee() {
        return cumulheurerealisee;
    }

    public void setCumulheurerealisee(BigInteger cumulheurerealisee) {
        this.cumulheurerealisee = cumulheurerealisee;
    }

    public BigInteger getHeurerestante() {
        return heurerestante;
    }

    public void setHeurerestante(BigInteger heurerestante) {
        this.heurerestante = heurerestante;
    }

    public Anneescolaire getIdanneescolaire() {
        return idanneescolaire;
    }

    public void setIdanneescolaire(Anneescolaire idanneescolaire) {
        this.idanneescolaire = idanneescolaire;
    }

    public Enseignant getIdenseignant() {
        return idenseignant;
    }

    public void setIdenseignant(Enseignant idenseignant) {
        this.idenseignant = idenseignant;
    }

    public Institution getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Institution idinstitution) {
        this.idinstitution = idinstitution;
    }

    public Jour getIdjour() {
        return idjour;
    }

    public void setIdjour(Jour idjour) {
        this.idjour = idjour;
    }

    public Matiere getIdmatiere() {
        return idmatiere;
    }

    public void setIdmatiere(Matiere idmatiere) {
        this.idmatiere = idmatiere;
    }

    public Tranchehoraire getIdtranchehoraire() {
        return idtranchehoraire;
    }

    public void setIdtranchehoraire(Tranchehoraire idtranchehoraire) {
        this.idtranchehoraire = idtranchehoraire;
    }

    @XmlTransient
    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprogrammationcours != null ? idprogrammationcours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programmationcours)) {
            return false;
        }
        Programmationcours other = (Programmationcours) object;
        if ((this.idprogrammationcours == null && other.idprogrammationcours != null) || (this.idprogrammationcours != null && !this.idprogrammationcours.equals(other.idprogrammationcours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Programmationcours[ idprogrammationcours=" + idprogrammationcours + " ]";
    }

    public Classe getIdclasse() {
        return idclasse;
    }

    public void setIdclasse(Classe idclasse) {
        this.idclasse = idclasse;
    }
    
}
