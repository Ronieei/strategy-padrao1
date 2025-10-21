package com.manoelcampos.retornoboleto;

import java.net.URI;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface LeituraRetorno {

    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

    List<Boleto> lerArquivo(URI caminhoArquivo);
}
