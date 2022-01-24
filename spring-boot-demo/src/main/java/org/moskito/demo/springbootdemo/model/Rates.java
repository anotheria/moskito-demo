package org.moskito.demo.springbootdemo.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Rates {

    private Integer id;

    private String date;

    private String time;

    private Integer digitalCode;

    private String literalCode;

    private Integer number;

    private String currencyName;

    private BigDecimal officialCourse;
}
