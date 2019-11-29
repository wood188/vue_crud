package com.licong.config;


import com.licong.pojo.Permission;
import com.licong.pojo.User;
import com.licong.service.PermissionService;
import com.licong.service.UserService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component("myRealm")
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService us;
    @Autowired
    private PermissionService permissionService;
    //权限的
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String)principals.getPrimaryPrincipal();
        List<Permission> userPermissionByUserName = permissionService.selectPer(primaryPrincipal);
        System.err.println(userPermissionByUserName);
        if (userPermissionByUserName!=null&&userPermissionByUserName.size()>0){
            //去重
            Collection list = new HashSet<>();
            for (Permission per :userPermissionByUserName
            ) {
                list.add(per.getPname());
            }

            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addStringPermissions(list);
            return simpleAuthorizationInfo;
        }
        return null;
    }
    //登陆的
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws org.apache.shiro.authc.AuthenticationException {
        //获取到当前登录的用户名
        String name = (String)token.getPrincipal();
        User user1=new User();
        user1.setUname(name);
        User user = us.selectOne(user1);
        if (user!=null){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUname(), user.getUpass(), getName());
            return simpleAuthenticationInfo;
        }

        return null;
    }
}