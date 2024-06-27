## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

-------------------------------------------------------------------------
# Projeto de Gerenciamento de Cartas e Decks

## Informações Gerais sobre o Projeto

Este projeto é uma aplicação de gerenciamento de cartas e decks para um jogo de cartas colecionáveis. O objetivo principal é permitir que os usuários cadastrem cartas, organizem-nas, criem e editem decks, simulem batalhas entre decks, e salvem e carreguem os dados do jogo. As funcionalidades principais incluem:

- Cadastro de cartas com atributos como título, descrição, tipo, raridade, coleção, poder, vida, custo de mana e quantidade de cópias.
- Organização de cartas com base em filtros como raridade, tipo, poder, vida e custo de mana.
- Criação e edição de decks, permitindo adicionar múltiplas cópias de cartas e completar decks incompletos.
- Criação de decks aleatórios respeitando o limite de quatro cópias por carta.
- Simulação de batalhas entre decks.
- Exibição de estatísticas e relatórios sobre a coleção de cartas.
- Salvar e carregar dados de cartas e decks em um arquivo JSON.

## Informações sobre as Classes e suas Relações

### Classes Principais

- *Carta*: Representa uma carta do jogo, com atributos como título, descrição, tipo, raridade, coleção, poder, vida e custo de mana.
  - *Relação*: Classe base que é usada por outras classes como Colecao e Deck.

- *Deck*: Representa um deck de cartas, com um nome e uma lista de cartas.
  - *Relação*: Composição de cartas, pois um deck contém uma coleção de cartas e é responsável por gerenciar a adição e remoção de cartas.

- *Colecao*: Gerencia a coleção de cartas e decks.
  - *Relação*: Agregação de cartas e decks. A coleção contém múltiplas cartas e decks e fornece métodos para gerenciá-los.

- *Console*: Utilitário para leitura de entrada do usuário.
  - *Relação*: Associação com as classes que necessitam de entrada do usuário, como o MenuPrincipal.

- *MenuPrincipal*: Classe que controla o fluxo principal do programa, exibindo o menu e lidando com a lógica de entrada do usuário.
  - *Relação*: Utiliza Colecao, Carta, Deck e Console para implementar a lógica de negócios do aplicativo.

## Como Executar o Projeto

### Pré-requisitos

- Java Development Kit (JDK) 8 ou superior.
- Um editor de código ou IDE como IntelliJ IDEA, Eclipse ou VS Code.

### Passos para Configuração e Execução

Clone o repositório:

- git clone <url-do-repositorio>
- cd <nome-do-repositorio>

Compile o projeto:

- javac -d bin src/*/.java

Execute o projeto:

- java -cp bin MenuPrincipal

## Uso do ChatGPT

O ChatGPT foi utilizado no desenvolvimento deste projeto para:

- Auxiliar na elaboração de conceitos e estruturas de classes.
- Propor soluções para problemas específicos de implementação.
- Fornecer exemplos de código para funcionalidades específicas.
- Revisar e refatorar o código existente para melhorar a qualidade e a eficiência.
- Auxiliar na documentação do projeto, incluindo a criação deste README.

A utilização do ChatGPT ajudou a acelerar o desenvolvimento, fornecendo insights e sugestões rápidas para problemas encontrados durante a implementação.

## Referências e Recursos

- ChatGPT da OpenAI
- Conteúdo ministrado em sala de aula
