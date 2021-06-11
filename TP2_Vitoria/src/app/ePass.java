package app;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;


public abstract class ePass{
    private int cod, viagens, pontos;
    private Titular titular;
    private double saldo;
    private double preco ;
    private static int ult_cod;
    private String chave_val;
    private LocalDate dataValida;
    private Date dataCarrega;

    public LocalDate getDataValida() {
        return dataValida;
    }

    public void setDataValida(LocalDate dataValida) {
        this.dataValida = dataValida;
    }

    public Date getDataCarrega() {
        return dataCarrega;
    }

    public void setDataCarrega(Date dataCarrega) {
        this.dataCarrega = dataCarrega;
    }

    private final int precoViagem = 38;

    public ePass(){

    }

public ePass(double saldo, double preco , Date dataCarrega , LocalDate dataValida  ){
        this.saldo=saldo;
        this.preco=preco;
        this.dataCarrega=dataCarrega;
        this.dataValida=dataValida;


    }

    public ePass(String nome, String apelido, int telef, Date data_nasc, DocumentoID docID) {
        this.titular = new Titular(nome, apelido, telef, data_nasc, docID);
        this.viagens = 0;
        this.saldo = 0.0;
        this.pontos = 0;
        this.cod = ePass.ult_cod + 1;
        ePass.ult_cod = this.cod;
        this.chave_val = criarChave();

    }


    public ePass(String nome, String apelido, String morada, String email, int telef, Date data_nasc, DocumentoID docID) {
        this.titular = new Titular(nome, apelido, morada, email, telef, data_nasc, docID);
        this.viagens = 0;
        this.saldo = 0.0;
        this.pontos = 0;
        this.cod = ePass.ult_cod + 1;
        ePass.ult_cod = this.cod;

    }


    public void exibeSaldo(){
        System.out.println("O saldo do titular "+titular.getNome()+" é de "+saldo+" escudos");
    }


    public abstract void carregarEpass(double valor);



    public void pagarViagemPontos(int pontosViagem){
        if (pontosViagem >= 100){
            pontosViagem -= 40;
            System.out.println("Pagamento da viagem com pontos realizado com sucesso");
        }
        else {
            System.out.println("Impossivel realizar pagamento ... pontos insuficientes");
        }

    }



    public abstract void passarSaldo(ePass ePass, double valor);



    public void carregarPontos(){
        pontos = 0;
        pontos = viagens / 10 ;
    }

    public boolean checkValidade(){
        LocalDate today= LocalDate.now();
        if(this.getDataValida().isAfter(today))
            return true;
        return false;
    }


    private String criarChave(){
        String chave = "", name = "", surname = "";
        String[] s1 ={}, s2 = {}, d1 = {};

        s1 = titular.getNome().split("");
        s2 = titular.getApelido().split("");


        for (int i = s1.length - 1; i >= 0; i --){
            if(name.length() <= 5){
                name += s1[i].toUpperCase();
            }
        }

        for (int i = s2.length - 1; i >= 0; i --){
            if(surname.length() <= 5){
                surname += s2[i].toUpperCase();
            }
        }

        DateFormat f = DateFormat.getDateInstance();
        String data = f.format(titular.getData_nasc());


        d1 = data.split("/");

        chave = name+surname+d1[2]+"-"+d1[1]+"-"+d1[0]+cod;
        return chave;
    }


    public int getCod() {
        return cod;
    }

    public static int getUlt_cod() {
        return ult_cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getViagens() {
        return viagens;
    }

    public void setViagens(int viagens) {
        this.viagens = viagens;
    }


    public int getPontos() {
        return pontos;
    }


    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Titular getTitular() {
        return titular;
    }


    public void setTitular(Titular titular) {
        this.titular = titular;
    }


    public double getSaldo() {
        return saldo;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



    public String getChave_val() {
        return chave_val;
    }


    public void setChave_val(String chave_val) {
        this.chave_val = chave_val;
    }


    public int getPrecoViagem() {
        return precoViagem;
    }


    @Override
    public String toString() {
        return "ePass{" +
                "cod=" + cod +
                ", viagens=" + viagens +
                ", pontos=" + pontos +
                ", titular=" + titular +
                ", saldo=" + saldo +
                ", chave_val='" + chave_val + '\'' +
                ", precoViagem=" + precoViagem +
                '}';
    }
}
