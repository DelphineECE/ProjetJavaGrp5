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
    //private JButton boutonconnexion = new JButton("Connexion");
    CardLayout cl = new CardLayout();
    //private int monchoix=0;
    String[] listContent = {"Connexion", "MAJ", "Respori"};
    
    
    // contructeur
    public graphique () {
        
        setTitle("Gestion d'un hopital");
        setSize(1000,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pan = new JPanel();     // instancier le panneau
        getContentPane().add(pan, BorderLayout.CENTER);
        
        JPanel connexion = new JPanel();
        connexion.setBackground(Color.red);
        
        JPanel maj = new JPanel();
        maj.setBackground(Color.blue);
        
        JPanel repori = new JPanel();
        repori.setBackground(Color.green);
        
       
        
        //pan.add(boutonconnexion);
        setContentPane(pan);
        setVisible(true);
                
    }
    
    
    // methode pr affciher grille 
    
   /*public void affichegrille() {
        
        pan.setLayout(new GridLayout(5,5));
        boutons = new JButton[][];
        
        for (int i=0; i<10; i++) {
            boutons[i]=new JButton[laby.getTailleX()]; // pr chaque ligne, instancier les boutons
            
        }
        
        // ajouter les boutons dans le panneau
        for (int i=0; i<laby.getTailleY();i++) {
            for (int j=0; j<laby.getTailleX();j++) {
                boutons[i][j] = new JButton();
                pan.add(boutons[i][j]);
            }
        }
        //ajout des deux boutons pour le déplacement
        //ajouter les boutons de déplacement
       pan2.setLayout(new GridLayout(1,2)); // mise en forme avec une grille
       bouton1 = new JButton[2]; // instancier les lignes de la matrice de boutons
       bouton1[0] = new JButton("DFS"); // instancier chaque bouton
       bouton1[0].addActionListener(new BoutonListener());
       pan2.add(bouton1[0]);
       
       //bouton1[0].addActionListener(new BoutonListener());
       bouton1[1] = new JButton("Aleatoire"); // instancier chaque bouton
       bouton1[1].addActionListener(new Bouton2Listener());
       pan2.add(bouton1[1]);
    
        
        
        
        // Lire les cases du labyrinthe
        for (int y = 0; y < laby.getTailleY(); y++) { // lignes

            for (int x = 0; x < laby.getTailleX(); x++) {
                Case c = laby.getCase(y, x);
                if (c instanceof CaseMur) {  
                    ImageIcon imagemur = new ImageIcon("/Users/delphine/NetBeansProjects/tp3-Labyrinthe tom/b.jpg");
                    boutons[x][y].setIcon( imagemur);
 
                } else {
                    if (c.getVisited()) {
                        
                        ImageIcon imagesol = new ImageIcon("/Users/delphine/NetBeansProjects/tp3-Labyrinthe tom/noir.jpg");
                        boutons[x][y].setIcon( imagesol);
                        
                    } else {
                        
                        ImageIcon imageok = new ImageIcon("/Users/delphine/NetBeansProjects/tp3-Labyrinthe tom/c.jpg");
                        boutons[x][y].setIcon( imageok);
                    }
                }
            }
            
        }
        
        this.setVisible(true);

    } */
    
}
