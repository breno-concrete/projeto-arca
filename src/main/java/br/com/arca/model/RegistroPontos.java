package br.com.arca.model;
import java.time.LocalDate;

public class RegistroPontos {
    private String semana;
    private int pontos;
    private LocalDate dataRegistro;

    public RegistroPontos(String semana, int pontos){
        this.semana = semana;
        this.pontos = pontos;
        this.dataRegistro = LocalDate.now();


    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getSemana() {
        return semana;
    }

    public int getPontos() {
        return pontos;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    @Override
    public String toString() {
        return "Semana: " + semana +
                " | Pontos: " + pontos +
                " | Data: " + dataRegistro;
    }
}
