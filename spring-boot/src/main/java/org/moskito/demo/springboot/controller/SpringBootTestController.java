package org.moskito.demo.springboot.controller;

import org.moskito.demo.springboot.bean.Bean;
import org.moskito.demo.springboot.service.SpringBootTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import net.anotheria.moskito.aop.annotation.Monitor;

@RestController
@Monitor
public class SpringBootTestController {

    @Autowired
    private SpringBootTestService testService;

    @GetMapping("/test/get")
    public String testGet(){
        return "Test endpoint";
    }

    @PostMapping("/test/post")
    public String testPost(@RequestBody Bean bean){
        return testService.getBeanString(bean);
    }
}
