package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User;

public class UserDaoImpl implements UserDao {

    static private UserDao instance = new UserDaoImpl();
    private List<User> userList = new ArrayList<User>();
    private int num = 0;

    private UserDaoImpl() {
        // TODO Auto-generated constructor stub
    }

    static public UserDao getInstance() {
        return instance;
    }

    @Override
    public boolean insert(User user) {
        for (User temp : userList) {
            if (temp.getId().equals(user.getId())) {
                System.out.println("hello");
                return true;
            }
        }
        System.out.println("f  ");
        num++;
        user.setNum(num);
        userList.add(user);
        return false;
    }

    @Override
    public List<User> selectAll() {
        return userList;
    }

    @Override
    public User select(int num) {
        for (User user : userList) {
            if (user.getNum() == num) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User select(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void remove(int num) {
        int index = userList.size();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getNum() == num) {
                index = i;
                break;
            }
        }
        if (index == userList.size()) {
            System.out.println("IndexOutOfBounds 발생 ");
            return;
        }
        userList.remove(index);
    }

    @Override
    public boolean login(String id, String pwd) {
        // TODO Auto-generated method stub
        User user = new User();
        user.setId(id);
        user.setPwd(pwd);
        return userList.contains(user);
    }

}
