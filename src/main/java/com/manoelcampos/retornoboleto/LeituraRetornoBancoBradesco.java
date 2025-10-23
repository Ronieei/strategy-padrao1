package com.manoelcampos.retornoboleto;

import java.io.*;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.manoelcampos.retornoboleto.ProcessarBoletos.FORMATO_DATA;
import static com.manoelcampos.retornoboleto.ProcessarBoletos.FORMATO_DATA_HORA;

public class LeituraRetornoBancoBradesco implements LeituraRetorno{

    @Override
    public List<Boleto> lerArquivoBoleto(URI caminhoArquivo) {
        System.out.println("\nLendo arquivo do BB - Bradesco");
        var listaBoletos = new ArrayList<Boleto>();

        try {
            List<String> linhas = listaDeBoletos(caminhoArquivo);

            for (String linha : linhas){
                String[] vetor = linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA ));
                boleto.setDataPagamento(LocalDateTime.parse(vetor[5], FORMATO_DATA_HORA));
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

    private List<String> listaDeBoletos(URI caminhoArquivo) {
        String ENCONDING = "UTF-8";
        List<String> linhas = new ArrayList<>();
        try (BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(caminhoArquivo.getPath()),ENCONDING))) {
            for (String linha = leitor.readLine(); linha != null; linha = leitor.readLine()) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;
    }

    public void imprimirBoletos(List<Boleto> boletos){
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }


}
