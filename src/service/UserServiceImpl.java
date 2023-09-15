package service;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.User;

public class UserServiceImpl implements UserService {

    static private UserService instance = new UserServiceImpl();
    private UserDao dao = UserDaoImpl.getInstance();

    private UserServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    static public UserService getInstance() {
        return instance;
    }

    @Override
    public boolean insert(User user) {
        // TODO Auto-generated method stub
        return dao.insert(user);
    }

    @Override
    public List<User> selectAll() {
        // TODO Auto-generated method stub
        return dao.selectAll();
    }

    @Override
    public User select(int num) {
        // TODO Auto-generated method stub
        return dao.select(num);
    }

    @Override
    public User select(String id) {
        // TODO Auto-generated method stub
        return dao.select(id);
    }

    @Override
    public void remove(int num) {
        // TODO Auto-generated method stub
        dao.remove(num);
    }

    @Override
    public User login(String id, String pwd) {
        // TODO Auto-generated method stub
        if(dao.login(id, pwd)) {
            return dao.select(id);
        }
        return null;
    }

}
