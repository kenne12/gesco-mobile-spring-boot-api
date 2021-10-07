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
@Table(name = "adresse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a"),
    @NamedQuery(name = "Adresse.findByIdadresse", query = "SELECT a FROM Adresse a WHERE a.idadresse = :idadresse"),
    @NamedQuery(name = "Adresse.findByIdville", query = "SELECT a FROM Adresse a WHERE a.idville = :idville"),
    @NamedQuery(name = "Adresse.findByTelephone", query = "SELECT a FROM Adresse a WHERE a.telephone = :telephone"),
    @NamedQuery(name = "Adresse.findByBp", query = "SELECT a FROM Adresse a WHERE a.bp = :bp"),
    @NamedQuery(name = "Adresse.findByEmail", query = "SELECT a FROM Adresse a WHERE a.email = :email"),
    @NamedQuery(name = "Adresse.findBySiteweb", query = "SELECT a FROM Adresse a WHERE a.siteweb = :siteweb"),
    @NamedQuery(name = "Adresse.findByCode", query = "SELECT a FROM Adresse a WHERE a.code = :code"),
    @NamedQuery(name = "Adresse.findByFax", query = "SELECT a FROM Adresse a WHERE a.fax = :fax")})
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idadresse")
    private Integer idadresse;
    @Column(name = "idville")
    private Integer idville;
    @Column(name = "telephone" , length = 254)
    private String telephone;
    @Column(name = "bp" , length = 254)
    private String bp;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Column(name = "email" , length = 254)
    private String email;
    @Column(name = "siteweb" , length = 254)
    private String siteweb;
    @Column(name = "code" , length = 254)
    private String code;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Column(name = "fax" , length = 254)
    private String fax;
    @OneToMany(mappedBy = "idadresse", fetch = FetchType.LAZY)
    private List<Eleve> eleveList;
    @OneToMany(mappedBy = "idadresse", fetch = FetchType.LAZY)
    private List<Institution> institutionList;
    @JoinColumn(name = "idquartier", referencedColumnName = "idquartier")
    @ManyToOne(fetch = FetchType.LAZY)
    private Quartier idquartier;
    @OneToMany(mappedBy = "idadresse", fetch = FetchType.LAZY)
    private List<Enseignant> enseignantList;

    public Adresse() {
    }

    public Adresse(Integer idadresse) {
        this.idadresse = idadresse;
    }

    public Integer getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Integer idadresse) {
        this.idadresse = idadresse;
    }

    public Integer getIdville() {
        return idville;
    }

    public void setIdville(Integer idville) {
        this.idville = idville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @XmlTransient
    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    @XmlTransient
    public List<Institution> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
    }

    public Quartier getIdquartier() {
        return idquartier;
    }

    public void setIdquartier(Quartier idquartier) {
        this.idquartier = idquartier;
    }

    @XmlTransient
    public List<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(List<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadresse != null ? idadresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.idadresse == null && other.idadresse != null) || (this.idadresse != null && !this.idadresse.equals(other.idadresse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Adresse[ idadresse=" + idadresse + " ]";
    }

}
