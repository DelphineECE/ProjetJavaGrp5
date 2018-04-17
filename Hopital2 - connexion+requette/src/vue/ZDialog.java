/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author delphine
 */
public class ZDialog extends JDialog {
    
    public ZDialog (JFrame parent, String title, boolean modal) {
        setTitle(title);
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
    }
    
}