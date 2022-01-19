package com.example.springdemo.web;

import com.example.springdemo.model.RatesDto;
import com.example.springdemo.service.RatesService;
import lombok.RequiredArgsConstructor;
import net.anotheria.moskito.aop.annotation.Monitor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@Monitor
public class Controller {

    private final RatesService ratesService;

    @GetMapping("/factorial")
    public Integer calculateFactorial(@RequestParam(name = "number") Integer number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    @GetMapping("/fibonacci")
    public Integer calculateFibonacci(@RequestParam(name = "number") Integer number) {
        int num1 = 0, num2 = 1;
        int finonacci = 0;
        for (int i = 0; i < number; i++) {
            finonacci = num1 + num2;
            num1 = num2;
            num2 = finonacci;
        }

        return finonacci;
    }

    @GetMapping("/rates")
    public List<RatesDto> getRates() {
        return ratesService.findAll();
    }
}
