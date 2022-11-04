/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository;

import com.mycompany.pojos.Linhkien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface LinkkienRepository {
    List<Linhkien> getlinhkiens(String kw, int page);
    Linhkien getLinhkienByID(int linhkienId);
    boolean addOrUpdate(Linhkien linhkien);
    long countLinhkien();
    
}
