# Sistema-de-Gest-o-de-Campeonatos-de-Futebol
        
        Disciplina: Programação 2
        Repositório GitHub: //github.com/bernadina010/Sistema-de-Gest-o-de-Campeonatos-de-Futebol
        Linguagem: JAVA
        Ano: 2026

Membros do Grupo:

        Arsenio Almeida - 20242528
        Bernardina Neto - 20243573
        Simony Campos - 20243290

# Descrição do Projecto:
O sistema de gestão de campeonatos de futebol foi criado para auxiliar na organização e administração de competições desportivas, permitindo um controlo mais eficiente das informações relacionadas aos campeonatos e às equipas participantes.

# Objectivo:
O principal objectivo deste projecto é desenvolver uma solução prática, organizada e funcional para a gestão de campeonatos de futebol. Entre os objectivos específicos, destacam-se: gerar automaticamente os jogos entre as equipas participantes, permitir a consulta da classificação das equipas ao longo da competição e disponibilizar informações detalhadas sobre a composição e formação de cada equipa. Além disso, o projecto visa aplicar os conhecimentos adquiridos na disciplina de Programação 2, utilizando conceitos específicos dados na disciplina de Programação 2, nomeadamente:

        Estruturas de Decisão e Repetição
        Registros
        Funções
        Arquivos


# Modo de Funcionamento:
O sistema automatiza processos importantes de uma competição, como a geração automática da tabela de jogos, a visualização da tabela classificativa e a apresentação de detalhes sobre a formação das equipas. Com isso, busca-se reduzir erros manuais, melhorar a organização das informações e facilitar o acompanhamento do campeonato por parte dos utilizadores.

# Menu Principal:

           ==============================================
            SISTEMA DE GESTAO DE CAMPEONATOS DE FUTEBOL
          ==============================================
          
                1 - Criar Campeonato
                2 - Escolher Tipo de Campeonato
                3 - Cadastrar Equipas
                4 - Gerar Tabela de Jogos
                5 - Visualizar jogos
                6 - Simular Jogo
                7 - Simular Rodada
                8 - Ver Tabela Classificativa
                9 - Ver detalhes de uma equipa
                10 - Gurdar Dados
                11 - Carregar Dados
                0 - Sair
                Escolha uma opção: 
                
# Principais Entidades:

* Classe Campeonato
  
Representa o campeonato em si.

Atributos:

    nome
    ano
    quantidadeEquipas
    listaEquipas
    listaJogos
    tabelaClassificacao
    
Responsabilidades:
    
    Gerar calendário de jogos
    Organizar equipas
    Controlar classificação geral

* Classe Equipa
  
Representa cada equipa participante.

Atributos:

    idEquipa
    nome
    treinador
    escalão
    listaJogadores
    pontos
    jogosRealizados
    victórias
    empates
    derrotas
    golosMarcados
    golosSofridos


Responsabilidades:

    Armazenar informações da equipa
    Manter estatísticas no campeonato
    
* Classe Jogador
  
Representa os jogadores de cada equipa.

Atributos:

    idJogador
    nome
    idade
    numeroCamisola
    posicao
    nacionalidade
    altura
    peso
    
Responsabilidades:

    Guardar dados individuais dos jogadores
    
* Classe Jogo
  
Representa uma partida entre duas equipas.

Atributos:

    idJogo
    equipaCasa
    equipaVisitante
    data
    hora
    estadio
    golosCasa
    golosVisitante
    estadoJogo

Responsabilidades:

    Controlar resultados
    Guardar detalhes das partidas
    
*  Classe TabelaClassificacao
  
Responsável pela classificação do campeonato.

Atributos:

    listaEquipas
    criterioPontuacao
    Responsabilidades:
    Ordenar equipas
    Exibir classificação
    Actualizar pontuações
    
* Classe Treinador
  
Atributos:

    idTreinador
    nome
    idade
    nacionalidade    
    anosExperiencia
    Responsabilidades:
    Representar o treinador da equipa

# Relação entre as classes

* Pode explicar no relatório algo como:
* Um Campeonato possui várias Equipa
* Uma Equipa possui vários Jogadores
* Um Jogo envolve duas equipas
* A TabelaClassificacao organiza as equipas conforme os resultados
* Cada equipa pode possuir um Treinador 

# Entidades persistentes:

As entidades persistentes do sistema correspondem aos dados que são armazenados em ficheiros, permitindo que as informações permaneçam guardadas mesmo após o encerramento da aplicação. Essas entidades representam os principais elementos do sistema de gestão de campeonatos de futebol, garantindo a organização, segurança e recuperação dos dados sempre que necessário.
No presente projecto, as entidades persistentes incluem as equipas, jogadores, jogos e tabela de classificação. Cada uma dessas entidades possui informações específicas que são registadas e actualizadas ao longo da utilização do sistema. A persistência dos dados possibilita um melhor controlo das informações do campeonato, evitando a perda de dados e tornando o sistema mais eficiente e funcional.

    Classe Equipa : equipas.txt
    Classe Jogador : jogadores.txt
    Classe Jogo : jogos.txt
    Classe TabelaClassificacao : classificacao.txt 

# Link do Github: 

    https://github.com/bernadina010/Sistema-de-Gest-o-de-Campeonatos-de-Futebol



