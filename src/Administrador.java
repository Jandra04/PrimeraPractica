import java.util.ArrayList;

public class Administrador extends Usuario {

    public Administrador(String nombreCompleto,
                         String cedula,
                         String correoElectronico,
                         String contrasenia) {

        super(nombreCompleto, cedula, correoElectronico, contrasenia);
    }


    public void mostrarClientes(ArrayList<Cliente> clientes) {

        System.out.println("\n===== LISTA DE CLIENTES =====");

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {

            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }


    public void mostrarCuentas(ArrayList<Cuenta> cuentas) {

        System.out.println("\n===== LISTA DE CUENTAS =====");

        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {

            for (Cuenta cuenta : cuentas) {
                System.out.println(cuenta);
            }
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

        Administrador otroAdministrador = (Administrador) obj;

        return getCedula().equals(otroAdministrador.getCedula());
    }


    @Override
    public String toString() {

        return "Administrador: " +
                getNombreCompleto() +
                ", Cédula: " + getCedula() +
                ", Correo electrónico: " + getCorreoElectronico();
    }
}