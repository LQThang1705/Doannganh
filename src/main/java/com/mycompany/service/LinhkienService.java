/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.service;

import com.mycompany.pojos.Linhkien;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface LinhkienService {
    List<Linhkien> getLinhkiens(String kw, int page);
    boolean addOrUpdate(Linhkien linhkien);
    long countLinhkien();
    Linhkien getLinhkienByID(int linhkienId);
    
}
