package utnfc.isi.backend.parcial.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Monedas")
public class Moneda {

    @Id
    @Column(name = "moneda_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "conversion_usd", nullable = false)
    private Double conversionUSD;
    
    public Moneda() {
    }
    
    public Moneda(String nombre, Double conversionUSD) {
        this.nombre = nombre;
        this.conversionUSD = conversionUSD;
    }

    @Override
    public String toString() {
        return "Moneda: " + nombre + ", conversionUSD:" + conversionUSD;
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

    public Double getConversionUSD() {
        return conversionUSD;
    }

    public void setConversionUSD(Double conversionUSD) {
        this.conversionUSD = conversionUSD;
    }

}
