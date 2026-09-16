package com.khaled_GmbH.e.commerce.api.servicies;

import com.khaled_GmbH.e.commerce.api.entities.User;
import com.khaled_GmbH.e.commerce.api.repositories.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void userProfileService () {
        var user = User.builder().username("John Müller").email("mueller@yahoo.com").password("dsdsacxxvc").build();
        userRepository.save(user);
    }
}
