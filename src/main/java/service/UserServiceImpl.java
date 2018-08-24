package service;

import entity.User;
import dao.UserDAO;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by 1311230692@qq.com on 2018/8/17 10:24
 * 用户操作业务逻辑层接口实现
 **/
@Service("UserService")
public class UserServiceImpl implements UserService{

    // 注入 DAO 接口
    @Resource
    private UserDAO userDAO;

    public List<User> getAllUser(int start, int pageSize) {
        return userDAO.getAllUser(start,pageSize);
    }

    public List<User> getUserById(int id, int page, int limit) {
        return userDAO.getUserById(id, page, limit);
    }

    @Override
    public int getCount() {
        return userDAO.getCount();
    }

    @Override
    public User getUserById1(int id) {
        return userDAO.getUserById1(id);
    }

    @Override
    public User getUserByIdAndPassword(int id, String password) {
        return userDAO.getUserByIdAndPassword(id, password);
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUserByNickname(String nickname) {
        return userDAO.getUserByNickname(nickname);
    }

    @Override
    public void deleteUserById(int id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public void updatePassword(User user) {
        userDAO.updatePassword(user);
    }
}
