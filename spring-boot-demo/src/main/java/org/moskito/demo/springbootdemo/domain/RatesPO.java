package org.moskito.demo.springbootdemo.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Table(name = "rates")
@Entity
public class RatesPO {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "digital_code")
    private Integer digitalCode;

    @Column(name = "literal_code")
    private String literalCode;

    @Column(name = "number")
    private Integer number;

    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "official_course")
    private BigDecimal officialCourse;
}
