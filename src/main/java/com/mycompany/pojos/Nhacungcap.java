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
@Table(name = "nhacungcap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhacungcap.findAll", query = "SELECT n FROM Nhacungcap n"),
    @NamedQuery(name = "Nhacungcap.findByMaNCC", query = "SELECT n FROM Nhacungcap n WHERE n.maNCC = :maNCC"),
    @NamedQuery(name = "Nhacungcap.findByTenNCC", query = "SELECT n FROM Nhacungcap n WHERE n.tenNCC = :tenNCC"),
    @NamedQuery(name = "Nhacungcap.findByDiaChi", query = "SELECT n FROM Nhacungcap n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "Nhacungcap.findBySoDT", query = "SELECT n FROM Nhacungcap n WHERE n.soDT = :soDT")})
public class Nhacungcap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNCC")
    private Integer maNCC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenNCC")
    private String tenNCC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DiaChi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SoDT")
    private String soDT;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maNCC1")
    private Collection<Linhkien> linhkienCollection;

    public Nhacungcap() {
    }

    public Nhacungcap(Integer maNCC) {
        this.maNCC = maNCC;
    }

    public Nhacungcap(Integer maNCC, String tenNCC, String diaChi, String soDT) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public Integer getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(Integer maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
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
        hash += (maNCC != null ? maNCC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhacungcap)) {
            return false;
        }
        Nhacungcap other = (Nhacungcap) object;
        if ((this.maNCC == null && other.maNCC != null) || (this.maNCC != null && !this.maNCC.equals(other.maNCC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojos.Nhacungcap[ maNCC=" + maNCC + " ]";
    }
    
}
