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
 * @author Louis Stark
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i"),
    @NamedQuery(name = "Institution.findByIdinstitution", query = "SELECT i FROM Institution i WHERE i.idinstitution = :idinstitution"),
    @NamedQuery(name = "Institution.findBySigle", query = "SELECT i FROM Institution i WHERE i.sigle = :sigle"),
    @NamedQuery(name = "Institution.findByCode", query = "SELECT i FROM Institution i WHERE i.code = :code"),
    @NamedQuery(name = "Institution.findByNom", query = "SELECT i FROM Institution i WHERE i.nom = :nom"),
    @NamedQuery(name = "Institution.findByNumcompte", query = "SELECT i FROM Institution i WHERE i.numcompte = :numcompte"),
    @NamedQuery(name = "Institution.findByDevise", query = "SELECT i FROM Institution i WHERE i.devise = :devise"),
    @NamedQuery(name = "Institution.findByLogo", query = "SELECT i FROM Institution i WHERE i.logo = :logo"),
    @NamedQuery(name = "Institution.findByBanque", query = "SELECT i FROM Institution i WHERE i.banque = :banque"),
    @NamedQuery(name = "Institution.findByNb", query = "SELECT i FROM Institution i WHERE i.nb = :nb"),
    @NamedQuery(name = "Institution.findByCodeobc", query = "SELECT i FROM Institution i WHERE i.codeobc = :codeobc"),
    @NamedQuery(name = "Institution.findByDateCreation", query = "SELECT i FROM Institution i WHERE i.dateCreation = :dateCreation"),
    @NamedQuery(name = "Institution.findByCti", query = "SELECT i FROM Institution i WHERE i.cti = :cti"),
    @NamedQuery(name = "Institution.findByNbrecaractcontact", query = "SELECT i FROM Institution i WHERE i.nbrecaractcontact = :nbrecaractcontact"),
    @NamedQuery(name = "Institution.findByApiuser", query = "SELECT i FROM Institution i WHERE i.apiuser = :apiuser"),
    @NamedQuery(name = "Institution.findByApikey", query = "SELECT i FROM Institution i WHERE i.apikey = :apikey"),
    @NamedQuery(name = "Institution.findByApiauthkey", query = "SELECT i FROM Institution i WHERE i.apiauthkey = :apiauthkey")})
