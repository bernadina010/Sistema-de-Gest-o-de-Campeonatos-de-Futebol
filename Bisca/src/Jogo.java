public class Jogo {

    private Equipa equipaCasa;
    private Equipa equipaVisitante;

    private int golosCasa;
    private int golosVisitante;

    private boolean realizado;

    // ==================================================
    // Construtor para gerar calendário de jogos
    // ==================================================

    public Jogo(Equipa equipaCasa, Equipa equipaVisitante) {

        this.equipaCasa = equipaCasa;
        this.equipaVisitante = equipaVisitante;

        this.golosCasa = 0;
        this.golosVisitante = 0;

        this.realizado = false;
    }

    // ==================================================
    // Construtor para carregar jogos do ficheiro
    // ==================================================

    public Jogo(Equipa equipaCasa,
                Equipa equipaVisitante,
                int golosCasa,
                int golosVisitante,
                boolean realizado) {

        this.equipaCasa = equipaCasa;
        this.equipaVisitante = equipaVisitante;
        this.golosCasa = golosCasa;
        this.golosVisitante = golosVisitante;
        this.realizado = realizado;
    }

    public void registrarResultado(int golosCasa,
                                   int golosVisitante) {

        this.golosCasa = golosCasa;
        this.golosVisitante = golosVisitante;

        if (golosCasa > golosVisitante) {

            equipaCasa.registrarVitoria(golosCasa, golosVisitante);
            equipaVisitante.registrarDerrota(golosVisitante, golosCasa);

        } else if (golosCasa < golosVisitante) {

            equipaVisitante.registrarVitoria(golosVisitante, golosCasa);
            equipaCasa.registrarDerrota(golosCasa, golosVisitante);

        } else {

            equipaCasa.registrarEmpate(golosCasa, golosVisitante);
            equipaVisitante.registrarEmpate(golosVisitante, golosCasa);
        }

        realizado = true;
    }

    public Equipa getEquipaCasa() {
        return equipaCasa;
    }

    public Equipa getEquipaVisitante() {
        return equipaVisitante;
    }

    public int getGolosCasa() {
        return golosCasa;
    }

    public int getGolosVisitante() {
        return golosVisitante;
    }

    public boolean isRealizado() {
        return realizado;
    }

    @Override
    public String toString() {

        if (realizado) {

            return equipaCasa.getNomeEquipa()
                    + " " + golosCasa
                    + " x " + golosVisitante
                    + " " + equipaVisitante.getNomeEquipa();
        }

        return equipaCasa.getNomeEquipa()
                + " vs "
                + equipaVisitante.getNomeEquipa();
    }
}