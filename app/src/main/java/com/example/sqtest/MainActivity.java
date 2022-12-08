package com.example.sqtest;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqtest.models.CategoryModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv) RecyclerView recyclerView;
    @BindView(R.id.fabAddCategory) FloatingActionButton fabAdd;
    OtherHelper helper;
    ArrayList<CategoryModel> categoryArrayList;

    CategoryAdapter adapter;
    private com.example.sqtest.OtherHelper OtherHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        helper = new OtherHelper(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryArrayList = new ArrayList<>();
        categoryArrayList.addAll(helper.getAllCategories());

        adapter = new CategoryAdapter(this, android.R.layout.simple_list_item_1, categoryArrayList);
        recyclerView.setAdapter(adapter);


    }
    @OnClick(R.id.fabAddCategory)


    public void addCategoryBtnClick()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("CATEGORY");
        alertDialog.setMessage("Enter title?");

        final EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
               LinearLayout.LayoutParams.WRAP_CONTENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("Add", (dialogInterface, which) -> {
            String name_input = input.getText().toString();
            if (!name_input.equals(""))
            {
                CategoryModel category = new CategoryModel(name_input);
                int isAdded = helper.addCategory(category);

                if (isAdded == 0) {
                    Toast.makeText(MainActivity.this, "Category added successfully",
                            Toast.LENGTH_LONG).show();
                    dialogInterface.dismiss();
                    categoryArrayList.add(category);
                    adapter.notifyDataSetChanged();
                }

                else {
                    Toast.makeText(MainActivity.this, "Category could not be added",
                            Toast.LENGTH_LONG).show();
                    dialogInterface.dismiss();

                }
            }

        });
        alertDialog.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        alertDialog.show();
    }
    @OnClick(R.id.rv)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CategoryModel clickedUser = (CategoryModel) parent.getItemAtPosition(position);
        OtherHelper.deleteOneUser(clickedUser);
        ShowCatOnListView(helper);
        Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
    }

    private void ShowCatOnListView(OtherHelper dataBaseTest1) {
        adapter = new CategoryAdapter(MainActivity.this, android.R.layout.simple_list_item_1, this.OtherHelper.getAllCategories());
        recyclerView.setAdapter(adapter);
    }

}




