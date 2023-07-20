package com.example.example_value.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PrintSetterInjectionCommand implements CommandLineRunner {
    private Integer someValue;

    @Override
    public void run(String... args) throws Exception {
        log.info("{} {}", getClass(), someValue);
    }

    @Autowired
    public void setSomeValue(@Value("#{numbers.number}") Integer someValue) {
        this.someValue = someValue;
    }
}
