package com.ssm.dao;

import com.ssm.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author ljh
 */
@Repository
public interface UserDao {
    @Select("select * from user where username=#{username}")
    public User getUser(@Param("username") String username);
}
