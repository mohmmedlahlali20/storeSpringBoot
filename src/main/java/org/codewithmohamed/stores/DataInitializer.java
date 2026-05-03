package org.codewithmohamed.stores;

import org.codewithmohamed.stores.model.Event;
import org.codewithmohamed.stores.model.User;
import org.codewithmohamed.stores.repositories.EventRepository;
import org.codewithmohamed.stores.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public DataInitializer(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setEmail("mohammed@gmail.com");
            admin.setPassword("Mohammed123");
            admin.setRole("ROLE_ADMIN");
            userRepository.save(admin);
            System.out.println("admin User created");
        }
        if (eventRepository.count() == 0) {
            Event e1 = new Event();
            e1.setTitle("Techno Spayck");
            e1.setDescription("Events marocain");
            e1.setLocation("CasaBlanca");
            e1.setEventDate(LocalDateTime.now().plusDays(10));
            e1.setTotalCapacity(1001);

            Event e2 = new Event();
            e2.setTitle("Festival l-Gnaoua");
            e2.setDescription("event Essaouira.");
            e2.setLocation("Essaouira");
            e2.setEventDate(LocalDateTime.now().plusDays(30));
            e2.setTotalCapacity(1000);


            eventRepository.save(e1);
            eventRepository.save(e2);
            System.out.println("event saved");
        }
    }
}
