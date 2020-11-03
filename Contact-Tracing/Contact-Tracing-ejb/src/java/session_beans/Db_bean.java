/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Arts;
import model.Burger;

/**
 *
 * @author Thijs Vercammen
 */
@Stateless
public class Db_bean implements Db_beanLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Burger getBurger(String naam) {
        return (Burger) em.createNamedQuery("Burger.findByNaam").setParameter("naam", naam).getSingleResult();
    }

    @Override
    public boolean checkWachtwoord(Burger b, String p) {
        if(b.getWachtwoord().equals(p)) return true;
        else return false;
    }
    
    @Override
    public boolean checkWachtwoord(Arts a, String p) {
        if(a.getWachtwoord().equals(p)) return true;
        else return false;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Arts getArts(String naam) {
        return (Arts) em.createNamedQuery("Arts.findByNaam").setParameter("naam", naam).getSingleResult();
    }
}
