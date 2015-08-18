package com.androidrobo;

import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import java.sql.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.androidrobo.R;
import com.google.inject.Inject;

@ContentView(R.layout.product_list)
public class ProductListActivity extends RoboActivity {
 
    @Inject
    private IProductRepo _productRepo;
 
    @InjectView(R.id.listviewProduct)
    private ListView _listViewProduct;
 
    @InjectView(R.id.buttonProductAdd)
    private Button _buttonProductAdd;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        try {
 
            List products = _productRepo.GetProducts();
            ProducListAdapter producListAdapter = new ProducListAdapter(
                    getApplicationContext(), products);
            _listViewProduct.setAdapter(producListAdapter);
 
            _buttonProductAdd.setOnClickListener(new View.OnClickListener() {
 
                @Override
                public void onClick(View v) {
 
                    Intent intent = new Intent(ProductListActivity.this,
                            ProductEditActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivityForResult(intent, 0);
                    finish();
 
                }
            });
 
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
}