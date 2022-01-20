package org.moskito.demo.springdemo.mapper;

import org.moskito.demo.springdemo.domain.Rates;
import org.moskito.demo.springdemo.model.RatesDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatesMapper {

    RatesDto toDto(Rates dto);

    @IterableMapping(elementTargetType = RatesDto.class)
    List<RatesDto> toDto(List<Rates> dtoList);

}
