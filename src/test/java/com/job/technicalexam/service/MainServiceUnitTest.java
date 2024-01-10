package com.job.technicalexam.service;

import com.job.technicalexam.model.database.ProductsModel;
import com.job.technicalexam.model.response.SearchResponse;
import com.job.technicalexam.repository.ProductsModelRepository;
import com.job.technicalexam.service.implementation.MainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainServiceUnitTest {

    @InjectMocks
    MainService mainService;

    @Mock
    ProductsModelRepository productsModelRepository;

    @Test
    public void testSearchIds(){

        when(productsModelRepository.findByNameContainingIgnoreCase(anyString()))
                .thenReturn(Collections.singletonList(mockOfExistingProducts()));
        SearchResponse searchResponse = mainService.searchApi("modern");
        assertNotNull(searchResponse.getItemIds().get(0));
    }

    private ProductsModel mockOfExistingProducts(){
        ProductsModel productsModel = new ProductsModel();

        productsModel.setProductId(111);
        productsModel.setName("Modern Chair");
        productsModel.setCurrency("$");

    return productsModel;
    }
}
