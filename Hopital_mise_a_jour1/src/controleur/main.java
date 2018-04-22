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
 * @author delphine
 */
public class main {
    
    private static graphique fen ;

    /**
     * @param args the command line arguments
     * @param s
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @params
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        
        fen = new graphique(); //  instancier le graphique  
        
        
        
//        //connexion + requette
//        Connexion conn = new Connexion("hopital","root","");
//        conn.ajouterTable("dept");
//        conn.ajouterTable("emp");
//        conn.ajouterTable("mission");
//        
//        ArrayList<String> liste;
//        // recupérér les résultats de la requete selectionnee       
//        liste = conn. remplirChampsRequete("SELECT * FROM emp ;");
//        // afficher les lignes de la requete selectionnee a partir de la liste
//            for (String liste1 : liste)
//            {
//                System.out.println(liste1);
//            }
        
            
    }
    
}
