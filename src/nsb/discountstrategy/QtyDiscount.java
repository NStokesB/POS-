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
public class QtyDiscount implements DiscountStrategy {
    private double discountRate;
    private int minQty;
    private final int NO_DISCOUNT = 0;
    
    private QtyDiscount(double discountRate, int minQty){
        setDiscountRate(discountRate);
        setMinQty(minQty);
    }
    
    @Override
    public final double getDiscountAmt(int qty, double unitCost) {
        //needs validation
        if (qty >= minQty){
            return unitCost * qty * discountRate;
        }else {
            return NO_DISCOUNT;
        }
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) {
        //needs validation
        this.discountRate = discountRate;
    }

    public final int getMinQty() {
        return minQty;
    }

    public final void setMinQty(int minQty) {
        //needs validation
        this.minQty = minQty;
    }
    
    
}
