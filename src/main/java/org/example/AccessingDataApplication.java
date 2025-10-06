package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataApplication {

    AddressBook Book = new AddressBook();
    BuddyInfo buddy1 = new BuddyInfo("Brian Collins", "13 Colonel Street", "61488229090");
    BuddyInfo buddy2 = new BuddyInfo("Steph Curry", "55 Hope Drive", "61488229090");
    BuddyInfo buddy3 = new BuddyInfo("Estavon Sander", "105 Peach Street", "6629910035");
    BuddyInfo buddy4 = new BuddyInfo("Ryan Teeley", "99 Dove Crescent", "1234567890");


    private static final Logger log = LoggerFactory.getLogger(AccessingDataApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository repo) {
        Book.addBuddy(buddy1);
        Book.addBuddy(buddy2);
        Book.addBuddy(buddy3);
        Book.addBuddy(buddy4);

        return args -> {
            //save the addressBook
            repo.save(Book);

            //fetch all BuddyInfo
            log.info("AddressBook found with findAll()");
            log.info("--------------------------------");
            repo.findAll().forEach(Book -> log.info(Book.toString()));
            log.info("");

//            //fetch a buddy by name
//            log.info("Buddy found with findByName('Brian Collins'):");
//            log.info("---------------------------------------------");
//            repo.findByName("Brian Collins").forEach(b ->{
//                log.info(b.toString());
//            });
//            log.info("");
        };



    }
}
