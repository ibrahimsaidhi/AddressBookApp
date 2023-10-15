import org.example.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class BuddyInfoTest {

    @Test
    public void testBuddyInfoNamingIsCorrect(){
        BuddyInfo info = new BuddyInfo();
        info.setBuddyName("Ibrahim");
        assertEquals("Ibrahim", info.getBuddyName());
    }

    @Test
    public void testBuddyNumberIsValid(){
        BuddyInfo info = new BuddyInfo();
        info.setBuddyNumber("343-297-1675");
        assertEquals("343-297-1675", info.getBuddyNumber());
    }

    @Test
    public void testBuddyInfoIsDisplayedProperly(){
        BuddyInfo info = new BuddyInfo();
        info.setBuddyNumber("343-297-1675");
        info.setBuddyName("Ibrahim");
        info.display();
        assertEquals("Buddy Name: Ibrahim, Buddy Number: 343-297-1675", info.getCompleteBuddyInfo());
    }
    @Test
    public void testBuddyInfoAnnotationAndPersistence(){
        BuddyInfo info1 = new BuddyInfo();
        info1.setId(1L);
        info1.setBuddyName("Ibrahim");
        info1.setBuddyNumber("343-297-1675");

        BuddyInfo info2 = new BuddyInfo();
        info2.setId(2L);
        info2.setBuddyName("Asly");
        info2.setBuddyNumber("613-233-1463");

        // persistence of buddy infos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookTest");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the buddy info entity objects
        em.persist(info1);
        em.persist(info2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("All Buddy Information: \n----------------");

        for (BuddyInfo b : results) {
            System.out.println(b.getBuddyName() + " (id=" + b.getId() + ")");
        }

        // Closing connection
        em.close();
        emf.close();

    }
}
