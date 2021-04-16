# ProjetoJogoDeEstrategia
Projeto – Jogo de Estratégia em Tempo Real Programação Concorrente

Escopo do projeto:

Implementação de um jogo de estratégia em tempo real multijogadores em rede. Estilo
civilizações medievais;

Escopo da parte 1:
- Implementação de parte do jogo: vila;
- Considerando apenas 1 jogador;
- Antes de iniciar o jogo o jogador deve informar o seu nome e escolher a sua civilização
(Acádia, Babilônia, Helenística, Mesopotâmica, Persa, Suméria);
O jogo inicia com uma vila criada contendo:
- 5 aldeões;
- 1 prefeitura: criar novos aldeões e realizar evoluções;
- 0 templo: lançar pragas, realizar evoluções e produzir oferendas de fé;
- 0 maravilha: ganhar o jogo;
- 1 fazenda: produzir comida;
- 1 mina de ouro: produzir ouro;
- 150 unidades de comida;
- 100 unidades de ouro.
- 0 oferendas de fé.

Maiores detalhes dos componentes da vila estão no final do documento;

Vários eventos do jogo têm tempo associado anunciado em horas. Utilize uma constante
para estabelecer um tempo relógio equivalente à hora e respeite sempre este tempo.
Recomendo 500 na fase de desenvolvimento;

As entidades do jogo têm comportamento independente, simultâneo e autônomo controlado
pelo jogador. Ou seja, o jogador diz o que cada entidade deve fazer e a entidade faz.

Algumas entidades têm comportamento repetitivo. Ou seja, a entidade continua repetindo
aquela ação até que nova ordem seja dada;

Os comportamentos de cada entidade em particular são sequenciais. Ou seja, não podem
ocorrer simultaneamente. Cada um possui um tempo associado e a ação somente termina
após decorrido este tempo;

O jogador deve utilizar uma interface para dar ordens às entidades, informando a entidade e a ordem:
- Aldeão: Selecionar o aldeão:
  - Construir: selecionar o tipo da construção:
    - Fazenda;
    - Mina de ouro;
    - Templo (somente 1).

  - Cultivar: selecionar a fazenda;
  - Minerar: selecionar a mina de ouro;
  - Orar;
  - Sacrificar.
- Prefeitura:
  - Criar aldeão;
  - Evoluir aldeão;
  - Evoluir fazenda;
  - Evoluir mina de ouro.
- Templo:
  - Evoluir nuvem de gafanhotos;
  - Evoluir morte dos primogênitos;
  - Evoluir chuva de pedras;
  - Lançar nuvem de gafanhotos: selecionar o inimigo. Após a evolução. Apenas para a parte 2;
  - Lançar morte dos primogênitos: selecionar o inimigo. Após a evolução. Apenas para a parte 2;
  - Lançar chuva de pedras: selecionar o inimigo. Após a evolução. Apenas para a parte 2;
  - Evoluir proteção de nuvem de gafanhotos;
  - Evoluir proteção de morte dos primogênitos;
  - Evoluir proteção de chuva de pedras.
O jogo deve permitir ao jogador acompanhar a situação atual de todas as entidades.
