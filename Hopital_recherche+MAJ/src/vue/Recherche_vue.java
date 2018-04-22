/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import controleur.Recherche;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JComponent;
import modele.Connexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *classe qui permet d'acceder a la recherche et de l'executer
 * @author USER
 */
public class Recherche_vue {
 
JFrame jframe_rech = new JFrame("Menu de recherche");
JPanel jpanel_rech;
JButton bouton1,bouton2,bouton3,bouton4,bouton5,bouton6,bouton7,bouton8,bouton9,bouton10;
Recherche recherche;


    
    public Recherche_vue() throws ClassNotFoundException, SQLException
    {
    
        recherche = new Recherche();
                            
        //on met au point le jrame        
        jframe_rech.setSize(1800,600);
        jframe_rech.setLocationRelativeTo(null);
        jframe_rech.setResizable(false);

       //bouton + champ de taxte
       bouton1 = new JButton("requette 1");
       bouton1.setBackground(Color.RED);
       jpanel_rech = new JPanel();
       jpanel_rech.add(bouton1);
       JLabel textbouton1 = new JLabel("le bouton bouton1 donne le nom et le prenom des malades affiliés a la mutuelle MAAF ");
       textbouton1.setBackground(Color.WHITE);
       jpanel_rech.add(textbouton1);
       bouton1.addActionListener(new Recherche_vue.ItemAction());
       
       bouton2 = new JButton("requette 2");
       bouton2.setBackground(Color.RED);
       jpanel_rech.add(bouton2);
       JLabel textbouton2 = new JLabel("le bouton bouton2 donne le nom et le prenom desinfirmiers travaillants pendant la rotation de nuit");
       textbouton2.setBackground(Color.WHITE);
       jpanel_rech.add(textbouton2);
       bouton2.addActionListener(new Recherche_vue.ItemAction());

       bouton3 = new JButton("requette 3");
       bouton3.setBackground(Color.RED);
       jpanel_rech.add(bouton3);
       JLabel textbouton3 = new JLabel("le bouton bouton3 donne pour chaque services son nom, son batiment ainsi que les prenom nom et specialitees de son directeur ");
       textbouton3.setBackground(Color.WHITE);
       jpanel_rech.add(textbouton3);
       bouton3.addActionListener(new Recherche_vue.ItemAction());
       
       bouton4 = new JButton("requette 4");
       bouton4.setBackground(Color.GREEN);
       jpanel_rech.add(bouton4);
       JLabel textbouton4 = new JLabel("le bouton bouton4 donne le no_chambre, le lit le prenom et le nom des patient a la mutuelle commencant par MN.. dans le batiment B ");
       textbouton4.setBackground(Color.WHITE);
       jpanel_rech.add(textbouton4);
       bouton4.addActionListener(new Recherche_vue.ItemAction());
       
       bouton5 = new JButton("requette 5");
       bouton5.setBackground(Color.GREEN);       
       jpanel_rech.add(bouton5);
       JLabel textbouton5 = new JLabel("le bouton bouton5 donne la moyenne des salaires des infirmiers par service");
       textbouton5.setBackground(Color.WHITE);
       jpanel_rech.add(textbouton5);
       bouton5.addActionListener(new Recherche_vue.ItemAction());
        
       bouton6 = new JButton("requette 6");
       bouton6.setBackground(Color.GREEN);
       jpanel_rech.add(bouton6);
       JLabel textbouton6 = new JLabel("le bouton bouton6 donne le nombre moyen de lit par chambre pour chaque service du batiment A");
       textbouton6.setBackground(Color.WHITE);
       jpanel_rech.add(textbouton6);
       bouton6.addActionListener(new Recherche_vue.ItemAction());
       
       bouton7 = new JButton("requette 7");
       bouton7.setBackground(Color.GREEN);
       jpanel_rech.add(bouton7);
       JLabel textbouton7 = new JLabel("le bouton bouton7 donne le nom, le prenom, le nombre de soignant et nombre de specialite si le nombre soignant >3 ");
       textbouton7.setBackground(Color.WHITE);
       jpanel_rech.add(textbouton7);
       bouton7.addActionListener(new Recherche_vue.ItemAction());
       
       bouton8 = new JButton("requette 8");
       bouton8.setBackground(Color.ORANGE);
       jpanel_rech.add(bouton8);
       JLabel textbouton8 = new JLabel("le bouton bouton8 donne lerapport entre le nombre d'infirmieres affecte au service et le nombre de malade hospitalisé dans le service");
       textbouton8.setBackground(Color.WHITE);
       jpanel_rech.add(textbouton8);
       bouton8.addActionListener(new Recherche_vue.ItemAction());
       
       bouton9 = new JButton("requette 9");
       bouton9.setBackground(Color.ORANGE);       
       jpanel_rech.add(bouton9);
       JLabel textbouton9 = new JLabel("Le bouton 9 donne le nom et prenom des docteurs ayant au moins 1 malade hospitalisé");
       textbouton9.setBackground(Color.WHITE);
       jpanel_rech.add(textbouton9);
       bouton9.addActionListener(new Recherche_vue.ItemAction());
       
       bouton10 = new JButton("requette 10");
       bouton10.setBackground(Color.ORANGE);       
       jpanel_rech.add(bouton10);
       JLabel textbouton10 = new JLabel("le bouton 10 donne le prenom et le nom des docteurs n'ayant aucun malade hospitalisé");
       textbouton10.setBackground(Color.WHITE);
       jpanel_rech.add(textbouton10);
       bouton10.addActionListener(new Recherche_vue.ItemAction());
       

        //layout en grille avec 3 lignes et 1 colonne
        GridLayout gl = new GridLayout(10,2);
        gl.setHgap(5); // espace Horizontal
        gl.setVgap(5); // espace Vertical
        jpanel_rech.setLayout(gl); 
        jpanel_rech.setBackground(Color.WHITE);
        
        jframe_rech.add(jpanel_rech,BorderLayout.CENTER);

       jframe_rech.setVisible(true);
        

    
    }
    

    
    
    
    
