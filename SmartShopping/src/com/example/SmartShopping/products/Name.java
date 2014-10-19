package com.example.SmartShopping.products;

/**
 * Created by Leonardo on 19-Oct-14.
 */
public class Name {

    private String productName;

    /**
     *
     */
    public Name(){

    }

    /**
     *
     * @param name
     */
    public Name(String name){

        this.productName = name;
    }

    /**
     *
     * @return
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        if (productName != null ? !productName.equals(name.productName) : name.productName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return productName != null ? productName.hashCode() : 0;
    }

    @Override
    public String toString(){

        return ""+ productName +"";
    }
}
