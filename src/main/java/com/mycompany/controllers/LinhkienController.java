/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.mycompany.pojos.Linhkien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.mycompany.pojos.Linhkien;
import com.mycompany.service.LinhkienService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class LinhkienController {
    @Autowired
    private LinhkienService linhkienService;
    
    @GetMapping("/admin/Linhkien")
    public String list(Model model){
        model.addAttribute("Linhkien", new Linhkien());
        return "Linhkien";
    }
    @GetMapping("/Linhkien/{maLK}")
    public String detail(Model model,@PathVariable(value = "maLK")int maLK) {
        model.addAttribute("Linhkien", this.linhkienService.getLinhkienByID(maLK));
        return "Linhkien-detail";
    }
    
    @PostMapping("/admin/Linhkien")
    public String add(Model model ,@ModelAttribute(value="Linhkien")@Valid Linhkien linhkien,BindingResult result){
        if(!result.hasErrors()){
            if(this.linhkienService.addOrUpdate(linhkien)==true)
                return "redirect:/";
            else
                model.addAttribute("errMgs", "Something wrong!!!");
        }
        return "Linhkien";
        
}

}
