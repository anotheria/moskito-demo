package org.moskito.demo.springdemo.service;

import org.moskito.demo.springdemo.domain.Rates;
import org.moskito.demo.springdemo.mapper.RatesMapper;
import org.moskito.demo.springdemo.model.RatesDto;
import org.moskito.demo.springdemo.repository.RatesRepository;
import lombok.RequiredArgsConstructor;
import net.anotheria.moskito.aop.annotation.Count;
import net.anotheria.moskito.aop.annotation.Monitor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Monitor
public class RatesService {

    private final RatesRepository ratesRepository;

    private final RatesMapper ratesMapper;

    @Count
    public List<RatesDto> findAll() {
        List<Rates> rates = ratesRepository.findAll();
        return ratesMapper.toDto(rates);
    }
}
