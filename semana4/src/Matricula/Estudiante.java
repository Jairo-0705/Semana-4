package Matricula;

public class Estudiante {
    private String nombres;
    private String apellidos;
    private String documento;
    private String direccion;
    private String telefono;
    private String carrera;
    private int semestre;

    public Estudiante(String nombres, String apellidos, String documento, String direccion,
                      String telefono, String carrera, int semestre) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double calcularMatricula() {
        return 0;
    }

    public void mostrarDatos() {
        System.out.println("Estudiante: " + nombres + " " + apellidos);
        System.out.println("Documento: " + documento);
        System.out.println("Direccion: " + direccion);
        System.out.println("Telefono: " + telefono);
        System.out.println("Carrera: " + carrera);
        System.out.println("Semestre: " + semestre);
    }
}