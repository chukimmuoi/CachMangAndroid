package com.androidrobo;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;

public class ProductRepo implements IProductRepo {
 
    private Dao<Product, String> _productDao;
 
    @Inject
    public ProductRepo(Context context, ProductDaoProvider productDaoProvider) {
        _productDao = productDaoProvider.get();
    }
 
    @Override
    public List GetProducts() throws SQLException {
        return _productDao.queryForAll();
    }
 
    @Override
    public Product GetProduct(String id) throws SQLException {
        return _productDao.queryForId(id);
    }
 
    @Override
    public void DeleteProduct(Product deleteProduct) throws SQLException {
        _productDao.delete(deleteProduct);
    }
 
    @Override
    public void SaveProduct(Product saveProduct) throws SQLException {
        _productDao.create(saveProduct);
    }
 
    @Override
    public void UpdateProduct(Product updateProduct) throws SQLException {
        _productDao.update(updateProduct);
    }
}