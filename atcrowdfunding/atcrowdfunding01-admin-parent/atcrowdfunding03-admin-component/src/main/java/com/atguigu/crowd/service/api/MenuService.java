package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.Menu;

import java.util.List;

/**
 * @Auther: lxz
 * @Date: 2020/5/10 0010
 * @Description:
 */
public interface MenuService {
    List<Menu> getAll();

    void saveMenu(Menu menu);

    void removeMenu(Integer id);

    void updateMenu(Menu menu);
}
