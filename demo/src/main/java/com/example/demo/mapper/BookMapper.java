package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from book where bookname like CONCAT('%', #{key}, '%')")
    public List<Book> findByName(String key);
    @Select("select * from book")
    public List<Book> getbooks();

}
