package com.example.SmartShopping.convertor;

import com.example.SmartShopping.products.Product;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Leonardo on 19-Oct-14.
 */
public class JSONConverter {

    private JSONArray productsJSONArray;
    private JSONObject productsJSON;

    public JSONConverter(){

        productsJSON = new JSONObject();
        productsJSONArray = new JSONArray();
    }

    /**
     *
     */
    public void convertToJSON(Product product) {

        JSONObject obj = new JSONObject();

        try {
            obj.put("name", product.getProductName().getProductName());
            obj.put("brand", product.getProductBrand().getProductBrand());
            obj.put("quantity", product.getProductQuantity().getProductQuantity());
            productsJSONArray.put(obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param header
     */
    public void setJSONArrayHeader(String header){

        try {
            productsJSON.put(header, productsJSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONArray getProductsJSONArray() {
        return productsJSONArray;
    }

    public void setProductsJSONArray(JSONArray productsJSONArray) {
        this.productsJSONArray = productsJSONArray;
    }

    public JSONObject getProductsJSON() {
        return productsJSON;
    }

    public void setProductsJSON(JSONObject productsJSON) {
        this.productsJSON = productsJSON;
    }
}
