package com.example.exam_spring_sec.common;

import com.example.exam_spring_sec.model.Book;
import com.example.exam_spring_sec.model.Role;
import com.example.exam_spring_sec.model.User;
import com.example.exam_spring_sec.repository.BookRepository;
import com.example.exam_spring_sec.repository.RoleRepository;
import com.example.exam_spring_sec.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles1 = new ArrayList<>(Arrays.asList(
                new Role(null, "ROLE_SUPER_ADMIN") ));

        roleRepository.saveAll(roles1);
        List<Role> roles2 = new ArrayList<>(Arrays.asList(
                new Role(null,"ROLE_ADMIN")
        ));
        roleRepository.saveAll(roles2);
        userRepository.save(new User(null,"super_admin","1",roles1));
        userRepository.save(new User(null,"admin","1",roles2));


        bookRepository.save(new Book(null,"Goodbye America",25000.0));
    }
}
