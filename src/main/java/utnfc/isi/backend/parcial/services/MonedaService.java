package utnfc.isi.backend.parcial.services;

import java.util.HashMap;
import java.util.Map;

import utnfc.isi.backend.parcial.models.Moneda;

public class MonedaService {
    
    private Map<String, Moneda> monedas;

    public MonedaService() {
        this.monedas = new HashMap<>();
    }

    public Moneda getOrCreateMoneda(String nombre, Double conversionUSD) {
        // Si la moneda ya existe
        if (monedas.containsKey(nombre)) {
            Moneda monedaExistente = monedas.get(nombre);
            // Verificar si la conversión debe ser actualizada
            if (!monedaExistente.getConversionUSD().equals(conversionUSD)) {
                monedaExistente.setConversionUSD(conversionUSD);
            }
            return monedaExistente;
        }

        // Si la moneda no existe, crearla
        Moneda nuevaMoneda = new Moneda(nombre, conversionUSD);
        monedas.put(nombre, nuevaMoneda);
        return nuevaMoneda;
    
    }
    
}
