/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactclient;

import SwingBeans.SwingBeanRemote;
import contactApp.ContactApp;
import javax.ejb.EJB;

/**
 *
 * @author arnog
 */
public class Main {
    @EJB private static SwingBeanRemote boon;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContactApp c = new ContactApp(boon);
    }
    
}
