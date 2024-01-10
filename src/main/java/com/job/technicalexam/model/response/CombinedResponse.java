package com.job.technicalexam.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CombinedResponse {

    MetaModel meta;
    List<ItemsResponse> itemsResponseList;
}
