package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.repository.UsersRepository;
import com.sda.springjavapoz4.service.generator.FirstNameGenerator;
import com.sda.springjavapoz4.service.generator.LastNameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private FirstNameGenerator firstNameGenerator;

    @Autowired
    private LastNameGenerator lastNameGenerator;

    public UsersService() {
    }

    @PostConstruct
    public void init() {
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());
        usersRepository.save(getExampleUser());

        usersRepository.findAll().forEach(user -> System.out.println(user));
//        users.forEach(System.out::println);
    }

    public User getUser(int id) {
        return usersRepository.findOne((long)id);
    }

    public User getExampleUser() {
        User user = new User();
        user.setFirstName(firstNameGenerator.getRandomFirstName());
        user.setLastName(lastNameGenerator.getRandomLastName());
        user.setPhoneNumber("12368643");
        return user;
    }

    public User getRandomUser() {
        return getExampleUser();
    }

    public List<User> getUsersByFirstName(String firstName) {
        return usersRepository.findByFirstName(firstName);
    }

    public List<User> getAllUsers() {
        return StreamSupport.stream(usersRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
}

    public void addUser(User user) {
        usersRepository.save(user);
    }
}
