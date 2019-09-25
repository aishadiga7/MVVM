package com.example.myapplication.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.Injector;
import com.example.myapplication.data.remote.remote.model.ProductResponse;
import com.example.myapplication.databinding.ProductDetailsBinding;
import com.example.myapplication.viewmodel.HomeViewModel;

public class ProductDetailFragment extends Fragment {

    private ProductDetailsBinding binding;
    private HomeViewModel homeViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.product_details, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeViewModel = ViewModelProviders.of(getActivity(), Injector.getAppViewModelFacotry()).get(HomeViewModel.class);
        homeViewModel.getNewArrival().observe(this, new Observer<ProductResponse.Newarrival>() {
            @Override
            public void onChanged(ProductResponse.Newarrival newarrival) {
                binding.setNewArrival(newarrival);
                Glide.with(getContext()).load(newarrival.image).into(binding.imageView);
            }
        });
    }


}
