package com.androidrobo;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import java.sql.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.androidrobo.R;
import com.google.inject.Inject;

@ContentView(R.layout.product_edit)
public class ProductEditActivity extends RoboActivity {
 
    @Inject
    private IProductRepo _productRepo;
 
    @InjectView(R.id.editTextProductId)
    private EditText _editTextProductCode;
 
    @InjectView(R.id.editTextProductName)
    private EditText _editTextProductDescription;
 
    @InjectView(R.id.editTextProductPrice)
    private EditText _editTextProductPrice;
 
    @InjectView(R.id.editTextProductQty)
    private EditText _editTextProductQty;
 
    @InjectView(R.id.buttonProductSave)
    private Button _buttonProductSave;
 
    @InjectView(R.id.buttonProductDelete)
    private Button _buttonProductDelete;
 
    private Product _selectedProduct;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        _selectedProduct = (Product) (getIntent()
                .getSerializableExtra("Product"));
        loadSelectedProduct(_selectedProduct);
 
        _buttonProductSave.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View v) {
                try {
 
                    if (_selectedProduct == null) {
 
                        Product product = new Product();
 
                        product.setCode(_editTextProductCode.getText()
                                .toString());
 
                        product.setDescription(_editTextProductDescription
                                .getText().toString());
                        product.setPrice(Double
                                .parseDouble(_editTextProductPrice.getText()
                                        .toString()));
                        product.setQty(Integer.parseInt(_editTextProductQty
                                .getText().toString()));
 
                        _productRepo.SaveProduct(product);
 
                    } else {
 
                        _selectedProduct
                                .setDescription(_editTextProductDescription
                                        .getText().toString());
                        _selectedProduct.setPrice(Double
                                .parseDouble(_editTextProductPrice.getText()
                                        .toString()));
                        _selectedProduct.setQty(Integer
                                .parseInt(_editTextProductQty.getText()
                                        .toString()));
 
                        _productRepo.UpdateProduct(_selectedProduct);
 
                    }
 
                    Intent intent = new Intent(ProductEditActivity.this,
                            ProductListActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivityForResult(intent, 0);
                    finish();
 
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
 
            }
        });
 
        _buttonProductDelete.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View v) {
 
                if (_selectedProduct != null) {
 
                    try {
 
                        _productRepo.DeleteProduct(_selectedProduct);
                        Intent intent = new Intent(ProductEditActivity.this,
                                ProductListActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivityForResult(intent, 0);
                        finish();
 
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
 
            }
        });
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    private void loadSelectedProduct(Product selectedProduct) {
 
        if (selectedProduct != null) {
 
            _editTextProductCode.setText(selectedProduct.getCode());
            _editTextProductCode.setEnabled(false);
 
            _editTextProductDescription.setText(selectedProduct
                    .getDescription());
            _editTextProductPrice.setText(String.valueOf(selectedProduct
                    .getPrice()));
            _editTextProductQty
                    .setText(String.valueOf(selectedProduct.getQty()));
        }
 
    }
 
}