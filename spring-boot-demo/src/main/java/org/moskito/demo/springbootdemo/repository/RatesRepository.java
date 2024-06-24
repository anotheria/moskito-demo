package org.moskito.demo.springbootdemo.repository;

import org.moskito.demo.springbootdemo.domain.RatesPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesRepository extends JpaRepository<RatesPO, Integer> {
}
