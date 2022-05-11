package com.kafka.server.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public interface ISalvarCsv {
    public void salvarCsv(ArrayList<String []> aquivo) throws IOException;
}
