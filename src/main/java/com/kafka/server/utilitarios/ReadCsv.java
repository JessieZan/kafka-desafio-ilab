package com.kafka.server.utilitarios;

import java.io.*;
import java.util.ArrayList;

public class ReadCsv {
    public static ArrayList<String[]> lerCsvProdutos (String arquivo) throws IOException {
        BufferedReader reader = null;
        String line = "";
        ArrayList<String[]> dadosProdutos = new ArrayList<String[]>();

        try {
            reader = new BufferedReader(new FileReader(arquivo));
            while ((line = reader.readLine()) != null) {

                String[] row = line.split(";");
                dadosProdutos.add(row);

            }
            return dadosProdutos;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            reader.close();
        }
    }
}
