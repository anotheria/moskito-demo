package org.moskito.demo.springbootdemo.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.moskito.demo.springbootdemo.domain.RatesPO;
import org.moskito.demo.springbootdemo.model.Rates;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatesMapper {

    Rates toDto(RatesPO dto);

    @IterableMapping(elementTargetType = Rates.class)
    List<Rates> toDto(List<RatesPO> dtoList);

}
