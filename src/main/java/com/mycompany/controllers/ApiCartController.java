/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllers;

import com.mycompany.utills.Utils;
import com.mycompany.pojos.Cart;
import com.mycompany.pojos.Linhkien;
import com.mycompany.pojos.User;
import com.mycompany.service.LinhkienService;
import com.mycompany.service.OrderService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@RestController
public class ApiCartController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private LinhkienService linhkienService;
    
    @GetMapping("/api/linhkiens")
    public ResponseEntity<List<Linhkien>> listLinhkiens(){
        List<Linhkien> linhkiens = this.linhkienService.getLinhkiens("", 1);
        return new ResponseEntity<>(linhkiens,HttpStatus.OK);
    }
    
    @GetMapping("/api/cart/{maLK}")
    public ResponseEntity<Integer> cart(@PathVariable(value = "maLK") Integer maLK,
            HttpSession session){
        Map<Integer, Cart> cart= (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart == null)
            cart= new HashMap<>();
        
        
        if(cart.containsKey(maLK) == true){
            //san pham da co trong gio
            Cart c = cart.get(maLK);
            c.setCount(c.getCount()+1);
        }else{
            //san pham chua co trong gio
            Linhkien lk= this.linhkienService.getLinhkienByID(maLK);
            Cart c= new Cart();
            c.setMaLK(lk.getMaLK());
            c.setName(lk.getTenLK());
            c.setPrice(lk.getGia());
            c.setCount(1);
            
            cart.put(maLK, c);
        }
        
        session.setAttribute("cart", cart);
        
        return new ResponseEntity<>(Utils.countCart(cart),HttpStatus.OK);
//        System.out.println("=== CART =" + Utils.countCart(cart));
    }
    
    @DeleteMapping("/api/cart/{maLK}")
    public int deleteCartItem(@PathVariable(value = "maLK") Integer maLK,HttpSession session){
        Map<Integer, Cart> cart= (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart != null && cart.containsKey(maLK)){
            cart.remove(maLK);
            session.setAttribute("cart", cart);
        }
        return Utils.countCart(cart);
    }
    
    @PostMapping("/api/pay")
    public HttpStatus pay(HttpSession session){
        User u = (User) session.getAttribute("currentUser");
        if(this.orderService.addReceipt((Map<Integer, Cart>) session.getAttribute("cart"), u)==true){
            session.removeAttribute("cart");
            return HttpStatus.OK;
        }
            
        return HttpStatus.BAD_REQUEST;
    }
}
    
