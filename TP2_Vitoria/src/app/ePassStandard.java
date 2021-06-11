package app;

import java.util.Date;

public class ePassStandard extends ePass implements TituloTransporte {


    public ePassStandard(String nome, String apelido, int telef, Date data_nasc, DocumentoID docID) {
        super(nome, apelido, telef, data_nasc, docID);
    }

    public ePassStandard(String nome, String apelido, String morada, String email, int telef, Date data_nasc, DocumentoID docID) {
        super(nome, apelido, morada, email, telef, data_nasc, docID);
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
    public void validarTitulo() {

        System.out.println("Ainda nao esta implementao");
    }

    @Override
    public void carregarEpass(double valor) {

        setSaldo(getSaldo() + valor);
        System.out.println("O passe do titular "+getTitular().getNome()+" foi carregado com o valor de "+valor+" escudos");
        exibeSaldo();
    }

    @Override
    public void passarSaldo(ePass ePass, double valor) {
        if (getSaldo() > 0){
            setSaldo(getSaldo() - valor);
            ePass.setSaldo(getSaldo() +valor);
            System.out.println("Tranferencia do valor de "+valor+" escudos do passe  do titular "+getTitular().getNome()
                    +" para o titular "+ePass.getTitular().getNome()+" realizado com sucesso");
            this.exibeSaldo();
        }

        else {
            System.out.println("Impossivel realizar transferencia ... saldo insuficiente");
        }
    }


}
