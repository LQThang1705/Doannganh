/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "loailk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loailk.findAll", query = "SELECT l FROM Loailk l"),
    @NamedQuery(name = "Loailk.findByMaLoaiLK", query = "SELECT l FROM Loailk l WHERE l.maLoaiLK = :maLoaiLK"),
    @NamedQuery(name = "Loailk.findByTenLoai", query = "SELECT l FROM Loailk l WHERE l.tenLoai = :tenLoai")})
public class Loailk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaLoaiLK")
    private Integer maLoaiLK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenLoai")
    private String tenLoai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maLoai", fetch = FetchType.EAGER)
    private Collection<Linhkien> linhkienCollection;

    public Loailk() {
    }

    public Loailk(Integer maLoaiLK) {
        this.maLoaiLK = maLoaiLK;
    }

    public Loailk(Integer maLoaiLK, String tenLoai) {
        this.maLoaiLK = maLoaiLK;
        this.tenLoai = tenLoai;
    }

    public Integer getMaLoaiLK() {
        return maLoaiLK;
    }

    public void setMaLoaiLK(Integer maLoaiLK) {
        this.maLoaiLK = maLoaiLK;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    @XmlTransient
    public Collection<Linhkien> getLinhkienCollection() {
        return linhkienCollection;
    }

    public void setLinhkienCollection(Collection<Linhkien> linhkienCollection) {
        this.linhkienCollection = linhkienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoaiLK != null ? maLoaiLK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loailk)) {
            return false;
        }
        Loailk other = (Loailk) object;
        if ((this.maLoaiLK == null && other.maLoaiLK != null) || (this.maLoaiLK != null && !this.maLoaiLK.equals(other.maLoaiLK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojos.Loailk[ maLoaiLK=" + maLoaiLK + " ]";
    }
    
}
