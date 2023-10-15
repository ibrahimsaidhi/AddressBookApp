package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookApplication {
    private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class);
    }

    /*
    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repo, AddressBookRepository repo2) {
        return (args) -> {

            repo.save(new BuddyInfo("Ibrahim", "343-297-1675"));
            repo.save(new BuddyInfo("Asly", "613-233-1463"));
            repo.save(new BuddyInfo("Bob", "343-877-1411"));
            repo.save(new BuddyInfo("John", "613-111-2756"));

            log.info("Buddy Information found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo info : repo.findAll()) {
                log.info(info.toString());
            }
            log.info("");
            repo2.save(new AddressBook("Book 1"));
            BuddyInfo info = repo.findById(1L);

            for (AddressBook book : repo2.findAddressBookByNameOfBook("Book 1")){
                book.addBuddyInfo(info);
                log.info(book.toString());
                book.display();
            }
        };
    }
*/
}

