package dao;

import entity.User;

import java.util.List;

/**
 * create by 1311230692@qq.com on 2018/8/17 10:21
 * 用户操作接口
 **/
public interface UserDAO {
    List<User> getAllUser(int page, int limit); // 查询用户所有信息
    int getCount(); // 获取数据库数据总条数
    List<User> getUserById(int id,int page,int limit); // 根据 id 查询用户信息
    User getUserById1(int id); // 验证 id 是否存在
    User getUserByIdAndPassword(int id, String password); // 验证密码是否正确
}
