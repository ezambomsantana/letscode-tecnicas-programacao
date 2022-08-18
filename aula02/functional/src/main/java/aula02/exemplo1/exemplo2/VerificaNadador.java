package aula02.exemplo1.exemplo2;

import aula02.exemplo1.Animal;

public class VerificaNadador implements Verificador {

    @Override
    public boolean verificar(Animal a) {
        return a.podeNadar();
    }

}
