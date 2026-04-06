package Matricula;

import java.util.Scanner;

public class MainAplicativo1 {

    public static void mostrarMenuCarreras() {
        System.out.println("===== SISTEMA DE MATRICULA =====");
        System.out.println("1. Ingenieria de Sistemas");
        System.out.println("2. Administracion de Empresas");
        System.out.println("3. Contaduria Publica");
    }

    public static String obtenerCarrera(int opcion) {
        switch (opcion) {
            case 1:
                return "Ingenieria de Sistemas";
            case 2:
                return "Administracion de Empresas";
            case 3:
                return "Contaduria Publica";
            default:
                return "Carrera no valida";
        }
    }

    public static void imprimirRecibo(Estudiante estudiante) {
        System.out.println("\n========= RECIBO DE INSCRIPCION =========");
        estudiante.mostrarDatos();
        System.out.println("-----------------------------------------");
        System.out.println("TOTAL A PAGAR: $" + estudiante.calcularMatricula());
        System.out.println("=========================================\n");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {

            mostrarMenuCarreras();
            System.out.print("Seleccione una carrera (1-3): ");
            int opcionCarrera = teclado.nextInt();
            teclado.nextLine();

            String carrera = obtenerCarrera(opcionCarrera);

            System.out.print("Ingrese los nombres del estudiante: ");
            String nombres = teclado.nextLine();

            System.out.print("Ingrese los apellidos del estudiante: ");
            String apellidos = teclado.nextLine();

            System.out.print("Ingrese el documento del estudiante: ");
            String documento = teclado.nextLine();

            System.out.print("Ingrese la direccion del estudiante: ");
            String direccion = teclado.nextLine();

            System.out.print("Ingrese el telefono del estudiante: ");
            String telefono = teclado.nextLine();

            System.out.print("Ingrese el semestre que cursa: ");
            int semestre = teclado.nextInt();

            System.out.print("¿El estudiante realiza su curso en linea y no tiene materias aplazadas? (s/n): ");
            String respuesta = teclado.next();

            Estudiante estudiante;

            if (respuesta.equalsIgnoreCase("s")) {
                estudiante = new EstudianteEnLinea(
                        nombres, apellidos, documento, direccion, telefono, carrera, semestre
                );
            } else {
                System.out.print("Ingrese la cantidad de creditos del semestre actual: ");
                int creditosSemestre = teclado.nextInt();

                System.out.print("Ingrese la cantidad de creditos de las materias perdidas: ");
                int creditosPerdidos = teclado.nextInt();

                estudiante = new EstudiantePresencial(
                        nombres, apellidos, documento, direccion, telefono, carrera, semestre,
                        creditosSemestre, creditosPerdidos
                );
            }

            imprimirRecibo(estudiante);

            System.out.print("¿Desea registrar otro estudiante? (s/n): ");
            continuar = teclado.next();
            System.out.println();
        }

        System.out.println("Programa finalizado.");
        teclado.close();
    }
}