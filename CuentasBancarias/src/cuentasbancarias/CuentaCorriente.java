package cuentasbancarias;

public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(Cliente cliente, String numeroCuenta, double saldo) {
        super(cliente, numeroCuenta, saldo, "Corriente");
    }

    @Override
    public double calcularComisionDeposito(double monto) {
        if (monto < 500000) {
            return 7000;
        } else if (monto >= 500000 && monto < 2000000) {
            return 5000 + (monto * 0.02);
        } else if (monto >= 2000000 && monto <= 10000000) {
            return 4000 + (monto * 0.02);
        } else {
            return monto * 0.033;
        }
    }

    public void cobrarChequeEmitido() {
        if (saldo >= 3000) {
            saldo = saldo - 3000;
            System.out.println("Se cobraron $3000 por cheque emitido.");
            System.out.println("Saldo actual: $" + saldo);
        } else {
            System.out.println("Saldo insuficiente para cobrar el cheque emitido.");
        }
    }

    @Override
    public void aplicarCierreMes() {
        double mantenimiento = saldo * 0.015;
        saldo = saldo - mantenimiento;

        System.out.println("Cierre de mes aplicado a cuenta corriente.");
        System.out.println("Cobro por mantenimiento mensual: $" + mantenimiento);
        System.out.println("Saldo final: $" + saldo);
    }
}