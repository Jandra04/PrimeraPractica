import java.time.LocalDate;

public class CuentaCredito extends Cuenta {

    private double limiteCredito;
    private String tipo;


    public CuentaCredito(LocalDate fechaEmision,
                         LocalDate fechaVencimiento,
                         double porcentajeInteres,
                         double limiteCredito,
                         String tipo) {

        super(0, fechaEmision, fechaVencimiento, porcentajeInteres);

        this.limiteCredito = limiteCredito;
        this.tipo = tipo;
    }


    public double getLimiteCredito() {
        return limiteCredito;
    }


    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    @Override
    public void pagar(double monto) {

        if (!estaVigente()) {
            System.out.println(
                    "No se puede realizar el pago porque la cuenta de crédito está vencida."
            );
            return;
        }

        if (monto <= 0) {
            System.out.println(
                    "El monto del pago debe ser mayor a $0."
            );
            return;
        }

        if (getSaldo() + monto <= limiteCredito) {

            setSaldo(getSaldo() + monto);

            System.out.println(
                    "Pago realizado correctamente con la cuenta de crédito. " +
                            "Deuda actual: $" + getSaldo()
            );

        } else {

            System.out.println(
                    "No se puede realizar el pago porque supera el límite de crédito de $" +
                            limiteCredito + "."
            );
        }
    }


    public void abonar(double monto) {

        if (!estaVigente()) {
            System.out.println(
                    "No se puede realizar el abono porque la cuenta de crédito está vencida."
            );
            return;
        }

        if (monto <= 0) {
            System.out.println(
                    "El monto del abono debe ser mayor a $0."
            );
            return;
        }

        if (monto > getSaldo()) {

            System.out.println(
                    "No se puede abonar $" + monto +
                            " porque la deuda actual es de $" + getSaldo() + "."
            );

        } else {

            setSaldo(getSaldo() - monto);

            System.out.println(
                    "Abono realizado correctamente. Deuda restante: $" +
                            getSaldo()
            );
        }
    }


    @Override
    public void generarInteres() {

        if (!estaVigente()) {
            System.out.println(
                    "No se pueden generar intereses porque la cuenta de crédito está vencida."
            );
            return;
        }

        double interes = getSaldo() * (getPorcentajeInteres() / 100);

        if (getSaldo() + interes <= limiteCredito) {

            setSaldo(getSaldo() + interes);

            System.out.println(
                    "Se generaron $" + interes +
                            " de intereses. Nueva deuda: $" + getSaldo()
            );

        } else {

            System.out.println(
                    "No se pueden aplicar los intereses porque la deuda superaría " +
                            "el límite de crédito de $" + limiteCredito + "."
            );
        }
    }


    @Override
    public double obtenerSaldoConsolidado() {
        return -getSaldo();
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        CuentaCredito otraCuenta = (CuentaCredito) obj;

        return getSaldo() == otraCuenta.getSaldo()
                && getPorcentajeInteres() == otraCuenta.getPorcentajeInteres()
                && limiteCredito == otraCuenta.limiteCredito
                && tipo.equals(otraCuenta.tipo)
                && getFechaEmision().equals(otraCuenta.getFechaEmision())
                && getFechaVencimiento().equals(otraCuenta.getFechaVencimiento());
    }


    @Override
    public String toString() {

        return "Cuenta de Crédito " + tipo +
                " -> " + super.toString() +
                ", Límite de crédito: $" + limiteCredito;
    }
}