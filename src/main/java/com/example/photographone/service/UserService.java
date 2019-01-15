package com.example.photographone.service;

import com.example.photographone.models.Contact;
import com.example.photographone.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void savePhotograph(User user, Contact contact);
    void saveUser(User user, Contact contact);

    boolean activatePhotographer(String code);
}
