/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsb.discountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author NStokesBeamon
 */
public class JOptionOutputStrategy implements OutputStrategy {

    @Override
    public void printLn(Receipt rec) {
        JOptionPane.showMessageDialog(null, rec.outputReceipt());
    }
    
   
}
