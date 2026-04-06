package cuentasbancarias;

public class Banco {
    private CuentaBancaria[] cuentas;
    private int cantidad;

    public Banco() {
        cuentas = new CuentaBancaria[100];
        cantidad = 0;
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        if (cantidad < cuentas.length) {
            cuentas[cantidad] = cuenta;
            cantidad++;
        } else {
            System.out.println("No es posible agregar más cuentas.");
        }
    }

    public CuentaBancaria buscarCuenta(String numeroCuenta) {
        for (int i = 0; i < cantidad; i++) {
            if (cuentas[i].getNumeroCuenta().equals(numeroCuenta)) {
                return cuentas[i];
            }
        }
        return null;
    }

    public void aplicarCierreMesATodas() {
        if (cantidad == 0) {
            System.out.println("No hay cuentas registradas.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println();
            System.out.println("Cuenta: " + cuentas[i].getNumeroCuenta());
            cuentas[i].aplicarCierreMes();
        }
    }

    public void mostrarTodasLasCuentas() {
        if (cantidad == 0) {
            System.out.println("No hay cuentas registradas.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            cuentas[i].mostrarEstadoCuenta();
            System.out.println("--------------------------------------");
        }
    }
}