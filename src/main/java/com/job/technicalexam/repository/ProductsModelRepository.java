package com.job.technicalexam.repository;

import com.job.technicalexam.model.database.ProductsModel;
import com.job.technicalexam.model.response.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsModelRepository extends JpaRepository<ProductsModel, Long> {
    
    List<ProductsModel> findByNameContainingIgnoreCase(String searchTerm);

}
