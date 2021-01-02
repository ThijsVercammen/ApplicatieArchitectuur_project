/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author arnog
 */
@Stateless
public class SwingBean implements SwingBeanRemote {

    @PersistenceContext
    private EntityManager em;
    
    public int countBurger() {
        int aant = 0;
       try{
           aant = (int) em.createNamedQuery("Burger.findAll").getResultList().size();
       } catch(Exception e){
           
       }
       return aant;
    }
}
