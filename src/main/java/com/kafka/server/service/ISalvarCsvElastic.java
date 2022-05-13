package com.kafka.server.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;


@Component
public interface ISalvarCsvElastic {
    public void postElasticSearch(ArrayList<String[]> arquivo) throws IOException;
}
