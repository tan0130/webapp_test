package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by 1311230692@qq.com on 2018/8/17 10:28
 * 用户操作控制层
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    // 注入 UserService
//    @Autowired
    @Resource(name = "userService")
    private UserService userService;

    /**
     * 查询所有用户信息
     * @param page 查询的页码数
     * @param limit 每页的数据条数
     * @return json 返回 json 数据
     * */
    @RequestMapping(value="/getAllUser",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAllUser(int page, int limit) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> userLst = userService.getAllUser((page-1)*limit, limit);
        int totalCount = userService.getCount();
        map.put("status", 200);
        map.put("hint", "");
        map.put("total", totalCount);
        map.put("rows", userLst);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }

    /**
     * 根据 id 查询用户信息
     * */
    @RequestMapping(value="/getUserById",produces = "application/json; charset=utf-8")
    public String getUserById(int id, int page, int limit) throws Exception{
        System.out.println("用户信息为：" + userService.getUserById(id, page, limit));
        Map<String, Object> map = new HashMap<String, Object>();
        List<User> userLst = userService.getUserById(id, (page - 1) * limit, limit);
        int totalCount = 1;
        map.put("status", 200);
        map.put("hint", "");
        map.put("total", totalCount);
        map.put("rows", userLst);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(map);
    }

}
