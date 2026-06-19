import java.util.ArrayList;

public class Equipa {

    private int idEquipa;
    private String nome;
    private String treinador;

    private int pontos;
    private int vitorias;
    private int empates;
    private int derrotas;

     
       public void setvitprias(int vitorias){
      this.vitorias = vitorias;
    } 

     public int  getvitorias(){
      return vitorias;
    } 

       public void setempates(int empates){
      this.empates = empates;
    } 

     public int  getempates(){
      return empates;
    } 

       public void setderrotas(int derrotas){
      this.derrotas = derrotas;
    } 

     public int  getderrotas(){
      return derrotas;
    } 


    public Equipa(int idEquipa, String nome, String treinador) {

        this.idEquipa = idEquipa;
        this.nome = nome;
        this.treinador = treinador;

        this.pontos = 0;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public String getNome() {
        return nome;
    }

    public String getTreinador() {
        return treinador;
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarVitoria() {
        vitorias++;
        pontos += 3;
    }

    public void adicionarEmpate() {
        empates++;
        pontos += 1;
    }

    public void adicionarDerrota() {
        derrotas++;
    }

    @Override
    public String toString() {
        return idEquipa + " - " + nome + " | Treinador: " + treinador;
    }
}