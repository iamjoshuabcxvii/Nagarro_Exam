package com.job.technicalexam.model.response;

import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {

    private String searchTerm;
    private List<Long> itemIds;
}
