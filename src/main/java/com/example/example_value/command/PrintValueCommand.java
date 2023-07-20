package com.example.example_value.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Order(1)
@Component
public class PrintValueCommand implements CommandLineRunner {
    @Value("ha injected form value")
    private String injectString;

    @Value("${value.from.file}")
    private String valueFromFile;

    @Value("${path}")
    private String systemValue;

    @Value("${unkown.param:some default if not exists}")
    private String unknownParam;

    @Value("${server.port}")
    private String prioritySystemProperty;

    @Value("${arrayOfValues}")
    private String[] valuesArray;

    @Value("${listOfValues}")
    private List<String> listsValues;


    @Override
    public void run(String... args) throws Exception {
        log.info("Injected first: {}", injectString);
        log.info("Injected second: {}", valueFromFile);
        log.info("Injected third: {}", systemValue);
        log.info("Injected fourth: {}", unknownParam);
        log.info("Injected five: {}", prioritySystemProperty);
        log.info("Injected array: {}", Arrays.asList(valuesArray));
        log.info("Injected list: {}", listsValues);
    }
}
