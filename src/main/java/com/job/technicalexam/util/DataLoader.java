package com.job.technicalexam.util;

import com.job.technicalexam.model.OptionsModel;
import com.job.technicalexam.model.ProductsModel;
import com.job.technicalexam.repository.OptionsModelRepository;
import com.job.technicalexam.repository.ProductsModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    ProductsModelRepository productsModelRepository;

    @Autowired
    OptionsModelRepository optionsModelRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ProductsModel productsModelOne = new ProductsModel();
        ProductsModel productsModelTwo = new ProductsModel();
        ProductsModel productsModelThree = new ProductsModel();

        OptionsModel optionsModelOne = new OptionsModel();
        OptionsModel optionsModelTwo = new OptionsModel();
        OptionsModel optionsModelThree = new OptionsModel();
        OptionsModel optionsModelFour = new OptionsModel();
        OptionsModel optionsModelFive = new OptionsModel();
        OptionsModel optionsModelSix = new OptionsModel();

        productsModelOne.setProductId(111);
        productsModelOne.setName("Modern Chair");
        productsModelOne.setCurrency("$");

        productsModelTwo.setProductId(222);
        productsModelTwo.setName("Modern Table");
        productsModelTwo.setCurrency("$");

        productsModelThree.setProductId(333);
        productsModelThree.setName("Modern Couch");
        productsModelThree.setCurrency("$");

        optionsModelOne.setOptionId(4);
        optionsModelOne.setProductsId(111);
        optionsModelOne.setName("Blue");
        optionsModelOne.setPrice(123.0);

        optionsModelTwo.setOptionId(5);
        optionsModelTwo.setProductsId(111);
        optionsModelTwo.setName("Red");
        optionsModelTwo.setPrice(154.0);

        optionsModelThree.setOptionId(6);
        optionsModelThree.setProductsId(222);
        optionsModelThree.setName("Wood");
        optionsModelThree.setPrice(1223.0);

        optionsModelFour.setOptionId(7);
        optionsModelFour.setProductsId(222);
        optionsModelFour.setName("Metal");
        optionsModelFour.setPrice(2154.0);

        optionsModelFive.setOptionId(8);
        optionsModelFive.setProductsId(333);
        optionsModelFive.setName("Fuzzy");
        optionsModelFive.setPrice(892.0);

        optionsModelSix.setOptionId(9);
        optionsModelSix.setProductsId(333);
        optionsModelSix.setName("Leather");
        optionsModelSix.setPrice(1054.0);

        productsModelRepository.save(productsModelOne);
        productsModelRepository.save(productsModelTwo);
        productsModelRepository.save(productsModelThree);

        optionsModelRepository.save(optionsModelOne);
        optionsModelRepository.save(optionsModelTwo);
        optionsModelRepository.save(optionsModelThree);
        optionsModelRepository.save(optionsModelFour);
        optionsModelRepository.save(optionsModelFive);
        optionsModelRepository.save(optionsModelSix);

    }
}
