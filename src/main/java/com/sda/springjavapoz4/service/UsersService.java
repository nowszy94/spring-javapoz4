package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.User;
import com.sda.springjavapoz4.service.generator.FirstNameGenerator;
import com.sda.springjavapoz4.service.generator.LastNameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersService {

    private List<User> users;

    @Autowired
    private FirstNameGenerator firstNameGenerator;

    @Autowired
    private LastNameGenerator lastNameGenerator;

    public UsersService() {
        this.users = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());
        this.users.add(getExampleUser());

        users.forEach(user -> System.out.println(user));
//        users.forEach(System.out::println);
    }

    public User getUser(int id) {
        return id >= users.size() ? null : users.get(id);
    }

    public User getExampleUser() {
        User user = new User();
        user.setId(1);
        user.setFirstName(firstNameGenerator.getRandomFirstName());
        user.setLastName(lastNameGenerator.getRandomLastName());
        user.setPhoneNumber("12368643");
        return user;
    }

    public List<User> getUsersByFirstName(String firstName) {
        return users.stream()
                .filter(user -> user.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }
}
