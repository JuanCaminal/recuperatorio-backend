package utnfc.isi.backend.parcial.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OperadoresTarjetas")
public class OperadorTarjeta {

    @Id
    @Column(name = "operador_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
    
    public OperadorTarjeta() {
    }
    
    public OperadorTarjeta(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "OperadorTarjeta: " + nombre;
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

}
