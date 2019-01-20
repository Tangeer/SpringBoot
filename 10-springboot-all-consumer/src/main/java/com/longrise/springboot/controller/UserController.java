package com.longrise.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.longrise.springboot.constants.Constants;
import com.longrise.springboot.model.User;
import com.longrise.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:UserController
 * Package:com.longrise.springboot.controller
 * Description:
 *
 * @Date:2019/1/12 13:33
 * @Author:Tanger@longrise.com
 */
@Controller
public class UserController {

    /**引用远程dubbo服务*/
    @Reference
    private UserService userService;

    @RequestMapping("/index")
    public String index (Model model, @RequestParam(value = "curPage",required = false) Integer curPage){
        if(null == curPage){
            curPage = 1;
        }

        //查总数
        int totalRows = userService.getUserByTotal();

        int totalPages = totalRows / Constants.DEFAULT_PAGESIEZE;
        int left = totalRows % Constants.DEFAULT_PAGESIEZE;
        if(left > 0){
            totalPages = totalPages + 1;
        }

        //每次查询的起始行
        int startRow = (curPage - 1) * Constants.DEFAULT_PAGESIEZE;
        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("startRow",startRow);
        paramMap.put("pageSize",Constants.DEFAULT_PAGESIEZE);

        //分页查询当前页数据
        List<User> userList = userService.getUserByPage(paramMap);

        model.addAttribute("userList",userList);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("curPage",curPage);

        return "index";

    }

    @RequestMapping("/user/toAddUser")
    public String toAddUser (){
        return "user";
    }

    @RequestMapping("/user/addUser")
    public String addUser(User user){

        if(null == user.getId()){
            //添加用户
            userService.addUser(user);
        }else{
            //修改用户
            userService.updateUser(user);
        }

        return "redirect:/index";

    }

    @RequestMapping("/user/toUpdate")
    public String toUpdate (Model model,@RequestParam("id") Integer id){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user";
    }

    @RequestMapping("/user/delete")
    public String delete (@RequestParam("id") Integer id){
        userService.deleteUserById(id);
        return "redirect:/index";
    }






}
