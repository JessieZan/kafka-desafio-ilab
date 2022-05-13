package com.kafka.server.service;

import com.kafka.server.dao.ProdutosDAO;
import com.kafka.server.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import static java.time.Instant.now;

@Service
public class SalvarCvs implements ISalvarCsv {

    @Autowired
    private ProdutosDAO prodDao;

    SalvarCsvElastic salvarElastic;

    @Override
    public void salvarCsv(ArrayList<String[]> arquivo) throws IOException {

        for (String[] line : arquivo) {
            Produto pcsv = new Produto();
            pcsv.setNome(line[1].trim());
            pcsv.setDescricao(line[2].trim());
            pcsv.setQuantidadee(Integer.parseInt(line[3].trim()));
            pcsv.setValor(Double.parseDouble(line[4].trim()));
            pcsv.setDataCadastro(Timestamp.from(now()));
            prodDao.save(pcsv);

        }
    }

}
