package service;

import entity.User;

import java.util.List;

/**
 * create by 1311230692@qq.com on 2018/8/17 10:22
 * 用户操作业务逻辑层接口
 **/
public interface UserService {
    public List<User> getAllUser(int page, int limit); // 查询所有用户信息
    public int getCount(); // 返回数据库总条数
    public List<User> getUserById(int id,int page, int limit); // 根据 id 查询用户信息
}
