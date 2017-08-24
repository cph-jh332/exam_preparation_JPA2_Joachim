/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author craci
 */
@Entity
public class PaperBook extends Book implements Serializable {

    @Column(name = "shippingWeight")
    private double shippingWeight;
    
    @Column(name="inStock")
    private int inStock;

    /**
     * @return the shippingWeight
     */
    public double getShippingWeight() {
        return shippingWeight;
    }

    /**
     * @param shippingWeight the shippingWeight to set
     */
    public void setShippingWeight(double shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    /**
     * @return the inStock
     */
    public int getInStock() {
        return inStock;
    }

    /**
     * @param inStock the inStock to set
     */
    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    
}
