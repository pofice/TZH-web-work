package com.example.demo.controlle;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/book/findByName")
    public List<Book> findByName(String name){
        return  bookMapper.findByName(name);
    }

    @RequestMapping("/book/getbooks")
    public List<Book> getbooks(){
        return  bookMapper.getbooks();
    }
}