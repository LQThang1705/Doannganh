    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repository.impl;

import com.mycompany.pojos.Linhkien;
import com.mycompany.repository.LinkkienRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class LinhkienRepositoryImpl implements LinkkienRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
   public List<Linhkien> getlinhkiens(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder= session.getCriteriaBuilder();
        CriteriaQuery<Linhkien> query= builder.createQuery(Linhkien.class);
        Root root= query.from(Linhkien.class);       
        query= query.select(root);
        if(kw!=null){
            Predicate p = builder.like(root.get("tenLK").as(String.class), 
            String.format("%%%s%%",kw));
            query = query.where(p);
        }
        
        query = query.orderBy(builder.desc(root.get("maLK")));
        
        Query q= session.createQuery(query);
        
        int max=6;
        q.setMaxResults(max);
        q.setFirstResult((page -1)*max);
        
        return q.getResultList();
        
    }
    
    @Override
    public boolean addOrUpdate(Linhkien linhkien) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            session.save(linhkien);
            return true;
        }catch (Exception ex){
            System.err.println("== Add Linh kien =="+ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public long countLinhkien() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("Select Count(*) From Linhkien");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Linhkien getLinhkienByID(int linhkienId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Linhkien.class, linhkienId);
    }

    
    
}
