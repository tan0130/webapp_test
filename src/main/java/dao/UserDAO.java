package dao;

import entity.User;

import java.util.List;

/**
 * create by 1311230692@qq.com on 2018/8/17 10:21
 * 用户操作接口
 **/
public interface UserDAO {
    public List<User> getAllUser(int start, int pageSize); // 查询用户所有信息
    public List<User> getUserById(int id); // 根据 id 查询用户信息
}
