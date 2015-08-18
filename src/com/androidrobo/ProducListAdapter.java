package com.androidrobo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidrobo.R;

public class ProducListAdapter extends BaseAdapter {
 
    private List _productList;
    private Context _context;
 
    public ProducListAdapter(Context context, List products) {
        _context = context;
        _productList = products;
    }
 
    static class ViewHolder {
        protected TextView textViewProductId, textViewProductDescription,
                textViewProductPrice;
    }
 
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
 
        ViewHolder holder = null;
        LayoutInflater inflater = LayoutInflater.from(_context);
 
        if (convertView == null) {
 
            convertView = inflater.inflate(R.layout.product_list_row, null);
            holder = new ViewHolder();
 
            holder.textViewProductId = (TextView) convertView
                    .findViewById(R.id.listProductId);
            holder.textViewProductDescription = (TextView) convertView
                    .findViewById(R.id.listProductDescription);
            holder.textViewProductPrice = (TextView) convertView
                    .findViewById(R.id.listProductPrice);
 
            convertView.setTag(holder);
 
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
 
        Product product = (Product) _productList.get(position);
 
        if (product != null) {
 
            try {
 
                holder.textViewProductId.setText(String.format(_context
                        .getString(R.string.list_product_code_format,
                                product.getCode())));
                holder.textViewProductDescription.setText(String
                        .format(_context.getString(
                                R.string.list_product_description_format,
                                product.getDescription())));
                holder.textViewProductPrice.setText(String.format(_context
                        .getString(R.string.list_product_price_format,
                                String.valueOf(product.getPrice()))));
 
            } catch (Exception e) {
                e.printStackTrace();
            }
 
        }
 
        return convertView;
    }
 
    @Override
    public int getCount() {
        return _productList.size();
    }
 
    @Override
    public Object getItem(int pos) {
        return _productList.get(pos);
    }
 
    @Override
    public long getItemId(int pos) {
        return pos;
    }
}