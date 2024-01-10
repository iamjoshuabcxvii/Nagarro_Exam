package com.job.technicalexam.repository;

import com.job.technicalexam.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsModelRepository extends JpaRepository<ProductsModel, Long> {
}
