# Manipulação de Arquivos


O Java possui dois pacotes para a manipulação de arquivo, o java.io e o java.nio. Os dois funncionam, mas atualmente é recomendado usar sempre o java.nio.

A classe principal do pacote java.io é a File, com a qual podemos pegar uma referência para um arquivo e ler tanto o conteúdo quanto metadados dos arquivos. Também existem alguns métodos auxiliares.

Já no pacote java.nio, a classe principal é a Path, que representa um caminho para um arquivo, com ela podemos recuperar os metadados de um arquivo. Alémm dela existe a classe File que possui vários métodos utilitários para a manipulação dos arquivos.

## Exercícios

1) Escreva um programa que receba um path e mostre todos os arquivo e todos os diretórios dentro daquele path.

2) Escreva um programa que receba um path e mostre todos os diretórios e todos os subdiretórios dentro daquele path.

3) Escreva um programa que conte quantos arquivos (excluindo diretórios) existem dentro desse path.

4) Escreva um programa que conte quantos arquivos (excluindo diretórios) existem dentro do path e dos subdiretórios.

5) Escreva um programa que verifica se dois arquivos são iguais.
