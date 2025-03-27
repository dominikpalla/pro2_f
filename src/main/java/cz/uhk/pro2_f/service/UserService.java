package cz.uhk.pro2_f.service;

import cz.uhk.pro2_f.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUser(long id);
    void delete(long id);
}
