package aula02.exemplo1.exemplo2;

import aula02.exemplo1.Animal;

@FunctionalInterface
public interface Verificador {
    boolean verificar(Animal a);
}
