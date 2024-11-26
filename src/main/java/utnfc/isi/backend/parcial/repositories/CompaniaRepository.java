    package utnfc.isi.backend.parcial.repositories;

    import java.util.Collection;

    import jakarta.persistence.EntityManager;
    import utnfc.isi.backend.parcial.models.Compania;

    public class CompaniaRepository {

        private EntityManager entityManager;

        public CompaniaRepository(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        public void saveAll(Collection<Compania> toBeSaved) {
            toBeSaved.forEach(this::save);
        }

        public void save(Compania toBeSaved) {
            begin();
            entityManager.persist(toBeSaved);
            entityManager.flush();
            commit();
        }

        private void begin() {
            entityManager.getTransaction()
                    .begin();
        }

        private void commit() {
            entityManager.getTransaction()
                    .commit();
        }

    }
