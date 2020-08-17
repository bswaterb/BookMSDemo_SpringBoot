package com.bswaterb.repository;

import com.bswaterb.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by chaohui on 2020/8/16
 */
@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }
    @Test
    void Add(){
        Book book = new Book();
        book.setAuthor("12");
        book.setName("123");
        Book book2 = bookRepository.save(book);
        System.out.println(book2);
    }

    @Test
    void delete(){
        bookRepository.deleteById(125);
    }

}