public class Institution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idinstitution")
    private Integer idinstitution;
    @Column(name = "sigle" , length = 254)
    private String sigle;
    @Column(name = "code" , length = 254)
    private String code;
    @Column(name = "nom" , length = 254)
    private String nom;
    @Column(name = "numcompte" , length = 254)
    private String numcompte;
    @Column(name = "devise" , length = 100)
    private String devise;

    @Column(name = "logo" , length = 254)
    private String logo;

    @Column(name = "banque" , length = 254)
    private String banque;

    @Column(name = "nb" , length = 300)
    private String nb;

    @Column(name = "codeobc" , length = 10)
    private String codeobc;
    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "notif_group")
    private boolean notifGroup;
    @Column(name = "notif_indiv")
    private boolean notifIndiv;

    @Column(name = "notif_bulletin_etablissement")
    private boolean notifBulletinEtablissement;

    @Column(name = "notif_bulletin_indiv")
    private boolean notifBulletinIndiv;

    @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
    private List<Eleve> eleveList;
    @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "idadresse", referencedColumnName = "idadresse")
    @ManyToOne(fetch = FetchType.LAZY)
    private Adresse idadresse;
    @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
    private List<Fraisscolarite> fraisscolariteList;
    @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
    private List<Programmationcours> programmationcoursList;
    @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
    private List<Utilisateur> utilisateurList;
    @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
    private List<Inscription> inscriptionList;
    @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
    private List<Enseignant> enseignantList;
    @OneToMany(mappedBy = "idinstitution", fetch = FetchType.LAZY)
    private List<Programmationscolarite> programmationscolariteList;
    @JoinColumn(name = "idmodecalcul", referencedColumnName = "idmodecalcul")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modecalculmoyenne idmodecalcul;

    @JoinColumn(name = "idmodelebulletin", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Modelebulletin modelebulletin;

    @Column(length = 6)
    private String cti;
    private int nbrecaractcontact;

    @Column(length = 50)
    private String apiuser;

    @Column(length = 50)
    private String apikey;

    @Column(length = 60)
    private String apiauthkey;

    @Column(name = "devise_anglais", length = 100)
    private String deviseAnglais;

    @JoinColumn(name = "id_mode_app", referencedColumnName = "id_mode")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModeAppreciation modeAppreciation;

    @Column(name = "orange_auth_header", length = 150)
    private String orangeAuthHeader;

    @JoinColumn(name = "idsms_api", referencedColumnName = "idsms_api")
    @ManyToOne(fetch = FetchType.LAZY)
    private SmsApi smsApi;

    @Column(name = "niveau_priorite", length = 2)
    private String niveauPriorite;

    public Institution() {
        nbrecaractcontact = 9;
        cti = "+237";
    }

    public Institution(Integer idinstitution) {
        this.idinstitution = idinstitution;
        nbrecaractcontact = 9;
        cti = "+237";
    }

    public boolean isNotifGroup() {
        return notifGroup;
    }

    public void setNotifGroup(boolean notifGroup) {
        this.notifGroup = notifGroup;
    }

    public boolean isNotifIndiv() {
        return notifIndiv;
    }

    public void setNotifIndiv(boolean notifIndiv) {
        this.notifIndiv = notifIndiv;
    }

    public Integer getIdinstitution() {
        return idinstitution;
    }

    public void setIdinstitution(Integer idinstitution) {
        this.idinstitution = idinstitution;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
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

    public String getNumcompte() {
        return numcompte;
    }

    public void setNumcompte(String numcompte) {
        this.numcompte = numcompte;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getNb() {
        return nb;
    }

    public void setNb(String nb) {
        this.nb = nb;
    }

    public String getCodeobc() {
        return codeobc;
    }

    public void setCodeobc(String codeobc) {
        this.codeobc = codeobc;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getCti() {
        return cti;
    }

    public void setCti(String cti) {
        this.cti = cti;
    }

    public Integer getNbrecaractcontact() {
        return nbrecaractcontact;
    }

    public void setNbrecaractcontact(Integer nbrecaractcontact) {
        this.nbrecaractcontact = nbrecaractcontact;
    }

    public String getApiuser() {
        return apiuser;
    }

    public void setApiuser(String apiuser) {
        this.apiuser = apiuser;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getApiauthkey() {
        return apiauthkey;
    }

    public void setApiauthkey(String apiauthkey) {
        this.apiauthkey = apiauthkey;
    }

    public Modecalculmoyenne getIdmodecalcul() {
        return idmodecalcul;
    }

    public void setIdmodecalcul(Modecalculmoyenne idmodecalcul) {
        this.idmodecalcul = idmodecalcul;
    }

    public void setNbrecaractcontact(int nbrecaractcontact) {
        this.nbrecaractcontact = nbrecaractcontact;
    }

    public String getDeviseAnglais() {
        return deviseAnglais;
    }

    public void setDeviseAnglais(String deviseAnglais) {
        this.deviseAnglais = deviseAnglais;
    }

    public boolean isNotifBulletinEtablissement() {
        return notifBulletinEtablissement;
    }

    public void setNotifBulletinEtablissement(boolean notifBulletinEtablissement) {
        this.notifBulletinEtablissement = notifBulletinEtablissement;
    }

    public boolean isNotifBulletinIndiv() {
        return notifBulletinIndiv;
    }

    public void setNotifBulletinIndiv(boolean notifBulletinIndiv) {
        this.notifBulletinIndiv = notifBulletinIndiv;
    }

    public ModeAppreciation getModeAppreciation() {
        return modeAppreciation;
    }

    public void setModeAppreciation(ModeAppreciation modeAppreciation) {
        this.modeAppreciation = modeAppreciation;
    }

    @XmlTransient
    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public Adresse getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Adresse idadresse) {
        this.idadresse = idadresse;
    }

    public String getOrangeAuthHeader() {
        return orangeAuthHeader;
    }

    public void setOrangeAuthHeader(String orangeAuthHeader) {
        this.orangeAuthHeader = orangeAuthHeader;
    }

    @XmlTransient
    public List<Fraisscolarite> getFraisscolariteList() {
        return fraisscolariteList;
    }

    public void setFraisscolariteList(List<Fraisscolarite> fraisscolariteList) {
        this.fraisscolariteList = fraisscolariteList;
    }

    @XmlTransient
    public List<Programmationcours> getProgrammationcoursList() {
        return programmationcoursList;
    }

    public void setProgrammationcoursList(List<Programmationcours> programmationcoursList) {
        this.programmationcoursList = programmationcoursList;
    }

    @XmlTransient
    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    @XmlTransient
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @XmlTransient
    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    @XmlTransient
    public List<Programmationscolarite> getProgrammationscolariteList() {
        return programmationscolariteList;
    }

    public void setProgrammationscolariteList(List<Programmationscolarite> programmationscolariteList) {
        this.programmationscolariteList = programmationscolariteList;
    }

    public Modelebulletin getModelebulletin() {
        return modelebulletin;
    }

    public void setModelebulletin(Modelebulletin modelebulletin) {
        this.modelebulletin = modelebulletin;
    }

    public SmsApi getSmsApi() {
        return smsApi;
    }

    public void setSmsApi(SmsApi smsApi) {
        this.smsApi = smsApi;
    }

    public String getNiveauPriorite() {
        return niveauPriorite;
    }

    public void setNiveauPriorite(String niveauPriorite) {
        this.niveauPriorite = niveauPriorite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinstitution != null ? idinstitution.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institution)) {
            return false;
        }
        Institution other = (Institution) object;
        return !((this.idinstitution == null && other.idinstitution != null) || (this.idinstitution != null && !this.idinstitution.equals(other.idinstitution)));
    }

    @Override
    public String toString() {
        return "entities.Institution[ idinstitution=" + idinstitution + " ]";
    }

}
