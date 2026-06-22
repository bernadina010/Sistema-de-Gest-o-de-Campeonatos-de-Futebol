public class Classificacao {

    private Equipa equipa;

    public Classificacao(Equipa equipa) {
        this.equipa = equipa;
    }

    public Equipa getEquipa() {
        return equipa;
    }

    public int getPontos() {
        return equipa.getPontos();
    }

    public int getSaldoGolos() {
        return equipa.saldoGolos();
    }

    @Override
    public String toString() {

        return equipa.getNomeEquipa() +
                " | Pts: " + equipa.getPontos() +
                " | J: " + equipa.getJogosRealizados() +
                " | V: " + equipa.getVitorias() +
                " | E: " + equipa.getEmpates() +
                " | D: " + equipa.getDerrotas() +
                " | SG: " + equipa.saldoGolos();
    }
}