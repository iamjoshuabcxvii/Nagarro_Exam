package com.job.technicalexam.repository;

import com.job.technicalexam.model.database.OptionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionsModelRepository extends JpaRepository<OptionsModel, Long> {

    List<OptionsModel> findByProductsIdContains(Integer id);

    List<OptionsModel> findAllByProductsId(Integer id);
}
