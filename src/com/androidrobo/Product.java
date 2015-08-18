package com.androidrobo;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Product")
public class Product implements Serializable{
 
    private static final long serialVersionUID = 1L;
 
    // this is the primary key column which is not automatically generated
    @DatabaseField(columnName = "Id", id = true, generatedId = false, canBeNull = false)
    private String code;
 
    @DatabaseField(columnName = "Description", canBeNull = false)
    private String description;
 
    @DatabaseField(columnName = "Price", canBeNull = false)
    private double price;
 
    @DatabaseField(columnName = "Qty")
    private int qty;
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setQty(int qty) {
        this.qty = qty;
    }
 
    public int getQty() {
        return qty;
    }
}