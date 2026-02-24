package br.com.arca.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Embaixador {
    private long id;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String pai;
    private String mae;
    private String telefoneResp;
    private List<RegistroPontos> historicoPontos;
    private List<RegistroFrequencia> frequencias;
    private int anoIngresso;

    //Construtor

    public Embaixador(long id, String nome, LocalDate dataNascimento, String telefone, String pai, String mae, String telefoneResp, int anoIngresso) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.pai = pai;
        this.mae = mae;
        this.telefoneResp = telefoneResp;
        this.historicoPontos = new ArrayList<>();
        this.frequencias = new ArrayList<>();
        this.anoIngresso = anoIngresso;

    }



    //Getters

    public long getId() {
        return id;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public List<RegistroFrequencia> getFrequencias() {
        return List.copyOf(frequencias);
    }

    public List<RegistroPontos> getHistoricoPontos() {
        return List.copyOf(historicoPontos);
    }

    public String getTelefoneResp() {
        return telefoneResp;
    }

    public String getMae() {
        return mae;
    }

    public String getPai() {
        return pai;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }


    //Setters


    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public void setTelefoneResp(String telefoneResp) {
        this.telefoneResp = telefoneResp;
    }


    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    //Métodos

    public void adicionarPontos(String semana, int pontos){

        if(semana == null || semana.isBlank()){
            throw new IllegalArgumentException("Semana é obrigatória.");
        }

        if(pontos < 0){
            throw new IllegalArgumentException("Pontos nÃ£o podem ser negativos.");
        }
        RegistroPontos registro = new RegistroPontos(semana, pontos);

        historicoPontos.add(registro);
    }

    public void registrarFrequencia(LocalDate data, boolean presente){

        if(data == null){
            throw new IllegalArgumentException("Data da frequÃªncia Ã© obrigatÃ³ria!");
        }

        for (RegistroFrequencia f : frequencias){
            if(f.getData().equals(data)){
                throw new IllegalArgumentException("Essa frequência já foi registrada nessa data.");
            }
        }
        RegistroFrequencia registro = new RegistroFrequencia(data, presente);

        frequencias.add(registro);
    }
}

