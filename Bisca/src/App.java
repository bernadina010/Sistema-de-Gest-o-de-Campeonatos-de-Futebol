import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        FileSystemManager.inicializar();
        Scanner input = new Scanner(System.in);

        ArrayList<Campeonato> campeonatos = new ArrayList<>();

        int opcao;

        do {

                    // Cores ANSI
            String AZUL = "\u001B[34m";
            String RESET = "\u001B[0m";
            String NEGRITO = "\u001B[1m";

            System.out.println(AZUL + NEGRITO);
            System.out.println("+========================================+");
            System.out.println("|        SISTEMA DE CAMPEONATO           |");
            System.out.println("+========================================+" + RESET);

            System.out.println(AZUL + "----------------------------------------" + RESET);

            System.out.println("1. Criar Campeonato");
            System.out.println("2. Cadastrar Equipa");
            System.out.println("3. Gerar Tabela de Jogos");
            System.out.println("4. Simular Jogo");
            System.out.println("5. Ver Classificação");
            System.out.println("6. Ver Detalhes da Equipa");
            System.out.println("7. Guardar Dados");
            System.out.println("8. Carregar Dados");
            System.out.println("9. Listar Jogos");
            System.out.println("10.Listar Equipas");

            System.out.println(AZUL + "----------------------------------------" + RESET);
            System.out.println("0. Sair");

            System.out.println(AZUL + "========================================" + RESET);
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {

                // =========================
                // 1. CRIAR CAMPEONATO
                // =========================
                case 1:

                    System.out.print("Nome do campeonato: ");
                    String nomeCamp = input.nextLine();

                    System.out.print("Ano: ");
                    int ano = input.nextInt();
                    input.nextLine();

                    campeonatos.add(new Campeonato(nomeCamp, ano));

                    System.out.println("Campeonato criado com sucesso!");
                    break;

                // =========================
                // 2. CADASTRAR EQUIPA
                // =========================
                case 2:

                    if (campeonatos.isEmpty()) {
                        System.out.println("Crie primeiro um campeonato.");
                        break;
                    }

                    Campeonato camp = campeonatos.get(0);

                    System.out.println("\n1 - Manual");
                    System.out.println("2 - Ficheiro");
                    System.out.print("Modo: ");
                    int modo = input.nextInt();
                    input.nextLine();

                    if (modo == 1) {

                        // =========================
                        // MANUAL
                        // =========================

                        System.out.print("ID Equipa: ");
                        int idEq = input.nextInt();
                        input.nextLine();

                        System.out.print("Nome Equipa: ");
                        String nomeEq = input.nextLine();

                        System.out.print("ID Treinador: ");
                        int idT = input.nextInt();
                        input.nextLine();

                        System.out.print("Nome Treinador: ");
                        String nomeT = input.nextLine();

                        System.out.print("Idade: ");
                        int idadeT = input.nextInt();
                        input.nextLine();

                        System.out.print("Nacionalidade: ");
                        String nac = input.nextLine();

                        Treinador treinador =
                                new Treinador(idT, nomeT, idadeT, nac);

                        Equipa equipa =
                                new Equipa(idEq, nomeEq, treinador);

                        int count = 0;

                        while (count < 24) {

                            System.out.print("Adicionar jogador? (s/n): ");
                            String resp = input.nextLine();

                            if (!resp.equalsIgnoreCase("s")) break;

                            System.out.print("ID Jogador: ");
                            int idJ = input.nextInt();
                            input.nextLine();

                            System.out.print("Nome: ");
                            String nomeJ = input.nextLine();

                            System.out.print("Numero: ");
                            int num = input.nextInt();
                            input.nextLine();

                            System.out.print("Posição: ");
                            String pos = input.nextLine();

                            equipa.adicionarJogador(
                                    new Jogador(idJ, nomeJ, num, pos)
                            );

                            count++;
                        }

                        camp.adicionarEquipa(equipa);

                        System.out.println("Equipa criada!");

                    } else if (modo == 2) {

                        // =========================
                        // FICHEIRO (BASE)
                        // =========================

                        System.out.print("Nome ficheiro: ");
                        //String file = input.nextLine();

                        System.out.println("Funcionalidade de ficheiro ainda não implementada.");
                    }

                    break;

                // =========================
                // 3. GERAR CALENDÁRIO
                // =========================
                case 3:

                    if (!campeonatos.isEmpty()) {
                        campeonatos.get(0).gerarCalendarioJogos();
                        System.out.println("Calendário gerado.");
                    }

                    break;

                // =========================
                // 4. SIMULAR JOGO
                // =========================
                case 4:

                    if (campeonatos.isEmpty()) break;

                    Campeonato c4 = campeonatos.get(0);

                    if (c4.getListaJogos().isEmpty()) {
                        System.out.println("Sem jogos.");
                        break;
                    }

                    for (int i = 0; i < c4.getListaJogos().size(); i++) {
                        System.out.println((i + 1) + " - " +
                                c4.getListaJogos().get(i));
                    }

                    System.out.print("Escolha jogo: ");
                    int j = input.nextInt() - 1;

                    System.out.print("Golos casa: ");
                    int gc = input.nextInt();

                    System.out.print("Golos fora: ");
                    int gf = input.nextInt();

                    c4.getListaJogos()
                            .get(j)
                            .registrarResultado(gc, gf);

                    System.out.println("Jogo simulado.");
                    break;

                // =========================
                // 5. CLASSIFICAÇÃO
                // =========================
                case 5:

                    if (!campeonatos.isEmpty()) {

                        Campeonato c5 = campeonatos.get(0);

                        System.out.println("\nCLASSIFICAÇÃO");

                        for (Equipa e : c5.getListaEquipas()) {
                            System.out.println(e);
                        }
                    }

                    break;

                // =========================
                // 6. DETALHES EQUIPA
                // =========================
                case 6:

                    if (!campeonatos.isEmpty()) {

                        Campeonato c6 = campeonatos.get(0);

                        for (Equipa e : c6.getListaEquipas()) {
                            System.out.println(e);
                            System.out.println("----------------");
                        }
                    }

                    break;

                // =========================
                // 7. GUARDAR DADOS
                // =========================
                case 7:

                    if(campeonatos.isEmpty()) 
                    {
                    System.out.println("Nenhum campeonato encontrado.");
                    break;
                    }

                      FicheiroUtil.guardarTudo(campeonatos.get(0));

                    break;

                // =========================
                // 8. CARREGAR DADOS
                // =========================
                case 8:

                    Campeonato carregado = FicheiroUtil.carregarTudo();

                    if (carregado != null) {

                        campeonatos.clear();
                        campeonatos.add(carregado);

                        System.out.println(  "Campeonato carregado.");
                    }

                    break;
                // =========================
                // 0. SAIR
                // =========================
                case 0:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        input.close();
    }
}