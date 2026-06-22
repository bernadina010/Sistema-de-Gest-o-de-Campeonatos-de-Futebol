public class Jogador {

    private int idJogador;
    private String nomej;
    private int numero;
    private String posicao;

    public Jogador(int idJogador, String nomej,int numero, String posicao) {

        this.idJogador = idJogador;
        this.nomej = nomej;
        this.numero = numero;
        this.posicao = posicao;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public String getNome() {
        return nomej;
    }

    public int getNumero() {
        return numero;
    }

    public String getPosicao() {
        return posicao;
    }

    @Override
    public String toString() {
        return numero + " - " + nomej + " (" + posicao + ")";
    }
}