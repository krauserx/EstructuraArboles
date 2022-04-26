/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuraaboles;

import javax.swing.JOptionPane;

/**
 *
 * @author kraus
 */
public class EstructuraAboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          try{
        clsArbol arbolito = new clsArbol();
        arbolito.menu();
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Salio del Programa");
            
        }
        
    }
    
}
