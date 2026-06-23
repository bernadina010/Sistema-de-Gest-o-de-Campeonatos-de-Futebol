
import java.io.*;

public class FicheiroUtil {

    private static final String PASTA = "dados/";
    // ==========================
    // CAMPEONATO
    // ==========================

    public static void guardarCampeonato(Campeonato campeonato) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(FileSystemManager.CAMPEONATO))) {

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

        try (PrintWriter pw =
                     new PrintWriter(new FileWriter(FileSystemManager.EQUIPAS))) {

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

        try (PrintWriter pw =
                     new PrintWriter(new FileWriter(FileSystemManager.JOGOS))) {

            for (Jogo jogo : campeonato.getListaJogos()) {

                pw.println(jogo.getEquipaCasa().getNomeEquipa());
                pw.println(jogo.getEquipaVisitante().getNomeEquipa());
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

    public static void guardarClassificacao(Campeonato campeonato) {

        try (PrintWriter pw =
                     new PrintWriter(new FileWriter(FileSystemManager.CLASSIFICACAO))) {

            for (Equipa e : campeonato.getListaEquipas()) {

                pw.println(
                        e.getNomeEquipa() + ";" +
                        e.getPontos() + ";" +
                        e.getJogosRealizados() + ";" +
                        e.getVitorias() + ";" +
                        e.getEmpates() + ";" +
                        e.getDerrotas() + ";" +
                        e.getGolosMarcados() + ";" +
                        e.getGolosSofridos()
                );
            }

        } catch (IOException ex) {
            System.out.println("Erro ao guardar classificação.");
        }
    }