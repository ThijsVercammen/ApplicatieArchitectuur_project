/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact.tracing.client;

import javax.ejb.EJB;
import SwingBeans.SwingBeanRemote;

/**
 *
 * @author arnog
 */
public class Main {
    @EJB private static SwingBeanRemote db;
    
    public static void main(String[] args)
    {
        if (db==null)
            System.out.println("Das hier gewoon al null seg.");
        Rapportering r = new Rapportering(db);
    }
}
