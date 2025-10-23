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

        var processador = new ProcessarBoletos();
        Function<URI, List<Boleto>> leitura = LeituraRetornoBancoBrasil::lerArquivo; // --> ARMAZENANDO A FUNÇÃO E NAO O OBJETO sendo metodo statico

        processador.setLeituraRetorno(leitura);

        URI caminhoArquivo = URI.create("src/main/resources/banco-brasil-1.csv");
        processador.processarBoletos(caminhoArquivo);

        var bd = new LeituraRetornoBancoBradesco();
        List<Boleto> boletoList = bd.lerArquivoBoleto(URI.create("src/main/resources/bradesco-1.csv"));

        bd.imprimirBoletos(boletoList);

    }
}
