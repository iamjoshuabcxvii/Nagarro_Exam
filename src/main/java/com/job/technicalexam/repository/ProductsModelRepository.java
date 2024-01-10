package com.job.technicalexam.repository;

import com.job.technicalexam.model.database.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsModelRepository extends JpaRepository<ProductsModel, Long> {

    List<ProductsModel> findByNameContainingIgnoreCase(String searchTerm);
/*    ProductsModel findByIdContains(Integer id);
    ProductsModel findDistinctFirstById(Integer id);
    ProductsModel findDistinctFirstByProductId(Integer id);
    ProductsModel findByProductIdContains(Integer id);
    ProductsModel findDistinctFirstByProductIdContains(Integer id);
    ProductsModel findProductsModelByProductIdContains(Integer id);
    @Query("SELECT p FROM ProductsModel p WHERE p.productId like %:id%")
    SELECT * FROM PRODUCTS_MODEL WHERE PRODUCT_ID like '%1%'
    @Query("SELECT p FROM ProductsModel p WHERE p.productId like '%productId%'")
    ProductsModel findByProductIdWithin(@Param("productId") int productId);
    ProductsModel findProductsModelByProductIdIsLike(int id);
    ProductsModel findProductsModelByProductIdContains(int id);*/

    ProductsModel findDistinctFirstByProductId(int id);



}
