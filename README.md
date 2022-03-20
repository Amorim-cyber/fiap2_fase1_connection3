<h1>FIAP Fase 1: Connection</h1>

<h3>Início</h3>

O desafio do connection da Fiap consiste em desenvolver uma aplicação que registre pedidos de clientes dentro de Bar.  Caso o cliente seja novo, será aberto um formulário on board do qual terá que informar seus dados. 

Caso ele já tenha frequentado o estabelecimento, a aplicação precisará responder as seguintes perguntas:

* <b>Qual a data da última visita ao estabelecimento?</b>
* <b>Qual é a frequência de visitas?</b>
* <b>Qual é o ticket médio (valor médio gasto no estabelecimento)?</b>
* <b>Qual é a bebida e o estilo (cervejas IPA, Pilsen etc.) favoritos com base no consumo?</b>

A ideia é, com base nestas informações, o atendimento aconteça de forma personalizada a cada cliente que venha a frequentar o bar.

Este projeto foi dividido nos seguintes tópicos:

1. Modelo
2. Funcionalidades
3. Considerações finais

<hr>

<h3>Modelo</h3>

O modelo de negócios foi feito da seguinte forma:

<img src="assets/tabelas.PNG">

<b>Cliente:</b> Consumidor do estabelecimento, seus dados serão armazenados na Tabela `BAR_CLIENTE`. Nome e celular são informações obrigatórias.

<b>Comanda:</b> Registro de consumo de um cliente em um determinado período. Informações postas na tabela `BAR_COMANDA`.

<b>Bebidas:</b> Produtos oferecidos pelo bar. Estes vão estar presentes na tabela `BAR_BEBIDAS`.

#################################################################

<b>Relacionamento entre CLIENTE e COMANDA:</b>

Um cliente pode ter mais de uma comanda conforme ele frequente o bar, contudo uma comanda não pode pertencer a mais de um cliente.

<b>Relacionamento entre COMANDA e BEBIDA:</b>

Uma comanda pode registrar multiplas bebidas da mesma forma que uma bebida pode estar em multiplas comandas. Em ambos dos casos pode ocorrer repetição ou não de um mesmo pedido, por isso foi criada a tabela auxiliar `BAR_PEDIDOS` para registrar esses casos.

 #################################################################

*Obs:*

O Cliente obrigatoriamente terá uma comanda no momento que entra no estabelecimento, contudo ele pode optar em consumir ou não uma bebida. 



<hr>

<h3>Funcionalidade</h3>

