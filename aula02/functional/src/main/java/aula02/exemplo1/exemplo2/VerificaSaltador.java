package aula02.exemplo1.exemplo2;

import aula02.exemplo1.Animal;

public class VerificaSaltador implements Verificador {

    @Override
    public boolean verificar(Animal a) {
        return a.podeSaltar();
    }

}
