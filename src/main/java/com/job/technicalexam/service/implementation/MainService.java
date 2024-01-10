package com.job.technicalexam.service.implementation;

import com.job.technicalexam.model.database.OptionsModel;
import com.job.technicalexam.model.database.ProductsModel;
import com.job.technicalexam.model.exception.ErrorException;
import com.job.technicalexam.model.response.*;
import com.job.technicalexam.repository.OptionsModelRepository;
import com.job.technicalexam.repository.ProductsModelRepository;
import com.job.technicalexam.service.MainInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MainService implements MainInterface {

    @Autowired
    ProductsModelRepository productsModelRepository;

    @Autowired
    OptionsModelRepository optionsModelRepository;

    @Override
    public SearchResponse searchApi(String searchTerm) {
        List<ProductsModel> productsModelList = productsModelRepository.findByNameContainingIgnoreCase(searchTerm);
        List<Long> itemIds = new ArrayList<>();

        if (Optional.of(itemIds).isPresent()) {
            productsModelList.stream().forEach(item -> itemIds.add(Long.valueOf(item.getProductId())));
        }

        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setSearchTerm(searchTerm);
        searchResponse.setItemIds(itemIds);

        return searchResponse;
    }

    @Override
    public ProductResponse productApi(int id) throws ErrorException {
        ProductResponse productResponse = new ProductResponse();
        ProductsModel productsModel;
        List<OptionsModel> optionsModel;
        List<OptionsModelModifiedResponse> optionsModelModifiedResponseList = new ArrayList<>();


        productsModel = productsModelRepository.findDistinctFirstByProductId(id);
        try {
            optionsModel = optionsModelRepository.findAllByProductsId(productsModel.getProductId());
        } catch (Exception exception) {
            throw new ErrorException("Error has been Encountered. Please modify your request or try again.");
        }

        optionsModel.stream().forEach(record -> {
            OptionsModelModifiedResponse optionsModelModifiedResponse = new OptionsModelModifiedResponse();
            optionsModelModifiedResponse.setId(record.getOptionId());
            optionsModelModifiedResponse.setName(record.getName());
            optionsModelModifiedResponse.setPrice(record.getPrice());
            optionsModelModifiedResponseList.add(optionsModelModifiedResponse);
        });


        productResponse.setId(productsModel.getProductId());
        productResponse.setName(productsModel.getName());
        productResponse.setOptions(optionsModelModifiedResponseList);


        return productResponse;
    }

    @Override
    public CombinedResponse combinedApi(String searchTerm) {
        CombinedResponse combinedResponse = new CombinedResponse();
        MetaModel metaModel = new MetaModel();
        List<ProductsModel> productsModelList;

        List<ItemsResponse> itemsResponseList = new ArrayList<>();
        List<OptionsModel> optionsModelList = new ArrayList<>();

        productsModelList = productsModelRepository.findByNameContainingIgnoreCase(searchTerm);

        productsModelList.stream().forEach(product -> {
            optionsModelList.addAll(optionsModelRepository.findAllByProductsId(product.getProductId()));

        });

        metaModel.setSearchTerm(searchTerm);
        metaModel.setCount(productsModelList.size());
        combinedResponse.setMeta(metaModel);


        productsModelList.stream().forEach(product -> {
            itemsResponseList.add(buildList(product.getProductId()));
        });

        combinedResponse.setItems(itemsResponseList);


        return combinedResponse;
    }

    private ItemsResponse buildList(int id) {
        ItemsResponse itemsResponse = new ItemsResponse();
        ProductsModel productsModel;
        List<OptionsModel> optionsModel;

        List<OptionsModelModifiedResponse> optionsModelModifiedResponseList = new ArrayList<>();
        List<Double> prices = new ArrayList<>();
        productsModel = productsModelRepository.findDistinctFirstByProductId(id);
        optionsModel = optionsModelRepository.findAllByProductsId(productsModel.getProductId());

        optionsModel.stream().forEach(record -> {
            OptionsModelModifiedResponse optionsModelModifiedResponse = new OptionsModelModifiedResponse();
            optionsModelModifiedResponse.setId(record.getOptionId());
            optionsModelModifiedResponse.setName(record.getName());
            optionsModelModifiedResponse.setPrice(record.getPrice());
            optionsModelModifiedResponseList.add(optionsModelModifiedResponse);
            prices.add(record.getPrice());
        });
        itemsResponse.setId(id);
        itemsResponse.setName(productsModel.getName());
        itemsResponse.setPriceRange(productsModel.getCurrency() + Collections.min(prices)
                + " - " + productsModel.getCurrency() + Collections.max(prices));
        itemsResponse.setOptions(optionsModelModifiedResponseList);

        return itemsResponse;
    }
}
