package app;

import java.util.Calendar;
import java.util.Date;


public class ePassTurista extends ePass implements TituloTransporte{

    private Date passVal;
    private final int dias;
    private final int precoViagem = 50;
    private Ticket ticket;


    public ePassTurista(String nome, String apelido, int telef, Date data_nasc, DocumentoID docID, int dias, Ticket ticket) {
        super(nome, apelido, telef, data_nasc, docID);
        this.dias = dias;
        this.passVal = DataVal();
        this.ticket = ticket;
        iniciarSaldo();
    }


    public ePassTurista(String nome, String apelido, String morada, String email, int telef, Date data_nasc, DocumentoID docID, int dias, Ticket ticket) {
        super(nome, apelido, morada, email, telef, data_nasc, docID);
        this.passVal = DataVal();
        this.dias = dias;
        this.ticket = ticket;
        iniciarSaldo();
    }



    @Override
    public void carregarEpass(double valor) {
        System.out.println("Não é possivel realizar esta operação");
    }


    @Override
    public void pagarViagemPontos(int pontosViagem) {
        System.out.println("Não é possivel realizar esta operação");
    }


    @Override
    public void passarSaldo(ePass ePass, double valor) {
        if (Calendar.getInstance().getTime().compareTo(passVal) < 0){
            if (getSaldo() > 0){
                setSaldo(getSaldo() - valor);
                ePass.setSaldo(getSaldo() + valor);
                System.out.println("Tranferencia do valor de "+valor+" escudos do passe do titular "+getTitular().getNome()
                        +" para o titular "+ePass.getTitular().getNome()+" foi  realizado com sucesso");
                this.exibeSaldo();
            }

            else {
                System.out.println("Impossivel realizar transferencia ... saldo insuficiente");
            }
        }
        else {
            System.out.println("Impossivel fazer pagamento ... Expirou a data de validade do seu ePass");
        }

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
    public void carregarPontos() {
        System.out.println("Não é possivel realizar esta operação");
    }


    private Date DataVal(){
        Calendar c = Calendar.getInstance();
        Date  dataVal;
        c.add(Calendar.DAY_OF_MONTH, dias);
        dataVal = c.getTime();

        return dataVal;
    }

    private void iniciarSaldo(){
        if (dias == 1){
            setSaldo(500);
        }
        else if (dias == 3){
            setSaldo(700);
        }
        else if (dias == 7){
            setSaldo(1500);
        }
    }

}
