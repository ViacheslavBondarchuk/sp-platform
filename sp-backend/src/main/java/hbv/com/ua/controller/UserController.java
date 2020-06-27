package hbv.com.ua.controller;

import hbv.com.ua.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public User read(@PathVariable long id) {
        return new User();
    }

    @GetMapping
    public List<User> readAll() {
        return Arrays.asList(new User());
    }

}
