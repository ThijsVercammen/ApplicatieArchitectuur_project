/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactApp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import SwingBeans.SwingBeanRemote;

/**
 *
 * @author arnog
 */
public class ContactApp extends JFrame implements ActionListener{

    private Container pane;
    private JButton burgers, testen, contacten;
    
    private SwingBeanRemote boon;
    public ContactApp(SwingBeanRemote boon) {
        this.boon = boon;
        
        pane = this.getContentPane();
        pane.setLayout(new GridLayout(4,0));
        pane.setPreferredSize(new Dimension(500, 300));
        burgers = new JButton("Aantal burgers");
        testen = new JButton("Aantal testen");
        contacten = new JButton("Overzicht contacten");
        this.burgers.addActionListener(this);
        this.testen.addActionListener(this);
        this.contacten.addActionListener(this);
        pane.add(new JLabel("Maak uw keuze: "));
        pane.add(burgers);
        pane.add(testen);
        pane.add(contacten);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.burgers) {
            int aantb = boon.countBurger();
            JOptionPane.showMessageDialog(pane, "Aantal geregistreerde burgers: " + aantb, "Aantal burgers", 1);
        }else if (e.getSource() == this.testen) {
            int aantt = boon.countTest();
            JOptionPane.showMessageDialog(pane, "Aantal uitgevoerde testen: " + aantt, "Aantal testen", 1);
        }else if (e.getSource() == this.contacten) {
            int aantN = boon.countNauw();
            int aantG = boon.countGewoon();
            int aantV = boon.countVeilig();
            JOptionPane.showMessageDialog(pane, "Aantal nauwe contacten: " + aantN
                    + "\nAantal gewone contacten: " + aantG
                    + "\nAantal veilige contacten: " + aantV, "Overzicht contacten", 1);
        }
    }
    
}
