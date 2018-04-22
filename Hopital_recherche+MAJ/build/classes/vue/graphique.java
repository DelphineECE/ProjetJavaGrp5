/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import java.awt.*;
import vue.MiseAJour;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import modele.Connexion;
import vue.Recherche_vue;


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
    
    
    private JLabel imag;
    private JButton conn;
    public java.awt.List listeDeTables, listeDeRequetes;
    private Connexion maconnexion;
    private JLabel tab, req, res, lignes, requeteLabel;
    public JTextArea fenetreLignes, fenetreRes;
    private JPanel p1, nord, p2, p3;
    private JTextField requeteTexte;
    private JButton exec;
    
    private JLabel monlabel;
    
    
    
    
    
    
    
    
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
        imag = new JLabel();
        
        pan3 = new JPanel();     // instancier le panneau
        getContentPane().add(pan3, BorderLayout.SOUTH);
        
        
        boutonco = new JButton("Connexion");
        boutonco.setPreferredSize(new Dimension(200,80));
        boutonco.setBackground(Color.LIGHT_GRAY);
        pan.add(boutonco);
        boutonco.addActionListener(this);
        
        boutonrech = new JButton("Recherche");
        boutonrech.setPreferredSize(new Dimension(200,80));
        boutonrech.setBackground(Color.LIGHT_GRAY);
        pan.add(boutonrech);
        boutonrech.addActionListener(this);
        
        boutonmaj = new JButton("Mise à jour");
        boutonmaj.setPreferredSize(new Dimension(200,80));
        boutonmaj.setBackground(Color.LIGHT_GRAY);
        pan.setBackground(Color.WHITE);
        pan.add(boutonmaj);
        boutonmaj.addActionListener(this);
        
        boutonrepor = new JButton("Reporting");
        boutonrepor.setPreferredSize(new Dimension(200,80));
        boutonrepor.setBackground(Color.LIGHT_GRAY);
        pan.add(boutonrepor);
        boutonrepor.addActionListener(this);
        
        ImageIcon imghopital = new ImageIcon("C:/Users/USER/Documents/3e annee d'ingenieur/Semestre2/NetBeansProjects/sauvegarde_projet/Hopital_mise_a_jour/hopital.jpg");
        imag.setIcon( imghopital);
        pan2.setBackground(Color.WHITE);
        pan2.add(imag);
        
        JLabel boutonequipe = new JLabel(".                                            Gestion d'un centre hospitalier par Vincent B, Tom B et Delphine H");
        boutonequipe.setBackground(Color.LIGHT_GRAY);
        boutonequipe.setPreferredSize(new Dimension(600,50));
        pan3.setBackground(Color.WHITE);
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
 
                    try {
                            Recherche_vue recherche = new Recherche_vue();
                        } 
                    catch (ClassNotFoundException | SQLException ex) {Logger.getLogger(graphique.class.getName()).log(Level.SEVERE, null, ex);}
                }
                
                if (source == boutonmaj) {
                    MiseAJour maj = new MiseAJour(); 
                    maj.FX_MiseAJour();
                }
                
                if (source == boutonrepor) {
                    ZDialog fenrepor = new ZDialog(null,"Reporting",true); 
                    
                    
                }
                
                
                
                
        }
   
    
   
        
        


}

