/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import vue.graphique;

/**
 *
 * @author delphine
 */
public class main {
    
    private static graphique fen = new graphique();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        fen = new graphique(); //  instancier le graphique  
     
        fen.setVisible(true);
            
    }
    
}
