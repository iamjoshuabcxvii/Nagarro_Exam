package com.job.technicalexam.service;

import com.job.technicalexam.model.exception.ErrorException;
import com.job.technicalexam.model.response.CombinedResponse;
import com.job.technicalexam.model.response.ProductResponse;
import com.job.technicalexam.model.response.SearchResponse;

public interface MainInterface {

    SearchResponse searchApi(String searchTerm);

    ProductResponse productApi(int id) throws ErrorException;

    CombinedResponse combinedApi(String searchTerm);
}
