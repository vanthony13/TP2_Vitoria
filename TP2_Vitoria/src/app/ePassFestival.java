package app;

import java.util.Calendar;
import java.util.Date;


public class ePassFestival extends ePass implements TituloTransporte, CartaoPagamento{
    private double saldoFesta;
    private Date inicioEvento, fimEvento;
    private final int precoViagem = 38;



    public ePassFestival(String nome, String apelido, int telef, Date data_nasc, DocumentoID docID, Date inicioEvento, Date fimEvento) {
        super(nome, apelido, telef, data_nasc, docID);
        this.saldoFesta = 0.0;
        this.inicioEvento = inicioEvento;
        this.fimEvento = fimEvento;
    }




    public ePassFestival(String nome, String apelido, String morada, String email, int telef, Date data_nasc, DocumentoID docID, Date inicioEvento, Date fimEvento) {
        super(nome, apelido, morada, email, telef, data_nasc, docID);
        this.saldoFesta = 0.0;
        this.inicioEvento = inicioEvento;
        this.fimEvento = fimEvento;
    }



    private void carregarSaldoFesta(int valor){
        saldoFesta += valor;
        System.out.println("O saldo de festa do passe do titular "+getTitular().getNome()+" foi carregado com o valor de "+valor+" escudos");
        exibeSaldoFesta();
    }


    @Override
    public void pagarConsumo(int valor){
        if(saldoFesta >= valor){
            saldoFesta -= valor;
            System.out.println("Pagamento do produto realizado com sucesso");
            exibeSaldoFesta();
        }
        else {
            System.out.println("Impossivel realizar o pagamento do produto ... saldo festa insuficente");
        }
    }

    private void exibeSaldoFesta(){
        System.out.println("O saldo do titular "+getTitular().getNome()+" é de "+saldoFesta+" escudos");
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
        System.out.println("Ainda nao esta implementado");
    }


    @Override
    public void carregarEpass(double valor) {
        System.out.println("O passe turista nao pode ser carregado!");//caso o codigo introduzido seja de um passe turista
    }

    @Override
    public void passarSaldo(ePass ePass, double valor) {
        if(Calendar.getInstance().getTime().compareTo(inicioEvento) > 0 && Calendar.getInstance().getTime().compareTo(fimEvento) < 0){
            if (getSaldo() > 0){
                setSaldo(getSaldo() - valor);
                ePass.setSaldo(getSaldo() + valor);
                System.out.println("Tranferencia do valor de "+valor+" escudos do passe do titular "+getTitular().getNome()
                        +" para o titular "+ePass.getTitular().getNome()+" foi realizado com sucesso");
                this.exibeSaldo();
            }

            else {
                System.out.println("Impossivel realizar transferencia ... saldo insuficiente");
            }
        }
        else {
            System.out.println("Impossivel fazer pagamento ... Expirou a data de validade do seu saldo");
        }
    }
}
