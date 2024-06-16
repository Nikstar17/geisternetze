import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class NetzDatenbankController implements Serializable {
    private List<Geisternetz> netzliste;

    public List<Geisternetz> getAlleNetze() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("geisternetzPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT e FROM Geisternetz e", Geisternetz.class).getResultList();

    }

    public List<Geisternetz> getGemeldeteNetze() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("geisternetzPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT e FROM Geisternetz e WHERE e.status = 0", Geisternetz.class).getResultList();

    }

    public List<Geisternetz> getBergungBevorstehendNetze() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("geisternetzPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT e FROM Geisternetz e WHERE e.status = 1", Geisternetz.class).getResultList();

    }

    public List<Geisternetz> getGeborgendeNetze() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("geisternetzPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT e FROM Geisternetz e WHERE e.status = 2", Geisternetz.class).getResultList();

    }

    public List<Geisternetz> getVerschollendeNetze() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("geisternetzPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT e FROM Geisternetz e WHERE e.status = 3", Geisternetz.class).getResultList();

    }
}
