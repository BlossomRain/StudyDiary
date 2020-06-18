package com.atguigu.crowd.mvc.config;

import com.atguigu.crowd.entity.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/5/13 0013
 * @Description:对原来的进行拓展,增加权限属性
 */
public class SecurityAdmin extends User {

    private static final long serialVersionUID = 1324124123420L;
    // 原始的admin对象,仅仅包含账号密码
    private Admin originalAdmin;

    public SecurityAdmin(Admin originalAdmin, List<GrantedAuthority> authorities) {
        super(originalAdmin.getUserName(), originalAdmin.getUserPswd(), authorities);
        this.originalAdmin = originalAdmin;
        this.originalAdmin.setUserPswd(null);
    }

    public Admin getOriginalAdmin() {
        return originalAdmin;
    }

    public void setOriginalAdmin(Admin originalAdmin) {
        this.originalAdmin = originalAdmin;
    }

}