    /**
 *Classe interne implémentant l'interface ActionListener 
 */

    class ItemAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
          Object source = e.getSource();
          
          if(source == bouton1 )
          {
              try {
                  recherche.requette1();
                  } 
              catch (SQLException ex) {Logger.getLogger(Recherche_vue.class.getName()).log(Level.SEVERE, null, ex);}
          }
          
          if(source == bouton2 )
          {
              try {
                  recherche.requette2();
                  } 
              catch (SQLException ex) {Logger.getLogger(Recherche_vue.class.getName()).log(Level.SEVERE, null, ex);}
          }
          
          if(source == bouton3 )
          {
              try {
                  recherche.requette3();
                  } 
              catch (SQLException ex) {Logger.getLogger(Recherche_vue.class.getName()).log(Level.SEVERE, null, ex);}
          }
          
          if(source == bouton4 )
          {
              try {
                  recherche.requette4();
                  } 
              catch (SQLException ex) {Logger.getLogger(Recherche_vue.class.getName()).log(Level.SEVERE, null, ex);}
          }
          
          if(source == bouton5 )
          {
              try {
                  recherche.requette5();
                  } 
              catch (SQLException ex) {Logger.getLogger(Recherche_vue.class.getName()).log(Level.SEVERE, null, ex);}
          }
          
          if(source == bouton6 )
          {
              try {
                  recherche.requette6();
                  } 
              catch (SQLException ex) {Logger.getLogger(Recherche_vue.class.getName()).log(Level.SEVERE, null, ex);}
          }
          
          if(source == bouton7 )
          {
              try {
                  recherche.requette7();
                  } 
              catch (SQLException ex) {Logger.getLogger(Recherche_vue.class.getName()).log(Level.SEVERE, null, ex);}
          }
          
          if(source == bouton8 )
          {
              try {
                  recherche.requette8();
                  } 
              catch (SQLException ex) {Logger.getLogger(Recherche_vue.class.getName()).log(Level.SEVERE, null, ex);}
          }

          if(source == bouton9 )
          {
              try {
                  recherche.requette9();
                  } 
              catch (SQLException ex) {Logger.getLogger(Recherche_vue.class.getName()).log(Level.SEVERE, null, ex);}
          }
          
          if(source == bouton10 )
          {
              try {
                  recherche.requette10();
                  } 
              catch (SQLException ex) {Logger.getLogger(Recherche_vue.class.getName()).log(Level.SEVERE, null, ex);}
          }

        }
    
    }
    
    
    
    
    
    
    
}
