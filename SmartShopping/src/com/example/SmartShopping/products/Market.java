package com.example.SmartShopping.products;

/**
 * Created by Leonardo on 19-Oct-14.
 */
public class Market {

    private String marketName;

    /**
     *
     */
    public Market(){

    }

    /**
     *
     * @param name
     */
    public Market(String name){

        this.marketName = name;
    }

    /**
     *
     * @return
     */
    public String getProductName() {
        return marketName;
    }

    /**
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.marketName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Market market = (Market) o;

        if (marketName != null ? !marketName.equals(market.marketName) : market.marketName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return marketName != null ? marketName.hashCode() : 0;
    }

    @Override
    public String toString(){

        return ""+ marketName +"";
    }
}
