package com.example.springdemo.mapper;

import com.example.springdemo.domain.Rates;
import com.example.springdemo.model.RatesDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatesMapper {

    RatesDto toDto(Rates dto);

    @IterableMapping(elementTargetType = RatesDto.class)
    List<RatesDto> toDto(List<Rates> dtoList);

}
