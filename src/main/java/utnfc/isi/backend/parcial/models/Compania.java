package utnfc.isi.backend.parcial.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Companias")
public class Compania {
    
    @Id
    @Column(name = "compania_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "comision", nullable = false)
    private Double comision;

    @OneToMany(mappedBy = "compania", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Empleado> empleados;
    
    public Compania() {
    }

    public Compania(String nombre, Double comision) {
        this.nombre = nombre;
        this.comision = comision;
        this.empleados = new ArrayList<>();
    }

    public Compania(String nombre, Double comision, List<Empleado> empleados) {
        this.nombre = nombre;
        this.comision = comision;
        this.empleados = empleados;
    }

    /* 
     * 
     @Override
     public String toString() {
        return "Compania [\n" +
        "  nombre=" + nombre + ",\n" +
        "  comision=" + comision + ",\n" +
        "  empleados=\n" + (empleados != null ? empleados.stream()
        .map(emp -> "    " + emp.toString())
        .collect(Collectors.joining(",\n")) 
        : "    []") + "\n]";
    }
    
    */

    @Override
    public String toString() {
       return "Compania [\n" +
       "  nombre=" + nombre + ",\n" +
       "  comision=" + comision + "],\n";
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
    
    public Double getComision() {
        return comision;
    }
    
    public void setComision(Double comision) {
        this.comision = comision;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    

}
