package com.job.technicalexam.repository;

import com.job.technicalexam.model.database.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsModelRepository extends JpaRepository<ProductsModel, Long> {

    List<ProductsModel> findByNameContainingIgnoreCase(String searchTerm);

    /*
        @Query("SELECT p FROM ProductsModel p WHERE p.productId like '%productId%'")
        ProductsModel findByProductIdWithin(@Param("productId") int productId);
    */
    ProductsModel findDistinctFirstByProductId(int id);


}
