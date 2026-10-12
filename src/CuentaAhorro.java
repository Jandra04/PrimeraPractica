import java.time.LocalDate;

public class CuentaAhorro extends Cuenta {

    public CuentaAhorro(double saldo,
                        LocalDate fechaEmision,
                        LocalDate fechaVencimiento,
                        double porcentajeInteres) {

        super(saldo, fechaEmision, fechaVencimiento, porcentajeInteres);

        if (saldo < 100) {
            throw new IllegalArgumentException(
                    "La cuenta de ahorro debe iniciar con al menos $100."
            );
        }
    }


    public void depositar(double monto) {

        if (!estaVigente()) {
            System.out.println(
                    "No se puede realizar el depósito porque la cuenta de ahorro está vencida."
            );
            return;
        }

        if (monto <= 0) {
            System.out.println(
                    "El monto del depósito debe ser mayor a $0."
            );
            return;
        }

        setSaldo(getSaldo() + monto);

        System.out.println(
                "Depósito realizado correctamente. Nuevo saldo de ahorro: $" +
                        getSaldo()
        );
    }


    @Override
    public void pagar(double monto) {

        if (!estaVigente()) {
            System.out.println(
                    "No se puede realizar el pago porque la cuenta de ahorro está vencida."
            );
            return;
        }

        if (monto <= 0) {
            System.out.println(
                    "El monto del pago debe ser mayor a $0."
            );
            return;
        }

        if (getSaldo() - monto >= 100) {

            setSaldo(getSaldo() - monto);

            System.out.println(
                    "Pago realizado correctamente desde la cuenta de ahorro. " +
                            "Nuevo saldo: $" + getSaldo()
            );

        } else {

            System.out.println(
                    "No se puede realizar el pago porque la cuenta de ahorro " +
                            "debe mantener un saldo mínimo de $100."
            );
        }
    }


    @Override
    public void generarInteres() {

        if (!estaVigente()) {
            System.out.println(
                    "No se pueden generar intereses porque la cuenta de ahorro está vencida."
            );
            return;
        }

        double interes = getSaldo() * (getPorcentajeInteres() / 100);

        setSaldo(getSaldo() + interes);

        System.out.println(
                "Se generaron $" + interes +
                        " de intereses. Nuevo saldo de ahorro: $" +
                        getSaldo()
        );
    }


    @Override
    public double obtenerSaldoConsolidado() {
        return getSaldo();
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CuentaAhorro otraCuenta = (CuentaAhorro) obj;

        return getSaldo() == otraCuenta.getSaldo()
                && getPorcentajeInteres() == otraCuenta.getPorcentajeInteres()
                && getFechaEmision().equals(otraCuenta.getFechaEmision())
                && getFechaVencimiento().equals(otraCuenta.getFechaVencimiento());
    }


    @Override
    public String toString() {

        return "Cuenta de Ahorro -> " + super.toString();
    }
}