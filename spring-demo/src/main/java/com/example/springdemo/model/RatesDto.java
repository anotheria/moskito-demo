package com.example.springdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
public class RatesDto {

    private Integer id;

    private String date;

    private String time;

    private Integer digitalCode;

    private String literalCode;

    private Integer number;

    private String currencyName;

    private BigDecimal officialCourse;
}
