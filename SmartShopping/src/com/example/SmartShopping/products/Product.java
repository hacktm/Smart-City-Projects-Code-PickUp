package com.example.SmartShopping.products;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Leonardo on 19-Oct-14.
 */
public class Product {

    private Name productName;
    private Brand productBrand;
    private Quantity productQuantity;
    private Price productPrice;
    private Market productMarket;

    /**
     *
     */
    public Product(){

    }

    /**
     *
     * @param name
     * @param brand
     * @param quantity
     */
    public Product(Name name, Brand brand, Quantity quantity, Price price, Market market){

        this.productName = name;
        this.productBrand = brand;
        this.productQuantity = quantity;
        this.productPrice = price;
        this.productMarket = market;

    }

    public Name getProductName() {
        return productName;
    }

    public void setProductName(Name productName) {
        this.productName = productName;
    }

    public Brand getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(Brand productBrand) {
        this.productBrand = productBrand;
    }

    public Quantity getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Quantity productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Price getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Price productPrice) {
        this.productPrice = productPrice;
    }

    public Market getProductMarket() {
        return productMarket;
    }

    public void setProductMarket(Market productMarket) {
        this.productMarket = productMarket;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productBrand != null ? !productBrand.equals(product.productBrand) : product.productBrand != null)
            return false;
        if (productMarket != null ? !productMarket.equals(product.productMarket) : product.productMarket != null)
            return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productPrice != null ? !productPrice.equals(product.productPrice) : product.productPrice != null)
            return false;
        if (productQuantity != null ? !productQuantity.equals(product.productQuantity) : product.productQuantity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (productBrand != null ? productBrand.hashCode() : 0);
        result = 31 * result + (productQuantity != null ? productQuantity.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (productMarket != null ? productMarket.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){

        return ""+ productName + " " + productBrand + " " + productQuantity +"";
    }
}
