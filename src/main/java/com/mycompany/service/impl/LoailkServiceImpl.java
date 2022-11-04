/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojos.Loailk;
import com.mycompany.repository.LoailkRepository;
import com.mycompany.service.LoailkService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class LoailkServiceImpl implements LoailkService{
    @Autowired
    private LoailkRepository loailkRepository;
    
    @Override
    public List<Loailk> getLoailk() {
        return this.loailkRepository.getLoailk();
    }

    @Override
    public Loailk getLoaiLKById(int cateId) {
        return this.loailkRepository.getLoaiLKById(cateId);
    }
    
}
