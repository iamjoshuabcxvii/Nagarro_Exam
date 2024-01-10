package com.job.technicalexam.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {

    private int id;
    private String name;
    private List<OptionsModelModifiedResponse> options;
}
