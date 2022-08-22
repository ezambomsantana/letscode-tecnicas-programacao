package exemplo1.modo3;

import exemplo1.Animal;

@FunctionalInterface
public interface Verificador {
    boolean verificar(Animal animal);
}
