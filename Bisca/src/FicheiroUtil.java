import java.io.*;
//import java.util.ArrayList;

public class FicheiroUtil {

    private static final String PASTA = "dados/";

    // ==========================
    // CAMPEONATO
    // ==========================

    public static void guardarCampeonato(Campeonato campeonato) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(PASTA + "campeonato.txt"))) {

            pw.println(campeonato.getNome());
            pw.println(campeonato.getAno());
            pw.println(campeonato.getQuantidadeEquipas());

        } catch (IOException e) {
            System.out.println("Erro ao guardar campeonato.");
        }
    }

    // ==========================
    // EQUIPAS
    // ==========================

    public static void guardarEquipas(Campeonato campeonato) {

        try (PrintWriter pw = new PrintWriter( new FileWriter( PASTA + "equipas.txt"))) 
        {

            for (Equipa e : campeonato.getListaEquipas()) {

                pw.println("EQUIPA");

                pw.println(e.getIdEquipa());
                pw.println(e.getNomeEquipa());

                Treinador t = e.getTreinador();

                pw.println(t.getIdTreinador());
                pw.println(t.getNome());
                pw.println(t.getIdade());
                pw.println(t.getNacionalidade());

                pw.println(e.getListaJogadores().size());

                for (Jogador j : e.getListaJogadores()) {

                    pw.println(j.getIdJogador());
                    pw.println(j.getNome());
                    pw.println(j.getNumero());
                    pw.println(j.getPosicao());
                }
            }

        } catch (IOException ex) {

            System.out.println("Erro ao guardar equipas.");
        }
    }

    // ==========================
    // JOGOS
    // ==========================

    public static void guardarJogos(Campeonato campeonato) {

        try (PrintWriter pw = new PrintWriter( new FileWriter(PASTA + "jogos.txt"))) 
        {

            for (Jogo jogo : campeonato.getListaJogos()) {

                pw.println(
                        jogo.getEquipaCasa()
                                .getNomeEquipa());

                pw.println(
                        jogo.getEquipaVisitante()
                                .getNomeEquipa());

                pw.println(jogo.getGolosCasa());

                pw.println(jogo.getGolosVisitante());

                pw.println(jogo.isRealizado());
            }

        } catch (IOException ex) {

            System.out.println("Erro ao guardar jogos.");
        }
    }

    // ==========================
    // CLASSIFICAÇÃO
    // ==========================
    

    public static void guardarClassificacao(
            Campeonato campeonato) {

        try (PrintWriter pw = new PrintWriter( new FileWriter(PASTA + "classificacao.txt")))
         {

            for (Equipa e :
                    campeonato.getListaEquipas()) {

                pw.println(
                        e.getNomeEquipa() + ";"
                                + e.getPontos() + ";"
                                + e.getJogosRealizados() + ";"
                                + e.getVitorias() + ";"
                                + e.getEmpates() + ";"
                                + e.getDerrotas() + ";"
                                + e.getGolosMarcados() + ";"
                                + e.getGolosSofridos()
                );
            }

        } catch (IOException ex) {

            System.out.println("Erro ao guardar classificação.");
        }
    }

    // ==========================
    // GUARDAR TUDO
    // ==========================

    public static void guardarTudo(
            Campeonato campeonato) {

        File pasta = new File(PASTA);

        if (!pasta.exists()) {
            pasta.mkdir();
        }

        guardarCampeonato(campeonato);
        guardarEquipas(campeonato);
        guardarJogos(campeonato);
        guardarClassificacao(campeonato);

        System.out.println(
                "Dados guardados com sucesso.");
    }

   private static Equipa procurarEquipa(
        Campeonato campeonato,
        String nomeEquipa) {

    for (Equipa e :
            campeonato.getListaEquipas()) {

        if (e.getNomeEquipa()
                .equals(nomeEquipa)) {

            return e;
        }
    }

    return null;
}

  
    public static Campeonato carregarTudo() {

    Campeonato campeonato = null;

    try {

        // ==========================
        // CAMPEONATO
        // ==========================

        BufferedReader brCamp =
                new BufferedReader(
                        new FileReader(
                                PASTA + "campeonato.txt"));

        String nome = brCamp.readLine();
        int ano = Integer.parseInt(brCamp.readLine());
        int qtdEquipas =
                Integer.parseInt(brCamp.readLine());

        campeonato = new Campeonato(nome, ano);
        campeonato.setQuantidadeEquipas(qtdEquipas);

        brCamp.close();

        // ==========================
        // EQUIPAS
        // ==========================

        BufferedReader brEq =
                new BufferedReader(
                        new FileReader(
                                PASTA + "equipas.txt"));

        String linha;

        while ((linha = brEq.readLine()) != null) {

            if (!linha.equals("EQUIPA")) {
                continue;
            }

            int idEquipa =
                    Integer.parseInt(brEq.readLine());

            String nomeEquipa =
                    brEq.readLine();

            int idTreinador =
                    Integer.parseInt(brEq.readLine());

            String nomeTreinador =
                    brEq.readLine();

            int idadeTreinador =
                    Integer.parseInt(brEq.readLine());

            String nacionalidade =
                    brEq.readLine();

            Treinador treinador =
                    new Treinador(
                            idTreinador,
                            nomeTreinador,
                            idadeTreinador,
                            nacionalidade
                    );

            Equipa equipa =
                    new Equipa(
                            idEquipa,
                            nomeEquipa,
                            treinador
                    );

            int qtdJogadores =
                    Integer.parseInt(brEq.readLine());

            for (int i = 0;
                 i < qtdJogadores;
                 i++) {

                int idJogador =
                        Integer.parseInt(brEq.readLine());

                String nomeJogador =
                        brEq.readLine();

                int numero =
                        Integer.parseInt(brEq.readLine());

                String posicao =
                        brEq.readLine();

                Jogador jogador =
                        new Jogador(
                                idJogador,
                                nomeJogador,
                                numero,
                                posicao
                        );

                equipa.adicionarJogador(jogador);
            }

            campeonato.adicionarEquipa(equipa);
        }

        brEq.close();

        // ==========================
        // JOGOS
        // ==========================

        File jogosFile =
                new File(PASTA + "jogos.txt");

        if (jogosFile.exists()) {

            BufferedReader brJogos =
                    new BufferedReader(
                            new FileReader(jogosFile));

            while (true) {

                String casa =
                        brJogos.readLine();

                if (casa == null)
                    break;

                String visitante =
                        brJogos.readLine();

                int golosCasa =
                        Integer.parseInt(
                                brJogos.readLine());

                int golosVisitante =
                        Integer.parseInt(
                                brJogos.readLine());

                boolean realizado =
                        Boolean.parseBoolean(
                                brJogos.readLine());

                Equipa equipaCasa =
                        procurarEquipa(
                                campeonato,
                                casa);

                Equipa equipaVisitante =
                        procurarEquipa(
                                campeonato,
                                visitante);

                if (equipaCasa != null &&
                        equipaVisitante != null) {

                    Jogo jogo =
                            new Jogo(
                                    equipaCasa,
                                    equipaVisitante,
                                    golosCasa,
                                    golosVisitante,
                                    realizado
                            );

                    campeonato.adicionarJogo(jogo);
                }
            }

            brJogos.close();
        }

        System.out.println(
                "Dados carregados com sucesso!");

    } catch (Exception e) {

        System.out.println(
                "Erro ao carregar dados.");

        e.printStackTrace();
    }

    return campeonato;
}
}