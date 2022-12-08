package com.example.sqtest;

import com.example.sqtest.models.CategoryModel;

public class MyConstants
{
    public static String TABLE_NAME_CAT = "category";
    public static String TABLE_CAT_ID = "cat_id";
    public static String TABLE_CAT_TITLE = "title";


    public static String CAT_QUERY = "CREATE TABLE " + TABLE_NAME_CAT + " ("+TABLE_CAT_ID+
            " INTEGER PRIMARY KEY " + "AUTOINCREMENT," + TABLE_CAT_TITLE + " TEXT)";


    public static String CAT_DROP = "DROP TABLE IF EXISTS "+ TABLE_NAME_CAT;


    public com.example.sqtest.models.CategoryModel CategoryModel;
}
