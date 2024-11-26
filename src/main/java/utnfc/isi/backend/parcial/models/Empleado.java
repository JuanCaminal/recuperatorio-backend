package utnfc.isi.backend.parcial.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleados")
public class Empleado {
    
    @Id
    @Column(name = "empleado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "compania_id", referencedColumnName = "compania_id", nullable = false)
    private Compania compania;
    
    @Column(name = "codigo", nullable = false)
    private String codigoEmpleado;

    @OneToMany(mappedBy = "empleado", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cuenta> cuentas;

    public Empleado() {
    }

    public Empleado(String nombre, String telefono, Compania compania, String codigoEmpleado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.compania = compania;
        this.codigoEmpleado = codigoEmpleado;
        this.cuentas = new ArrayList<>();
    }

    public Empleado(String nombre, String telefono, Compania compania, String codigoEmpleado, List<Cuenta> cuentas) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.compania = compania;
        this.codigoEmpleado = codigoEmpleado;
        this.cuentas = cuentas;
    }


    @Override
    public String toString() {
    return "Empleado [\n" +
           "  nombre: " + nombre + ",\n" +
           "  codigoEmpleado: " + codigoEmpleado + ",\n" +
           "  cuentas=\n" + (cuentas != null ? cuentas.stream()
                   .map(cuenta -> "    " + cuenta.toString())
                   .collect(Collectors.joining(",\n")) 
                   : "    []") + "\n]";
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
