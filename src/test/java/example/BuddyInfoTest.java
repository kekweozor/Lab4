package example;

import jakarta.persistence.*;
import org.example.BuddyInfo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BuddyInfoTest {
    BuddyInfo buddyInfo = new BuddyInfo("Ryan", "67 Impeacher Road", "08033029118");

    @Test
    public void getName() {
        assertEquals("Ryan", buddyInfo.getName());
    }

    @Test
    public void getAddress() {
        assertEquals("67 Impeacher Road", buddyInfo.getAddress());
    }

    @Test
    public void getPhone() {
        assertEquals("08033029118", buddyInfo.getPhone());
    }

    @Test
    public void performJPA() {

        // Creating objects representing some products
        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setId(1);
        buddy1.setName("Ryan Cherki");
        buddy1.setAddress("15 Colonel Saint Road");
        buddy1.setPhone("6167799001");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setId(2);
        buddy2.setName("Gio Infantino");
        buddy2.setAddress("15 Saint-Saint Road");
        buddy2.setPhone("8810521002");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy1);
        em.persist(buddy2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        assertEquals(results.get(0).getName(), "Ryan Cherki");
        assertEquals(results.get(1).getName(), "Gio Infantino");

    }
}