/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "linhkien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linhkien.findAll", query = "SELECT l FROM Linhkien l"),
    @NamedQuery(name = "Linhkien.findByMaLK", query = "SELECT l FROM Linhkien l WHERE l.maLK = :maLK"),
    @NamedQuery(name = "Linhkien.findByTenLK", query = "SELECT l FROM Linhkien l WHERE l.tenLK = :tenLK"),
    @NamedQuery(name = "Linhkien.findByHangSX", query = "SELECT l FROM Linhkien l WHERE l.hangSX = :hangSX"),
    @NamedQuery(name = "Linhkien.findByMoTa", query = "SELECT l FROM Linhkien l WHERE l.moTa = :moTa"),
    @NamedQuery(name = "Linhkien.findByHinhanh", query = "SELECT l FROM Linhkien l WHERE l.hinhanh = :hinhanh"),
    @NamedQuery(name = "Linhkien.findByGia", query = "SELECT l FROM Linhkien l WHERE l.gia = :gia"),
    @NamedQuery(name = "Linhkien.findByActive", query = "SELECT l FROM Linhkien l WHERE l.active = :active")})
public class Linhkien implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maLK10")
    private Collection<Hoadon> hoadonCollection;

    @Basic(optional = false)
    @NotNull
    @Column(name = "Gia")
    private long gia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lKid", fetch = FetchType.EAGER)
    private Collection<Comment> commentCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaLK")
    private Integer maLK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TenLK")
    private String tenLK;
    @Size(max = 45)
    @Column(name = "HangSX")
    private String hangSX;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MoTa")
    private String moTa;
    @Size(max = 255)
    @Column(name = "Hinhanh")
    private String hinhanh;
    @Size(max = 45)
    @Column(name = "active")
    @JsonIgnore
    private String active;
    @JoinColumn(name = "MaLoai", referencedColumnName = "MaLoaiLK")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Loailk maLoai;
    @JoinColumn(name = "MaNCC1", referencedColumnName = "MaNCC")
    @ManyToOne(optional = false)
    @JsonIgnore
    private Nhacungcap maNCC1;
    @Transient
    private MultipartFile file;
    public Linhkien() {
    }

    public Linhkien(Integer maLK) {
        this.maLK = maLK;
    }

    public Linhkien(Integer maLK, String tenLK, String moTa, long gia) {
        this.maLK = maLK;
        this.tenLK = tenLK;
        this.moTa = moTa;
        this.gia = gia;
    }

    public Integer getMaLK() {
        return maLK;
    }

    public void setMaLK(Integer maLK) {
        this.maLK = maLK;
    }

    public String getTenLK() {
        return tenLK;
    }

    public void setTenLK(String tenLK) {
        this.tenLK = tenLK;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }


    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

 

 

   

    public Loailk getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Loailk maLoai) {
        this.maLoai = maLoai;
    }

    public Nhacungcap getMaNCC1() {
        return maNCC1;
    }

    public void setMaNCC1(Nhacungcap maNCC1) {
        this.maNCC1 = maNCC1;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLK != null ? maLK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linhkien)) {
            return false;
        }
        Linhkien other = (Linhkien) object;
        if ((this.maLK == null && other.maLK != null) || (this.maLK != null && !this.maLK.equals(other.maLK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.pojos.Linhkien[ maLK=" + maLK + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Hoadon> getHoadonCollection() {
        return hoadonCollection;
    }

    public void setHoadonCollection(Collection<Hoadon> hoadonCollection) {
        this.hoadonCollection = hoadonCollection;
    }
    
}
