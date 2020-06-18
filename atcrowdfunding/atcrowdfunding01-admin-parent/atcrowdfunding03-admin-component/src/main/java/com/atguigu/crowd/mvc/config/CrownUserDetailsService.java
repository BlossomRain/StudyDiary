package com.atguigu.crowd.mvc.config;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Auth;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.service.api.AuthService;
import com.atguigu.crowd.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/5/13 0013
 * @Description:
 */
@Component
public class CrownUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthService authService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 根据username 查询相关的角色和权限
        Admin admin = adminService.getAdminByLoginAcct(username);
        Integer adminId = admin.getId();
        List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
        List<String> authNameList = authService.getAssignedAuthNameByAdminId(adminId);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        // 将查询到的角色和权限信息添加进 ArrayList<GrantedAuthority>
        // 角色信息添加
        for (Role role : assignedRoleList) {
            String roleName = "ROLE_" + role.getName();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleName);
            authorities.add(authority);
        }

        //  权限信息添加
        for (String authName : authNameList) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(authName);
            authorities.add(authority);
        }

        SecurityAdmin securityAdmin = new SecurityAdmin(admin, authorities);

        return securityAdmin;
    }
}
