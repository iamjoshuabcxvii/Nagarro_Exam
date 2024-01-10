package com.job.technicalexam.service;

import com.job.technicalexam.model.database.OptionsModel;
import com.job.technicalexam.model.database.ProductsModel;
import com.job.technicalexam.model.response.OptionsModelModifiedResponse;
import com.job.technicalexam.model.response.ProductResponse;
import com.job.technicalexam.model.response.SearchResponse;
import com.job.technicalexam.repository.OptionsModelRepository;
import com.job.technicalexam.repository.ProductsModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    @Autowired
    ProductsModelRepository productsModelRepository;

    @Autowired
    OptionsModelRepository optionsModelRepository;

    public SearchResponse searchApi(String searchTerm){
        List<ProductsModel> productsModelList = productsModelRepository.findByNameContainingIgnoreCase(searchTerm);
        List<Long> itemIds = new ArrayList<>();

        productsModelList.stream().forEach(item -> itemIds.add(Long.valueOf(item.getProductId())));

        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setSearchTerm(searchTerm);
        searchResponse.setItemIds(itemIds);

        return searchResponse;
    }

    public ProductResponse productApi(int id) {
        ProductResponse productResponse = new ProductResponse();
        ProductsModel productsModel;
        List<OptionsModel> optionsModel;
        OptionsModelModifiedResponse optionsModelModifiedResponse = new OptionsModelModifiedResponse();
        List<OptionsModelModifiedResponse> optionsModelModifiedResponseList = new ArrayList<>();


        productsModel = productsModelRepository.findDistinctFirstByProductId(id);
        optionsModel = optionsModelRepository.findAllByProductsId(productsModel.getProductId());

        optionsModel.stream().forEach(record -> {
            optionsModelModifiedResponse.setId(record.getId());
            optionsModelModifiedResponse.setName(record.getName());
            optionsModelModifiedResponse.setPrice(record.getPrice());
            optionsModelModifiedResponseList.add(optionsModelModifiedResponse);
        });

        productResponse.setId(productsModel.getId());
        productResponse.setName(productsModel.getName());
        productResponse.setOptions(optionsModelModifiedResponseList);


        return productResponse;
    }
}
