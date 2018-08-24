package service;

import entity.User;

import java.util.List;

/**
 * create by 1311230692@qq.com on 2018/8/17 10:22
 * 用户操作业务逻辑层接口
 **/
public interface UserService {
    List<User> getAllUser(int page, int limit); // 查询所有用户信息
    int getCount(); // 返回数据库总条数
    List<User> getUserById(int id,int page, int limit); // 根据 id 查询用户信息
    User getUserById1(int id); // 验证 id 是否存在
    User getUserByIdAndPassword(int id, String password); // 验证密码是否正确
    void addUser(User user); // 添加用户信息
    User getUserByNickname(String nickname); // 根据用户名查询信息
    void deleteUserById(int id); // 根据 id 删除员工信息
    void updatePassword(User user); // 修改密码
}
