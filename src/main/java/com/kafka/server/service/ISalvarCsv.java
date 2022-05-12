package com.kafka.server.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public interface ISalvarCsv {
    public void salvarCsv(ArrayList<String[]> aquivo) throws IOException;
}
