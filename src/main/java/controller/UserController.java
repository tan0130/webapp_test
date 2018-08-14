package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by 1311230692@qq.com on 2018/8/14 14:42
 * 用户操作控制层
 **/
@Controller
@RequestMapping(value="/user")
public class UserController {

    /**
     * 跳转 webapp.html 页面
     * */
    @RequestMapping(value="/toWebPage")
    public String toWebPage() {
        return "page/webapp";
    }

    /**
     * 跳转表单提交页面
     * */
    @RequestMapping(value="/toFormPage")
    public String toFormPage() {
        return "/page/form";
    }
}
