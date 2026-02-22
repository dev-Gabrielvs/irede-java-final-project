# Task Manager

Esse repositório conta com o projeto final para o Módulo Básico da Trilha de 
desenvolvimento técnico em Java no Programa Capacita Brasil I-Rede.

O projeto escolhido por mim para desenvolver e submeter foi o "Task Manager", um projeto
CLI de gerenciamento de tarefas. Dentro do programa, o usuário pode: listar tarefas, 
adicionar tarefas, mudar o status de tarefas (Concluída ⇽ ⇾ Pendente), remover tarefas 
por ID e remover tarefas concluídas.

Realizei o desenvolvimento desse projeto com o apoio do IntelliJ IDEA e Chat GPT CODEX 
(Revisão, auxílio para debug e sugestões de melhorias)

## Instruções: Projeto 1: TaskManager – Gerenciador de Tarefas (Versão Console)

### Objetivo do projeto:

O objetivo deste projeto é desenvolver, passo a passo, um Sistema de Gerenciamento de 
Tarefas simples em Java, rodando no console (linha de comando). O sistema será criado 
com Java puro, aplicando os conceitos fundamentais de Programação Orientada a Objetos 
(POO) aprendidos no módulo.  
Este projeto servirá como uma base sólida para evoluções futuras, como
uma interface gráfica com JavaFX e, posteriormente, uma API web com
Spring Boot.

### Descrição Geral:

O sistema TaskManager permitirá ao usuário realizar operações básicas de controle de 
tarefas. Nesta versão inicial, ele poderá:
- Criar novas tarefas;
- Listar todas as tarefas;
- Marcar tarefas como concluídas;
- Remover tarefas existentes.

A interação será feita via terminal (console) e todas as informações estarão em memória
(não há persistência em banco nesta etapa). Os alunos aprenderão os conceitos 
fundamentais da linguagem Java. Para o projeto, os seguintes tópicos serão usados:

### Fundamentos Utilizados

- Scanner para entrada de dados;
- System.out.println para saída no console;
- Estruturas de decisão: if, else, switch;
- Laços de repetição: for, while, do-while;
- Manipulação de listas com ArrayList<Tarefa>;
- Manipulação básica de String (formatação, comparação, divisão com split, etc.).

Os alunos aprenderão os pilares da POO e os aplicarão no projeto:
- Classes e Objetos:
  - Criação da classe Tarefa com os atributos:
  ```java
    String titulo;
    String descricao;
    boolean concluida;
  ```

### Conceitos de POO Aplicados:

- Encapsulamento com private e uso de getters/setters;
- Herança: exemplo com uma classe TarefaPrioritaria que herda de Tarefa;
- Polimorfismo: tratamento genérico de tarefas e subtarefas;
- Classe abstrata BaseTarefa (opcional), ou interface ITarefa;
- Tratamento básico de exceções com try/catch para entradas inválidas.

### Organização do Projeto em Pacotes:

- models/         -> classes como Tarefa, TarefaPrioritaria
- controller/     -> TaskManager (lógica de gerenciamento)
- app/            -> classe principal com o menu interativo
- exceptions/     -> customização de exceções (opcional)

Na etapa final, os alunos irão construir uma interface de texto (console)
com um menu básico que permite a interação do usuário com o sistema:

### Exemplo de Menu no Console:

```bash
===== GERENCIADOR DE TAREFAS =====
1. Criar nova tarefa
2. Listar tarefas
3. Marcar tarefa como concluída
4. Remover tarefa
5. Sair
Escolha uma opção:
```

**O menu deve funcionar em loop:**  
Após executar uma ação, o menu aparece novamente até que o usuário
selecione "Sair".