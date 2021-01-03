/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingBeans;

import javax.ejb.Remote;

/**
 *
 * @author arnog
 */
@Remote
public interface SwingBeanRemote{
    public int countBurger();
    public int countTest();
    public int countNauw();
    public int countGewoon();
    public int countVeilig();
}
