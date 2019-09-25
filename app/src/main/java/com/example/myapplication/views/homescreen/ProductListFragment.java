package com.example.myapplication.views.homescreen;

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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.data.Injector;
import com.example.myapplication.databinding.Page1Binding;
import com.example.myapplication.viewmodel.HomeViewModel;
import com.example.myapplication.views.adapter.ProductsListAdapter;
import com.example.myapplication.views.uimodel.ProductUIModel;

import java.util.List;

public class ProductListFragment extends Fragment {

    private Page1Binding binding;
    private final ProductsListAdapter adapter = new ProductsListAdapter();
    private HomeViewModel homeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.page_1,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    private void initRecyclerView() {
        if (binding.recyclerview != null) {
            binding.recyclerview.setLayoutManager(new LinearLayoutManager(this.getContext()));
            binding.recyclerview.setAdapter(adapter);
            binding.recyclerview.setItemAnimator(new DefaultItemAnimator());
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
        homeViewModel = ViewModelProviders.of(getActivity(), Injector.getAppViewModelFacotry()).get(HomeViewModel.class);
        homeViewModel.getProductList().observe(this, new Observer<List<ProductUIModel>>() {
            @Override
            public void onChanged(List<ProductUIModel> productUIModels) {
                adapter.setList(productUIModels);
            }
        });

    }
}
