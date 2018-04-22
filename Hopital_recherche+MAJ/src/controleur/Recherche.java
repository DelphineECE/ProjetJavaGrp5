/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import modele.Connexion;
import vue.graphique;
import modele.Connexion;

/**
 *
 * @author USER
 */
public class Recherche {
    
    private Connexion conn;
    private ArrayList<String> liste_chambre,liste_docteur,liste_employe,liste_hospitalisation,liste_infirmier,liste_malade,liste_service,liste_soigne;
    private ArrayList<String> requette_1;
    JTextArea jtextarea_rep;
    JLabel jtextarea_rep2;
    JFrame jframe_rep = new JFrame("Resultat");
    JPanel jpanel_rep,jpanel_rep2;
    String phrase;
    
        public Recherche() throws SQLException, ClassNotFoundException
    {

        //connexion + requette
        conn = new Connexion("hopital","root","");
        conn.ajouterTable("chambre");
        conn.ajouterTable("docteur");
        conn.ajouterTable("employe");
        conn.ajouterTable("hospitalisation");
        conn.ajouterTable("infirmier");
        conn.ajouterTable("malade");
        conn.ajouterTable("service");
        conn.ajouterTable("soigne");
        
        
        //on recupere les tables
        liste_chambre = conn. remplirChampsRequete("SELECT * FROM chambre;");
        liste_docteur = conn. remplirChampsRequete("SELECT * FROM docteur;");
        liste_employe = conn. remplirChampsRequete("SELECT * FROM employe;");
        liste_hospitalisation = conn. remplirChampsRequete("SELECT * FROM hospitalisation;");
        liste_infirmier = conn. remplirChampsRequete("SELECT * FROM infirmier;");
        liste_malade = conn. remplirChampsRequete("SELECT * FROM malade;");
        liste_service = conn. remplirChampsRequete("SELECT * FROM service;");
        liste_soigne = conn. remplirChampsRequete("SELECT * FROM soigne;");
                
    }
    
         /**
         * renvoi le tableau de toutes les chambres
         * @return 
         */
    public String[] les_chambre() 
    {
            int indice_tab=0;
            String[] mes_chambres = new String [liste_chambre.size()];  
            for(String liste1 : liste_chambre)
            {
                    if(liste1!=null)
                    {
                        mes_chambres[indice_tab]=liste1;
                        indice_tab=indice_tab+1;
                    }
                    
   
            }
       return mes_chambres;
    
    }
         /**
         * renvoi le tableau de toutes les docteurs
         * @return 
         */
    public String[] les_docteur() 
    {
            int indice_tab=0;
            String[] mes_docteurs = new String [liste_docteur.size()];  
            for(String liste1 : liste_docteur)
            {
                    if(liste1!=null)
                    {
                        mes_docteurs[indice_tab]=liste1;
                        indice_tab=indice_tab+1;
                    }
                    
   
            }
       return mes_docteurs;
    
    }
        /**
         * renvoi le tableau de toutes les hospitalisations
         * @return 
         */
        
    public String[] les_hospitalisation() 
    {
            int indice_tab=0;
            String[] mes_hospitalisations = new String [liste_hospitalisation.size()]; 
            for(String liste1 : liste_hospitalisation)
            {
                    if(liste1!=null)
                    {
                        mes_hospitalisations[indice_tab]=liste1;
                        indice_tab=indice_tab+1;
                    }
                    
   
            }
       return mes_hospitalisations;
    
    }
         /**
         * renvoi le tableau de toutes les hospitalisations
         * @return 
         */
    public String[] les_infirmier() 
    {
            int indice_tab=0;
            String[] mes_infirmiers = new String [liste_infirmier.size()]; //200 car X lignes dans la fenetre modifier connexion de mise a jour 
            for(String liste1 : liste_infirmier)
            {
                    if(liste1!=null)
                    {
                        mes_infirmiers[indice_tab]=liste1;
                        indice_tab=indice_tab+1;
                    }
                    
   
            }
       return mes_infirmiers;
    
    }
    
            /**
         * renvoi le tableau de tout les malades
         * @return 
         */
        //renvoi le tableau de toutes les malades
    public String[] les_malade() 
    {
            int indice_tab=0;
            String[] mes_malades = new String [liste_malade.size()]; //200 car X lignes dans la fenetre modifier connexion de mise a jour 
            for(String liste1 : liste_malade)
            {
                    if(liste1!=null)
                    {
                        mes_malades[indice_tab]=liste1;
                        indice_tab=indice_tab+1;
                    }
                    
   
            }
       return mes_malades;
    
    }
         /**
         * renvoi le tableau de touts les services
         * @return 
         */

    public String[] les_service() 
    {
            int indice_tab=0;
            String[] mes_services = new String [liste_service.size()]; //200 car X lignes dans la fenetre modifier connexion de mise a jour 
            for(String liste1 : liste_service)
            {
                    if(liste1!=null)
                    {
                        mes_services[indice_tab]=liste1;
                        indice_tab=indice_tab+1;
                    }
                    
   
            }
       return mes_services;
    
    }
         /**
         * renvoi le tableau de toutes les soigne
         * @return 
         */
        
