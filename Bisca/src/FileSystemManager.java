import java.io.File;

public class FileSystemManager {

    public static final String PASTA = "dados";

    public static final String CAMPEONATO = PASTA + "/campeonato.txt";
    public static final String EQUIPAS = PASTA + "/equipas.txt";
    public static final String JOGOS = PASTA + "/jogos.txt";
    public static final String CLASSIFICACAO = PASTA + "/classificacao.txt";

    public static void inicializar() {

        File pasta = new File(PASTA);

        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        criarFicheiroSeNaoExiste(CAMPEONATO);
        criarFicheiroSeNaoExiste(EQUIPAS);
        criarFicheiroSeNaoExiste(JOGOS);
        criarFicheiroSeNaoExiste(CLASSIFICACAO);
    }

    private static void criarFicheiroSeNaoExiste(String path) {
        try {
            File f = new File(path);

            if (!f.exists()) {
                f.createNewFile();
            }

        } catch (Exception e) {
            System.out.println("Erro ao criar ficheiro: " + path);
        }
    }
}