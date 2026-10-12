import java.time.LocalDate;

public class CuentaDebito extends Cuenta {

    public CuentaDebito(double saldo,
                        LocalDate fechaEmision,
                        LocalDate fechaVencimiento,
                        double porcentajeInteres) {

        super(saldo, fechaEmision, fechaVencimiento, porcentajeInteres);

        if (saldo < 0) {
            throw new IllegalArgumentException(
                    "La cuenta de débito no puede iniciar con saldo negativo."
            );
        }
    }


    public void depositar(double monto) {

        if (!estaVigente()) {
            System.out.println(
                    "No se puede realizar el depósito porque la cuenta de débito está vencida."
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
                "Depósito realizado correctamente. Nuevo saldo de débito: $" +
                        getSaldo()
        );
    }


    @Override
    public void pagar(double monto) {

        if (!estaVigente()) {
            System.out.println(
                    "No se puede realizar el pago porque la cuenta de débito está vencida."
            );
            return;
        }

        if (monto <= 0) {
            System.out.println(
                    "El monto del pago debe ser mayor a $0."
            );
            return;
        }

        if (getSaldo() - monto >= 0) {

            setSaldo(getSaldo() - monto);

            System.out.println(
                    "Pago realizado correctamente desde la cuenta de débito. " +
                            "Nuevo saldo: $" + getSaldo()
            );

        } else {

            System.out.println(
                    "No se puede realizar el pago porque la cuenta de débito " +
                            "no puede quedar con saldo negativo."
            );
        }
    }


    @Override
    public void generarInteres() {

        if (!estaVigente()) {
            System.out.println(
                    "No se pueden generar intereses porque la cuenta de débito está vencida."
            );
            return;
        }

        double interes = getSaldo() * (getPorcentajeInteres() / 100);

        setSaldo(getSaldo() + interes);

        System.out.println(
                "Se generaron $" + interes +
                        " de intereses. Nuevo saldo de débito: $" +
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

        CuentaDebito otraCuenta = (CuentaDebito) obj;

        return getSaldo() == otraCuenta.getSaldo()
                && getPorcentajeInteres() == otraCuenta.getPorcentajeInteres()
                && getFechaEmision().equals(otraCuenta.getFechaEmision())
                && getFechaVencimiento().equals(otraCuenta.getFechaVencimiento());
    }


    @Override
    public String toString() {

        return "Cuenta de Débito -> " + super.toString();
    }
}