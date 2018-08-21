package test;

import dao.UserDAO;
import entity.User;
import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by 1311230692@qq.com on 2018/8/17 13:17
 * 用户操作控制侧测试类
 **/
public class UserControllerTest extends BaseJunitTest{

//    @Autowired
    @Resource(name = "userService") // 默认是 ByName 获取 bean 的值，通过获取配置文件中配置
    private UserService userService;


    @Test
    public void testController() {
        List<User> userList = userService.getUserById(1,1,10);
        System.out.println("查询用户信息为：" + userList);
    }
}
