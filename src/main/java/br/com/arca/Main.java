package br.com.arca;

import br.com.arca.model.Embaixador;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args){
        System.out.println("=== TESTE ARCA ===");

        Embaixador embaixador = new Embaixador(
                1L,
                "Joao Silva",
                LocalDate.of(2010, 5, 10),
                "(11) 99999-0000",
                "Pai Exemplo",
                "Mae Exemplo",
                "(11) 98888-0000",
                2024
        );

        System.out.println("\n1) Perfil inicial (sem pontos/frequencia):");
        System.out.println(embaixador.exibirPerfil());

        System.out.println("2) Adicionando pontos...");
        embaixador.adicionarPontos("Semana 1", 10);
        embaixador.adicionarPontos("Semana 2", 15);
        System.out.println("Total de pontos esperado: 25");
        System.out.println("Total de pontos obtido : " + embaixador.calcularPontos());

        System.out.println("\n3) Registrando frequencia...");
        embaixador.registrarFrequencia(LocalDate.of(2026, 3, 1), true);
        embaixador.registrarFrequencia(LocalDate.of(2026, 3, 2), false);
        embaixador.registrarFrequencia(LocalDate.of(2026, 3, 3), true);
        System.out.println("Frequencia esperada: 66.67");
        System.out.println("Frequencia obtida : " + embaixador.calcularPercentualFrequencia());

        System.out.println("\n4) Perfil apos lancamentos:");
        System.out.println(embaixador.exibirPerfil());

        System.out.println("5) Testes de erro esperados:");
        try {
            embaixador.adicionarPontos("", 5);
        } catch (IllegalArgumentException e) {
            System.out.println("- Erro esperado (semana vazia): " + e.getMessage());
        }

        try {
            embaixador.adicionarPontos("Semana 3", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("- Erro esperado (pontos negativos): " + e.getMessage());
        }

        try {
            embaixador.registrarFrequencia(LocalDate.of(2026, 3, 1), true);
        } catch (IllegalArgumentException e) {
            System.out.println("- Erro esperado (frequencia duplicada): " + e.getMessage());
        }

        System.out.println("\n=== FIM DOS TESTES ===");

    }
}
