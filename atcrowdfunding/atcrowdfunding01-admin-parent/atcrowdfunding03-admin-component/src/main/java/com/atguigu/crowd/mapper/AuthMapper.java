package com.atguigu.crowd.mapper;

import com.atguigu.crowd.entity.Auth;
import com.atguigu.crowd.entity.AuthExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AuthMapper {
    int countByExample(AuthExample example);

    int deleteByExample(AuthExample example);

    int deleteByPrimaryKey(Integer id);

    // 自定义 删除旧关系
    void deleteOldRelationship(Integer roleId);

    int insert(Auth record);

    int insertSelective(Auth record);

    // 新加新关系
    void insertNewRelationship(@Param("roleId") Integer roleId, @Param("authIdList") List<Integer> authIdList);

    List<Auth> selectByExample(AuthExample example);

    Auth selectByPrimaryKey(Integer id);


    // 自定义 获取某个角色拥有的权限
    List<Integer> selectAssignedAuthIdByRoleId(Integer roleId);

    int updateByExampleSelective(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByExample(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);

    // 自定义
    List<String> selectAssignedAuthNameByAdminId(Integer adminId);
}