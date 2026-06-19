public class Jogo {

    private int idJogo;

    private Equipa casa;
    private Equipa visitante;

    private int golosCasa;
    private int golosVisitante;

    private boolean realizado;

    public Jogo(int idJogo, Equipa casa, Equipa visitante) {

        this.idJogo = idJogo;
        this.casa = casa;
        this.visitante = visitante;

        realizado = false;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public Equipa getCasa() {
        return casa;
    }

    public Equipa getVisitante() {
        return visitante;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void simular() {

        golosCasa = (int)(Math.random()*6);
        golosVisitante = (int)(Math.random()*6);

        realizado = true;

        if(golosCasa > golosVisitante)
            casa.adicionarVitoria();

        else if(golosCasa < golosVisitante)
            visitante.adicionarVitoria();

        else{
            casa.adicionarEmpate();
            visitante.adicionarEmpate();
        }
    }

    @Override
    public String toString() {

        if(realizado){

            return casa.getNome() +
                    " " +
                    golosCasa +
                    " x " +
                    golosVisitante +
                    " " +
                    visitante.getNome();
        }

        return casa.getNome() +
                " vs " +
                visitante.getNome();
    }
}