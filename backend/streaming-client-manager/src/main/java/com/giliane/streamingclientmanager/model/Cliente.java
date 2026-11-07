package com.giliane.streamingclientmanager.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String telefone;
    private String painel;
    private int telas;
    private double valor;
    private String vencimento;
    private String status;

    public long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;

    }
    public String getPainelpainel(){
        return painel;
    }
    public void setPainel(String painel){
        this.painel = painel;
    }
    public int getTelas(){
        return telas;
    }
    public void setTelas(int telas){
        this.telas = telas;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(Double valor){
        this.valor = valor;
    }
    public String getVencimento(){
        return vencimento;
    }
    public void setVencimento(String vencimento){
        this.vencimento = vencimento;
    }
    public String getStatus(){
        return status;
    }
    public void setstatus(String status){
        this.status = status;
    }
}

