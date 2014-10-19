package com.example.SmartShopping.products;

/**
 * Created by Leonardo on 19-Oct-14.
 */
public class Quantity {

    private String productQuantity;

    /**
     *
     */
    public Quantity(){

    }

    /**
     *
     * @param name
     */
    public Quantity(String name){

        this.productQuantity = name;
    }

    /**
     *
     * @return
     */
    public String getProductQuantity() {
        return productQuantity;
    }

    /**
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productQuantity = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity quantity = (Quantity) o;

        if (productQuantity != null ? !productQuantity.equals(quantity.productQuantity) : quantity.productQuantity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return productQuantity != null ? productQuantity.hashCode() : 0;
    }

    @Override
    public String toString(){

        return ""+ productQuantity +"";
    }
}
