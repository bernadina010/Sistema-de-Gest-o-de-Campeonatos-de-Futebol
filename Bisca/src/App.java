import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      
        Scanner input = new Scanner (System.in);
        Campeonato campeonato = new Campeonato();

        int op;
    
        do{
            System.out.println("==============================================");
            System.out.println("SISTEMA DE GESTAO DE CAMPEONATOS DE FUTEBOL");
            System.out.println("==============================================");

            System.out.println("1 - Criar Campeonato\n2 - Escolher Tipo de Campeonato\n3 - Cadastrar Equipas\n4 - Gerar Tabela de Jogos\n5 - Visualizar jogos\n6 - Simular Jogo\n7 - Simular Rodada\n8 - Ver Tabela Classificativa\n9 - Ver detalhes de uma equipa\n10 - Gurdar Dados\n11 - Carregar Dados\n0 - Sair");
            System.out.println("\nEscolha uma opçãO: ");
            op = input.nextInt();

            switch (op) {
                case 1:

                    input.nextLine();

                    System.out.print("Nome do campeonato: ");
                    String nome = input.nextLine();

                    System.out.print("Ano: ");
                    int ano = input.nextInt();

                    campeonato.criar(nome, ano);

                    System.out.println("Campeonato criado com sucesso!");

                    break;

                case 2:

                     input.nextLine();

                     System.out.println("1 - Liga");
                     System.out.println("2 - Eliminatória");

                     int tipo = input.nextInt();

                     if(tipo == 1)
                     campeonato.definirTipo("Liga");

                     else
                     campeonato.definirTipo("Eliminatoria");

                     System.out.println("Tipo definido.");

                     break;

                case 3:
                    

                     input.nextLine();

                     System.out.print("ID da equipa: ");
                     int id = input.nextInt();

                     input.nextLine();

                     System.out.print("Nome da equipa: ");
                     String nomeEquipa = input.nextLine();

                     System.out.print("Treinador: ");
                     String treinador = input.nextLine();

                     Equipa equipa = new Equipa(id,nomeEquipa, treinador );

                     campeonato.adicionarEquipa(equipa);

                     System.out.println("Equipa cadastrada.");

                     break;

                case 4:
                  
                     campeonato.gerarJogos();
                     System.out.println("Tabela de jogos gerada com sucesso.");

                     break;

                case 5:

                     for(Jogo j : campeonato.getJogos()){
                     System.out.println(j.getIdJogo() +  " - " + j);
                    
                     }   

                     break;

                case 6:
                     
                     System.out.print("Digite o ID do jogo: " );
                     int idJogo = input.nextInt();

                     for(Jogo j : campeonato.getJogos()){

                            if(j.getIdJogo() == idJogo){
                               
                             j.simular();

                             System.out.println( "Resultado:" );

                             System.out.println(j);
                          }
                     }

                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                case 10:
                    
                    break;
                case 11:
                    
                    break;
                case 0:
                    
                    break;
            
                default:
                    System.out.println("OpçãO de menu invÁlida. Escolha um nÚmero entre 0 e 11 (inclusive)");
                    break;
            }
        }while(op != 0);
        
        input.close();
    }
     
   
}
