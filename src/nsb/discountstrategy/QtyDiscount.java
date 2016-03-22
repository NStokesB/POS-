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

    public final void setDiscountRate(double discountRate) throws IllegalArgumentException {

        if(discountRate <= 0) {
            throw new IllegalArgumentException (
                    "discount rate is too small");

        }
        this.discountRate = discountRate;
    }

    public final int getMinQty() {
        return minQty;
    }

    public final void setMinQty(int minQty)throws IllegalArgumentException {

        if(minQty < -1) {
            throw new IllegalArgumentException (
                    "quantity not valid");

        }
        this.minQty = minQty;
    }
    
    
}
