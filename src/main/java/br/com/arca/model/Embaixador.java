package br.com.arca.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;

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

    public Embaixador(){
        this.historicoPontos = new ArrayList<>();
        this.frequencias = new ArrayList<>();

    }

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


    public void setHistoricoPontos(List<RegistroPontos> historicoPontos) {
        this.historicoPontos = (historicoPontos == null) ? new ArrayList<>() : new ArrayList<>(historicoPontos);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFrequencias(List<RegistroFrequencia> frequencias) {
        this.frequencias = (frequencias == null) ? new ArrayList<>() : new ArrayList<>(frequencias);
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
            throw new IllegalArgumentException("Pontos não podem ser negativos.");
        }

        RegistroPontos registro = new RegistroPontos(semana, pontos);

        historicoPontos.add(registro);
    }

    public void registrarFrequencia(LocalDate data, boolean presente){

        if(data == null){
            throw new IllegalArgumentException("Data da frequência é obrigatória!");
        }

        for (RegistroFrequencia f : frequencias){
            if(f.getData().equals(data)){
                throw new IllegalArgumentException("Essa frequência já foi registrada nessa data.");
            }
        }
        RegistroFrequencia registro = new RegistroFrequencia(data, presente);

        frequencias.add(registro);
    }

    public int calcularPontos(){
        int totalPontos = 0;

        if(historicoPontos == null){
            return 0;
        }

        for(RegistroPontos f : historicoPontos){
            totalPontos = totalPontos + f.getPontos();
        }

        return totalPontos;
    }

    public double calcularPercentualFrequencia(){
        int totalRegistros = frequencias.size();

        if(totalRegistros == 0){
            return 0.0;
        }
        int presentes = 0;

        for(RegistroFrequencia f : frequencias){
            if(f.isPresente() == true){
                presentes += 1;
            }
        }

        return Math.round((presentes * 100.0) / totalRegistros * 100.0) / 100.0;

    }

    public int calcularIdade(){
        if(dataNascimento == null){
            throw new IllegalArgumentException("Data de nascimento não pode ser nula.");
        }

        if(dataNascimento.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Data de nascimento não pode ser futura.");
        }

        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        return idade;

    }

    public String exibirPerfil(){
        int idade = calcularIdade();
        double freqPercent = calcularPercentualFrequencia();
        int pontos = calcularPontos();

        return """
                ===== DADOS PESSOAIS =====
                Nome: %s
                ID: %d
                Idade: %d
                Telefone: %s
                Ano Ingresso: %d
                Total de Pontos: %d
                Percentual de Frequência: %.2f
                Quantidade de Registros (pontos): %d
                Quantidade de Registros (frequência): %d
                
                
                """.formatted(
                        this.nome,
                        this.id,
                        idade,
                        this.telefone,
                        this.anoIngresso,
                        pontos,
                        freqPercent,
                        this.historicoPontos.size(),
                        this.frequencias.size()


        );

    }
}

