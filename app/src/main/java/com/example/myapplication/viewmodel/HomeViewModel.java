package com.example.myapplication.viewmodel;



import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.myapplication.data.Callback;
import com.example.myapplication.data.Repository;
import com.example.myapplication.data.remote.remote.model.ProductResponse;
import com.example.myapplication.model.Product;
import com.example.myapplication.views.uimodel.ProductUIModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends BaseViewModel {

    private Repository repository;
    private MutableLiveData<List<Product>> mutableLiveData = new MutableLiveData<>();
    private MutableLiveData<ProductResponse.Newarrival> newArrival = new MutableLiveData<>();

    public LiveData<List<ProductUIModel>> getProductList() {
      return Transformations.map(mutableLiveData, new Function<List<Product>, List<ProductUIModel>>() {
           @Override
           public List<ProductUIModel> apply(List<Product> input) {
               List<ProductUIModel> models = new ArrayList<>();
               for (Product product : input) {
                   ProductUIModel model = new ProductUIModel();
                   model.title = product.getName();
                   model.description = product.getDescription();
                   model.imageUrl = product.getUrl();
                   model.value = product.getPrice();
                   models.add(model);
               }
               return models;
           }
       });
    }

    public LiveData<ProductResponse.Newarrival> getNewArrival() {
        return newArrival;
    }

    public HomeViewModel(Repository repository) {
        this.repository = repository;
    }

     public void fetchData() {
            setProgress(true);
            repository.getProducts(new Callback<List<Product>>() {
                @Override
                public void onSuccess(List<Product> result) {
                    setProgress(false);
                    if (result != null) {
                        mutableLiveData.setValue(result);
                        newArrival.setValue(repository.geNewArrivals());
                    }
                }

                @Override
                public void onError(Throwable error) {
                    setProgress(false);

                }
            });

    }
}
