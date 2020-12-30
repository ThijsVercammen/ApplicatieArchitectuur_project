/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_beans;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import model.Arts;
import model.Burger;
import model.Contacten;
import model.Status;
import model.Test;

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
    public Arts getArts(String naam) {
        return (Arts) em.createNamedQuery("Arts.findByNaam").setParameter("naam", naam).getSingleResult();
    }

    @Override
    public List<Burger> getAllBurgers(String naam) {
        return em.createQuery("SELECT b FROM Burger b WHERE b.naam <> ?1").setParameter(1, naam).getResultList();
    }

    @Override
    public void addContact(String burger, String contact, String type) {
        Contacten c = new Contacten();
        Contacten c2 = new Contacten();
        c.setBurgernr(getBurger(burger));
        c.setContact(getBurger(contact));
        int contactnr = 1;
        if(getMaxContactNummer() != null) {
            contactnr = getMaxContactNummer().intValue();
            contactnr++;
        }
        c.setContactnr(new BigDecimal(contactnr));
        c.setSoortContact(type);
        contactnr++;
        c2.setBurgernr(getBurger(contact));
        c2.setContact(getBurger(burger));
        c2.setContactnr(new BigDecimal(contactnr));
        c2.setSoortContact(type);
        em.persist(c);
        em.persist(c2);
        //contactnr++;
    }

    @Override
    public List<Contacten> getContacten(String burger) {
        return em.createQuery("SELECT c FROM Contacten c WHERE c.burgernr = ?1").setParameter(1, getBurger(burger)).getResultList();
    }

    @Override
    public String getRisicoStatus(String burger) {
        if(getBurger(burger).getRisicostatus().getNaam().equals("Positief")){
                return "ROOD";
        }
        return "GROEN";
    }

    @Override
    public Status getStatus(String status) {
        return (Status) em.createNamedQuery("Status.findByNaam").setParameter("naam", status).getSingleResult();
    }

    @Override
    public Test getTest(String burger) {
        BigDecimal testnum = (BigDecimal) em.createQuery("SELECT max(t.testnr) FROM Test t WHERE t.gebruiker = ?1").setParameter(1, getBurger(burger)).getSingleResult();
        if((em.createQuery("SELECT t FROM Test t WHERE t.gebruiker = ?1 and t.testnr = ?2").setParameter(1, getBurger(burger)).setParameter(2, testnum).getResultList()).size() > 0){
            return (Test) em.createQuery("SELECT t FROM Test t WHERE t.gebruiker = ?1 and t.testnr = ?2").setParameter(1, getBurger(burger)).setParameter(2, testnum).getSingleResult();
        }
        return null;
    }

    @Override
    public void updateTest(Test t, String burger) {
        if(t.getGebruiker() == null){
            t.setGebruiker(getBurger(burger));
            int testnr = 1;
            if(getMaxTestNummer() != null) {
                testnr = getMaxTestNummer().intValue();
                testnr++;
            }
            t.setTestnr(new BigDecimal(testnr));
        } else {
            List<Contacten> l = getNauweContacten(burger);
            for(int i = 0; i< l.size(); i++){
                l.get(i).getContact().setRisicostatus(getStatus("Positief"));
            }
            em.remove(getTestByID(t.getTestnr().toPlainString()));
            em.flush();
        }
        em.persist(t);
    }

    @Override
    public BigDecimal getMaxContactNummer() {
       return (BigDecimal) em.createQuery("SELECT max(c.contactnr) FROM Contacten c").getSingleResult();
    }

    @Override
    public BigDecimal getMaxTestNummer() {
        return (BigDecimal) em.createQuery("SELECT max(t.testnr) FROM Test t").getSingleResult();
    }

    @Override
    public List<Contacten> getNauweContacten(String burger) {
        return em.createQuery("SELECT c FROM Contacten c WHERE c.burgernr = ?1 and c.soortContact = ?2")
                .setParameter(1, getBurger(burger))
                .setParameter(2, "Nauw contact")
                .getResultList();
    }

    @Override
    public List<Contacten> getGewoneContacten(String burger) {
                return em.createQuery("SELECT c FROM Contacten c WHERE c.burgernr = ?1 and c.soortContact = ?2")
                .setParameter(1, getBurger(burger))
                .setParameter(2, "Gewoon contact")
                .getResultList();
    }

    @Override
    public List<Contacten> getVeiligeContacten(String burger) {
                return em.createQuery("SELECT c FROM Contacten c WHERE c.burgernr = ?1 and c.soortContact = ?2")
                .setParameter(1, getBurger(burger))
                .setParameter(2, "Veilig contact")
                .getResultList();
    }

    @Override
    public Test getTestByID(String id) {
        try
        {
            return (Test) em.createNamedQuery("Test.findByTestnr").setParameter("testnr", new BigDecimal(id)).getSingleResult();
        }catch (NoResultException e)
                {
                    return null;
                }
         
    }
}
