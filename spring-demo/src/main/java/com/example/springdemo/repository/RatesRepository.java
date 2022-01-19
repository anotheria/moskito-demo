package com.example.springdemo.repository;

import com.example.springdemo.domain.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesRepository extends JpaRepository<Rates, Integer> {
}
