package com.example.contant;/*
 *Created by tutu on 2018/4/17
 */

import com.example.model.User;
import com.example.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {

        /**
         * 授权用户权限
         */
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(
                PrincipalCollection principals) {
            //获取用户
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
            //获取用户角色
            Set<String> roleSet = new HashSet<String>();
            roleSet.add("100002");
            info.setRoles(roleSet);

            //获取用户权限
            Set<String> permissionSet = new HashSet<String>();
            permissionSet.add("权限添加");
            permissionSet.add("权限删除");
            info.setStringPermissions(permissionSet);


            return info;
        }

        /**
         * 验证用户身份
         */
        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(
                AuthenticationToken authcToken) throws AuthenticationException {

            UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
            String username = token.getUsername();
            String password = String.valueOf(token.getPassword());

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("nickname", username);
            //密码进行加密处理  明文为  password+name
              String paw = password+username;
//            String pawDES = MD5.MD5Encode(paw);
//            map.put("pswd", pawDES);

            User user = new User();
//            user.setId("112222");
//            user.setUsername(username);
//            user.setPassword(pawDES);


            return new SimpleAuthenticationInfo(user, password, getName());
        }


}
