package com.example.SmartShopping.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.SmartShopping.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Leonardo on 18-Oct-14.
 */
public class ShoppingActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);

        EditText productNameAdder = (EditText) this.findViewById(R.id.productNameAdder);
        EditText productBrandAdder = (EditText) this.findViewById(R.id.brandNameAdder);
        EditText productQuantity = (EditText) this.findViewById(R.id.quantityAdder);
        setInput(Arrays.asList(productNameAdder, productBrandAdder, productQuantity));



        Button addButton = (Button) this.findViewById(R.id.add);
        //addButton.setTypeface(font);
        addButton.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        Button editButton = (Button) this.findViewById(R.id.remove);
        //editButton.setTypeface(font);
        editButton.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }

    /**
     *
     * @param inputs
     */
    private void setInput(List<EditText> inputs){

        for (int i = 0; i < inputs.size(); i++) {
            inputs.get(i).setVisibility(View.GONE);
            inputs.get(i).setTextSize(getResources().getDimension(R.dimen.textSize));
            inputs.get(i).setFocusable(true);
        }
    }
}
