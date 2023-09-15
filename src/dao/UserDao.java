package dao;

import java.util.List;

import dto.User;

public interface UserDao {

    // C
    boolean insert(User user);

    // R
    List<User> selectAll();

    User select(int num);

    User select(String id);

    // D
    void remove(int num);
    
    boolean login(String id, String pwd);
}
