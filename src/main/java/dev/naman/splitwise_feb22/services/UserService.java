package dev.naman.splitwise_feb22.services;

import dev.naman.splitwise_feb22.models.User;
import dev.naman.splitwise_feb22.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User registerUser(String name,
                             String phoneNumber,
                             String password) {
        User user = new User();
        user.setName(name);
        user.setHashedPassword(password);
        user.setPhoneNumber(phoneNumber);

        User userResponse = userRepository.save(user);

        return userResponse;
    }

    public boolean updatePassword(Long userId,
                                  String newPassword) {
        // 1. find the user with the user id
        // 2. update the password of the user
        // 3. save the new user
        Optional<User> user = userRepository.findById(userId);

        System.out.println("Found a user");

        if (user.isEmpty()) {
            // TODO: Throw exception
            return false;
        }

        User userObj = user.get();
        userObj.setHashedPassword(newPassword);
        userRepository.save(userObj);

        return true;
    }
}
