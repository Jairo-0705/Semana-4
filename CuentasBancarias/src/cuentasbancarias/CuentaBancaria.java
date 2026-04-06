package cuentasbancarias;

public class CuentaBancaria {
    protected Cliente cliente;
    protected String numeroCuenta;
    protected double saldo;
    protected String tipoCuenta;

    public CuentaBancaria(Cliente cliente, String numeroCuenta, double saldo, String tipoCuenta) {
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double calcularComisionDeposito(double monto) {
        return 0;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto del depósito debe ser mayor a cero.");
            return;
        }

        double comision = calcularComisionDeposito(monto);
        saldo = saldo + (monto - comision);

        System.out.println("Depósito realizado correctamente.");
        System.out.println("Comisión cobrada: $" + comision);
        System.out.println("Saldo actual: $" + saldo);
    }

    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto del retiro debe ser mayor a cero.");
            return false;
        }

        if (monto <= saldo) {
            saldo = saldo - monto;
            return true;
        }

        return false;
    }

    public boolean transferir(CuentaBancaria destino, double monto) {
        if (destino == null) {
            return false;
        }

        if (retirar(monto)) {
            destino.saldo = destino.saldo + monto;
            return true;
        }

        return false;
    }

    public void aplicarCierreMes() {
    }

    public void mostrarEstadoCuenta() {
        System.out.println("========== ESTADO DE CUENTA ==========");
        cliente.mostrarDatos();
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Tipo de cuenta: " + tipoCuenta);
        System.out.println("Saldo actual: $" + saldo);
    }
}