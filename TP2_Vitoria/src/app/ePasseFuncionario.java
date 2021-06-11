package app;

import java.util.Date;

public class ePasseFuncionario extends ePassStandard implements TituloTransporte{
    public ePasseFuncionario(String nome, String apelido, int telef, Date data_nasc, DocumentoID docID) {
        super(nome, apelido, telef, data_nasc, docID);
    }
}
