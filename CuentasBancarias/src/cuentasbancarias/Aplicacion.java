package cuentasbancarias;

import java.util.Scanner;

public class Aplicacion {

    public static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Aperturas de Cuentas: Ahorro y Corriente");
        System.out.println("2. Transferencias");
        System.out.println("3. Cajero Automático");
        System.out.println("4. Cierre de mes (Estado de Cuenta)");
        System.out.println("5. Depósitos");
        System.out.println("6. Cheque emitido (solo cuenta corriente)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static Cliente crearCliente(Scanner teclado) {
        System.out.print("Nombres: ");
        String nombres = teclado.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = teclado.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(teclado.nextLine());

        String nombresRepresentante = "";
        String apellidosRepresentante = "";

        if (edad < 18) {
            System.out.print("Nombres del representante: ");
            nombresRepresentante = teclado.nextLine();

            System.out.print("Apellidos del representante: ");
            apellidosRepresentante = teclado.nextLine();
        }

        return new Cliente(nombres, apellidos, edad, nombresRepresentante, apellidosRepresentante);
    }

    public static void abrirCuenta(Scanner teclado, Banco banco) {
        Cliente cliente = crearCliente(teclado);

        System.out.print("Número de cuenta: ");
        String numeroCuenta = teclado.nextLine();

        System.out.print("Tipo de cuenta (ahorros/corriente): ");
        String tipoCuenta = teclado.nextLine().toLowerCase();

        System.out.print("Monto de apertura: ");
        double montoApertura = Double.parseDouble(teclado.nextLine());

        if (tipoCuenta.equals("corriente")) {
            if (montoApertura >= 200000) {
                CuentaCorriente cuenta = new CuentaCorriente(cliente, numeroCuenta, montoApertura);
                banco.agregarCuenta(cuenta);
                System.out.println("Cuenta corriente creada correctamente.");
            } else {
                System.out.println("La cuenta corriente requiere un monto mínimo de $200000.");
            }
        } else if (tipoCuenta.equals("ahorros")) {
            CuentaAhorros cuenta = new CuentaAhorros(cliente, numeroCuenta, montoApertura);
            banco.agregarCuenta(cuenta);
            System.out.println("Cuenta de ahorros creada correctamente.");
        } else {
            System.out.println("Tipo de cuenta no válido.");
        }
    }

    public static void realizarTransferencia(Scanner teclado, Banco banco) {
        System.out.print("Número de cuenta origen: ");
        String cuentaOrigenTexto = teclado.nextLine();

        System.out.print("Número de cuenta destino: ");
        String cuentaDestinoTexto = teclado.nextLine();

        System.out.print("Monto a transferir: ");
        double monto = Double.parseDouble(teclado.nextLine());

        CuentaBancaria cuentaOrigen = banco.buscarCuenta(cuentaOrigenTexto);
        CuentaBancaria cuentaDestino = banco.buscarCuenta(cuentaDestinoTexto);

        if (cuentaOrigen != null && cuentaDestino != null) {
            if (cuentaOrigen.transferir(cuentaDestino, monto)) {
                System.out.println("Transferencia realizada correctamente.");
                System.out.println("Saldo cuenta origen: $" + cuentaOrigen.getSaldo());
                System.out.println("Saldo cuenta destino: $" + cuentaDestino.getSaldo());
            } else {
                System.out.println("No fue posible realizar la transferencia. Verifique el saldo.");
            }
        } else {
            System.out.println("Cuenta origen o cuenta destino no encontrada.");
        }
    }

    public static void usarCajeroAutomatico(Scanner teclado, Banco banco) {
        System.out.print("Número de cuenta: ");
        String numeroCuenta = teclado.nextLine();

        CuentaBancaria cuenta = banco.buscarCuenta(numeroCuenta);

        if (cuenta == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }

        System.out.print("Monto a retirar: ");
        double monto = Double.parseDouble(teclado.nextLine());

        if (cuenta instanceof CuentaAhorros) {
            System.out.print("¿El cajero pertenece al banco? (s/n): ");
            String respuesta = teclado.nextLine();
            boolean cajeroDelBanco = respuesta.equalsIgnoreCase("s");

            ((CuentaAhorros) cuenta).retiroCajero(monto, cajeroDelBanco);
        } else if (cuenta instanceof CuentaCorriente) {
            if (cuenta.retirar(monto)) {
                System.out.println("Retiro realizado correctamente.");
                System.out.println("Saldo actual: $" + cuenta.getSaldo());
            } else {
                System.out.println("Saldo insuficiente.");
            }
        }
    }

    public static void realizarDeposito(Scanner teclado, Banco banco) {
        System.out.print("Número de cuenta: ");
        String numeroCuenta = teclado.nextLine();

        CuentaBancaria cuenta = banco.buscarCuenta(numeroCuenta);

        if (cuenta != null) {
            System.out.print("Monto a depositar: ");
            double monto = Double.parseDouble(teclado.nextLine());
            cuenta.depositar(monto);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public static void cobrarCheque(Scanner teclado, Banco banco) {
        System.out.print("Número de cuenta corriente: ");
        String numeroCuenta = teclado.nextLine();

        CuentaBancaria cuenta = banco.buscarCuenta(numeroCuenta);

        if (cuenta instanceof CuentaCorriente) {
            ((CuentaCorriente) cuenta).cobrarChequeEmitido();
        } else {
            System.out.println("La cuenta no existe o no es una cuenta corriente.");
        }
    }

    public static void realizarCierreMes(Banco banco) {
        banco.aplicarCierreMesATodas();
        System.out.println("\nEstados de cuenta:");
        banco.mostrarTodasLasCuentas();
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Banco banco = new Banco();
        int opcion;

        do {
            mostrarMenu();
            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1:
                    abrirCuenta(teclado, banco);
                    break;

                case 2:
                    realizarTransferencia(teclado, banco);
                    break;

                case 3:
                    usarCajeroAutomatico(teclado, banco);
                    break;

                case 4:
                    realizarCierreMes(banco);
                    break;

                case 5:
                    realizarDeposito(teclado, banco);
                    break;

                case 6:
                    cobrarCheque(teclado, banco);
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}