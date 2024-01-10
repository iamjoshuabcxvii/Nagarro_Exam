package com.job.technicalexam.model.response;

import lombok.Data;

import java.util.List;

@Data
public class ItemsResponse {

    private int id;
    private String name;
    private String priceRange;
    private List<OptionsModelModifiedResponse> options;
}
