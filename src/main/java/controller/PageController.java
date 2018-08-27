package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * create by 1311230692@qq.com on 2018/8/14 14:42
 * 页面跳转
 **/
@Controller
@RequestMapping(value="/page")
public class PageController {

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

    /**
     * 跳转 admin 页面
     * */
    @RequestMapping(value="/toAdminPage")
    public String toLayPage() {
        return "admin/admin";
    }

    /**
     * 跳转 layui 导航栏
     * */
    @RequestMapping(value="/toNavPage")
    public String toNavPage() {
        return "page/layui_nav";
    }

    /**
     * 跳转 layui_form 页面
     * */
    @RequestMapping(value="/toLayuiFormPage")
    public String toLayuiForPage() {
        return "page/layui_form";
    }

    /**
     * 跳转 index 首页
     * */
    @RequestMapping(value="/toIndexPage")
    public String toIndexPage() {
        return "page/index";
    }

    /**
     * 跳转 userinfo 页面
     * */
    @RequestMapping(value="/toUserinfoPage")
    public String toUserInfoPage() {
        return "page/userinfo";
    }

    /**
     * 注销跳转 login 页面
     * */
    @RequestMapping(value="/toLoginPage")
    public void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws Exception{

        request.getRequestDispatcher("/login.html").forward(request,response);
    }

    /**
     * 跳转 register 页面
     * */
    @RequestMapping(value="/toRegisterPage")
    public String toRegisterPage() {
        return "page/register";
    }

    /**
     * 跳转 updatePassword 页面
     * */
    @RequestMapping(value="/toUpdatePassword")
    public String toUpdatePassword() {
        return "page/updatepassword";
    }

    /**
     * 跳转 test 页面
     * */
    @RequestMapping(value="/toTestPage")
    public String toTestPage() {
        return "admin/test";
    }
}
