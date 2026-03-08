package br.com.arca;

import br.com.arca.model.Embaixador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Embaixador> embaixadores = new ArrayList<>();

        int opcao = -1;
        while (opcao != 0) {
            exibirMenuPrincipal();
            opcao = lerOpcao(scan);

            switch (opcao) {
                case 1 -> menuCrud(embaixadores, scan);
                case 2 -> lancamentoSemanal(embaixadores, scan);
                case 3 -> verDadosEmbaixador(embaixadores, scan);
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opcao invalida. Tente novamente.");
            }

            System.out.println();
        }


        scan.close();

    }
    private static void exibirMenuPrincipal() {
        System.out.println("""
                ===== INTERFACE A.R.C.A =====
                1 - CRUD DE EMBAIXADORES
                2 - LANCAMENTO SEMANAL (PONTOS + FREQUENCIA)
                3 - VER DADOS DE UM EMBAIXADOR
                0 - SAIR
                """);
    }


    private static int lerOpcao(Scanner scan) {
        System.out.print("Escolha uma opcao: ");
        String entrada = scan.nextLine();

        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void menuCrud(List<Embaixador> embaixadores, Scanner scan) {
        int opcaoCrud = -1;

        while (opcaoCrud != 0) {
            System.out.println("""
                ===== CRUD DE EMBAIXADORES =====
                1 - Cadastrar
                2 - Listar
                3 - Editar
                4 - Remover
                0 - Voltar
                """);

            opcaoCrud = lerOpcao(scan);

            switch (opcaoCrud) {
                case 1 -> cadastrarEmbaixador(embaixadores, scan);
                case 2 -> listarEmbaixadores(embaixadores);
                case 3 -> editarEmbaixador(embaixadores, scan);
                case 4 -> removerEmbaixador(embaixadores, scan);
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opcao invalida.");
            }

            System.out.println();
        }
    }

    private static void cadastrarEmbaixador(List<Embaixador> embaixadores, Scanner scan) {
        System.out.println("=== Cadastro de Embaixador ===");

        long id = proximoId(embaixadores);

        System.out.println("Nome: ");
        String nome = scan.nextLine();

        LocalDate dataNascimento = lerData(scan, "Data de nascimento (yyyy-MM-dd): ");

        System.out.print("Telefone: ");
        String telefone = scan.nextLine();

        System.out.print("Nome do pai: ");
        String pai = scan.nextLine();

        System.out.print("Nome da mae: ");
        String mae = scan.nextLine();

        System.out.print("Telefone do responsavel: ");
        String telefoneResp = scan.nextLine();

        int anoIngresso = lerInteiro(scan, "Ano de ingresso: ");

        Embaixador novo = new Embaixador(
                id, nome, dataNascimento, telefone, pai, mae, telefoneResp, anoIngresso
        );

        embaixadores.add(novo);
        System.out.println("Embaixador cadastrado com sucesso. ID: " + id);

    }

    private static void listarEmbaixadores(List<Embaixador> embaixadores) {
        System.out.println("=== Lista de Embaixadores ===");

        if (embaixadores.isEmpty()) {
            System.out.println("Nenhum embaixador cadastrado.");
            return;
        }

        for (Embaixador e : embaixadores) {
            System.out.printf("ID: %d | Nome: %s | Ano ingresso: %d%n",
                    e.getId(), e.getNome(), e.getAnoIngresso());
        }
    }

    private static long proximoId(List<Embaixador> embaixadores) {
        long maior = 0;
        for (Embaixador e : embaixadores) {
            if (e.getId() > maior) {
                maior = e.getId();
            }
        }
        return maior + 1;
    }

    private static int lerInteiro(Scanner scan, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scan.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero inteiro.");
            }
        }
    }

    private static LocalDate lerData(Scanner scan, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scan.nextLine();

            try {
                return LocalDate.parse(entrada);
            } catch (DateTimeParseException e) {
                System.out.println("Data invalida. Use o formato yyyy-MM-dd.");
            }
        }
    }

    private static void editarEmbaixador(List<Embaixador> embaixadores, Scanner scan) {
        if (embaixadores.isEmpty()) {
            System.out.println("Nao ha embaixadores cadastrados.");
            return;
        }
        listarEmbaixadores(embaixadores);
        long id = lerInteiro(scan, "ID do embaixador para editar: ");
        Embaixador embaixador = buscarPorId(embaixadores, id);

        if (embaixador == null) {
            System.out.println("Embaixador nao encontrado.");
            return;
        }

        System.out.print("Novo nome (atual: " + embaixador.getNome() + "): ");
        String nome = scan.nextLine();
        if (!nome.isBlank()) embaixador.setNome(nome);

        System.out.print("Nova data nascimento yyyy-MM-dd (atual: " + embaixador.getDataNascimento() + ", Enter para manter): ");
        String dataTexto = scan.nextLine();
        if (!dataTexto.isBlank()) {
            try {
                embaixador.setDataNascimento(LocalDate.parse(dataTexto));
            } catch (DateTimeParseException e) {
                System.out.println("Data invalida. Mantida a data anterior.");
            }
        }

        System.out.print("Novo telefone (atual: " + embaixador.getTelefone() + "): ");
        String telefone = scan.nextLine();
        if (!telefone.isBlank()) embaixador.setTelefone(telefone);

        System.out.print("Novo pai (atual: " + embaixador.getPai() + "): ");
        String pai = scan.nextLine();
        if (!pai.isBlank()) embaixador.setPai(pai);

        System.out.print("Nova mae (atual: " + embaixador.getMae() + "): ");
        String mae = scan.nextLine();
        if (!mae.isBlank()) embaixador.setMae(mae);

        System.out.print("Novo telefone responsavel (atual: " + embaixador.getTelefoneResp() + "): ");
        String telefoneResp = scan.nextLine();
        if (!telefoneResp.isBlank()) embaixador.setTelefoneResp(telefoneResp);

        System.out.print("Novo ano ingresso (atual: " + embaixador.getAnoIngresso() + ", Enter para manter): ");
        String anoTexto = scan.nextLine();
        if (!anoTexto.isBlank()) {
            try {
                embaixador.setAnoIngresso(Integer.parseInt(anoTexto));
            } catch (NumberFormatException e) {
                System.out.println("Ano invalido. Mantido o ano anterior.");
            }
        }

        System.out.println("Embaixador atualizado com sucesso.");
    }

    private static void removerEmbaixador(List<Embaixador> embaixadores, Scanner scan) {
        listarEmbaixadores(embaixadores);

        if (embaixadores.isEmpty()) {
            System.out.println("Nao ha embaixadores cadastrados.");
            return;
        }

        long id = lerInteiro(scan, "ID do embaixador para remover: ");
        Embaixador embaixador = buscarPorId(embaixadores, id);

        if (embaixador == null) {
            System.out.println("Embaixador nao encontrado.");
            return;
        }

        embaixadores.remove(embaixador);
        System.out.println("Embaixador removido com sucesso.");
    }

    private static Embaixador buscarPorId(List<Embaixador> embaixadores, long id) {
        for (Embaixador e : embaixadores) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    private static void verDadosEmbaixador(List<Embaixador> embaixadores, Scanner scan) {
        System.out.println("Visualizacao de dados: sera implementado no proximo passo.");
    }

    private static void lancamentoSemanal(List<Embaixador> embaixadores, Scanner scan) {
        if (embaixadores.isEmpty()) {
            System.out.println("Nao ha embaixadores cadastrados.");
            return;
        }
        System.out.print("Semana de referencia (ex: 2026-S10): ");
        String semana = scan.nextLine().trim();

        for (Embaixador embaixador : embaixadores) {
            System.out.println(embaixador.getNome());

            int pontos = lerInteiro(scan, "Pontos da semana: ");
            LocalDate dataFrequencia = lerData(scan, "Data da frequencia (yyyy-MM-dd): ");
            boolean presente = lerPresenca(scan);

            try {
                embaixador.adicionarPontos(semana, pontos);
                embaixador.registrarFrequencia(dataFrequencia, presente);
                System.out.println("Lancamento semanal registrado com sucesso.");
            } catch (IllegalArgumentException ex) {
                System.out.println("Erro ao registrar lancamento: " + ex.getMessage());
            }
        }
    }

    private static boolean lerPresenca(Scanner scan) {
        while (true) {
            System.out.print("Presente na semana? (S/N): ");
            String entrada = scan.nextLine().trim().toUpperCase();

            if (entrada.equals("S")) return true;
            if (entrada.equals("N")) return false;

            System.out.println("Entrada invalida. Digite S ou N.");
        }
    }
}