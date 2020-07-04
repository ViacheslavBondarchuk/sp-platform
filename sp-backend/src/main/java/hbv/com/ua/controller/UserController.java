package hbv.com.ua.controller;

import hbv.com.ua.model.User;
import hbv.com.ua.service.impl.UserServiceImpl;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User read(@PathVariable long id) throws NotFoundException {
        return userService.read(id);
    }

    @GetMapping
    public List<User> readAll() {
        return Arrays.asList(new User());
    }

}
