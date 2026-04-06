package Matricula;

public class EstudiantePresencial extends Estudiante {
    private int creditosSemestre;
    private int creditosPerdidos;

    public EstudiantePresencial(String nombres, String apellidos, String documento, String direccion,
                                String telefono, String carrera, int semestre,
                                int creditosSemestre, int creditosPerdidos) {
        super(nombres, apellidos, documento, direccion, telefono, carrera, semestre);
        this.creditosSemestre = creditosSemestre;
        this.creditosPerdidos = creditosPerdidos;
    }

    public int getCreditosSemestre() {
        return creditosSemestre;
    }

    public void setCreditosSemestre(int creditosSemestre) {
        this.creditosSemestre = creditosSemestre;
    }

    public int getCreditosPerdidos() {
        return creditosPerdidos;
    }

    public void setCreditosPerdidos(int creditosPerdidos) {
        this.creditosPerdidos = creditosPerdidos;
    }

    public double obtenerValorCredito() {
        if (getSemestre() >= 1 && getSemestre() <= 3) {
            return 20;
        } else if (getSemestre() >= 4 && getSemestre() <= 6) {
            return 25;
        } else {
            return 30;
        }
    }

    public double calcularValorSemestre() {
        return creditosSemestre * obtenerValorCredito();
    }

    public double calcularValorPerdidas() {
        return creditosPerdidos * obtenerValorCredito();
    }

    @Override
    public double calcularMatricula() {
        return calcularValorSemestre() + calcularValorPerdidas();
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Modalidad: Con materias aplazadas");
        System.out.println("Creditos del semestre: " + creditosSemestre);
        System.out.println("Creditos perdidos: " + creditosPerdidos);
        System.out.println("Valor por credito: $" + obtenerValorCredito());
        System.out.println("Valor semestre: $" + calcularValorSemestre());
        System.out.println("Valor materias perdidas: $" + calcularValorPerdidas());
    }
}