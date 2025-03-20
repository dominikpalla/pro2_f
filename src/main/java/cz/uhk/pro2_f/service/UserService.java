package cz.uhk.pro2_f.service;

import cz.uhk.pro2_f.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserService {
    ArrayList<User> getAllUsers();
    void saveUser(User user);
}
