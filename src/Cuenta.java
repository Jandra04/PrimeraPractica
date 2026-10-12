import java.time.LocalDate;

public abstract class Cuenta {

    private double saldo;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private double porcentajeInteres;


    public Cuenta(double saldo,
                  LocalDate fechaEmision,
                  LocalDate fechaVencimiento,
                  double porcentajeInteres) {

        this.saldo = saldo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.porcentajeInteres = porcentajeInteres;
    }


    public double getSaldo() {
        return saldo;
    }


    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public LocalDate getFechaEmision() {
        return fechaEmision;
    }


    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }


    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }


    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }


    public double getPorcentajeInteres() {
        return porcentajeInteres;
    }


    public void setPorcentajeInteres(double porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }


    public boolean estaVigente() {

        LocalDate fechaActual = LocalDate.now();

        return fechaVencimiento.isAfter(fechaActual);
    }


    public abstract void pagar(double monto);


    public abstract void generarInteres();


    public abstract double obtenerSaldoConsolidado();


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Cuenta otraCuenta = (Cuenta) obj;

        return saldo == otraCuenta.saldo
                && porcentajeInteres == otraCuenta.porcentajeInteres
                && fechaEmision.equals(otraCuenta.fechaEmision)
                && fechaVencimiento.equals(otraCuenta.fechaVencimiento);
    }


    @Override
    public String toString() {

        return "Saldo: $" + saldo +
                ", Fecha de emisión: " + fechaEmision +
                ", Fecha de vencimiento: " + fechaVencimiento +
                ", Porcentaje de interés: " + porcentajeInteres + "%";
    }
}