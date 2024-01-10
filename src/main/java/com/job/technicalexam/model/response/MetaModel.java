package com.job.technicalexam.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetaModel {

    private String searchTerm;
    private int count;
}
