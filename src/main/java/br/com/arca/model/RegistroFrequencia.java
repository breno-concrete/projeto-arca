package br.com.arca.model;

import java.time.LocalDate;

public class RegistroFrequencia {

    private LocalDate data;
    private boolean presente;

    public RegistroFrequencia(){

    }


    public RegistroFrequencia(LocalDate data, boolean presente) {
        this.data = data;
        this.presente = presente;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isPresente() {
        return presente;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    @Override
    public String toString() {
        return "Data: " + data +
                " | Presente: " + (presente ? "Sim" : "Não");
    }
}