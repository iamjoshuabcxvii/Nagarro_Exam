package com.job.technicalexam.model.response;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class OptionsModelModifiedResponse {

    private int id;
    private String name;
    private double price;
}
