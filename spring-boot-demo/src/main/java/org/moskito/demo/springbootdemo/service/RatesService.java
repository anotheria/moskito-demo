package org.moskito.demo.springbootdemo.service;

import lombok.RequiredArgsConstructor;
import net.anotheria.moskito.aop.annotation.Count;
import net.anotheria.moskito.aop.annotation.Monitor;
import org.moskito.demo.springbootdemo.domain.RatesPO;
import org.moskito.demo.springbootdemo.mapper.RatesMapper;
import org.moskito.demo.springbootdemo.model.Rates;
import org.moskito.demo.springbootdemo.repository.RatesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Monitor
public class RatesService {

    private final RatesRepository ratesRepository;

    private final RatesMapper ratesMapper;

    @Count
    public List<Rates> findAll() {
        List<RatesPO> rates = ratesRepository.findAll();
        return ratesMapper.toDto(rates);
    }
}
