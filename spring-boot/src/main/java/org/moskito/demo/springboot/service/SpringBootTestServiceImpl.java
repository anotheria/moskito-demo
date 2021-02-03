package org.moskito.demo.springboot.service;

import net.anotheria.moskito.aop.annotation.Monitor;
import org.moskito.demo.springboot.bean.Bean;
import org.moskito.demo.springboot.service.SpringBootTestService;
import org.springframework.stereotype.Service;

@Service
@Monitor
class SpringBootTestServiceImpl implements SpringBootTestService {

    @Override
    public String getBeanString(Bean bean) {
        return bean.getString();
    }
}
