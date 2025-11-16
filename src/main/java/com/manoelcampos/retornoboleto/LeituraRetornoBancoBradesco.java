package com.manoelcampos.retornoboleto;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.manoelcampos.retornoboleto.ProcessarBoletos.*;

public class LeituraRetornoBancoBradesco {

    public static List<Boleto> lerArquivoBoleto(URI caminhoArquivo) {
        System.out.println("\nLendo arquivo do BB - Bradesco");
        var listaBoletos = new ArrayList<Boleto>();

        try {
            //ByteBuffer - Melhor armazenar dados - Pegando o arquivo e lendo os dados
            List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo.getPath()));

            for (String linha : linhas){
                String[] vetor = linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA ));
                boleto.setDataPagamento(LocalDateTime.parse(vetor[5], FORMATO_DATA_HORA24));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));

                listaBoletos.add(boleto);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return listaBoletos;
    }
}
