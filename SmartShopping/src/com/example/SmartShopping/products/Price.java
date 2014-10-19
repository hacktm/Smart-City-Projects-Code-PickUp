package com.example.SmartShopping.products;

/**
 * Created by Leonardo on 19-Oct-14.
 */
public class Price {

    private String priceValue;

    /**
     *
     */
    public Price(){

    }

    /**
     *
     * @param name
     */
    public Price(String name){

        this.priceValue = name;
    }

    /**
     *
     * @return
     */
    public String getProductPrice() {
        return priceValue;
    }

    /**
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.priceValue = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (priceValue != null ? !priceValue.equals(price.priceValue) : price.priceValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return priceValue != null ? priceValue.hashCode() : 0;
    }

    @Override
    public String toString(){

        return ""+ priceValue +"";
    }
}
