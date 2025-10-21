package com.manoelcampos.retornoboleto;

import java.net.URI;
import java.util.List;
import java.util.function.Function;

public class ProcessarBoletos {
    // Contrato continua funcionando, é obrigatorio passar URI e retorna a Lista de boletos, logo o contrato continua funcionando.
    private Function<URI, List<Boleto>> leituraRetorno;

    public void setLeituraRetorno(Function leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processarBoletos(URI caminhoArquivo){
        // retiramos e utilizamos o apply que recebe o URI e retorna a lista de boletos como era o metodo de antes conseguimos cumprir nosso objetivo
        var listaDeBoletos = leituraRetorno.apply(caminhoArquivo);
        for (Boleto boleto : listaDeBoletos) {
            // na pratica, iriramos salva no bando de dados
            System.out.println(boleto); // nome da variavel e atalho boleto.sout
        }
    }
}

// Cc - Case sensitive - Ctrl+R
// W - mudar somente aquilo
// Embaixo coloca o nome que queremos