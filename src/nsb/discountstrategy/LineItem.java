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
public class LineItem {
    private Product product;
    private Customer customer;
    private int qty;

    public LineItem(String prodId, int qty, DatabaseStrategy db) {
        setProduct(db.findProductById(prodId));
        this.qty = qty;
    }

    public LineItem() {
    }
    
     public String getLineItemData(){
        String data =              
                 this.getProduct().getProdId() + "        " + this.getProduct().getProdName()
                + "              " + this.getProduct().getUnitCost() + "               " + this.getQty() + "              " + String.format("%.2f", this.getExtPrice()) + "               " + String.format("%.2f", this.getDiscount()) + "  \n" ;
                         
                return data;
     }
   
      public final double getExtPrice() {
        return qty * product.getUnitCost();
    }
     
    public final double getSubTotal(double unitCost, int qty){
        return this.getProduct().getUnitCost() * this.qty;
    }

    public final double getDiscount(){
        return this.getProduct().getDiscount().getDiscountAmt(qty, product.getUnitCost());
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        //need validation
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        //needs validation
        this.qty = qty;
    }
    
    
}
