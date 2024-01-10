package com.job.technicalexam.service;

import com.job.technicalexam.model.database.ProductsModel;
import com.job.technicalexam.model.response.ProductResponse;
import com.job.technicalexam.model.response.SearchResponse;
import com.job.technicalexam.repository.ProductsModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    @Autowired
    ProductsModelRepository productsModelRepository;

    public SearchResponse searchProducts(String searchTerm){
        List<ProductsModel> productsModelList = productsModelRepository.findByNameContainingIgnoreCase(searchTerm);
        List<Long> itemIds = new ArrayList<>();

        productsModelList.stream().forEach(item -> itemIds.add(Long.valueOf(item.getProductId())));




        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setSearchTerm(searchTerm);
        searchResponse.setItemIds(itemIds);

        return searchResponse;
    }
}
