/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formatter;

import com.mycompany.pojos.Loailk;
import com.mycompany.pojos.Nhacungcap;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Admin
 */
public class NhacungcapFormatter implements Formatter<Nhacungcap> {

    @Override
    public String print(Nhacungcap t, Locale locale) {
       return String.valueOf(t.getMaNCC());
    }

    @Override
    public Nhacungcap parse(String MaNCC, Locale locale) throws ParseException {
        Nhacungcap c= new Nhacungcap();
        c.setMaNCC(Integer.parseInt(MaNCC));
        return c;
    }
    
}
