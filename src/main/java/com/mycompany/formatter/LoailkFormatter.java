/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.formatter;

import com.mycompany.pojos.Loailk;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;


/**
 *
 * @author Admin
 */
public class LoailkFormatter implements Formatter<Loailk>{

    @Override
    public String print(Loailk t, Locale locale) {
       return String.valueOf(t.getMaLoaiLK());
    }

    @Override
    public Loailk parse(String Maloai, Locale locale) throws ParseException {
        Loailk c= new Loailk();
        c.setMaLoaiLK(Integer.parseInt(Maloai));
        return c;
    }
    
}
