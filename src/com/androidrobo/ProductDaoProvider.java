package com.androidrobo;

import javax.inject.Inject;
import javax.inject.Provider;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

public class ProductDaoProvider implements Provider<Dao<Product, String>> {
 
    private ConnectionSource connectionSource;
 
    @Inject
    public ProductDaoProvider(DbHelper dbHelper) {
        connectionSource = dbHelper.getConnectionSource();
    }
 
    @Override
    public Dao<Product, String> get() {
        try {
            return DaoManager.createDao(connectionSource, Product.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
