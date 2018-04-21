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
import javax.swing.*;
import javax.swing.JComponent;
import modele.Connexion;
import java.sql.*;
import java.util.ArrayList;
import controleur.Gestion_MAJ;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class MiseAJour extends JFrame  {


   //jfarme touchant a la mise a jour
    private JFrame jframe_MAJ;
    private JPanel jpanel_MAJ;
    private JButton modifier,supprimer,inserer ;
    private String table,id_no,no,id_colonne,modification;//string permettant de faire la requette sql grace a connexion
    private boolean chambre, docteur, employe, hospitalisation, infirmier, malade, service, soigne;
    
    //sous composants modifier 
    private JFrame jframe_modif ,derniere ;            
    private JPanel jpanel_modif,jpanel_modif_barre;
    private JComboBox combo_chambre,combo_docteur,combo_employe,combo_hospitalisation,combo_infirmier,combo_malade,combo_service,combo_soigne,combo_choix_modif; //laJcombobok pour les listes
    private String choix_sql;
    private JTextField dernier_field;
    private JButton dernier_bouton;
    //sous composants supprimer
    private JFrame jframe_supp ,derniere_supp ;            
    private JPanel jpanel_supp,jpanel_supp_barre;
    private JComboBox combo_chambre_supp,combo_docteur_supp,combo_employe_supp,combo_hospitalisation_supp,combo_infirmier_supp,combo_malade_supp,combo_service_supp,combo_soigne_supp, combo_choix_supp; //laJcombobok pour les listes
    private JLabel dernier_label;
    private JButton dernier_bouton_supp;
    
        //sous composants inserer
    private JFrame jframe_inser1 ,jframe_inser2 ;            
    private JPanel jpanel_inser1_haut,jpanel_inser1_millieu,jpanel_inser2_haut,jpanel_inser2_millieu,jpanel_inser2_millieu2;
    private JLabel label_inser1, label_inser2;
    private JTextField[] text_inser_chambre, text_inser_docteur, text_inser_employe, text_inser_hospitalisation, text_inser_infirmier, text_inser_malade, text_inser_service, text_inser_soigne;
    private JButton bouton_inserer_chambre,bouton_inserer_docteur,bouton_inserer_employe,bouton_inserer_hospitalisation,bouton_inserer_infirmier,bouton_inserer_malade,bouton_inserer_service,bouton_inserer_soigne,bouton_inser_valider;
    private String[] tab_chambre, tab_docteur ,tab_employe ,tab_hospitalisation, tab_infirmier ,tab_malade, tab_service ,tab_soigne;

                      	
    /*
    chambre
    docteur
    employe
    hospitalisation
    infirmier
    malade
    service
    soigne
    
    tab_chambre tab_docteur tab_employe tab_hospitalisation tab_infirmier tab_malade tab_service tab_soigne
    */
    
    
    
    public MiseAJour()
    {
        
    
       //page initiale de mise a jour:
       jframe_MAJ = new JFrame("MISE A JOUR");

           
       modifier = new JButton("modifier");
       modifier.setPreferredSize(new Dimension(200,80));
       modifier.setBackground(Color.LIGHT_GRAY);
       jpanel_MAJ = new JPanel();
       jpanel_MAJ.add(modifier);
       JLabel textmodifier = new JLabel("le bouton modifier les attributs choisis ");
       textmodifier.setBackground(Color.WHITE);
       jpanel_MAJ.add(textmodifier);
       modifier.addActionListener(new ItemAction());
       
       supprimer = new JButton("supprimer");
       supprimer.setPreferredSize(new Dimension(200,80));
       supprimer.setBackground(Color.LIGHT_GRAY);
       jpanel_MAJ.add(supprimer);
       JLabel textsupprimer = new JLabel("le bouton supprimer supprime les attributs choisis ");
       textsupprimer.setBackground(Color.WHITE);
       jpanel_MAJ.add(textsupprimer);
       supprimer.addActionListener(new ItemAction());
       
       inserer = new JButton("inserer");
       inserer.setPreferredSize(new Dimension(200,80));
       inserer.setBackground(Color.LIGHT_GRAY);
       jpanel_MAJ.add(inserer);
       JLabel textinserer = new JLabel("le bouton inserer permet d'inserer un nouveau departement ou employé avec une nouvelle mission. ");
       textinserer.setBackground(Color.WHITE);
       jpanel_MAJ.add(textinserer);
       inserer.addActionListener(new ItemAction());
       
       
    chambre =false;
    docteur=false;
    employe=false;
    hospitalisation=false;
    infirmier=false;
    malade=false;
    service=false;
    soigne=false;
        
    }
    
    
    
        //fonction de choix entre modif , suppression et inserer
        public void FX_MiseAJour()
    {
        //on met au point le jrame        
        jframe_MAJ.setTitle("Gestion d'un hopital");
        jframe_MAJ.setSize(1300,290);
        jframe_MAJ.setLocationRelativeTo(null);
        jframe_MAJ.setResizable(false);


        //layout en grille avec 3 lignes et 1 colonne
        GridLayout gl = new GridLayout(3, 2);
        gl.setHgap(5); // espace Horizontal
        gl.setVgap(5); // espace Vertical
        jpanel_MAJ.setLayout(gl); 
        jpanel_MAJ.setBackground(Color.WHITE);
        jframe_MAJ.add(jpanel_MAJ, BorderLayout.NORTH);

       jframe_MAJ.setVisible(true);
        
        
    }
        
        
        
    public void Modifier()throws SQLException, ClassNotFoundException
    {
       //objet de gestion maj
       Gestion_MAJ gestion_maj = new Gestion_MAJ();
       //sous composant de MODIFICATION:
       jframe_modif= new JFrame("MODIFICATIONS");
       jframe_modif.setSize(1500, 140);
       jframe_modif.setLocationRelativeTo(null);
       jframe_modif.setResizable(false);
       
       //la barre du haut
       jpanel_modif_barre = new JPanel();
       jpanel_modif_barre.setLayout(new GridLayout(1, 8));//les grid layout
       JLabel text = new JLabel("CHAMBRE");
       text.setBackground(Color.LIGHT_GRAY);
       jpanel_modif_barre.add(text);
       JLabel text2 = new JLabel("DOCTEUR");
       text2.setBackground(Color.LIGHT_GRAY);
       jpanel_modif_barre.add(text2);
       JLabel text3 = new JLabel("EMPLOYE");
       text3.setBackground(Color.LIGHT_GRAY);
       jpanel_modif_barre.add(text3);
              JLabel text4 = new JLabel("HOSPITALISATION");
       text4.setBackground(Color.LIGHT_GRAY);
       jpanel_modif_barre.add(text4);
              JLabel text5 = new JLabel("INFIRMIER");
       text5.setBackground(Color.LIGHT_GRAY);
       jpanel_modif_barre.add(text5);
              JLabel text6 = new JLabel("MALADE");
       text6.setBackground(Color.LIGHT_GRAY);
       jpanel_modif_barre.add(text6);
              JLabel text7 = new JLabel("SERVICE");
       text7.setBackground(Color.LIGHT_GRAY);
       jpanel_modif_barre.add(text7);
              JLabel text8 = new JLabel("SOIGNE");
       text8.setBackground(Color.LIGHT_GRAY);
       jpanel_modif_barre.add(text8);
       
       
       
       
       
       jpanel_modif= new JPanel();
       jpanel_modif.setLayout(new GridLayout(1,8));
       
        //recupere dans 1 string les table correspondante
        String[] les_chambre;
        les_chambre = gestion_maj.les_chambre(); 
        String[] les_docteur;
        les_docteur = gestion_maj.les_docteur();
        String[] les_hospitalisation;
        les_hospitalisation = gestion_maj.les_hospitalisation();
        String[] les_infirmier;
        les_infirmier = gestion_maj.les_infirmier();
        String[] les_malade;
        les_malade = gestion_maj.les_malade();
        String[] les_service;
        les_service = gestion_maj.les_service();
        String[] les_soigne;
        les_soigne = gestion_maj.les_soigne();
        String[] les_employe;
        les_employe = gestion_maj.les_employe(); 
        
        //les combos
        combo_chambre = new JComboBox(les_chambre);
        combo_chambre.setBackground(Color.cyan);
        combo_chambre.addActionListener(new ItemAction());
        combo_docteur = new JComboBox(les_docteur);
        combo_docteur.setBackground(Color.cyan);
        combo_docteur.addActionListener(new ItemAction());
        combo_employe = new JComboBox(les_employe);
        combo_employe.setBackground(Color.cyan);
        combo_employe.addActionListener(new ItemAction());
        combo_hospitalisation = new JComboBox(les_hospitalisation);
        combo_hospitalisation.setBackground(Color.white);
        combo_hospitalisation.addActionListener(new ItemAction());
        combo_infirmier = new JComboBox(les_infirmier);
        combo_infirmier.setBackground(Color.white);
        combo_infirmier.addActionListener(new ItemAction());
        combo_malade = new JComboBox(les_malade);
        combo_malade.setBackground(Color.red);
        combo_malade.addActionListener(new ItemAction());
        combo_service = new JComboBox(les_service);
        combo_service.setBackground(Color.red);
        combo_service.addActionListener(new ItemAction());
        combo_soigne = new JComboBox(les_soigne);
        combo_soigne.setBackground(Color.red);
        combo_soigne.addActionListener(new ItemAction());
        
        
        
        //on mets les layout dans les pannels
        jpanel_modif.add(combo_chambre);
        jpanel_modif.add(combo_docteur);
        jpanel_modif.add(combo_employe);
        jpanel_modif.add(combo_hospitalisation);
        jpanel_modif.add(combo_infirmier);
        jpanel_modif.add(combo_malade);
        jpanel_modif.add(combo_service);
        jpanel_modif.add(combo_soigne);
        
        //on localise les pannels dans le jframe
        jframe_modif.add("North",jpanel_modif_barre);
        jframe_modif.add("Center", jpanel_modif);
        jframe_modif.setVisible(true);
    
    }
        

    
    
    
    
    public void Supprimer() throws SQLException, ClassNotFoundException
    {
       //objet de gestion maj
       Gestion_MAJ gestion_maj = new Gestion_MAJ();
       //sous composant de MODIFICATION:
       jframe_supp= new JFrame("SUPPRESSION");
       jframe_supp.setSize(1500, 140);
       jframe_supp.setLocationRelativeTo(null);
       jframe_supp.setResizable(false);
       
//la barre du haut
       jpanel_supp_barre = new JPanel();
       jpanel_supp_barre.setLayout(new GridLayout(1, 8));//les grid layout
       JLabel text = new JLabel("CHAMBRE");
       text.setBackground(Color.LIGHT_GRAY);
       jpanel_supp_barre.add(text);
       JLabel text2 = new JLabel("DOCTEUR");
       text2.setBackground(Color.LIGHT_GRAY);
       jpanel_supp_barre.add(text2);
       JLabel text3 = new JLabel("EMPLOYE");
       text3.setBackground(Color.LIGHT_GRAY);
       jpanel_supp_barre.add(text3);
              JLabel text4 = new JLabel("HOSPITALISATION");
       text4.setBackground(Color.LIGHT_GRAY);
       jpanel_supp_barre.add(text4);
              JLabel text5 = new JLabel("INFIRMIER");
       text5.setBackground(Color.LIGHT_GRAY);
       jpanel_supp_barre.add(text5);
              JLabel text6 = new JLabel("MALADE");
       text6.setBackground(Color.LIGHT_GRAY);
       jpanel_supp_barre.add(text6);
              JLabel text7 = new JLabel("SERVICE");
       text7.setBackground(Color.LIGHT_GRAY);
       jpanel_supp_barre.add(text7);
              JLabel text8 = new JLabel("SOIGNE");
       text8.setBackground(Color.LIGHT_GRAY);
       jpanel_supp_barre.add(text8);

       jpanel_supp= new JPanel();
       jpanel_supp.setLayout(new GridLayout(1,8));
       
       
        //recupere dans 1 string les mission,employe et departements de la table correspondante
        //recupere dans 1 string les table correspondante
        String[] les_chambre;
        les_chambre = gestion_maj.les_chambre(); 
        String[] les_docteur;
        les_docteur = gestion_maj.les_docteur();
        String[] les_hospitalisation;
        les_hospitalisation = gestion_maj.les_hospitalisation();
        String[] les_infirmier;
        les_infirmier = gestion_maj.les_infirmier();
        String[] les_malade;
        les_malade = gestion_maj.les_malade();
        String[] les_service;
        les_service = gestion_maj.les_service();
        String[] les_soigne;
        les_soigne = gestion_maj.les_soigne();
        String[] les_employe;
        les_employe = gestion_maj.les_employe(); 
        
        //les combos
        combo_chambre_supp = new JComboBox(les_chambre);
        combo_chambre_supp.setBackground(Color.cyan);
        combo_chambre_supp.addActionListener(new ItemAction());
        combo_docteur_supp = new JComboBox(les_docteur);
        combo_docteur_supp.setBackground(Color.white);
        combo_docteur_supp.addActionListener(new ItemAction());
        combo_employe_supp = new JComboBox(les_employe);
        combo_employe_supp.setBackground(Color.red);
        combo_employe_supp.addActionListener(new ItemAction());
        combo_hospitalisation_supp = new JComboBox(les_hospitalisation);
        combo_hospitalisation_supp.setBackground(Color.cyan);
        combo_hospitalisation_supp.addActionListener(new ItemAction());
        combo_infirmier_supp = new JComboBox(les_infirmier);
        combo_infirmier_supp.setBackground(Color.white);
        combo_infirmier_supp.addActionListener(new ItemAction());
        combo_malade_supp = new JComboBox(les_malade);
        combo_malade_supp.setBackground(Color.red);
        combo_malade_supp.addActionListener(new ItemAction());
        combo_service_supp = new JComboBox(les_service);
        combo_service_supp.setBackground(Color.cyan);
        combo_service_supp.addActionListener(new ItemAction());
        combo_soigne_supp = new JComboBox(les_soigne);
        combo_soigne_supp.setBackground(Color.white);
        combo_soigne_supp.addActionListener(new ItemAction());
        
        //on mets les layout dans les pannels
        jpanel_supp.add(combo_chambre_supp);
        jpanel_supp.add(combo_docteur_supp);
        jpanel_supp.add(combo_employe_supp);
        jpanel_supp.add(combo_hospitalisation_supp);
        jpanel_supp.add(combo_infirmier_supp);
        jpanel_supp.add(combo_malade_supp);
        jpanel_supp.add(combo_service_supp);
        jpanel_supp.add(combo_soigne_supp);
        
        //on localise les pannels dans le jframe
        jframe_supp.add("North",jpanel_supp_barre);
        jframe_supp.add("Center", jpanel_supp);
        jframe_supp.setVisible(true);
        
    
    }
    

    
    
    
    public void Inserer() throws SQLException, ClassNotFoundException 
    {
        
        Gestion_MAJ gestion_maj = new Gestion_MAJ();
        
        //on initialise les string[]
        tab_chambre=new String[4];
        tab_docteur=new String[2];
        tab_employe=new String[5];
        tab_hospitalisation=new String[4];
        tab_infirmier=new String[4];
        tab_malade=new String[6];
        tab_service=new String[4];
        tab_soigne=new String[2]; 
        
        tab_chambre[0]="code_service"; tab_chambre[1]="no_chambre";tab_chambre[2]="surveillant";tab_chambre[3]="nb_lits"; //composante informative pour le jbox
        tab_docteur[0]="numero"; tab_docteur[1]="specialite"; //composante informative pour le jbox
        tab_employe[0]="numero"; tab_employe[1]="nom";tab_employe[2]="prenom";tab_employe[3]="adresse";tab_employe[4]="tel"; //composante informative pour le jbox
        tab_hospitalisation[0]="no_malade"; tab_hospitalisation[1]="code_service";tab_hospitalisation[2]="no_chambre";tab_hospitalisation[3]="lit"; //composante informative pour le jbox
        tab_infirmier[0]="numero"; tab_infirmier[1]="code_service";tab_infirmier[2]="rotation";tab_infirmier[3]="salaire"; //composante informative pour le jbox
        tab_malade[0]="numero"; tab_malade[1]="nom";tab_malade[2]="prenom";tab_malade[3]="adresse";tab_malade[4]="tel";tab_malade[5]="mutuelle"; //composante informative pour le jbox
        tab_service[0]="code"; tab_service[1]="nom";tab_service[2]="batiment";tab_service[3]="directeur"; //composante informative pour le jbox
        tab_soigne[0]="no_docteur"; tab_soigne[1]="no_malade"; //composante informative pour le jbox
        
        
        
        //on initiaise les jtextfields[]
        text_inser_chambre=new JTextField[4];
        text_inser_docteur=new JTextField[2];
        text_inser_employe=new JTextField[5];
        text_inser_hospitalisation=new JTextField[4];
        text_inser_infirmier=new JTextField[4];
        text_inser_malade=new JTextField[6];
        text_inser_service=new JTextField[4];
        text_inser_soigne=new JTextField[2];
        
        for(int i=0; i<text_inser_chambre.length; i++)
        {
            text_inser_chambre[i] = new JTextField(tab_chambre[i]);
        }
        for(int i=0; i<text_inser_docteur.length; i++)
        {
            text_inser_docteur[i]=new JTextField(tab_docteur[i]);
        }
        for(int i=0; i<text_inser_employe.length; i++)
        {
            text_inser_employe[i]=new JTextField(tab_employe[i]);
        }
        for(int i=0; i<text_inser_hospitalisation.length; i++)
        {
            text_inser_hospitalisation[i]=new JTextField(tab_hospitalisation[i]);
        }
        for(int i=0; i<text_inser_infirmier.length; i++)
        {
            text_inser_infirmier[i]=new JTextField(tab_infirmier[i]);
        }
        for(int i=0; i<text_inser_malade.length; i++)
        {
            text_inser_malade[i]=new JTextField(tab_malade[i]);
        }
        for(int i=0; i<text_inser_service.length; i++)
        {
            text_inser_service[i]=new JTextField(tab_service[i]);
        }
        for(int i=0; i<text_inser_soigne.length; i++)
        {
            text_inser_soigne[i]=new JTextField(tab_soigne[i]);
        }
        

       //sous composant de MODIFICATION:
       jframe_inser1= new JFrame("Ajout");
       jframe_inser1.setSize(700, 130);
       jframe_inser1.setLocationRelativeTo(null);
       jframe_inser1.setResizable(false);
       
       //la barre du haut
       jpanel_inser1_haut = new JPanel();
       jpanel_inser1_haut.setLayout(new GridLayout(1,1));
       label_inser1 = new JLabel("Quel type d'objet voulez vous inserrer?");
       label_inser1.setBackground(Color.LIGHT_GRAY);
       
       //barre du millieu
       jpanel_inser1_millieu = new JPanel();
       jpanel_inser1_millieu.setLayout(new GridLayout(1,8));
       
       //les boutons + actions listeners
       bouton_inserer_chambre = new JButton("chambre");
       bouton_inserer_chambre.setBackground(Color.orange);
       bouton_inserer_chambre.addActionListener(new ItemAction());
       bouton_inserer_docteur = new JButton("docteur");
       bouton_inserer_docteur.setBackground(Color.yellow);
       bouton_inserer_docteur.addActionListener(new ItemAction());
       bouton_inserer_employe = new JButton("employe");
       bouton_inserer_employe.setBackground(Color.green);
       bouton_inserer_employe.addActionListener(new ItemAction());
       bouton_inserer_hospitalisation = new JButton("hospitalisation");
       bouton_inserer_hospitalisation.setBackground(Color.orange);
       bouton_inserer_hospitalisation.addActionListener(new ItemAction());
       bouton_inserer_infirmier = new JButton("infirmier");
       bouton_inserer_infirmier.setBackground(Color.yellow);
       bouton_inserer_infirmier.addActionListener(new ItemAction());
       bouton_inserer_malade = new JButton("malade");
       bouton_inserer_malade.setBackground(Color.green);
       bouton_inserer_malade.addActionListener(new ItemAction());
       bouton_inserer_service = new JButton("service");
       bouton_inserer_service.setBackground(Color.orange);
       bouton_inserer_service.addActionListener(new ItemAction()); 
       bouton_inserer_soigne = new JButton("soigne");
       bouton_inserer_soigne.setBackground(Color.yellow);
       bouton_inserer_soigne.addActionListener(new ItemAction());
       

       //on assemble le tout
       jpanel_inser1_haut.add(label_inser1);

       jpanel_inser1_millieu.add(bouton_inserer_chambre);
       jpanel_inser1_millieu.add(bouton_inserer_docteur);
       jpanel_inser1_millieu.add(bouton_inserer_employe);
       jpanel_inser1_millieu.add(bouton_inserer_hospitalisation);
       jpanel_inser1_millieu.add(bouton_inserer_infirmier);
       jpanel_inser1_millieu.add(bouton_inserer_malade);
       jpanel_inser1_millieu.add(bouton_inserer_service);
       jpanel_inser1_millieu.add(bouton_inserer_soigne);
       
        //on localise les pannels dans le jframe
        jframe_inser1.add("North",jpanel_inser1_haut);
        jframe_inser1.add("Center", jpanel_inser1_millieu);
        jframe_inser1.setVisible(true);
        
    
    }
    
    
    
    
    
        //affiche la derniere fenettre
    
    public void dernier_suppr(JComboBox moncombo)
    {
        

                    derniere_supp = new JFrame("SUPPRESSION");
                    derniere_supp.setSize(600,110);
                    derniere_supp.setLocationRelativeTo(null);
                    derniere_supp.setResizable(false);
                    JPanel dernier = new JPanel();
                    JPanel dernier2 = new JPanel();
                    dernier.setLayout(new FlowLayout());
                    dernier.setBackground(Color.WHITE);
                    dernier_label = new JLabel("       Supprimer la ligne:     "+moncombo.getSelectedItem().toString()+"     ???              ");
                    dernier_bouton_supp = new JButton("SUPPRIMER!");
                    dernier_bouton_supp.addActionListener(new ItemAction());
                    dernier_bouton_supp.setBackground(Color.ORANGE);
                    //on assemble la fenetre
                    dernier.add(dernier_label);
                    dernier2.add(dernier_bouton_supp);
                    derniere_supp.add("Center",dernier);
                    derniere_supp.add("South",dernier2);
                    derniere_supp.setVisible(true);
        
    }
    
    
    
    
    
    
   
    
    
        
        
        
 //Classe interne implémentant l'interface ActionListener


    class ItemAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) 
    {
      Object source = e.getSource();
      
         //sous boutons de mise a jour
                if (source == modifier) //bouton de choix initial 
                {
                    try { 
                            Modifier();
                        }
                    catch (SQLException | ClassNotFoundException ex){Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);}
                jframe_modif.setVisible(true);
                }
                
                
                
                if (source == supprimer) //bouton de choix initial 
                {
                    try {
                          Supprimer();
                        } 
                    catch (SQLException | ClassNotFoundException ex) {Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);}
                }
                
                
                
                if (source == inserer)//bouton de choix initial 
                {
                    try {
                          Inserer();
                    }
                    catch(SQLException | ClassNotFoundException ex) {Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);}

                }
                
                
                
                
                
                
                
                
                
                

                //Jbox MODIFICATION
                if (source ==combo_chambre)//Si le jcombo est selectionne, on cree un Jcombbox en bas du jframe avec la ligne selectionnee
                {

                      table="chambre";
                      id_no="no_chambre";
                      String miss1[] = combo_chambre.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[1];
                      miss1[0]="code_service:"+miss1[0]; miss1[1]="no_chambre:"+miss1[1];miss1[2]="surveillant:"+miss1[2];miss1[3]="nb_lits:"+miss1[3]; //composante informative pour le jbox
                        	 	 	 
                      jframe_modif.setSize(1500, 300);
                      JPanel pan_modif1 = new JPanel();
                       combo_choix_modif = new JComboBox(miss1);
                       combo_choix_modif.setBackground(Color.cyan);
                       combo_choix_modif.addActionListener(new ItemAction());
                       JLabel n = new JLabel("selectionnez l'element a modifier");
                       pan_modif1.add(n);
                       pan_modif1.add(combo_choix_modif);
                       jframe_modif.add("South",pan_modif1);
                      
                }
                
                if (source ==combo_docteur)//Si le jcombo est selectionne, on cree un Jcombbox en bas du jframe avec la ligne selectionnee
                {

                      table="docteur";
                      id_no="numero";
                      String miss1[] = combo_docteur.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[0];
                      miss1[0]="numero:"+miss1[0]; miss1[1]="specialite:"+miss1[1]; //composante informative pour le jbox
                        	 	 	 
                      jframe_modif.setSize(1500, 300);
                      JPanel pan_modif1 = new JPanel();
                       combo_choix_modif = new JComboBox(miss1);
                       combo_choix_modif.setBackground(Color.cyan);
                       combo_choix_modif.addActionListener(new ItemAction());
                       JLabel n = new JLabel("selectionnez l'element a modifier");
                       pan_modif1.add(n);
                       pan_modif1.add(combo_choix_modif);
                       jframe_modif.add("South",pan_modif1);
                      
                }
                
                if (source ==combo_employe)//Si le jcombo est selectionne, on cree un Jcombbox en bas du jframe avec la ligne selectionnee
                {

                      table="employe";
                      id_no="numero";
                      String miss1[] = combo_employe.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[1];
                      miss1[0]="numero:"+miss1[0]; miss1[1]="nom:"+miss1[1];miss1[2]="prenom:"+miss1[2];miss1[3]="adresse:"+miss1[3];miss1[4]="tel:"+miss1[4]; //composante informative pour le jbox
                        	 	 	 
                      jframe_modif.setSize(1500, 300);
                      JPanel pan_modif1 = new JPanel();
                       combo_choix_modif = new JComboBox(miss1);
                       combo_choix_modif.setBackground(Color.cyan);
                       combo_choix_modif.addActionListener(new ItemAction());
                       JLabel n = new JLabel("selectionnez l'element a modifier");
                       pan_modif1.add(n);
                       pan_modif1.add(combo_choix_modif);
                       jframe_modif.add("South",pan_modif1);
                      
                }
                
                if (source ==combo_hospitalisation)//Si le jcombo est selectionne, on cree un Jcombbox en bas du jframe avec la ligne selectionnee
                {

                      table="hospitalisation";
                      id_no="no_malade";
                      String miss1[] = combo_hospitalisation.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[1];
                      miss1[0]="no_malade:"+miss1[0]; miss1[1]="code_service:"+miss1[1];miss1[2]="no_chambre:"+miss1[2];miss1[3]="lit:"+miss1[3]; //composante informative pour le jbox
                        	 	 	 
                      jframe_modif.setSize(1500, 300);
                      JPanel pan_modif1 = new JPanel();
                       combo_choix_modif = new JComboBox(miss1);
                       combo_choix_modif.setBackground(Color.cyan);
                       combo_choix_modif.addActionListener(new ItemAction());
                       JLabel n = new JLabel("selectionnez l'element a modifier");
                       pan_modif1.add(n);
                       pan_modif1.add(combo_choix_modif);
                       jframe_modif.add("South",pan_modif1);
                      
                }
                
                if (source ==combo_infirmier)//Si le jcombo est selectionne, on cree un Jcombbox en bas du jframe avec la ligne selectionnee
                {
                    
                      table="infirmier";
                      id_no="numero";
                      String miss1[] = combo_infirmier.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[1];
                      miss1[0]="numero:"+miss1[0]; miss1[1]="code_service:"+miss1[1];miss1[2]="rotation:"+miss1[2];miss1[3]="salaire:"+miss1[3]; //composante informative pour le jbox
                        	 	 	 
                      jframe_modif.setSize(1500, 300);
                      JPanel pan_modif1 = new JPanel();
                       combo_choix_modif = new JComboBox(miss1);
                       combo_choix_modif.setBackground(Color.cyan);
                       combo_choix_modif.addActionListener(new ItemAction());
                       JLabel n = new JLabel("selectionnez l'element a modifier");
                       pan_modif1.add(n);
                       pan_modif1.add(combo_choix_modif);
                       jframe_modif.add("South",pan_modif1);
                      
                }
                
                if (source ==combo_malade)//Si le jcombo est selectionne, on cree un Jcombbox en bas du jframe avec la ligne selectionnee
                {

                      table="malade";
                      id_no="numero";
                      String miss1[] = combo_malade.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[1];
                      miss1[0]="numero:"+miss1[0]; miss1[1]="nom:"+miss1[1];miss1[2]="prenom:"+miss1[2];miss1[3]="adresse:"+miss1[3];miss1[4]="tel:"+miss1[4];miss1[5]="mutuelle:"+miss1[5]; //composante informative pour le jbox
                        	 	 	 
                      jframe_modif.setSize(1500, 300);
                      JPanel pan_modif1 = new JPanel();
                       combo_choix_modif = new JComboBox(miss1);
                       combo_choix_modif.setBackground(Color.cyan);
                       combo_choix_modif.addActionListener(new ItemAction());
                       JLabel n = new JLabel("selectionnez l'element a modifier");
                       pan_modif1.add(n);
                       pan_modif1.add(combo_choix_modif);
                       jframe_modif.add("South",pan_modif1);
                      
                }
                
                if (source ==combo_service)//Si le jcombo est selectionne, on cree un Jcombbox en bas du jframe avec la ligne selectionnee
                {

                      table="service";
                      id_no="code";
                      String miss1[] = combo_service.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[1];
                      miss1[0]="code:"+miss1[0]; miss1[1]="nom:"+miss1[1];miss1[2]="batiment:"+miss1[2];miss1[3]="directeur:"+miss1[3]; //composante informative pour le jbox
                        	 	 	 
                      jframe_modif.setSize(1500, 300);
                      JPanel pan_modif1 = new JPanel();
                      combo_choix_modif = new JComboBox(miss1);
                      combo_choix_modif.setBackground(Color.cyan);
                      combo_choix_modif.addActionListener(new ItemAction());
                      JLabel n = new JLabel("selectionnez l'element a modifier");
                      pan_modif1.add(n);
                      pan_modif1.add(combo_choix_modif);
                      jframe_modif.add("South",pan_modif1);
                      
                }
                
                if (source ==combo_soigne)//Si le jcombo est selectionne, on cree un Jcombbox en bas du jframe avec la ligne selectionnee
                {

                      table="soigne";
                      id_no="no_docteur";
                      String miss1[] = combo_soigne.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[1];
                      miss1[0]="no_docteur:"+miss1[0]; miss1[1]="no_malade:"+miss1[1]; //composante informative pour le jbox
                        	 	 	 
                      jframe_modif.setSize(1500, 300);
                      JPanel pan_modif1 = new JPanel();
                       combo_choix_modif = new JComboBox(miss1);
                       combo_choix_modif.setBackground(Color.cyan);
                       combo_choix_modif.addActionListener(new ItemAction());
                       JLabel n = new JLabel("selectionnez l'element a modifier");
                       pan_modif1.add(n);
                       pan_modif1.add(combo_choix_modif);
                       jframe_modif.add("South",pan_modif1);
                      
                }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                //jcombobox SUPPRESSION
                
                if (source ==combo_chambre_supp)//meme code que au dessu
                {     
                      table="chambre";
                      id_no="no_chambre";
                      String miss1[] = combo_chambre_supp.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[0];
                      dernier_suppr(combo_chambre_supp);
                }
                
                if (source ==combo_docteur_supp)//meme code que au dessu
                {     
                      table="docteur";  
                      id_no="numero";
                      String miss1[] = combo_docteur_supp.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[0];
                      dernier_suppr(combo_docteur_supp);
                }
                
                if (source ==combo_employe_supp)//meme code que au dessu
                {     
                      table="employe";  
                      id_no="empno";
                      String miss1[] = combo_employe_supp.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[0];
                      dernier_suppr(combo_employe_supp);
                }
                
                if (source ==combo_hospitalisation_supp)//meme code que au dessu
                {     
                      table="hospitalisation";
                      id_no="no_malade";
                      String miss1[] = combo_hospitalisation_supp.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[0];
                      dernier_suppr(combo_hospitalisation_supp);
                }
                
                if (source ==combo_infirmier_supp)//meme code que au dessu
                {     
                      table="infirmier";  
                      id_no="numero";
                      String miss1[] = combo_infirmier_supp.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[0];
                      dernier_suppr(combo_infirmier_supp);
                }
                
                if (source ==combo_malade_supp)//meme code que au dessu
                {     
                      table="malade";
                      id_no="numero";
                      String miss1[] = combo_malade_supp.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[0];
                      dernier_suppr(combo_malade_supp);
                }
                
                if (source ==combo_service_supp)//meme code que au dessu
                {     
                      table="service";  
                      id_no="code";
                      String miss1[] = combo_service_supp.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[0];
                      dernier_suppr(combo_service_supp);
                }
                
                if (source ==combo_soigne_supp)//meme code que au dessu
                {     
                      table="soigne";  
                      String miss1[] = combo_soigne_supp.getSelectedItem().toString().split(","); //on recupere chaque attribut de la ligne
                      no=miss1[0];
                      id_no=miss1[1];
                      dernier_suppr(combo_soigne_supp);
                }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                //MODIFICATION
                //si on a choisis dans la jbox, creation de la derniere fenetre de modification
                if (source == combo_choix_modif)
                {
                    
                    choix_sql=combo_choix_modif.getSelectedItem().toString();
                    String[] tmp = choix_sql.split(":"); //le choix fait est le choix dans le jcombo en bas de la fenetre
                    id_colonne=tmp[0];
                    derniere = new JFrame("Entrez les modifications de : "+tmp[1]);
                    derniere.setSize(1000,500);
                    derniere.setLocationRelativeTo(null);
                    derniere.setResizable(false);
                    JPanel dernier = new JPanel();
                    dernier.setLayout(new FlowLayout());
                    dernier.setBackground(Color.WHITE);
                    dernier_field = new JTextField(tmp[1]);
                    dernier_bouton = new JButton("VALIDER");
                    dernier_bouton.addActionListener(new ItemAction());
                    //on assemble la fenetre
                    dernier.add(dernier_field);
                    dernier.add(dernier_bouton);
                    derniere.add("Center",dernier);
                    derniere.setVisible(true);
                }
                
                
                
                
                
                
                
                
                
                //DERNIERES PAGES
                
                
                //modification
                if (source == dernier_bouton)//si le dernier bouton est cliqué, on fait la mise a jour
                {
                    String modification = dernier_field.getText();
                    try {
                            Gestion_MAJ g = new Gestion_MAJ();
                            g.modification(table,id_no, no,id_colonne,modification);//String table , String id_no ,String no, String id_colonne,String modification
                            derniere.setVisible(false);
                            jframe_modif.setVisible(false);
                            jframe_MAJ.setVisible(false);
                            JFrame effectuey = new JFrame();
                            JPanel effectuey2 = new JPanel();
                            JLabel effectuey3 = new JLabel("MODIFICATION EFFECTUE");
                            effectuey2.add("Center", effectuey3);
                            effectuey.add(effectuey2);
                            effectuey.setSize(200,100);
                            effectuey.setLocationRelativeTo(null);
                            effectuey.setResizable(false);
                            effectuey.setVisible(true);
                            
                        }
                    catch (SQLException ex) {Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);}
                    catch (ClassNotFoundException ex) {Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);}
                }
                
                
                
                
                
                
                
                
                //SUPPRESSION
                if (source == dernier_bouton_supp)//si le dernier bouton est cliqué, on SUPPRIME la ligne
                {
                    try {
                            Gestion_MAJ g = new Gestion_MAJ();
                            g.suppression(table,id_no,no);//String table , String id_no ,String no
                            
                            
                            derniere_supp.setVisible(false);
                            jframe_supp.setVisible(false);
                            jframe_MAJ.setVisible(false);
                            JFrame effectuey = new JFrame();
                            JPanel effectuey2 = new JPanel();
                            JLabel effectuey3 = new JLabel("SUPPRESSION EFFECTUE");
                            effectuey2.add("Center", effectuey3);
                            effectuey.add(effectuey2);
                            effectuey.setSize(200,100);
                            effectuey.setLocationRelativeTo(null);
                            effectuey.setVisible(true);
                            
                        }
                    catch (SQLException ex) {Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);}
                    catch (ClassNotFoundException ex) {Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);}
                }
                
                
                
                
                
                
                
                
                //AJOUT
                if((source == bouton_inserer_chambre)||(source == bouton_inserer_docteur)||(source == bouton_inserer_employe)||(source == bouton_inserer_hospitalisation)||(source == bouton_inserer_infirmier)||(source == bouton_inserer_malade)||(source == bouton_inserer_service)||(source == bouton_inserer_soigne))
                {
                    
                        //objet de gestion maj
                        
                        //sous composant de MODIFICATION:
                        jframe_inser2= new JFrame("Ajout");
                        jframe_inser2.setSize(1000, 130);
                        jframe_inser2.setLocationRelativeTo(null);
                        jframe_inser2.setResizable(false);

                        //la barre du haut
                        jpanel_inser2_haut = new JPanel();
                        jpanel_inser2_haut.setLayout(new GridLayout(1,1));
                        label_inser2 = new JLabel("Remplissez les champs suivant pour proceder à l'ajout");
                        label_inser2.setBackground(Color.LIGHT_GRAY);
                        //barre du millieu
                        jpanel_inser2_millieu = new JPanel();
                        jpanel_inser2_millieu.setLayout(new GridLayout(1,5));//mission =5 colonnes
                        //les boutons + actions listeners
                        bouton_inser_valider = new JButton("Valider");
                        bouton_inser_valider.setBackground(Color.orange);
                        bouton_inser_valider.addActionListener(new ItemAction());

                        
                        //on assemble le tout
                        jpanel_inser2_haut.add(label_inser2);
                        
                        if(source==bouton_inserer_chambre)
                        {
                            for(int i =0; i<text_inser_chambre.length ;i++)
                            {
                                jpanel_inser2_millieu.add(text_inser_chambre[i]);
                            }
                            chambre=true;
                        }
                        
                        if(source==bouton_inserer_docteur)
                        {
                            for(int i =0; i<text_inser_docteur.length ;i++)
                            {
                                jpanel_inser2_millieu.add(text_inser_docteur[i]);
                            }
                            docteur=true;
                        }
                        if(source==bouton_inserer_employe)
                        {
                            for(int i =0; i<text_inser_employe.length ;i++)
                            {
                                jpanel_inser2_millieu.add(text_inser_employe[i]);
                            }
                            employe=true;
                        }
                        if(source==bouton_inserer_hospitalisation)
                        {
                            for(int i =0; i<text_inser_hospitalisation.length ;i++)
                            {
                                jpanel_inser2_millieu.add(text_inser_hospitalisation[i]);
                            }
                            hospitalisation=true;
                        }
                        if(source==bouton_inserer_infirmier)
                        { 
                            for(int i =0; i<text_inser_infirmier.length ;i++)
                            {
                                jpanel_inser2_millieu.add(text_inser_infirmier[i]);
                            }
                            infirmier=true;
                        }
                        if(source==bouton_inserer_malade)
                        {
                            for(int i =0; i<text_inser_malade.length ;i++)
                            {
                                jpanel_inser2_millieu.add(text_inser_malade[i]);
                            }
                            malade=true;
                        }
                        if(source==bouton_inserer_service)
                        {
                            for(int i =0; i<text_inser_service.length ;i++)
                            {
                                jpanel_inser2_millieu.add(text_inser_service[i]);
                            }
                            service=true;
                        }
                        if(source==bouton_inserer_soigne)
                        {
                            for(int i =0; i<text_inser_soigne.length ;i++)
                            {
                                jpanel_inser2_millieu.add(text_inser_soigne[i]);
                            }
                            soigne=true;
                        }

                        jpanel_inser2_millieu2= new JPanel();
                        jpanel_inser2_millieu2.add(bouton_inser_valider);

                        //on localise les pannels dans le jframe et on les ajoutes
                        jframe_inser2.add("North",jpanel_inser2_haut);
                        jframe_inser2.add("Center", jpanel_inser2_millieu);
                        jframe_inser2.add("South",jpanel_inser2_millieu2);
                        jframe_inser2.setVisible(true);

                }
                
                
                
                
                
                
                
                
                if (source==bouton_inser_valider)
                {       
                try {

                        Gestion_MAJ gestion_inser = new Gestion_MAJ();
                        if(chambre==true)
                        {   table="chambre";
                            String[] insertion = new String[text_inser_chambre.length];
                            for(int i=0;i<text_inser_chambre.length;i++)
                            {
                                insertion[i]=text_inser_chambre[i].getText();
                            }
                            gestion_inser.inserer_ligne(table,insertion);
                            chambre=false;
                        }
                        if(docteur==true)
                        {   table="docteur";
                            String[] insertion = new String[text_inser_docteur.length];
                            for(int i=0;i<text_inser_docteur.length;i++)
                            {
                                insertion[i]=text_inser_docteur[i].getText();
                            }
                            gestion_inser.inserer_ligne(table,insertion);
                            docteur=false;
                        }
                        if(employe==true)
                        {   table="employe";
                            String[] insertion = new String[text_inser_employe.length];
                            for(int i=0;i<text_inser_employe.length;i++)
                            {
                                insertion[i]=text_inser_employe[i].getText();
                            }
                            gestion_inser.inserer_ligne(table,insertion);
                            employe=false;
                        }
                        if(hospitalisation==true)
                        {   table="hospitalisation";
                            String[] insertion = new String[text_inser_hospitalisation.length];
                            for(int i=0;i<text_inser_hospitalisation.length;i++)
                            {
                                insertion[i]=text_inser_hospitalisation[i].getText();
                            }
                            gestion_inser.inserer_ligne(table,insertion);
                            hospitalisation=false;
                        }
                        if(infirmier==true)
                        {   table="infirmier";
                            String[] insertion = new String[text_inser_infirmier.length];
                            for(int i=0;i<text_inser_infirmier.length;i++)
                            {
                                insertion[i]=text_inser_infirmier[i].getText();
                            }
                            gestion_inser.inserer_ligne(table,insertion);
                            infirmier=false;
                        }
                        if(malade==true)
                        {   table="malade";
                            String[] insertion = new String[text_inser_malade.length];
                            for(int i=0;i<text_inser_malade.length;i++)
                            {
                                insertion[i]=text_inser_malade[i].getText();
                            }
                            gestion_inser.inserer_ligne(table,insertion);
                            malade=false;
                        }
                        if(service==true)
                        {   table="service";
                            String[] insertion = new String[text_inser_service.length];
                            for(int i=0;i<text_inser_service.length;i++)
                            {
                                insertion[i]=text_inser_service[i].getText();
                            }
                            gestion_inser.inserer_ligne(table,insertion);
                            service=false;
                        }
                        if(soigne==true)
                        {   table="soigne";
                            String[] insertion = new String[text_inser_soigne.length];
                            for(int i=0;i<text_inser_soigne.length;i++)
                            {
                                insertion[i]=text_inser_soigne[i].getText();
                            }
                            gestion_inser.inserer_ligne(table,insertion);
                            soigne=false;
                        }
                        
                        
                        


                            jframe_inser1.setVisible(false);
                            jframe_inser2.setVisible(false);
                            JFrame effectuey = new JFrame();
                            JPanel effectuey2 = new JPanel();
                            JLabel effectuey3 = new JLabel("AJOUT EFFECTUE");
                            effectuey2.add("Center", effectuey3);
                            effectuey.add(effectuey2);
                            effectuey.setSize(200,100);
                            effectuey.setLocationRelativeTo(null);
                            effectuey.setVisible(true);
                        
                    
                    } 

                catch (SQLException | ClassNotFoundException ex) {Logger.getLogger(MiseAJour.class.getName()).log(Level.SEVERE, null, ex);}

                
                }
                
                
                

      
    }               

  }



    



    
    
    
    
}
