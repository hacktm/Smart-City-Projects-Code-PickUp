package com.example.SmartShopping.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.example.SmartShopping.R;
import com.example.SmartShopping.products.Product;

import java.util.List;

/**
 * Created by Leonardo on 18-Oct-14.
 */
public class ShoppingAdapter extends ArrayAdapter {

    private List<Product> products;
    private Activity activity;
    private boolean isRemovable;
    private boolean isScoreEditable;

    /**
     * @param activity
     * @param products
     */
    public ShoppingAdapter(Activity activity, List<Product> products, boolean isRemovable) {

        super(activity, R.layout.shoppinglist, products);
        this.activity = activity;
        this.products = products;
        this.isRemovable = isRemovable;
        setNotifyOnChange(true);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {

        final ViewHolder holder;

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.shoppinglist, viewGroup, false);

            holder = new ViewHolder();
            holder.nameBrand = (TextView) convertView.findViewById(R.id.nameBrand);
            holder.nameBrand.setTextSize(activity.getResources().getDimension(R.dimen.textSize));

            holder.quantity = (TextView) convertView.findViewById(R.id.quantity);
            holder.quantity.setTextSize(activity.getResources().getDimension(R.dimen.textSize));

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Product product = products.get(position);

        deleteData(holder.nameBrand, position);
        deleteData(holder.quantity, position);

        holder.nameBrand.setText(String.valueOf(product.getProductName() + " " + product.getProductBrand()));
        holder.quantity.setText(String.valueOf(product.getProductQuantity()));
        convertView.setSaveEnabled(true);

        System.out.println(products);
        return convertView;
    }

    /**
     * @param isRemovable
     */
    public void setEditable(boolean isRemovable) {

        this.isRemovable = isRemovable;
    }

    /**
     * @param products
     */
    public void setPlayers(List<Product> products) {

        this.products = products;
    }

    /**
     *
     * @param textView
     * @param position
     */
    private void deleteData(TextView textView, final int position){

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isRemovable) {

                    products.remove(position);
                    notifyDataSetChanged();
                }
                else {

                    isScoreEditable = true;
                }
            }
        });
    }

    /**
     *
     */
    protected class ViewHolder {

        protected TextView nameBrand;
        protected TextView quantity;
    }
}
