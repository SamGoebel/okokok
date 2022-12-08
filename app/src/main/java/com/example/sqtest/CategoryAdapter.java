package com.example.sqtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqtest.models.CategoryModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{

    public ArrayList<CategoryModel> arrayListCategory;
    public Context context;

    public CategoryAdapter(Context context, int simple_list_item_1, ArrayList<CategoryModel> arrayListCategory)
    {
    this.arrayListCategory = arrayListCategory;
    this.context = context;


    }

    @NonNull
    @NotNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_1,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryViewHolder holder, int position) {
        CategoryModel category = arrayListCategory.get(position);
        holder.catText.setText(category.getName());
    }

    @Override
    public int getItemCount()
    {
        return arrayListCategory.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.txtCategory) TextView catText;

        public CategoryViewHolder(@NonNull @NotNull View itemView)
        {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
