package com.manoelcampos;


import com.manoelcampos.retornoboleto.Boleto;
import com.manoelcampos.retornoboleto.LeituraRetornoBancoBradesco;
import com.manoelcampos.retornoboleto.LeituraRetornoBancoBrasil;
import com.manoelcampos.retornoboleto.ProcessarBoletos;

import java.net.URI;
import java.util.List;
import java.util.function.Function;

public class Principal {
    public static void main(String[] args) {
       //  a = IO.readln("Acessando o banco!");

        // Criação de uma instância de ProcessarBoletos, responsável pelo processamento dos boletos.
        var processador = new ProcessarBoletos();

        // Definição de uma função de leitura que usa uma referência a método estático.
        // A função `lerArquivo` da classe LeituraRetornoBancoBrasil é responsável por ler um arquivo CSV
        // e retornar uma lista de objetos do tipo Boleto.
        Function<URI, List<Boleto>> leitura = LeituraRetornoBancoBrasil::lerArquivo;

        // Configura o processador para usar a função de leitura definida acima.
        // Isso permite que o processador saiba como ler os dados de boletos a partir de um arquivo.
        processador.setLeituraRetorno(leitura);

        // Criação de um objeto URI que aponta para o arquivo CSV contendo os dados dos boletos.
        // O caminho do arquivo é relativo à estrutura do projeto (pasta resources).
        URI caminhoArquivo = URI.create("src/main/resources/banco-brasil-1.csv");

        // Chamada ao método processarBoletos, que usa a função de leitura configurada
        // para processar os boletos a partir do arquivo especificado.
        processador.processarBoletos(caminhoArquivo);



        var bd = new LeituraRetornoBancoBradesco();
        Function<URI, List<Boleto>> leituraB = LeituraRetornoBancoBradesco::lerArquivoBoleto;

        processador.setLeituraRetorno(leituraB);
        processador.processarBoletos(URI.create("src/main/resources/bradesco-1.csv"));



    }
}
