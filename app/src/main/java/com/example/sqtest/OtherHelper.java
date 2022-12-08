package com.example.sqtest;


import static com.example.sqtest.MyConstants.TABLE_CAT_ID;
import static com.example.sqtest.MyConstants.TABLE_CAT_TITLE;
import static com.example.sqtest.MyConstants.TABLE_NAME_CAT;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import android.database.Cursor;

import com.example.sqtest.models.CategoryModel;

import java.util.ArrayList;
import android.widget.Toast;

public class OtherHelper extends SQLiteOpenHelper {


    public OtherHelper(@Nullable Context context) {

        super(context, "category.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(MyConstants.CAT_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(MyConstants.CAT_DROP);

    }

    public ArrayList<CategoryModel> getAllCategories() {
        ArrayList<CategoryModel> arrayListCat = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + MyConstants.TABLE_NAME_CAT, null);
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(0);
                String name = cursor.getString(1);
                CategoryModel category = new CategoryModel(id, name);
                arrayListCat.add(category);

            } while (cursor.moveToNext());
        }
        return arrayListCat;
    }

    public int addCategory(CategoryModel category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", category.getName());

        try {
            long newRowID = db.insertOrThrow(MyConstants.TABLE_NAME_CAT,
                    null, contentValues);


            if (newRowID != -1) {
                return 0;
            } else {
                return -1;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return -1;


    }

    public boolean deleteOneUser(CategoryModel catModel) {
        //find customerModel in the database. if it is found, delete it and return true.
        //if it is not found, return false

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + TABLE_CAT_TITLE + " WHERE " + TABLE_CAT_ID + " = " + catModel.getId();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            return true;
        }
        else {
            return false;
        }
    }

}





