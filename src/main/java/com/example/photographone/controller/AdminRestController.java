package com.example.photographone.controller;

import com.example.photographone.DAO.CityDAO;
import com.example.photographone.DAO.CostumerDAO;
import com.example.photographone.DAO.UserDAO;
import com.example.photographone.models.*;
import com.example.photographone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminRestController {
    @Autowired
    UserService userService;
    @Autowired
    CityDAO cityDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    CostumerDAO costumerDAO;

    @RequestMapping(value = "/saveCity")
    public List<City> saveCity(@RequestBody City city) {
        cityDAO.save(city);
        return cityDAO.findAll();
    }

    @GetMapping("/allCities")
    public List<City> allCities() {
        return cityDAO.findAll();
    }

    @RequestMapping(value = "/saveAdmin")
    public String saveAdmin(@RequestBody User user) {
        System.out.println("1");
        user.setRole(Role.ROLE_ADMIN);
        userService.saveAdmin(user,new Contact());

        System.out.println("2");
        return "adminn";

    }

    @GetMapping("/findUser")
    public UserDetails user(@RequestParam String username) {
        UserDetails byUsername = userDAO.findByUsername(username);

        return byUsername;
    }
}
