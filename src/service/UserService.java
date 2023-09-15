package service;

import java.util.List;

import dto.User;

public interface UserService {

    // C
    boolean insert(User user);

    // R
    List<User> selectAll();

    User select(int num);

    User select(String id);

    // D
    void remove(int num);
    
    User login(String id, String pwd);
}
