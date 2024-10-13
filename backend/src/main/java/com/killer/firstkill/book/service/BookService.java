package com.killer.firstkill.book.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.killer.firstkill.book.model.Book;
import com.killer.firstkill.book.repository.BookRepository;

@Service
@RequiredArgsConstructor  //final 필드를 받는 생성자를 자동으로 생성
public class BookService {
    private final BookRepository bookRepository;

    public Book getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }
}
