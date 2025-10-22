package com.manoelcampos.retornoboleto;

import java.net.URI;
import java.util.List;

public interface LeituraRetorno {
    public List<Boleto> lerArquivoBoleto(URI caminhoArquivo);
}
