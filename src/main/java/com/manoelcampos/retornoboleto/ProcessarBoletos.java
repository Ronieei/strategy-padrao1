package com.manoelcampos.retornoboleto;

import java.net.URI;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

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

// :: -> guarda a referencia do metodo na Funcion para ser chamado posteriormente a variavel e assim poderemos usar o metodo apply para chamar o metodo e retornar o resultado

// Function<String, String> trim = String::trim; --> informa que recebe uma string e retorna uma string trim é uma variavel que armazena o metodo trim da string

// UnaryOperator<String> trim = String::trim --> informa que recebe uma string e retorna uma string logo é um contrato forte

// Function trimUpper = trim.andThen(String::toUpperCase) --> usar o trim que retira o espaços e agora deixa todos os caracteres em maiusculo

//trim.apply() - retirar os espaços
//trimUpperCase.apply() - retirar os espaços e depois colocar em maiusculo

// Predicate<String> hasValue = s -> s != null && !s.isBlank()

// var noValue = hasValue.negate()
// noValue.test(" ") --> retorna true
// noValue.test("") --> retorna true
// noValue.test("a") --> retorna false

// Na hora de declarar uma Function é de fato uma Função
// na hora de usar é um objeto que tem metodos e pode ser chamado

