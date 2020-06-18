package com.atguigu.crowd.mvc.config;

import com.atguigu.crowd.constant.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Auther: lxz
 * @Date: 2020/5/13 0013
 * @Description:spring security 的配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//表示启用全局方法权限管理功能
public class CrowdfundingSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        // 临时测试使用
        // builder.inMemoryAuthentication().withUser("Tom").password("123456").roles("ADMIN");
        // 使用数据库校验
        builder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
                .authorizeRequests()
                .antMatchers("/index.html", "/index.jsp", "/admin/to/login/page.html",
                        "/bootstrap/**", "/css/**", "/fonts/**", "/img/**",
                        "/jquery/**", " /layer/**", "/script/**", "/ztree/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()    //开启表单登陆页面
                .loginPage("/admin/to/login/page.html")//指定登陆页面
                .loginProcessingUrl("/security/do/login.html")//处理的请求
                .defaultSuccessUrl("/admin/to/main/page.html")//登陆成功前往的页面
                .usernameParameter("loginAcct")
                .passwordParameter("userPswd")
                .and()//指定退出登录处理的url以及后续的url
                .logout().logoutUrl("/security/do/logout.html").logoutSuccessUrl("/index.html")
                .and().exceptionHandling().accessDeniedHandler((request, response, ex) -> {

                    request.setAttribute("exception",new Exception(CrowdConstant.MESSAGE_ACCESS_DENIED));
                    request.getRequestDispatcher("/WEB-INF/system-error.jsp").forward(request,response);
                 })
                .and().csrf().disable()  //禁用csrf功能,为了测试方便
        ;
    }
}
