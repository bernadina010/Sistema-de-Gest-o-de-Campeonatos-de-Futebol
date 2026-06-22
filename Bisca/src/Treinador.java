public class Treinador {

    private int idTreinador;
    private String nome;
    private int idade;
    private String nacionalidade;

    public Treinador(int idTreinador, String nome,
                      int idade, String nacionalidade) {

        this.idTreinador = idTreinador;
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
    }

    public int getIdTreinador() {
        return idTreinador;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    @Override
    public String toString() {
        return nome;
    }
}