/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Angsuran;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author Fitriany Chairunnisa
 */
public class AngsuranDAO implements InterfaceDAO{
    
    public SessionFactory factory;
    private Session session;
    private Transaction transaction;
    public FunctionsDAO fdao;
    
    public AngsuranDAO() {
         this.fdao = new FunctionsDAO(HibernateUtil.getSessionFactory());
         this.factory=HibernateUtil.getSessionFactory();
    }
    
    @Override
    public boolean insert(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean update(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean delete(Object object) {
        return fdao.delete(Angsuran.class,object.toString());
    }

    @Override
    public List<Object> getAll() {
       return fdao.getAll("FROM Angsuran order by idAngsuran desc");
    }

    @Override
    public List<Object> search(String category, String search) {
     return fdao.getAll("FROM Angsuran WHERE " + category + " LIKE '%" + search + "%'");
    }

    @Override
    public Object getById(String id) {
          return fdao.getById("from Angsuran where id_angsuran='" + id + "'");
    }
    
           public String getAutoID() {
        return (String) fdao.getById("SELECT CONCAT('TR',LPAD((TO_NUMBER(SUBSTR(MAX(idAngsuran),3,3))+1),3,'0')) FROM Angsuran");
    }

    @Override
    public boolean save(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
    
