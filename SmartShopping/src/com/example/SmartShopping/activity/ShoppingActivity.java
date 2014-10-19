package com.example.SmartShopping.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.text.method.TextKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.SmartShopping.R;
import com.example.SmartShopping.adapter.ShoppingAdapter;
import com.example.SmartShopping.convertor.JSONConverter;
import com.example.SmartShopping.products.Brand;
import com.example.SmartShopping.products.Name;
import com.example.SmartShopping.products.Product;
import com.example.SmartShopping.products.Quantity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Leonardo on 18-Oct-14.
 */
public class ShoppingActivity extends ListActivity {

    private List<Product> products;
    private int productPosition;
    private ShoppingAdapter shoppingAdapter;
    private boolean isRemovable;
    private int editVerifier = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);

        products = new ArrayList<Product>();
        shoppingAdapter = new ShoppingAdapter(ShoppingActivity.this, products, isRemovable);

        final Button submitList = (Button) this.findViewById(R.id.submit);
        submitList.setVisibility(View.GONE);

        final EditText productNameAdder = (EditText) this.findViewById(R.id.productNameAdder);
        final EditText productBrandAdder = (EditText) this.findViewById(R.id.brandNameAdder);
        final EditText productQuantity = (EditText) this.findViewById(R.id.quantityAdder);
        setInput(Arrays.asList(productNameAdder, productBrandAdder, productQuantity));

        Button addButton = (Button) this.findViewById(R.id.add);
        addButton.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                productNameAdder.setVisibility(View.VISIBLE);
                productBrandAdder.setTextSize(getResources().getDimension(R.dimen.textSize));
                productBrandAdder.setVisibility(View.VISIBLE);
                productBrandAdder.setTextSize(getResources().getDimension(R.dimen.textSize));
                productQuantity.setVisibility(View.VISIBLE);
                productQuantity.setTextSize(getResources().getDimension(R.dimen.textSize));
                submitList.setVisibility(View.GONE);
            }
        });

        productNameAdder.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    productNameAdder.setVisibility(View.GONE);
                    productNameAdder.setText("");
                }
                return false;
            }
        });

        productNameAdder.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {
                    String input = productNameAdder.getText().toString();

                    if (!input.isEmpty()) {

                        Product product = new Product();
                        product.setProductName(new Name(input));
                        product.setProductBrand(new Brand(""));
                        product.setProductQuantity(new Quantity(""));
                        products.add(product);
                        productPosition = products.size() - 1;
                        shoppingAdapter.setPlayers(products);
                        shoppingAdapter.notifyDataSetChanged();
                        productNameAdder.setVisibility(View.GONE);
                        TextKeyListener.clear(productNameAdder.getText());
                        hideKeyboard(productNameAdder);
                    } else {
                        Toast.makeText(ShoppingActivity.this, "Write the name!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        productBrandAdder.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    productBrandAdder.setVisibility(View.GONE);
                    productBrandAdder.setText("");
                }
                return false;
            }
        });

        productBrandAdder.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {
                    String input = productBrandAdder.getText().toString();

                    if (!input.isEmpty()) {

                        Product product = products.get(productPosition);
                        product.setProductBrand(new Brand(input));
                        products.set(productPosition, product);
                        shoppingAdapter.setPlayers(products);
                        shoppingAdapter.notifyDataSetChanged();
                        productBrandAdder.setVisibility(View.GONE);
                        TextKeyListener.clear(productBrandAdder.getText());
                        hideKeyboard(productBrandAdder);
                    } else {
                        Toast.makeText(ShoppingActivity.this, "Write the brand!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        productQuantity.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    productQuantity.setVisibility(View.GONE);
                    productQuantity.setText("");
                }
                return false;
            }
        });

        productQuantity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {
                    String input = productQuantity.getText().toString();

                    if (!input.isEmpty()) {

                        Product product = products.get(productPosition);
                        product.setProductQuantity(new Quantity(input));
                        products.set(productPosition, product);
                        shoppingAdapter.setPlayers(products);
                        shoppingAdapter.notifyDataSetChanged();
                        productQuantity.setVisibility(View.GONE);
                        TextKeyListener.clear(productQuantity.getText());
                        hideKeyboard(productQuantity);
                        submitList.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(ShoppingActivity.this, "Write the quantity!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        Button removeButton = (Button) this.findViewById(R.id.remove);
        removeButton.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!products.isEmpty()) {
                    editVerifier++;

                    if (editVerifier % 2 == 0) {
                        isRemovable = true;
                        shoppingAdapter.setEditable(isRemovable);
                    } else {
                        isRemovable = false;
                        shoppingAdapter.setEditable(isRemovable);
                    }
                } else {
                    isRemovable = false;
                    shoppingAdapter.setEditable(isRemovable);
                    Toast.makeText(ShoppingActivity.this, "Add some products first!", Toast.LENGTH_LONG).show();
                }
            }
        });

        submitList.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        submitList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                JSONConverter jsonConverter = new JSONConverter();

                for (int i = 0; i < products.size(); i++){

                    jsonConverter.convertToJSON(products.get(i));
                }

                jsonConverter.setJSONArrayHeader("products");

                System.out.println(jsonConverter.getProductsJSON().toString());
                //ConnectionThread connectionThread = new ConnectionThread();
                //connectionThread.execute(urlAddress);
            }

        });

        setListAdapter(shoppingAdapter);
    }

    /**
     * @param inputs
     */
    private void setInput(List<EditText> inputs) {

        for (int i = 0; i < inputs.size(); i++) {
            inputs.get(i).setVisibility(View.GONE);
            inputs.get(i).setTextSize(getResources().getDimension(R.dimen.textSize));
            inputs.get(i).setFocusable(true);
        }
    }

    /**
     *
     */
    private void hideKeyboard(EditText editText) {

        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
