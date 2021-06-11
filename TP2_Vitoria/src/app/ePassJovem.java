package app;

import java.util.Calendar;
import java.util.Date;

public class ePassJovem extends ePassStandard implements TituloTransporte{
    public ePassJovem(String nome, String apelido, int telef, Date data_nasc, DocumentoID docID) {
        super(nome, apelido, telef, data_nasc, docID);
    }


    @Override
    public void pagarViagem(int pontosViagem) {

        if (super.getSaldo()>super.getPrecoViagem() && pontosViagem<101) {

            System.out.println("Insuficiente.");
        }
        else if (super.getSaldo()>super.getPrecoViagem() && pontosViagem>101){
            pontosViagem-=40;
            System.out.println("Pagamento efetuado com sucesso!");
        }
        else if(super.getSaldo()>super.getPrecoViagem() && pontosViagem<101){
            System.out.println("Insuficiente.");}

        else if (super.getSaldo()<super.getPrecoViagem() && pontosViagem<101){
            System.out.println("Insuficiente");
        }
        else {
            System.out.println("Pagamento efetuado com sucesso!");
        }
    }



    @Override
    public boolean checkValidade() {
        return super.checkValidade();
    }





}
