/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author delphine
 */
public class graphique extends JFrame implements ActionListener {
    
    JPanel pan = new JPanel() ;
    JPanel pan2 = new JPanel() ;
    JPanel pan3 = new JPanel() ;
    JButton boutonco = new JButton();
    JButton boutonrech = new JButton();
    JButton boutonmaj = new JButton();
    JButton boutonrepor = new JButton();  
    private JButton imag = new JButton("h");
    
   
        
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
        
        
        boutonco = new JButton("Connexion");
        boutonco.setPreferredSize(new Dimension(200,80));
        pan.add(boutonco);
        boutonco.addActionListener(this);
        
        boutonrech = new JButton("Recherche");
        boutonrech.setPreferredSize(new Dimension(200,80));
        pan.add(boutonrech);
        boutonrech.addActionListener(this);
        
        boutonmaj = new JButton("Mise à jour");
        boutonmaj.setPreferredSize(new Dimension(200,80));
        pan.add(boutonmaj);
        boutonmaj.addActionListener(this);
        
        boutonrepor = new JButton("Reporting");
        boutonrepor.setPreferredSize(new Dimension(200,80));
        pan.add(boutonrepor);
        boutonrepor.addActionListener(this);
        
        ImageIcon imghopital = new ImageIcon("C:/Users/USER/Documents/3e annee d'ingenieur/Semestre2/NetBeansProjectsProjetJavaGrp5/Hopital2 - connexion+requette/hopital.jpg");
        imag.setIcon( imghopital);
        pan2.add(imag);
        
        JButton boutonequipe = new JButton("Gestion d'un centre hospitalier par Vincent B, Tom B et Delphine H");
        boutonequipe.setPreferredSize(new Dimension(600,50));
        pan3.add(boutonequipe);

        

        setVisible(true);
                
    }
    
    
    


        
        
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
                
                Object source = e.getSource();
                
                if (source == boutonco) {
                    ZDialog fenco = new ZDialog(null,"Connexion",true); 
                }
                
                if (source == boutonrech) {
                    ZDialog fenrech = new ZDialog(null,"Recherche",true); 
                }
                
                
                //mise a jour
                if (source == boutonmaj) 
                {
                    //on fait un try catch afin de gerer les erreurs sqlexeption et
                    MiseAJour objetmaj = new MiseAJour();
                    objetmaj.FX_MiseAJour();
                }

                
                
                
                
                
                if (source == boutonrepor) {
                    ZDialog fenrepor = new ZDialog(null,"Reporting",true); 
                }
                
                
                
                          
        }
    
    
}
