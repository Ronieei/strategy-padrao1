package com.manoelcampos.retornoboleto;

import java.net.URI;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
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
