package cuentasbancarias;

public class CuentaAhorros extends CuentaBancaria {

    public CuentaAhorros(Cliente cliente, String numeroCuenta, double saldo) {
        super(cliente, numeroCuenta, saldo, "Ahorros");
    }

    @Override
    public double calcularComisionDeposito(double monto) {
        if (monto < 500000) {
            return 0;
        } else if (monto >= 500000 && monto < 2000000) {
            return 3000 + (monto * 0.01);
        } else if (monto >= 2000000 && monto <= 10000000) {
            return 2000 + (monto * 0.005);
        } else if (monto > 10000000 && monto < 100000000) {
            return monto * 0.018;
        } else {
            return monto * 0.02;
        }
    }

    public void retiroCajero(double monto, boolean cajeroDelBanco) {
        if (monto <= 0) {
            System.out.println("El monto del retiro debe ser mayor a cero.");
            return;
        }

        double comision = 0;

        if (!cajeroDelBanco) {
            comision = 4500;
        }

        if (saldo >= (monto + comision)) {
            saldo = saldo - (monto + comision);
            System.out.println("Retiro realizado correctamente.");
            System.out.println("Comisión cajero: $" + comision);
            System.out.println("Saldo actual: $" + saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    }

    @Override
    public void aplicarCierreMes() {
        double rendimientoMensual = (saldo * 0.022) / 12;
        saldo = saldo + rendimientoMensual;

        System.out.println("Cierre de mes aplicado a cuenta de ahorros.");
        System.out.println("Rendimiento generado: $" + rendimientoMensual);
        System.out.println("Saldo final: $" + saldo);
    }
}