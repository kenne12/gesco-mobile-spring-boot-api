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
@Table(name = "bulletin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bulletin.findAll", query = "SELECT b FROM Bulletin b"),
    @NamedQuery(name = "Bulletin.findByIdBull", query = "SELECT b FROM Bulletin b WHERE b.idBull = :idBull"),
    @NamedQuery(name = "Bulletin.findByIntitulleBull", query = "SELECT b FROM Bulletin b WHERE b.intitulleBull = :intitulleBull"),
    @NamedQuery(name = "Bulletin.findByMoyenne", query = "SELECT b FROM Bulletin b WHERE b.moyenne = :moyenne"),
    @NamedQuery(name = "Bulletin.findByRang", query = "SELECT b FROM Bulletin b WHERE b.rang = :rang"),
    @NamedQuery(name = "Bulletin.findByTableauDhonneur", query = "SELECT b FROM Bulletin b WHERE b.tableauDhonneur = :tableauDhonneur"),
    @NamedQuery(name = "Bulletin.findByMoyMin", query = "SELECT b FROM Bulletin b WHERE b.moyMin = :moyMin"),
    @NamedQuery(name = "Bulletin.findByMoyMax", query = "SELECT b FROM Bulletin b WHERE b.moyMax = :moyMax"),
    @NamedQuery(name = "Bulletin.findByMoyGen", query = "SELECT b FROM Bulletin b WHERE b.moyGen = :moyGen"),
    @NamedQuery(name = "Bulletin.findByApreciation", query = "SELECT b FROM Bulletin b WHERE b.apreciation = :apreciation")})
public class Bulletin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_bull")
    private Integer idBull;
    @Column(name = "intitulle_bull" , length = 254)
    private String intitulleBull;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "moyenne")
    private Double moyenne;
    @Column(name = "rang")
    private Integer rang;
    @Column(name = "tableau_dhonneur")
    private Boolean tableauDhonneur;
    @Column(name = "moy_min")
    private Double moyMin;
    @Column(name = "moy_max")
    private Double moyMax;
    @Column(name = "moy_gen")
    private Double moyGen;

    @Column(name = "mark_notif")
    private boolean markNotif;

    @Column(name = "notifie")
    private boolean notifie;

    @Column(name = "apreciation" , length = 254)
    private String apreciation;
    @JoinColumn(name = "id_disc", referencedColumnName = "id_disc")
    @ManyToOne(fetch = FetchType.LAZY)
    private DossierDiscipline idDisc;
    @JoinColumn(name = "idinscription", referencedColumnName = "idinscription")
    @ManyToOne(fetch = FetchType.LAZY)
    private Inscription idinscription;
    @JoinColumn(name = "id_periode", referencedColumnName = "id_periode")
    @ManyToOne(fetch = FetchType.LAZY)
    private Periode idPeriode;

    @Column(name = "moyenne_t1")
    private double moyenneT1;
    @Column(name = "moyenne_t2")
    private double moyenneT2;

    @Column(name = "synthese_moyenne", length = 60)
    private String syntheseMoyenne;

    @JoinColumn(name = "idanneescolaire", referencedColumnName = "idanneescolaire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Anneescolaire anneescolaire;

    private boolean annuel;

    public boolean isMarkNotif() {
        return markNotif;
    }

    public void setMarkNotif(boolean markNotif) {
        this.markNotif = markNotif;
    }

    public boolean isNotifie() {
        return notifie;
    }

    public void setNotifie(boolean notifie) {
        this.notifie = notifie;
    }

    public Bulletin() {
    }

    public Bulletin(Integer idBull) {
        this.idBull = idBull;
    }

    public Integer getIdBull() {
        return idBull;
    }

    public void setIdBull(Integer idBull) {
        this.idBull = idBull;
    }

    public String getIntitulleBull() {
        return intitulleBull;
    }

    public void setIntitulleBull(String intitulleBull) {
        this.intitulleBull = intitulleBull;
    }

    public Double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Double moyenne) {
        this.moyenne = moyenne;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public Boolean getTableauDhonneur() {
        return tableauDhonneur;
    }

    public void setTableauDhonneur(Boolean tableauDhonneur) {
        this.tableauDhonneur = tableauDhonneur;
    }

    public Double getMoyMin() {
        return moyMin;
    }

    public void setMoyMin(Double moyMin) {
        this.moyMin = moyMin;
    }

    public Double getMoyMax() {
        return moyMax;
    }

    public void setMoyMax(Double moyMax) {
        this.moyMax = moyMax;
    }

    public Double getMoyGen() {
        return moyGen;
    }

    public void setMoyGen(Double moyGen) {
        this.moyGen = moyGen;
    }

    public String getApreciation() {
        return apreciation;
    }

    public void setApreciation(String apreciation) {
        this.apreciation = apreciation;
    }

    public DossierDiscipline getIdDisc() {
        return idDisc;
    }

    public void setIdDisc(DossierDiscipline idDisc) {
        this.idDisc = idDisc;
    }

    public Inscription getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(Inscription idinscription) {
        this.idinscription = idinscription;
    }

    public Periode getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(Periode idPeriode) {
        this.idPeriode = idPeriode;
    }

    public double getMoyenneT1() {
        return moyenneT1;
    }

    public void setMoyenneT1(double moyenneT1) {
        this.moyenneT1 = moyenneT1;
    }

    public double getMoyenneT2() {
        return moyenneT2;
    }

    public void setMoyenneT2(double moyenneT2) {
        this.moyenneT2 = moyenneT2;
    }

    public String getSyntheseMoyenne() {
        return syntheseMoyenne;
    }

    public void setSyntheseMoyenne(String syntheseMoyenne) {
        this.syntheseMoyenne = syntheseMoyenne;
    }

    public Anneescolaire getAnneescolaire() {
        return anneescolaire;
    }

    public void setAnneescolaire(Anneescolaire anneescolaire) {
        this.anneescolaire = anneescolaire;
    }

    public boolean isAnnuel() {
        return annuel;
    }

    public void setAnnuel(boolean annuel) {
        this.annuel = annuel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBull != null ? idBull.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bulletin)) {
            return false;
        }
        Bulletin other = (Bulletin) object;
        if ((this.idBull == null && other.idBull != null) || (this.idBull != null && !this.idBull.equals(other.idBull))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bulletin[ idBull=" + idBull + " ]";
    }

}
