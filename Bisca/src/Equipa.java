import java.util.ArrayList;

public class Equipa {

    // Atributos
    private int idEquipa;
    private String nomeEquipa;
    private Treinador treinador;

    private ArrayList<Jogador> listaJogadores;

    private int pontos;
    private int jogosRealizados;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golosMarcados;
    private int golosSofridos;

    // Construtor
    public Equipa(int idEquipa, String nomeEquipa, Treinador treinador) {
        this.idEquipa = idEquipa;
        this.nomeEquipa = nomeEquipa;
        this.treinador = treinador;
        this.listaJogadores = new ArrayList<>();

        this.pontos = 0;
        this.jogosRealizados = 0;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.golosMarcados = 0;
        this.golosSofridos = 0;
    }

    // Getters

    public int getIdEquipa() {
        return idEquipa;
    }

    public String getNomeEquipa() {
        return nomeEquipa;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public ArrayList<Jogador> getListaJogadores() {
        return listaJogadores;
    }

    public int getPontos() {
        return pontos;
    }

    public int getJogosRealizados() {
        return jogosRealizados;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getGolosMarcados() {
        return golosMarcados;
    }

    public int getGolosSofridos() {
        return golosSofridos;
    }

    // Setters

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public void setNomeEquipa(String nomeEquipa) {
        this.nomeEquipa = nomeEquipa;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    // Métodos

    public void adicionarJogador(Jogador jogador) {
        listaJogadores.add(jogador);
    }

    public void removerJogador(Jogador jogador) {
        listaJogadores.remove(jogador);
    }

    public void registrarVitoria(int golosMarcados, int golosSofridos) {

        jogosRealizados++;
        vitorias++;
        pontos += 3;

        this.golosMarcados += golosMarcados;
        this.golosSofridos += golosSofridos;
    }

    public void registrarEmpate(int golosMarcados, int golosSofridos) {

        jogosRealizados++;
        empates++;
        pontos += 1;

        this.golosMarcados += golosMarcados;
        this.golosSofridos += golosSofridos;
    }

    public void registrarDerrota(int golosMarcados, int golosSofridos) {

        jogosRealizados++;
        derrotas++;

        this.golosMarcados += golosMarcados;
        this.golosSofridos += golosSofridos;
    }

    public int saldoGolos() {
        return golosMarcados - golosSofridos;
    }

    public void listarJogadores() {

        System.out.println("\nJogadores da equipa " + nomeEquipa);

        for (Jogador jogador : listaJogadores) {
            System.out.println(jogador);
        }
    }

    @Override
    public String toString() {

        return "ID: " + idEquipa +
               "\nEquipa: " + nomeEquipa +
               "\nTreinador: " + treinador.getNome() +
               "\nPontos: " + pontos +
               "\nJogos: " + jogosRealizados +
               "\nVitórias: " + vitorias +
               "\nEmpates: " + empates +
               "\nDerrotas: " + derrotas +
               "\nGM: " + golosMarcados +
               "\nGS: " + golosSofridos;
    }
}