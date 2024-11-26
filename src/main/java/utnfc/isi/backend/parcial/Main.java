package utnfc.isi.backend.parcial;

import jakarta.persistence.Persistence;
import utnfc.isi.backend.parcial.services.CompaniaService;

public class Main {

    public static void main(String[] args) throws Exception {
        try(var emf = Persistence.createEntityManagerFactory("parcial-pu");
                var em = emf.createEntityManager()) {

            CompaniaService companiaService = new CompaniaService(em);
            companiaService.loadCompanias();

            companiaService.saveCompaniasToDB();

        }
    }
}
