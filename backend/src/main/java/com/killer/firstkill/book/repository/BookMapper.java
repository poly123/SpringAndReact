package com.killer.firstkill.book.repository;

import org.apache.ibatis.annotations.Mapper;
import com.killer.firstkill.book.model.Book;

@Mapper
public interface BookMapper {

    Book findById(Long id);

    void insertBook(Book book);
    
}
