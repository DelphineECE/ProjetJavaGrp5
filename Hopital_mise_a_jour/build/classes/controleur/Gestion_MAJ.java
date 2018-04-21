/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import vue.graphique;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Connexion;
import modele.SSHTunnel;

/**
 *
 * @author USER
 */
public class Gestion_MAJ 
{
    
    Connexion conn;
    String nom_de_colonne;
    ArrayList<String> liste_chambre,liste_docteur,liste_employe,liste_hospitalisation,liste_infirmier,liste_malade,liste_service,liste_soigne;
            
    
    
    public Gestion_MAJ()throws SQLException, ClassNotFoundException
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
    //renvoi le tableau de toutes les chambres
    public String[] les_chambre() 
    {
            int indice_tab=0;
            String[] mes_chambres = new String [liste_chambre.size()]; //200 car X lignes dans la fenetre modifier connexion de mise a jour 
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
        //renvoi le tableau de toutes les docteurs
    public String[] les_docteur() 
    {
            int indice_tab=0;
            String[] mes_docteurs = new String [liste_docteur.size()]; //200 car X lignes dans la fenetre modifier connexion de mise a jour 
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
        //renvoi le tableau de toutes les hospitalisations
    public String[] les_hospitalisation() 
    {
            int indice_tab=0;
            String[] mes_hospitalisations = new String [liste_hospitalisation.size()]; //200 car X lignes dans la fenetre modifier connexion de mise a jour 
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
        //renvoi le tableau de toutes les infirmiers
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
        //renvoi le tableau de toutes les services
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
        //renvoi le tableau de toutes les soigne
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

        //renvoi le tableau de tout les employés
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
        

           
      
        
        
        
                
       //MODIFIER
       //methode qui va modifier le champ voulu dans la table voulu
        public void modification(String table , String id_no ,String no,String id_colonne,String modification) throws SQLException
    {
        System.out.print("UPDATE "+table+" SET "+ id_colonne +"='"+ modification +"' WHERE "+id_no+" LIKE "+no+";");
            conn.executeUpdate("UPDATE "+table+" SET "+ id_colonne +"='"+ modification +"' WHERE "+id_no+" LIKE "+no+";");
            
    }
        
        
        
        
        
        
        
        //SUPPRIMER
        
        public void suppression(String table , String id_no ,String no)throws SQLException
        {
            if(table=="soigne")
            {
                conn.executeUpdate("DELETE FROM "+table+" WHERE no_docteur LIKE "+no+" AND no_malade LIKE "+id_no+";");
            }
            else{conn.executeUpdate("DELETE FROM "+table+" WHERE "+id_no+" LIKE "+no+";");}
        }
        
        
        
        
        
        
        //INSERRER
        
        public void inserer_ligne(String table, String[] insertion) throws SQLException
        {
            String phrase="";
            for(int i=0;i<insertion.length;i++)
            {
                if(i==insertion.length-1)
                {
                    phrase=phrase+" '"+insertion[i]+"' ";
                }
                else{phrase=phrase+" '"+insertion[i]+"',";}
            }
            conn.executeUpdate("INSERT INTO "+table+" VALUES ("+phrase+")");
        }

                        
                        
                        
                        




}