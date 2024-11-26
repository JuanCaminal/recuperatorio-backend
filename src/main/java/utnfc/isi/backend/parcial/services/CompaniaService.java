package utnfc.isi.backend.parcial.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import utnfc.isi.backend.parcial.models.Compania;
import utnfc.isi.backend.parcial.models.Cuenta;
import utnfc.isi.backend.parcial.models.Empleado;
import utnfc.isi.backend.parcial.models.Moneda;
import utnfc.isi.backend.parcial.models.OperadorTarjeta;
import utnfc.isi.backend.parcial.repositories.CompaniaRepository;

public class CompaniaService {

    private static final String OPERACIONES_URL = "data\\operaciones.csv";

    private CompaniaRepository companiaRepository;
    // private List<Compania> companias;
    private Map<String, Compania> companias; 
    private EmpleadoService empleadoService;
    private CuentaService cuentaService;
    private OperadorTarjetaService operadorTarjetaService;
    private MonedaService monedaService;

    public CompaniaService(EntityManager entityManager) {

        this.companiaRepository = new CompaniaRepository(entityManager);
        // companias = new ArrayList<Compania>();
        this.companias = new HashMap<>();
        empleadoService = new EmpleadoService();
        cuentaService = new CuentaService();
        operadorTarjetaService = new OperadorTarjetaService();
        monedaService = new MonedaService();   

    }

    public void loadCompanias() {

        try (BufferedReader reader = new BufferedReader(new FileReader(OPERACIONES_URL))) {

            // companias = reader.lines()
            //                 .skip(1)
            //                 .map(this::getCompaniasCSV)
            //                 .toList();
            // companias.forEach(System.out::println)

            reader.lines()
                  .skip(1) // Omitir encabezado
                  .forEach(this::getCompaniasCSV); // Procesar cada línea
            System.err.println("Total de compañías procesadas: " + companias.size());
            // System.err.println(companias.size());

            companias.values().forEach(System.out::println);

            
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Compania getCompaniasCSV(String line) {

        String[] datos = line.split("\\|");

        System.out.println(line);

        // datos compania
        String nombreCompania = datos[0].trim();
        Double comisionCompania = Double.valueOf(datos[1].trim());
        
        // datos Empleado
        String codigoEmpleado = datos[2].trim();
        String telefonoEmpleado = datos[3].trim();
        String nombreEmpleado = datos[4].trim();
        
        // datos cuenta 2da parte
        String nroCuenta = datos[5].trim();
        String nroTarjetaCuenta = datos[6].trim();

        // datos operador cuenta
        String nombreOperadorTarjeta = datos[7].trim();

        // datos cuenta 3ra parte
        String vencimientoTarjetaCuenta = datos[8].trim();
        Double saldoCuenta = Double.valueOf(datos[9].trim());

        // datos moneda
        String nombreMoneda = datos[10].trim();
        Double cotizacionMoneda = Double.valueOf(datos[11].trim());

        
        OperadorTarjeta operadorTarjeta = operadorTarjetaService.getOrCreateOperadorTarjeta(nombreOperadorTarjeta);

        Moneda moneda = monedaService.getOrCreateMoneda(nombreMoneda, cotizacionMoneda);

        // Compania compania = companias.stream()
        //                             .filter(c -> c.getNombre().equals(nombreCompania))
        //                             .findFirst()
        //                         .orElseGet(() -> {
        //                             Compania nuevaCompania = new Compania(nombreCompania, comisionCompania);
        //                             companias.add(nuevaCompania);
        //                             return nuevaCompania;
        // });

        Compania compania = companias.computeIfAbsent(nombreCompania, key -> new Compania(key, comisionCompania));

        Empleado empleado = empleadoService.getOrCreateEmpleado(nombreEmpleado, telefonoEmpleado, compania, codigoEmpleado);
        
        Cuenta cuenta = cuentaService.getOrCreateCuenta(nroCuenta, empleado, nroTarjetaCuenta, vencimientoTarjetaCuenta, operadorTarjeta, moneda, saldoCuenta);

        if (!compania.getEmpleados().contains(empleado)) {
            compania.getEmpleados().add(empleado);
            empleado.setCompania(compania);
        }

        if (!empleado.getCuentas().contains(cuenta)) {
            empleado.getCuentas().add(cuenta);
            cuenta.setEmpleado(empleado);
        }

        System.out.println("empleado: " + empleado + "#############################");

        return compania;
          
    }

    @Transactional
    public void saveCompaniasToDB() {
        // companiaRepository.saveAll(companias);
        companiaRepository.saveAll(companias.values());
    }

}
