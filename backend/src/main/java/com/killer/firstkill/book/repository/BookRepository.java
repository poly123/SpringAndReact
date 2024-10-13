package com.killer.firstkill.book.repository;

import org.springframework.stereotype.Repository;
import com.killer.firstkill.book.model.Book;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor // final 필드를 받는 생성자를 자동으로 생성
public class BookRepository {
    private final BookMapper bookMapper;

    public Book findById(Long id) {
        return bookMapper.findById(id);
    }

    public void save(Book book) {
        LocalDateTime now = LocalDateTime.now();
        book.setCreatedAt(now);
        book.setUpdatedAt(now);
        bookMapper.insertBook(book);
    }
}
