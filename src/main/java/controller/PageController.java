package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
     * 跳转 laiui 页面
     * */
    @RequestMapping(value="/toLayPage")
    public String toLayPage() {
        return "/page/layui";
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
        return "admin/index";
    }

    /**
     * 跳转 userinfo 页面
     * */
    @RequestMapping(value="/toUserinfoPage")
    public String toUserInfoPage() {
        return "page/userinfo";
    }
}
