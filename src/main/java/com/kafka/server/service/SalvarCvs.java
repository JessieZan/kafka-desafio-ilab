package com.kafka.server.service;

import com.kafka.server.dao.ProdutosDAO;
import com.kafka.server.models.Produto;
import com.kafka.server.utilitarios.ReadCsv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.sql.Timestamp;
import static java.time.Instant.now;

@Service
public class SalvarCvs implements ISalvarCsv{

    @Autowired
    private ProdutosDAO prodDao;

    @Override
    public void salvarCsv(String arquivo) {
        ArrayList<String[]> dadocsv = ReadCsv.lerCsvProdutos(arquivo);
        for (String[] line : dadocsv) {
            Produto pcsv = new Produto();
            pcsv.setNome(line[0]);
            pcsv.setDescricao(line[1]);
            pcsv.setQuantidade(Integer.parseInt(line[2]));
            pcsv.setValor(Integer.parseInt(line[3]));
            pcsv.setDataCadastro(Timestamp.from(now()));
            prodDao.save(pcsv);
        }
    }
    
}
