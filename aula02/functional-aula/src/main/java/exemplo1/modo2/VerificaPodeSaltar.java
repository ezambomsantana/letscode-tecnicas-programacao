package exemplo1.modo2;

import exemplo1.Animal;

public class VerificaPodeSaltar implements Verificador {
    @Override
    public boolean verificar(Animal animal) {
        return animal.isPodeSaltar();
    }
}
