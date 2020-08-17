package com.bswaterb.repository;

import com.bswaterb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chaohui on 2020/8/16
 */
public interface BookRepository extends JpaRepository<Book,Integer> {


}
