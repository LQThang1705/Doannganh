     /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojos.Linhkien;
import com.mycompany.repository.LinkkienRepository;
import com.mycompany.service.LinhkienService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class LinhkienServiceImpl implements LinhkienService{
    @Autowired
    private LinkkienRepository linkkienRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Override
    public List<Linhkien> getLinhkiens(String kw, int page) {
        return this.linkkienRepository.getlinhkiens(kw, page);
    }

    @Override
    public boolean addOrUpdate(Linhkien linhkien) {
            try {
                Map r = this.cloudinary.uploader().upload(linhkien.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type","auto"));
                linhkien.setHinhanh((String) r.get("secure_url"));
                linhkien.setMaLK(Integer.SIZE);
                return this.linkkienRepository.addOrUpdate(linhkien);
            } catch (IOException ex) { 
                System.err.println(ex.getMessage() + "==ADD Linh kien ==");
            }
            
            return false;
    }

    @Override
    public long countLinhkien() {
        return this.linkkienRepository.countLinhkien();
    }

    @Override
    public Linhkien getLinhkienByID(int i) {
       return this.linkkienRepository.getLinhkienByID(i);
    }

    
    
}
