# Streams

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
