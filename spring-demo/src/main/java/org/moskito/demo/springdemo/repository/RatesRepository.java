package org.moskito.demo.springdemo.repository;

import org.moskito.demo.springdemo.domain.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesRepository extends JpaRepository<Rates, Integer> {
}
