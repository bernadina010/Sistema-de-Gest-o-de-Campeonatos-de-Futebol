import java.util.ArrayList;

public class Campeonato {

    // Atributos
    private String nomec;
    private int ano;
    private int quantidadeEquipas;
    private ArrayList<Equipa> listaEquipas;
    private ArrayList<Jogo> listaJogos;
    private ArrayList<Classificacao> tabelaClassificacao;

    // Construtor
    public Campeonato(String nomec, int ano) {
        this.nomec = nomec;
        this.ano = ano;
        this.quantidadeEquipas = 0;
        this.listaEquipas = new ArrayList<>();
        this.listaJogos = new ArrayList<>();
        this.tabelaClassificacao = new ArrayList<>();
    }

    // Gets
    public String getNome() {
        return nomec;
    }

    public int getAno() {
        return ano;
    }

    public int getQuantidadeEquipas() {
        return quantidadeEquipas;
    }

    public ArrayList<Equipa> getListaEquipas() {
        return listaEquipas;
    }

    public ArrayList<Jogo> getListaJogos() {
        return listaJogos;
    }

    public ArrayList<Classificacao> getTabelaClassificacao() {
        return tabelaClassificacao;
    }

    // Sets
    public void setNome(String nome) {
        this.nomec = nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // Adicionar equipa ao campeonato
    public void adicionarEquipa(Equipa equipa) {
        listaEquipas.add(equipa);
        quantidadeEquipas++;
    }

    // Organizar equipas
    public void organizarEquipas() {
        System.out.println("\n=== Equipas Participantes ===");

        for (Equipa equipa : listaEquipas) {
            System.out.println(equipa.getNomeEquipa());
        }
    }

    // Gerar calendário de jogos
    public void gerarCalendarioJogos() {

        for (int i = 0; i < listaEquipas.size(); i++) {

            for (int j = i + 1; j < listaEquipas.size(); j++) {

                Equipa casa = listaEquipas.get(i);
                Equipa visitante = listaEquipas.get(j);

                Jogo jogo = new Jogo(casa, visitante);

                listaJogos.add(jogo);
            }
        }

        System.out.println("Calendário gerado com sucesso!");
    }

    // Mostrar jogos
    public void mostrarJogos() {

        System.out.println("\n=== Lista de Jogos ===");

        for (Jogo jogo : listaJogos) {
            System.out.println(jogo);
        }
    }

    // Atualizar classificação
    public void atualizarClassificacao() {

        tabelaClassificacao.clear();

        for (Equipa equipa : listaEquipas) {

            Classificacao classificacao =
                    new Classificacao(equipa);

            tabelaClassificacao.add(classificacao);
        }
    }

    // Mostrar classificação
    public void mostrarClassificacao() {

        System.out.println("\n=== Tabela Classificativa ===");

        for (Classificacao c : tabelaClassificacao) {
            System.out.println(c);
        }
    }

    @Override
    public String toString() {
        return "Campeonato{" +
                "nome='" + nomec + '\'' +
                ", ano=" + ano +
                ", quantidadeEquipas=" + quantidadeEquipas +
                '}';
    }
}