package utnfc.isi.backend.parcial.services;

import java.util.HashMap;
import java.util.Map;

import utnfc.isi.backend.parcial.models.OperadorTarjeta;

public class OperadorTarjetaService {
    
    private Map<String, OperadorTarjeta> operadoresTarjeta;

    public OperadorTarjetaService() {
        this.operadoresTarjeta = new HashMap<>();
    }

    public OperadorTarjeta getOrCreateOperadorTarjeta(String operadorTarjeta) {
        if (operadoresTarjeta.containsKey(operadorTarjeta)) {
            return operadoresTarjeta.get(operadorTarjeta);
        }

        OperadorTarjeta nuevoOperadorTarjeta = new OperadorTarjeta(operadorTarjeta);
        operadoresTarjeta.put(operadorTarjeta, nuevoOperadorTarjeta);
        return nuevoOperadorTarjeta;
    }
}
