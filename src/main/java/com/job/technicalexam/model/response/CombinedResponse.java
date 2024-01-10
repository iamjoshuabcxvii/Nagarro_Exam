package com.job.technicalexam.model.response;

import lombok.Data;

import java.util.List;

@Data
public class CombinedResponse {

    MetaModel meta;
    List<ItemsResponse> items;
}
