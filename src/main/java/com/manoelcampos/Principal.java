package com.manoelcampos;


import com.manoelcampos.retornoboleto.LeituraRetornoBancoBrasil;
import com.manoelcampos.retornoboleto.ProcessarBoletos;

import java.net.URI;
import java.util.function.Function;

public class Principal {
    public static void main(String[] args) {
       //  a = IO.readln("Acessando o banco!");

        var processador = new ProcessarBoletos();
        Function leitura = new LeituraRetornoBancoBrasil();

        processador.setLeituraRetorno(leitura);

        URI caminhoArquivo = URI.create("src/main/resources/banco-brasil-1.csv");
        processador.processarBoletos(caminhoArquivo);
    }
}
