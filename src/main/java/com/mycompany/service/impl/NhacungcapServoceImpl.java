    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.mycompany.pojos.Nhacungcap;
import com.mycompany.repository.LoailkRepository;
import com.mycompany.repository.NhacungcapRepository;
import com.mycompany.service.NhacungcapService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class NhacungcapServoceImpl implements NhacungcapService{
    @Autowired
    private NhacungcapRepository nhacungcapRepository;
    @Override
    public List<Nhacungcap> getNhacungcap() {
       return this.nhacungcapRepository.getNhacungcap();
    }
    
}
