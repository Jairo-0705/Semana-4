package Matricula;

public class EstudianteEnLinea extends Estudiante {

    public EstudianteEnLinea(String nombres, String apellidos, String documento, String direccion,
                             String telefono, String carrera, int semestre) {
        super(nombres, apellidos, documento, direccion, telefono, carrera, semestre);
    }

    @Override
    public double calcularMatricula() {
        double valorBase = 1500;

        if (getSemestre() >= 5) {
            valorBase = valorBase + (valorBase * 0.05);
        }

        return valorBase;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Modalidad: En linea");
        System.out.println("Tipo de cobro: Matricula base");
    }
}