package com.calculator.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

@Service
public class CalculateService {
    private final static Logger logger = Logger.getLogger(CalculateService.class.getName());
    @PostConstruct
    private void startTickEQueryService() {
        logger.info("Started Application");
    }
}
