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
public class Customer {
    private String custId;
    private String custName;

    public Customer(String custId, String custName) {
        setCustId(custId);
        setCustName(custName);
    }

    public final String getCustId() {
        return custId;
    }

    public final void setCustId(String custId)throws IllegalArgumentException {

        if(custId == null || custId.length() != 2) {
            throw new IllegalArgumentException (
                    "cust Id must be 2 characters in length");

        }
        this.custId = custId;
    }

    public final String getCustName() {
        return custName;
    }

    public final void setCustName(String custName) throws IllegalArgumentException {

        if(custName == null || custName.length() != 2) {
            throw new IllegalArgumentException (
                    "cust name must be 2 characters in length");

        }
        this.custName = custName;
    }

    
}