    public String[] les_soigne() 
    {
            int indice_tab=0;
            String[] mes_soignes = new String [liste_soigne.size()]; //200 car X lignes dans la fenetre modifier connexion de mise a jour 
            for(String liste1 : liste_soigne)
            {
                    if(liste1!=null)
                    {
                        mes_soignes[indice_tab]=liste1;
                        indice_tab=indice_tab+1;
                    }
                    
   
            }
       return mes_soignes;
    
    }

         /**
         * renvoi le tableau de toutes les employes
         * @return 
         */
        public String[] les_employe()
    {
            int indice_tab=0;
            String[] mes_employe = new String [liste_employe.size()]; //320 car 8*40  40 lignes dans la fenetre modifier employés de mise a jour 
            for (String liste1 : liste_employe)
            {
                    mes_employe[indice_tab]=liste1;
                    indice_tab=indice_tab+1;
                
               
            }
       return mes_employe;
    
    }
    
    
    
        
        
        
        
        
        
        
        
     /**
     * fonction qui organise la reponse final dans l'attribut de classe jlabel_rep et l'affiche dans une fenetre
     * @param nb_colonnes 
     * @param reponses 
     */
    public void reponse(String[] reponses,String phrase)
    {
        //initialisation elements
        jframe_rep = new JFrame();
        
        jframe_rep.setVisible(true);
        //on met au point le jrame        
        jframe_rep.setSize(700,300);
        jframe_rep.setLocationRelativeTo(null);
        jframe_rep.setResizable(false);
        jpanel_rep = new JPanel();
        jpanel_rep2 = new JPanel();
        jtextarea_rep = new JTextArea();
        jtextarea_rep.setWrapStyleWord(true);
        jtextarea_rep2 = new JLabel(phrase);
        String[] contient_rep= new String [1000];
        String repfinal="";
        
        //boucle qui mets chaque
        for(int i=0;i<reponses.length;i++)
        {

            contient_rep[i]= reponses[i];
            repfinal=repfinal+contient_rep[i];
        }

       jtextarea_rep.setText(repfinal);
       jpanel_rep2.add(jtextarea_rep2);
       jpanel_rep.add(jtextarea_rep);
       jpanel_rep.setBackground(Color.WHITE);
       jframe_rep.add("Center",jpanel_rep);
       jframe_rep.add("North",jpanel_rep2);
    }
        
        
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
        //les requettes
        
        /**
         * requette 1 
         * @throws java.sql.SQLException
         */
    
        public void requette1() throws SQLException
        {
            
            int indice_tab=0; phrase="NOM - PRENOM";
            

            requette_1=conn.remplirChampsRequete("SELECT nom , prenom FROM malade WHERE mutuelle = 'MAAF' ;");
            
            String[] ma_requette = new String [requette_1.size()];
        for (String liste1 : requette_1) {
            ma_requette[indice_tab]=liste1;
            indice_tab=indice_tab+1;
        }
            

             reponse(ma_requette, phrase);
        
        }
        
        
        /**
         * deuxieme requette
         * @throws SQLException 
         */
        
        public void requette2() throws SQLException
        {
            
            int indice_tab=0; phrase="NOM - PRENOM";
            requette_1=conn.remplirChampsRequete("SELECT prenom, nom FROM employe WHERE numero IN (SELECT numero FROM infirmier WHERE rotation = 'NUIT');");
           
            String[] ma_requette = new String [requette_1.size()];
        for (String liste1 : requette_1) {
            ma_requette[indice_tab]=liste1;
            indice_tab=indice_tab+1;
        }

             reponse(ma_requette, phrase);
        
        }
        
        /**
         * 3e requette
         * @throws SQLException 
         */
        
        public void requette3() throws SQLException
        {
            
            int indice_tab=0; phrase="NOM - BATIMENT - PRENOM - NOM - SPECIALITE";
            requette_1=conn.remplirChampsRequete("SELECT S.nom , S.batiment , E.prenom , E.nom , D.specialite FROM service S , docteur D , employe E WHERE S.directeur = D.numero AND D.numero = E.numero ;");
            
            String[] ma_requette = new String [requette_1.size()];
        for (String liste1 : requette_1) {
            ma_requette[indice_tab]=liste1;
            indice_tab=indice_tab+1;
        }

             reponse(ma_requette, phrase);
        
        }
        
        /**
         * 4e requette
         * @throws SQLException 
         */
        
