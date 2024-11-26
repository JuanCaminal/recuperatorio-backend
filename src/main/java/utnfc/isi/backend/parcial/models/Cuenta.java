package utnfc.isi.backend.parcial.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cuentas")
public class Cuenta {
    
    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_cuenta", nullable = false)
    private String numeroCuenta;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "empleado_id", referencedColumnName = "empleado_id", nullable = false)
    private Empleado empleado;

    @Column(name = "numero_tarjeta", nullable = false)
    private String numeroTarjeta;
    
    @Column(name = "vencimiento_tarjeta", nullable = false)
    private String vencimientoTarjeta;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_tarjeta_id", referencedColumnName = "operador_id", nullable = false)
    private OperadorTarjeta operadorTarjeta;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "moneda_id", nullable = false)
    private Moneda moneda;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, Empleado empleado, String numeroTarjeta, String vencimientoTarjeta,
            OperadorTarjeta operadorTarjeta, Moneda moneda, Double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.empleado = empleado;
        this.numeroTarjeta = numeroTarjeta;
        this.vencimientoTarjeta = vencimientoTarjeta;
        this.operadorTarjeta = operadorTarjeta;
        this.moneda = moneda;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
    return "Cuenta [\n" +
           "  numeroCuenta=" + numeroCuenta + ",\n" +
           "  numeroTarjeta=" + numeroTarjeta + ",\n" +
           "  operadorTarjeta=" + operadorTarjeta + ",\n" +
           "  moneda=" + moneda + ",\n" +
           "  saldo=" + saldo + "\n]";
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getVencimientoTarjeta() {
        return vencimientoTarjeta;
    }

    public void setVencimientoTarjeta(String vencimientoTarjeta) {
        this.vencimientoTarjeta = vencimientoTarjeta;
    }

    public OperadorTarjeta getOperadorTarjeta() {
        return operadorTarjeta;
    }

    public void setOperadorTarjeta(OperadorTarjeta operadorTarjeta) {
        this.operadorTarjeta = operadorTarjeta;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
