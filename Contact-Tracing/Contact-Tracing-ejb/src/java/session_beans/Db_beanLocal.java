/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_beans;

import javax.ejb.Local;
import model.Arts;
import model.Burger;

/**
 *
 * @author Thijs Vercammen
 */
@Local
public interface Db_beanLocal {
    
    public Burger getBurger(String naam);
    public Arts getArts(String naam);
    public boolean checkWachtwoord(Burger b, String p);
    public boolean checkWachtwoord(Arts a, String p);
    
}
