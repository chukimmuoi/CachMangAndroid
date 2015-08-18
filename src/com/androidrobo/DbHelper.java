package com.androidrobo;

import android.content.Context;
import java.sql.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.google.inject.Inject;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DbHelper extends OrmLiteSqliteOpenHelper {
	 
    private final static String DATABASENAME = "Main.db";
    private final static int DATABASEVERSION = 4;
 
    @Inject
    public DbHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }
 
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Product.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
            int oldVersion, int newVersion) {
    }
 
}