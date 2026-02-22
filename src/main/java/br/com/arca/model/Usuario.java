package br.com.arca.model;

public class Usuario {
    private String nome;
    private int anoNascimento;
    private String telefone;
    private int pontos;
    private int anoIngresso;

    public Usuario(String nome,int anoNascimento, String telefone, int pontos, int anoIngresso){
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.telefone = telefone;
        this.pontos = 0;
        this.anoIngresso = anoIngresso;

    }

    //Getters

    public int getPontos() {
        return pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    //Setters
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setAnoIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", anoNascimento=" + anoNascimento + '\'' +
                ", anoINgresso=" + anoIngresso + '\'' +
                ", pontos=" + pontos +
                '}';
    }
}
