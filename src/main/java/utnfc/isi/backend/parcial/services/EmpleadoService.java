package utnfc.isi.backend.parcial.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utnfc.isi.backend.parcial.models.Compania;
import utnfc.isi.backend.parcial.models.Cuenta;
import utnfc.isi.backend.parcial.models.Empleado;

public class EmpleadoService {

    private Map<String, Empleado> empleados;

    public EmpleadoService() {
        empleados = new HashMap<>();
    }

    public Empleado getOrCreateEmpleado(String nombreEmpleado, String telefono, Compania compania, String codEmpleado) {

        if (empleados.containsKey(codEmpleado)) {
            return empleados.get(codEmpleado);
        }

        Empleado nuevoEmpleado = new Empleado(nombreEmpleado, telefono, compania, codEmpleado);
        empleados.put(codEmpleado, nuevoEmpleado);
        return nuevoEmpleado;

    }

    public Empleado getOrCreateEmpleado(String nombreEmpleado, String telefono, Compania compania, String codEmpleado, List<Cuenta> cuenta) {

        if (empleados.containsKey(codEmpleado)) {
            return empleados.get(codEmpleado);
        }

        Empleado nuevoEmpleado = new Empleado(nombreEmpleado, telefono, compania, codEmpleado, cuenta);
        empleados.put(codEmpleado, nuevoEmpleado);
        return nuevoEmpleado;

    }

}
