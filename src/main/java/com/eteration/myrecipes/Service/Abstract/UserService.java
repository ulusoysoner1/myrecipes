package com.eteration.myrecipes.Service.Abstract;


import com.eteration.myrecipes.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(Integer userId, User user);

    User getUserById(Integer userId);


}
