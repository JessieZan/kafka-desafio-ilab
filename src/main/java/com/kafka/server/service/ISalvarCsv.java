package com.kafka.server.service;

import org.springframework.stereotype.Component;

@Component
public interface ISalvarCsv {
    public void salvarCsv(String aquivo);
}
