package com.example.myapplication.views.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ProdItemBinding;
import com.example.myapplication.views.uimodel.ProductUIModel;

import java.util.ArrayList;
import java.util.List;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ViewHolder> {

    private List<ProductUIModel> list = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProdItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.prod_item, parent, false);
        return new ViewHolder(binding);
    }

    public void setList(List<ProductUIModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ProdItemBinding itemView;

        public ViewHolder(@NonNull ProdItemBinding itemView) {
            super(itemView.getRoot());

            this.itemView = itemView;
        }

        public void bind(ProductUIModel model) {
            itemView.setViewModel(model);
            Glide.with(itemView.imageView.getContext()).load(model.imageUrl).into(itemView.imageView);
            itemView.executePendingBindings();
        }

    }
}
