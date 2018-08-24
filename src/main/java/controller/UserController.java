package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by 1311230692@qq.com on 2018/8/17 10:28
 * 用户操作控制层
 **/
@Controller
@Transactional
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
    @ResponseBody
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

    /**
     * 登录操作，用户名和密码确认
     * @param id 登录 id
     * @param password 登录密码
     * @return string 返回提示信息
     * */
    @RequestMapping(value = "/login")
    @ResponseBody
    public String loginCheck(int id, String password, HttpServletRequest request) throws Exception{
        Map<String, Object> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (null == userService.getUserById1(id)) {
                map.put("result","idNotExist");
                return objectMapper.writeValueAsString(map);
            } else if (null == userService.getUserByIdAndPassword(id, password)) {
                map.put("result","wrongPassword");
                return objectMapper.writeValueAsString(map);
            } else {
                String userName = userService.getUserById1(id).getUsername();
                //request.setAttribute("loginName", userName)
                request.getSession().setAttribute("loginName", userName);
                request.getSession().setAttribute("loginId",id);
                map.put("result","success");
                map.put("name",userName);
                return objectMapper.writeValueAsString(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("用户登录验证");
        map.put("result","fail");
        return objectMapper.writeValueAsString(map);
    }

    /**
     * 获取 login name
     * */
    @RequestMapping(value = "/name")
    @ResponseBody
    public String getLoginName(HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("loginName");
        //System.out.print("登录名为：" + name);
        return name;
    }

    /**
     * 注册页面
     * @param user 用户实体
     * */
    @RequestMapping(value = "/addUser")
    @ResponseBody
    public String addUser(User user) throws Exception{
        //System.out.println("添加用户信息");
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            userService.addUser(user);
            Thread.currentThread().sleep(3000);
            int id = userService.getUserByNickname(user.getNickname()).getId();
            map.put("result","success");
            map.put("id",id);
            System.out.print(mapper.writeValueAsString(map));
            return  mapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("result","fail");
        return mapper.writeValueAsString(map);
    }

    /**
     * 根据 id 删除用户信息
     * @param id 用户 id
     * */
    @RequestMapping(value="/deleteUser")
    @ResponseBody
    public String deleteUser(int id) {
        try {
            userService.deleteUserById(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    /**
     * 修改密码
     * @param oldPassword 用户旧密码
     * @param newPassword 用户新密码
     * @param request 用户获取 session 对象
     * */
    @RequestMapping(value = "/updatePassword")
    @ResponseBody
    public String updatePassword(User user ,String oldPassword, String newPassword, HttpServletRequest request) {
            System.out.println("修改密码");
            int id = 0;
        if (null != request.getSession().getAttribute("loginId")) {
            id = (Integer)request.getSession().getAttribute("loginId");
            System.out.println("id:" + id);
        }
        try {
            if (null != userService.getUserByIdAndPassword(id, oldPassword)) {
                user.setId(id);
                user.setPassword(newPassword);
                userService.updatePassword(user);
                return "success";
            } else {
                return "wrongPassword";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "fail";
    }
}
