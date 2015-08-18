package com.androidrobo;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepo {
	public List GetProducts() throws SQLException;
    public Product GetProduct(String id) throws SQLException;
    public void DeleteProduct(Product deleteProduct) throws SQLException;
    public void SaveProduct(Product saveProduct) throws SQLException;
    public void UpdateProduct(Product updateProduct) throws SQLException;
}
