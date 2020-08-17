package com.bswaterb.controller;

import com.bswaterb.entity.Book;
import com.bswaterb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by chaohui on 2020/8/16
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page-1,size);
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result==null){
            return "error";
        }else{
            return "success";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @PutMapping("/updateBook")
    public String updateBook(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result==null){
            return "error";
        }else{
            return "success";
        }
    }

    @DeleteMapping("/deleteBookById/{id}")
    public void deleteBookById(@PathVariable("id") Integer id ){
        bookRepository.deleteById(id);
    }

}