        public void requette4() throws SQLException
        {
            
            int indice_tab=0; phrase="NO_CHAMBRE - LIT - NOM - PRENOM - NOM - MUTUELLE";
            requette_1=conn.remplirChampsRequete("SELECT H.no_chambre, H.lit, S.nom, M.prenom, M.nom, M.mutuelle FROM service S, hospitalisation H, malade M WHERE S.batiment = 'B' AND S.code = H.code_service AND H.no_malade = M.numero AND M.mutuelle LIKE 'MN%' ;");
            
            String[] ma_requette = new String [requette_1.size()];
        for (String liste1 : requette_1) {
            ma_requette[indice_tab]=liste1;
            indice_tab=indice_tab+1;
        }

             reponse(ma_requette, phrase);
        
        }
        
        /**
         * 5e requette
         * @throws SQLException 
         */
        
        public void requette5() throws SQLException
        {
            
            int indice_tab=0; phrase="CODE_SERVICE - MOYENNE DES SALAIRES";
            requette_1=conn.remplirChampsRequete("SELECT code_service, cast(avg(salaire) AS decimal(10,2)) AS moyenne_des_salaires FROM infirmier GROUP BY code_service ;");
  
            String[] ma_requette = new String [requette_1.size()];
        for (String liste1 : requette_1) {
            ma_requette[indice_tab]=liste1;
            indice_tab=indice_tab+1;
        }

             reponse(ma_requette, phrase);
        
        }
        
        /**
         * 6e requette
         * @throws SQLException 
         */
        
        public void requette6() throws SQLException
        {
            
            int indice_tab=0; phrase="CODE_SERVICE - NB_MOYES_DE_LIT";
            requette_1=conn.remplirChampsRequete("SELECT code_service, cast(avg(nb_lits) AS decimal(3,1)) AS nb_moyen_de_lits FROM chambre WHERE code_service IN ( SELECT code FROM service WHERE batiment = 'A') GROUP BY code_service ;");
            
            String[] ma_requette = new String [requette_1.size()];
        for (String liste1 : requette_1) {
            ma_requette[indice_tab]=liste1;
            indice_tab=indice_tab+1;
        }

             reponse(ma_requette, phrase);
        
        }
        
        /**
         * 7e requette
         * @throws SQLException 
         */
        
        public void requette7() throws SQLException
        {
            
            int indice_tab=0; phrase="NOM - PRENOM - NB_SOIGNANTS - NB_SPECIALITE";
            requette_1=conn.remplirChampsRequete("SELECT m.nom, m.prenom, COUNT(*) AS nb_soignants, COUNT(distinct d.specialite) AS nb_specialites FROM docteur d, soigne so, malade m WHERE d.numero = so.no_docteur AND so.no_malade = m.numero GROUP BY m.nom, m.prenom HAVING COUNT(*) > 3 ;");
            
            String[] ma_requette = new String [requette_1.size()];
        for (String liste1 : requette_1) {
            ma_requette[indice_tab]=liste1;
            indice_tab=indice_tab+1;
        }

             reponse(ma_requette, phrase);
        
        }
        
        /**
         * 8e requette
         * @throws SQLException 
         */
        
        public void requette8() throws SQLException
        {
            
            int indice_tab=0; phrase="NOM - RAPPORT_I_SUR_M";
            requette_1=conn.remplirChampsRequete("SELECT nom, ( SELECT count(*) FROM infirmier i WHERE i.code_service = s.code ) / ( SELECT count(*) FROM hospitalisation h WHERE h.code_service = s.code ) AS rapport_i_sur_m FROM service s ;");
            
            String[] ma_requette = new String [requette_1.size()];
        for (String liste1 : requette_1) {
            ma_requette[indice_tab]=liste1;
            indice_tab=indice_tab+1;
        }

             reponse(ma_requette, phrase);
        
        }
        
        /**
         * 9e requette
         * @throws SQLException 
         */
        
        public void requette9() throws SQLException
        {
            
            int indice_tab=0; phrase="PRENOM - NOM";
            requette_1=conn.remplirChampsRequete("SELECT prenom, nom FROM employe WHERE numero IN ( SELECT no_docteur FROM soigne WHERE no_malade IN ( SELECT no_malade FROM hospitalisation ) ) ;");
            
            String[] ma_requette = new String [requette_1.size()];
        for (String liste1 : requette_1) {
            ma_requette[indice_tab]=liste1;
            indice_tab=indice_tab+1;
        }

             reponse(ma_requette, phrase);
        
        }
        
        /**
         * 10e requette
         * @throws SQLException 
         */
        
        public void requette10() throws SQLException
        {
            
            int indice_tab=0; phrase="PRENOM - NOM";
            requette_1=conn.remplirChampsRequete("SELECT prenom, nom FROM employe WHERE numero IN ( SELECT numero FROM docteur ) AND numero NOT IN ( SELECT no_docteur FROM soigne WHERE no_malade IN (SELECT no_malade FROM hospitalisation ));");
            
            String[] ma_requette = new String [requette_1.size()];
        for (String liste1 : requette_1) {
            ma_requette[indice_tab]=liste1;
            indice_tab=indice_tab+1;
        }

             reponse(ma_requette, phrase);
        
        }
    
    
    

        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
}
