import java.util.ArrayList;

public class Cliente extends Usuario {

    private String sexo;
    private String profesion;
    private String direccion;
    private ArrayList<Cuenta> cuentas;


    public Cliente(String nombreCompleto,
                   String cedula,
                   String sexo,
                   String correoElectronico,
                   String profesion,
                   String direccion,
                   String contrasenia) {

        super(nombreCompleto, cedula, correoElectronico, contrasenia);

        this.sexo = sexo;
        this.profesion = profesion;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }


    public String getSexo() {
        return sexo;
    }


    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getProfesion() {
        return profesion;
    }


    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }


    public void agregarCuenta(Cuenta cuenta) {

        cuentas.add(cuenta);

        System.out.println(
                "Se agregó una cuenta a " + getNombreCompleto() + "."
        );
    }


    public double calcularSaldoConsolidado() {

        double saldoTotal = 0;

        for (Cuenta cuenta : cuentas) {

            saldoTotal += cuenta.obtenerSaldoConsolidado();
        }

        return saldoTotal;
    }


    public void mostrarEstadoCuentas() {

        System.out.println(
                "\n===== ESTADO DE CUENTAS DE " +
                        getNombreCompleto().toUpperCase() +
                        " ====="
        );

        if (cuentas.isEmpty()) {

            System.out.println("El cliente no tiene cuentas registradas.");

        } else {

            for (Cuenta cuenta : cuentas) {
                System.out.println(cuenta);
            }

            System.out.println(
                    "Saldo final consolidado: $" +
                            calcularSaldoConsolidado()
            );
        }
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Cliente otroCliente = (Cliente) obj;

        return getCedula().equals(otroCliente.getCedula());
    }


    @Override
    public String toString() {

        return "Cliente: " +
                getNombreCompleto() +
                ", Cédula: " + getCedula() +
                ", Sexo: " + sexo +
                ", Correo electrónico: " + getCorreoElectronico() +
                ", Profesión: " + profesion +
                ", Dirección: " + direccion;
    }
}