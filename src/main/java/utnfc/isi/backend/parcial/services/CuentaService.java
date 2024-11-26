package utnfc.isi.backend.parcial.services;

import java.util.HashMap;
import java.util.Map;

import utnfc.isi.backend.parcial.models.Cuenta;
import utnfc.isi.backend.parcial.models.Empleado;
import utnfc.isi.backend.parcial.models.Moneda;
import utnfc.isi.backend.parcial.models.OperadorTarjeta;

public class CuentaService {

    private Map<String, Cuenta> cuentas;

    public CuentaService() {
        cuentas = new HashMap<>();
    }

    public Cuenta getOrCreateCuenta(String numeroCuenta, Empleado empleado, String numeroTarjeta, String vencimientoTarjeta, 
                                    OperadorTarjeta operadorTarjeta, Moneda moneda, Double saldo) {
        
        if (cuentas.containsKey(numeroCuenta)) {
            return cuentas.get(numeroCuenta);
        }

        Cuenta nuevaCuenta = new Cuenta(numeroCuenta, empleado, numeroTarjeta, vencimientoTarjeta, operadorTarjeta, moneda, saldo);
        cuentas.put(numeroCuenta, nuevaCuenta);
        return nuevaCuenta;
        
    }

}
