package com.genius.services;

import com.genius.domain.security.User;
import com.genius.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class consists API for entity User
 *
 * @author  Gennady Savinov
 * @see     UserRepository
 */
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
