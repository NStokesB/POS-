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
public class Receipt {
    private DatabaseStrategy db;
    private Customer customer;
    private LineItem line;
    private LineItem[] lineItems;
    

    public Receipt(String custId, DatabaseStrategy db) {
        setCustomer(db.findCustomerById(custId));
        setDb(db);
        lineItems = new LineItem[0];
        
    }
    
    public final void addItemToReceipt(String prodId, int qty){
        LineItem item = new LineItem(prodId, qty, db);
        addItemToArray(lineItems, item);
        
//        LineItem[] tempArray = new LineItem[lineItems.length + 1];
//        
//        System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
//        tempArray[tempArray.length - 1] = item;
//        lineItems = tempArray;
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) {
        //needs validation
        this.lineItems = lineItems;
    }
    
    private void addItemToArray(LineItem[] origArray, LineItem item){
        LineItem[] tempArray = new LineItem[origArray.length + 1];
        
        System.arraycopy(origArray, 0, tempArray, 0, origArray.length);
        tempArray[tempArray.length - 1] = item;
        origArray = tempArray;
        lineItems = origArray;
    }

    public final DatabaseStrategy getDb() {
        return db;
    }

    public final void setDb(DatabaseStrategy db) {
        //needs validation
        this.db = db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        //needs validation
        this.customer = customer;
    }
    
    public final String outputReceipt(){
        double totalBeforeDiscount = 0;
        double totalAfterDiscount = 0;
        double totalDiscount = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("Thank you ").append(customer.getCustName() + "  \n");
        sb.append("For Shopping at Kohls Department Store   \n");
        sb.append("\n");
        sb.append("\n");
        
        
        sb.append( "ProdID          Item              UnitCost           Qty              Ext. Price         Discount     \n" + 
                  "----------------------------------------------------------------------------------------------------------- \n" );
           LineItem[] items =getLineItems();
            for(LineItem item : items) {
            totalBeforeDiscount += item.getExtPrice();
            totalAfterDiscount += (item.getExtPrice() - item.getDiscount());
            totalDiscount += item.getDiscount();
            
           sb.append(item.getLineItemData());
            }
           sb.append("\n");
           sb.append("\n");
           

           sb.append("                                                                           Grand Total: \n");
           sb.append("                                                                           Total Before discount: ").append(totalBeforeDiscount + " \n");
           sb.append("                                                                           Total After Discount: ").append(totalAfterDiscount + " \n");
           sb.append("                                                                           Total Saved Today: ").append(totalDiscount + " \n");
           
    return sb.toString();
    }
}