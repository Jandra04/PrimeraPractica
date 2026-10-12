import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Crear administrador
        Administrador administrador = new Administrador(
                "Yahaira Chavarria",
                "6-0300-0949",
                "admin@banco.com",
                "Banco123!"
        );


        // Crear cliente
        Cliente cliente1 = new Cliente(
                "Alejandra Carrillo Chavarria",
                "6-0476-0847",
                "Femenino",
                "alejandra@email.com",
                "Camarera",
                "Quepos, Costa Rica",
                "Aleja123!"
        );


        // Crear cuenta de ahorro
        CuentaAhorro cuentaAhorro = new CuentaAhorro(
                1000,
                LocalDate.of(2026, 10, 11),
                LocalDate.of(2030, 10, 11),
                3
        );


        // Crear cuenta de debito
        CuentaDebito cuentaDebito = new CuentaDebito(
                500,
                LocalDate.of(2026, 10, 11),
                LocalDate.of(2030, 10, 11),
                1
        );


        // Crear cuenta de credito
        CuentaCredito cuentaCredito = new CuentaCredito(
                LocalDate.of(2026, 10, 11),
                LocalDate.of(2030, 10, 11),
                5,
                3000,
                "Cashback"
        );


        // Agregar cuentas al cliente
        cliente1.agregarCuenta(cuentaAhorro);
        cliente1.agregarCuenta(cuentaDebito);
        cliente1.agregarCuenta(cuentaCredito);


        // Probar cuenta de ahorro
        System.out.println("\n===== CUENTA DE AHORRO =====");

        cuentaAhorro.depositar(200);
        cuentaAhorro.pagar(300);
        cuentaAhorro.generarInteres();


        // Probar cuenta de debito
        System.out.println("\n===== CUENTA DE DEBITO =====");

        cuentaDebito.depositar(100);
        cuentaDebito.pagar(250);
        cuentaDebito.generarInteres();


        // Probar cuenta de credito
        System.out.println("\n===== CUENTA DE CREDITO =====");

        cuentaCredito.pagar(800);
        cuentaCredito.abonar(300);
        cuentaCredito.generarInteres();


        // Mostrar estado de cuentas
        cliente1.mostrarEstadoCuentas();


        // Crear lista de clientes
        ArrayList<Cliente> clientes = new ArrayList<>();

        clientes.add(cliente1);


        // Crear lista de cuentas
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        cuentas.add(cuentaAhorro);
        cuentas.add(cuentaDebito);
        cuentas.add(cuentaCredito);


        // Mostrar clientes desde administrador
        administrador.mostrarClientes(clientes);


        // Mostrar cuentas desde administrador
        administrador.mostrarCuentas(cuentas);


        // Mostrar administrador
        System.out.println("\n===== ADMINISTRADOR =====");

        System.out.println(administrador);
    }
}