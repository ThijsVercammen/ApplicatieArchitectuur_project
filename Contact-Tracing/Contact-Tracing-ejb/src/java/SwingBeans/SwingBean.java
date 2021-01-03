/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingBeans;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author arnog
 */
@Stateless
@Remote(SwingBeanRemote.class)
public class SwingBean implements SwingBeanRemote {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public int countBurger() {
        int aant = 0;
       try{
           aant = (int) em.createNamedQuery("Burger.findAll").getResultList().size();
       } catch(Exception e){
           
       }
       return aant;
    }
    
    @Override
    public int countTest() {
        int aant = 0;
        try{
            aant = (int) em.createNamedQuery("Test.findAll").getResultList().size();
        } catch(Exception e) {
            
        }
        return aant;
    }
    
    @Override
    public int countNauw() {
        int aant = 0;
        try{
            aant = (int) em.createNamedQuery("Contacten.findBySoortContact").setParameter("soortContact", "Nauw contact").getResultList().size();
        } catch(Exception e) {
            
        }
        return aant;
    }
    
    @Override
    public int countGewoon() {
        int aant = 0;
        try{
            aant = (int) em.createNamedQuery("Contacten.findBySoortContact").setParameter("soortContact", "gewoon contact").getResultList().size();
        } catch(Exception e) {
            
        }
        return aant;
    }
    
    @Override
    public int countVeilig() {
        int aant = 0;
        try{
            aant = (int) em.createNamedQuery("Contacten.findBySoortContact").setParameter("soortContact", "veilig contact").getResultList().size();
        } catch(Exception e) {
            
        }
        return aant;
    }
}
