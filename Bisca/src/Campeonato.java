import java.util.ArrayList;

public class Campeonato {

    private String nome;
    private int ano;
    private String tipo;

    private ArrayList<Equipa> equipas;
    private ArrayList<Jogo> jogos;

    public void setnome(String nome){
      this.nome = nome;
    } 

     public String getnome(){
      return nome;
    } 

      public void setano(int ano){
      this.ano = ano;
    } 

     public int  getano(){
      return ano;
    } 

    public void settipo(String tipo){
        this.tipo = tipo;
    }
    
    public String gettipo(){
      return tipo;
    }
    
    public Campeonato() {

        equipas = new ArrayList<>();
        jogos = new ArrayList<>();
    }

    public void criar(String nome, int ano) {

        this.nome = nome;
        this.ano = ano;
    }

    public void definirTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Equipa> getEquipas() {
        return equipas;
    }

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }

    public void adicionarEquipa(Equipa e) {
        equipas.add(e);
    }

    public void gerarJogos() {

        jogos.clear();

        int id = 1;

        for(int i = 0; i < equipas.size(); i++){

            for(int j = i + 1; j < equipas.size(); j++){

                jogos.add(
                    new Jogo(
                        id++,
                        equipas.get(i),
                        equipas.get(j)
                    )
                );
            }
        }
    }
}