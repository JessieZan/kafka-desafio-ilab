package com.kafka.server.service;

import com.kafka.server.models.Produto;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import static java.time.Instant.now;


@Service
public class SalvarCsvElastic implements ISalvarCsvElastic {

    @Override
    public void postElasticSearch(ArrayList<String[]> arquivo)  throws IOException{
         
        for (String[] line : arquivo) {
            Produto produto = new Produto();
            produto.setNome(line[1].trim());
            produto.setDescricao(line[2].trim());
            produto.setQuantidadee(Integer.parseInt(line[3].trim()));
            produto.setValor(Double.parseDouble(line[4].trim()));
            produto.setDataCadastro(Timestamp.from(now()));
            String jsonFile = new Gson().toJson(produto);

            HttpEntity entity = new StringEntity(jsonFile);
            HttpPost post = new HttpPost("http://localhost:9200/produtos/_doc");
            post.setEntity(entity);
            HttpClientBuilder clientBuilder = HttpClientBuilder.create();
            CloseableHttpClient client = clientBuilder.build();
            post.addHeader("Content-Type", "application/json");
            post.addHeader("Accept","text/plain");
            var response = client.execute(post);
            System.out.println("Response: " + response);
        }

        
    }

   
    
}
