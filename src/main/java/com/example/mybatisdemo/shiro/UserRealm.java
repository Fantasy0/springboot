package com.example.mybatisdemo.shiro;

import com.example.mybatisdemo.entity.SysUser;
import com.example.mybatisdemo.service.SysPermissionService;
import com.example.mybatisdemo.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.generator.MapperPlugin;
import javax.annotation.Resource;
import java.util.List;

public class UserRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);
    @Resource
    SysUserService sysUserService;
    @Resource
    SysPermissionService sysPermissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        List<String> sysPermissions = sysPermissionService.selectPermissionByUserId(sysUser.getUserId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(sysPermissions);
        LOGGER.info("doGetAuthorizationInfo");
        return info;


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        SysUser user = sysUserService.findByUserName(username);
        if (user == null) {
            throw new UnknownAccountException();
        }
        LOGGER.info("doGetAuthenticationInfo");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                // 用户
                user,
                // 密码
                user.getPassword(),
                ByteSource.Util.bytes(username),
                // realm name
                getName()
        );
        return authenticationInfo;
    }
}
