package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE account = #{account}")
    User findByAccount(String account);

    @Select("SELECT * FROM user WHERE account = #{account} AND pwd = #{pwd}")
    User findByAccountAndPwd(String account, String pwd);

    @Insert("INSERT INTO user (account, pwd, nickname, picture, type) VALUES (#{account}, #{pwd}, #{nickname}, #{picture}, #{type})")
    void save(User user);
}