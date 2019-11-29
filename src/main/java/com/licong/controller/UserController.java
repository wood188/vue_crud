package com.licong.controller;


import com.licong.pojo.User;
import com.licong.pojo.UserRoler;
import com.licong.service.RolerPermService;
import com.licong.service.UserRolerService;
import com.licong.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRolerService userRolerService;
    @Autowired
    private RolerPermService rolerPermService;

    @RequestMapping("/register")
    public String register(User user) {
        user.setChoose(0);
        int res = userService.userAdd(user);
        if (res == 1) {
            //角色关系赋值
            UserRoler  userRoler = new UserRoler();
            userRoler.setUid(userService.selectOne(user).getUid());
            userRoler.setRid(3);
            userRolerService.userRolerAdd(userRoler);
           /* //权限赋值
            RolerPerm rolerPerm =new RolerPerm();
            rolerPerm.setRid(3);
            rolerPerm.setPid(1);
            rolerPermService.rolerPermAdd(rolerPerm);*/
            return "login";
        }
        return "register";
    }


    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        System.out.println(user);
        //加入shiro
        try {
            Subject subject = SecurityUtils.getSubject();//从安全对象内获取对象主体
            //构建令牌对象
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUname(), user.getUpass());
            subject.login(token);
            if (subject.isAuthenticated()) {
                return "{\"messg\":\"seccess\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("登录 失败");
        }
        return "{\"messg\":\"failed\"}";
    }
}
