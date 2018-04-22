/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import modele.Connexion;

/**
 *
 * @author delphine
 */
public class ZDialog extends JDialog {
    
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    private Connexion maconnexion;
    /**
     * ArrayList public pour les tables
     */
    public ArrayList<String> tables = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> requetes = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<>();

    
    public ZDialog (JFrame parent, String title, boolean modal) {
        setTitle(title);
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
    }
    
    
    
    public void ajouterTable(String table) {
        tables.add(table);
    }
    
     /**
     * Méthode privée qui initialise la liste des tables
     */
    public void remplirTables() throws SQLException, ClassNotFoundException {
        
        Connexion maconnexion =new Connexion("hopital","root","root");
        maconnexion.ajouterTable("service");
        maconnexion.ajouterTable("chambre");
        
    }
    
    
    
    
}