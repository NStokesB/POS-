/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsb.discountstrategy;

/**
 *
 * @author NStokesBeamon
 */
public class ConsoleOutput implements OutputStrategy {
    @Override
    public void printLn (Receipt rec){
        System.out.println(rec.outputReceipt());
    }
    
}
