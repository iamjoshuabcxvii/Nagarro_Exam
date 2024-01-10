package com.job.technicalexam.model.response;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {

    private int id;
    private String name;
    private List<OptionsModelModifiedResponse> options;
}
