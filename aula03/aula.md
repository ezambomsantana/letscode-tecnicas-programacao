# Programação Funcional

## Functional Interfaces

O Java possui as seguintes interfaces funcionais:

| Interface funcional |	Tipo de retorno	| Nome do método |	# de parâmetros |  
|----------------------|----------------|-------------|-----------------|
| Supplier\<T\>          | T              | get()       | 0               | 
| Consumer\<T\>          | void           | accept(T)   | 1               |
| BiConsumer<T, U>     | void           | accept(T,U) | 2 (T, U)        |
| Predicate\<T\>         | boolean        | test(T)     | 1 (T)           |
| BiPredicate<T, U>    | boolean        | test(T,U)   | 2 (T, U)        |
| Function<T, R> 	   | R 	            | apply(T) 	  | 1 (T)           |
| BiFunction<T, U, R>  | R              | apply(T,U)  | 2 (T, U)        |
| UnaryOperator\<T\> 	   | T 	            | apply(T) 	  | 1 (T)           |
| BinaryOperator\<T\>    | T 	            | apply(T,T)  | 2 (T, T)        |

## Optional

O Optional é uma classe para representar valores que podem ter valor ou não, evitando o uso do null, e evitando que o código tenha vários ifs.

## Streams

Streams são fluxos de dados, que definimos a partir de uma fonte, executamos operações intermediarias que irão modificar os dados no fluxo, e por fim executamos uma operações terminal que produzirá um resultado.

Fonte -> Operações Intermediárias -> Operações Terminais

- Fonte: A fonte dos dados que formarão o fluxo de dados, pode ser uma lista, um arquivo, uma consulta no banco de dados.
- Operações Intermediárias: Operações no fluxo de dados, que vão transformar os dados, mas vão gerar uma nova stream.
- Operações Terminais: Operações que vão gerar um resultado, pode ser qualquer coisa, um número, uma nova lista, ou uma String por exemplo.

## Exercícios

1) Crie uma classe Funcionário, que tenha os seguintes campos, nome, cargo e salário. A partir disso faça as seguintes operações.

  - Crie uma lista com 10 funcionários.
  - Crie uma stream a partir dessa lista.
  - Calcule a média dos salários.
  - Ache o funcionário com o maior salário.
  - Ache o funcionário com o menor salário.
