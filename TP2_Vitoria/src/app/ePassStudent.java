package app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ePassStudent extends ePass implements TituloTransporte{

    private int ano;
    private final int precoViagem = 20;
    private int viagensFree = 4;
    private ArrayList<Zona> zona;
    private Date dataCarregamento, dataValidade;

    public ePassStudent(){
        this.ano=0;
    }

    public ePassStudent(String nome, String apelido, int telef, Date data_nasc, DocumentoID docID, int anoEscolaridade,  ArrayList<Zona> zona) {
        super(nome, apelido, telef, data_nasc, docID);
        this.ano = anoEscolaridade;
        this.zona = zona;
        this.dataValidade = gerarDataVal();
        this.dataCarregamento = Calendar.getInstance().getTime();
    }


    public ePassStudent(String nome, String apelido, String morada, String email, int telef, Date data_nasc, DocumentoID docID, int anoEscolaridade,  ArrayList<Zona> zona) {
        super(nome, apelido, morada, email, telef, data_nasc, docID);
        this.ano = anoEscolaridade;
        this.zona = zona;
        this.dataValidade = gerarDataVal();
        this.dataCarregamento = Calendar.getInstance().getTime();
    }



    private Date gerarDataVal(){
        Calendar c = Calendar.getInstance();

        Date  dataVal;

        c.add(Calendar.DAY_OF_MONTH, 30);
        dataVal = c.getTime();

        return dataVal;
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
        dataCarregamento = Calendar.getInstance().getTime();
        setSaldo( getSaldo() + valor);
        viagensFree = 4;
        System.out.println("O passe do titular "+getTitular().getNome()+" foi carregado com o valor de "+getSaldo()+" escudos");
        exibeSaldo();
    }

    public Date getDataCarregamento() {
        return dataCarregamento;
    }

    @Override
    public void passarSaldo(ePass ePass, double valor) {

        if(Calendar.getInstance().getTime().compareTo(dataValidade) < 0){
            if (getSaldo() > 0){
                setSaldo(getSaldo() - valor);
                ePass.setSaldo(getSaldo() + valor);
                System.out.println("Tranferencia do valor de "+valor+" escudos do passe do titular "+getTitular().getNome()
                        +" para o titular "+ePass.getTitular().getNome()+" realizado com sucesso");
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

    public boolean verificarZona(String z){
        boolean verifZona = false;

       for (int i=0; i < zona.size(); i++){

           verifZona = z.equalsIgnoreCase(zona.get(i).getZona());
       }

        return verifZona;
    }
}
