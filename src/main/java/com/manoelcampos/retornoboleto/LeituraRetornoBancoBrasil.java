package com.manoelcampos.retornoboleto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBrasil implements LeituraRetorno {
    @Override
    public List<Boleto> lerArquivo(URI caminhoArquivo) {
        System.out.println("Lendo arquivo do BB");

        var listaBoletos = new ArrayList<Boleto>();

        try {
            //ByteBuffer - Melhor armazenar dados
            // readAllLines é totalmente desaconselhado se o arquivo for grande
            List<String> linhas = Files.readAllLines(Path.of(caminhoArquivo.getPath()));

            for (String linha : linhas) {
                // 1,001,23/12/2019,31/07/2019,12345678911,106.2,0,0
                // recolher a esquerda antes da virgula
                String[] vetor = linha.split(",");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA ));
                boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atStartOfDay());
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setJuros(Double.parseDouble(vetor[6]));
                boleto.setMulta(Double.parseDouble(vetor[7]));

                listaBoletos.add(boleto);

                //Bigdecimal
                // money


            }
        } catch (IOException e) {
            // RuntimeException exceção não checada.
            // Ela não vai obrigar quem chamar jo metodo a lidar com ela.
            throw new UncheckedIOException(e); // Unchcked
        }

        return listaBoletos;
    }
}
