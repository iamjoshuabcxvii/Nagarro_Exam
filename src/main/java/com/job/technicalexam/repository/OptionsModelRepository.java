package com.job.technicalexam.repository;

import com.job.technicalexam.model.database.OptionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsModelRepository extends JpaRepository<OptionsModel, Long> {
}
