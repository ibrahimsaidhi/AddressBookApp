import jakarta.persistence.*;
import org.example.AddressBook;
import org.example.BuddyInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AddressBookTest {

    @Test
    public void testIfBuddyInfoWasAddedToBook(){
        BuddyInfo info = new BuddyInfo("Ibrahim", "343-297-1675");
        AddressBook book = new AddressBook();

        book.addBuddyInfo(info);
        assertFalse(book.getBuddies().isEmpty());
    }

    @Test
    public void testIfBuddyInfoWasRemovedFromBook(){
        BuddyInfo info = new BuddyInfo("Ibrahim", "343-297-1675");
        AddressBook book = new AddressBook();
        book.addBuddyInfo(info);
        assertFalse(book.getBuddies().isEmpty());
        book.removeBuddyInfo(info);
        assertTrue(book.getBuddies().isEmpty());
    }

    @Test
    public void testPersistingAddressBookWithBuddyInfos(){
        BuddyInfo info1 = new BuddyInfo();
        info1.setId(1L);
        info1.setBuddyName("Ibrahim");
        info1.setBuddyNumber("343-297-1675");

        BuddyInfo info2 = new BuddyInfo();
        info2.setId(2L);
        info2.setBuddyName("Asly");
        info2.setBuddyNumber("613-233-1463");

        List<BuddyInfo> infoList = new ArrayList<BuddyInfo>();
        infoList.add(info1);
        infoList.add(info2);

        AddressBook book = new AddressBook();
        book.setId(1);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookTest");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(book);

        for (BuddyInfo info: infoList){
            info.setBook(book);
            book.addBuddyInfo(info);
            em.persist(info);
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

}
