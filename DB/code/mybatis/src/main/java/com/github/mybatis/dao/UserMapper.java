package com.github.mybatis.dao;

import com.github.mybatis.bean.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @Auther: lxz
 * @Date: 2020/4/8 0008
 * @Description:
 */
public interface UserMapper {
    //参数传递:在单个参数的时候,mapper中不需要跟参数名称一样
    //多个参数的时候 参数会封装到map中,可以使用索引0-n 或者 param1 - paramn
    //可以使用@Param去指定key的值,或者干脆直接传入pojo或者map
    //假如经常要用,比如说分页,可以创建一个TO(transfer object),支持级联
    //特别注意:Collection->collection List->list Array->array 类型->封装的key
    //还有#{使用占位符} ${可以拼接}
    void insertUser(User user);

    User getUserById(Integer id);

    void updateUser(User user);

    List<User> getUsers();
    //返回一个Map封装的对象
    Map<String,Object> getUserByIdReturnMap(Integer id);

    @MapKey("id")
    Map<Integer,User> getUsersMap();

    List<User> getUsersByConditionIf(User user);
}
