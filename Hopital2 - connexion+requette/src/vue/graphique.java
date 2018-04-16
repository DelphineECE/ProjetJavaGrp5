/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import java.awt.*;
import javax.swing.*;


/**
 *
 * @author delphine
 */
public class graphique extends JFrame {
    
    JPanel pan = new JPanel() ;
    JPanel pan2 = new JPanel() ;
    JPanel pan3 = new JPanel() ;
    
    private JButton imag = new JButton("h");
    //private int monchoix=0;
    
    
    // contructeur
    public graphique () {
        
        setTitle("Gestion d'un hopital");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pan = new JPanel();     // instancier le panneau
        getContentPane().add(pan, BorderLayout.NORTH);
        pan2 = new JPanel();     // instancier le panneau
        getContentPane().add(pan2, BorderLayout.CENTER);
        imag = new JButton("");
        
        pan3 = new JPanel();     // instancier le panneau
        getContentPane().add(pan3, BorderLayout.SOUTH);
        
        /*JPanel connexion = new JPanel();
        connexion.setBackground(Color.red);
        
        JPanel maj = new JPanel();
        maj.setBackground(Color.blue);
        
        JPanel reporting = new JPanel();
        reporting.setBackground(Color.green);
        */
        
        JButton boutonco = new JButton("Connexion");
        boutonco.setPreferredSize(new Dimension(200,80));
        pan.add(boutonco);
        
        JButton boutonrech = new JButton("Recherche");
        boutonrech.setPreferredSize(new Dimension(200,80));
        pan.add(boutonrech);
        
        JButton boutonmaj = new JButton("Mise à jour");
        boutonmaj.setPreferredSize(new Dimension(200,80));
        pan.add(boutonmaj);
        
        JButton boutonrepor = new JButton("Reporting");
        boutonrepor.setPreferredSize(new Dimension(200,80));
        pan.add(boutonrepor);
        
        ImageIcon imghopital = new ImageIcon("/Users/delphine/NetBeansProjects/Hopital/Hopital2 - connexion+requette/hopital.jpg");
        imag.setIcon( imghopital);
        pan2.add(imag);
        
        JButton boutonequipe = new JButton("Gestion d'un centre hospitalier par Vincent B, Tom B et Delphine H");
        boutonequipe.setPreferredSize(new Dimension(600,50));
        pan3.add(boutonequipe);
        
        
        setVisible(true);
                
    }
    
    
    
    
}
