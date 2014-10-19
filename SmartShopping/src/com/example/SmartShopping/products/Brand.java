package com.example.SmartShopping.products;

/**
 * Created by Leonardo on 19-Oct-14.
 */
public class Brand {

    private String productBrand;

    /**
     *
     */
    public Brand(){

    }

    /**
     *
     * @param name
     */
    public Brand(String name){

        this.productBrand = name;
    }

    /**
     *
     * @return
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productBrand = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        if (productBrand != null ? !productBrand.equals(brand.productBrand) : brand.productBrand != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return productBrand != null ? productBrand.hashCode() : 0;
    }

    @Override
    public String toString(){

        return ""+ productBrand +"";
    }
}
