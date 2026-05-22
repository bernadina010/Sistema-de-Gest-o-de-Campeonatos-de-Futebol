import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      
        Scanner input = new Scanner (System.in);

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
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
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
    }

   
}
