package com.manoelcampos.retornoboleto;

import java.net.URI;
import java.util.function.Function;

public class ProcessarBoletos {
    private Function leituraRetorno;

    public void setLeituraRetorno(Function leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processarBoletos(URI caminhoArquivo){
        var listaDeBoletos = leituraRetorno.lerArquivo(caminhoArquivo);
        for (Boleto boleto : listaDeBoletos) {
            // na pratica, iriramos salva no bando de dados
            System.out.println(boleto); // nome da variavel e atalho boleto.sout
        }
    }
}

// Cc - Case sensitive - Ctrl+R
// W - mudar somente aquilo
// Embaixo coloca o nome que queremos